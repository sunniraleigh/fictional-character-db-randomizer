import java.util.*;
import java.io.*;
public class HM_RS_Database {
    static Scanner scanUser = new Scanner(System.in).useDelimiter("\n");
    public static void main (String [] args){
        String fileName = "Characters1.csv";
        Scanner scan = null;
        try {
            scan = new Scanner(new File(fileName));
        }
        catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }
        
        ArrayList <Character> characters = new ArrayList <Character> ();
        while(scan.hasNext()){
            String [] arr = scan.nextLine().split(",");
            characters.add(new Character(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), arr[6], arr[7].equals("TRUE"), arr[8].equals("TRUE"), arr[9], arr[10]));
            // System.out.println(Arrays.toString(arr));
            // System.out.println(arr.length);
        }
       printAll(characters);

        int option;
        do{
            System.out.println("Menu:\n1. print list\n2. add character\n3. search name\n4. search fictional world\nPress 0 to quit");
            option = scanUser.nextInt();
            switch(option){
                case 1: System.out.println(characters);; break;
                case 2: characters.add(newCharacter()); break;
                case 3: searchCharacter(characters); break;
                case 4: searchWorld(characters); break;
                case 0: System.out.println("bye!"); break;
                default: System.out.println("ERROR");
            }
        }while(option != 0);
    }

    static void printAll(ArrayList <Character> characters){
        for(Character c : characters){
            System.out.println(c.toStringAll());
        }
    }

    static Character newCharacter(){
        System.out.print("Enter name: ");
        String name = scanUser.next();
        System.out.print("Enter fictional world: ");
        String fictionalWorld = scanUser.next();
        System.out.print("Enter character creator: ");
        String creator = scanUser.next();
        System.out.print("Enter birth day: ");
        int birthDay = scanUser.nextInt();
        System.out.print("Enter birth month: ");
        int birthMonth = scanUser.nextInt();
        System.out.print("Enter birth year: ");
        int birthYear = scanUser.nextInt();
        System.out.print("Enter gender: ");
        String gender = scanUser.next();
        System.out.print("Is character a hero (yes) or villian (no)? ");
        boolean hero = (scanUser.next().charAt(0)=='y')? true: false;
        System.out.print("Is character a cartoon (yes) or person (no)? ");
        boolean cartoon = (scanUser.next().charAt(0)=='y')? true: false;
        System.out.print("Enter media type: ");
        String mediaType = scanUser.next();
        System.out.print("Enter actor: ");
        String actor = scanUser.next();
        Character newC = new Character(name, fictionalWorld, creator, birthDay, birthMonth, birthYear, gender, hero, cartoon, mediaType, actor);
        
        return newC;
    }

    static void searchCharacter(ArrayList <Character> characters){
        System.out.print("Enter name of character to search for: ");
        String ch = scanUser.next();
        for(Character c : characters){
            if (c.name.equals(ch)){
                System.out.println(c.toStringAll());
            }
        }
    }
    
    static void searchWorld(ArrayList <Character> characters){
        System.out.print("Enter name of fictional world to search for: ");
        String world = scanUser.next();
        for(Character c : characters){
            if (c.fictionalWorld.equals(world)){
                System.out.println(c.toStringAll());
            }
        }
    }
}

class Character {
    String name, fictionalWorld, creator, gender, mediaType, actor;
    int birthDay, birthMonth, birthYear;
    boolean hero, cartoon;

    Character (String name, String fictionalWorld, String creator, int birthDay, int birthMonth, int birthYear, String gender, boolean hero, boolean cartoon, String mediaType, String actor){
        this.name = name;
        this.fictionalWorld = fictionalWorld;
        this.creator = creator;
        this.gender = gender;
        this.mediaType = mediaType;
        this.actor = actor;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.hero = hero;
        this.cartoon = cartoon;
    }

    public String toString(){ //just name
        return (name);
    }

    public String toStringAll(){
        String space1 = "", space2 = "", space3 = "", space4 = "", space5 = "", space6, space7, space8 = "";
        for(int i = 0; i < (25-name.length()); i++) space1 += " ";
        for(int i = 0; i < (37-fictionalWorld.length()); i++) space2 += " ";
        for(int i = 0; i < (26-creator.length()); i++) space3 += " ";
        String bday = "//" + birthDay + birthMonth + birthYear;
        for(int i = 0; i < (12-bday.length()); i++) space4 += " ";
        for(int i = 0; i < (12-gender.length()); i++) space5 += " ";
        space6 = hero? "     " : "  ";
        space7 = cartoon? "  " : "   ";
        for(int i = 0; i < (12-mediaType.length()); i++) space8 += " ";
        return (name + space1 + fictionalWorld + space2 + creator + space3 + birthMonth + "/" + birthDay + "/" + birthYear + space4 + gender + space5 + (hero?"hero":"villian") + space6 + (cartoon?"cartoon":"person") + space7 + mediaType + space8 + actor);
    }
}
