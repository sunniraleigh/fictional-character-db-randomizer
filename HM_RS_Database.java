import java.util.*;
import java.io.*;
public class HM_RS_Database {
    static Scanner cin = new Scanner(System.in);
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
        System.out.println(characters);

        int option;
        do{
            System.out.println("Menu:\n1. print worlds\nPress 0 to quit");
            option = cin.nextInt();
            switch(option){
                case 1: System.out.println(returnFictionalWorlds(characters)); break;
                case 2: System.out.println(returnCreators(characters)); break;
                case 3: System.out.println(returnMediaTypes(characters)); break;
                case 4: System.out.println(returnActors(characters)); break;
                case 5: generateRandomCharacter(characters); break;
                case 0: System.out.println("bye!"); break;
                default: System.out.println("ERROR");
            }
        }while(option != 0);
    }
    // PRINT UNIQUE VALUES FUNCTIONS //
    static void printDB(List <Character> characters){
        System.out.println(characters);
    } // print entire database

    static List <String> returnNames(List <Character> characters){
        List <String> uniqueNames = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueNames.contains(c.name)){
                uniqueNames.add(c.name);
            }
        }

        return uniqueNames;
    } // return unique worlds

    static List <String> returnFictionalWorlds(List <Character> characters){
        List <String> uniqueWorlds = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueWorlds.contains(c.fictionalWorld)){
                uniqueWorlds.add(c.fictionalWorld);
            }
        }

        return uniqueWorlds;
    } // return unique worlds

    static List <String> returnGenders(List <Character> characters){
        List <String> uniqueGenders = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueGenders.contains(c.gender)){
                uniqueGenders.add(c.gender);
            }
        }

        return uniqueGenders;
    } // return unique genders

    static List <Integer> returnBirthDays(List <Character> characters){
        List <Integer> uniqueBirthDays = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueBirthDays.contains(c.birthDay) && c.birthDay != 0){
                uniqueBirthDays.add(c.birthDay);
            }
        }

        return uniqueBirthDays;
    } // return unique birthdays

    static List <Integer> returnBirthMonths(List <Character> characters){
        List <Integer> uniqueBirthMonths = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueBirthMonths.contains(c.birthMonth) && c.birthMonth != 0){
                uniqueBirthMonths.add(c.birthMonth);
            }
        }

        return uniqueBirthMonths;
    } // return unique birthmonths

    static List <Integer> returnBirthYears(List <Character> characters){
        List <Integer> uniqueYears = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueYears.contains(c.birthYear) && c.birthYear != 0){
                uniqueYears.add(c.birthYear);
            }
        }

        return uniqueYears;
    } // return unique birthyears

    static List <String> returnCreators(List <Character> characters){
        List <String> uniqueCreators = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueCreators.contains(c.creator)){
                uniqueCreators.add(c.creator);
            }
        }

        return uniqueCreators;
    } // return unique creators

    static List <String> returnMediaTypes(List <Character> characters){
        List <String> uniqueMediaTypes = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueMediaTypes.contains(c.mediaType)){
                uniqueMediaTypes.add(c.mediaType);
            }
        }
        return uniqueMediaTypes;
    } // return unique media types

    static List <String> returnActors(List <Character> characters){
        List <String> uniqueActors = new ArrayList <> ();

        for(Character c : characters){
            if(!uniqueActors.contains(c.actor)){
                uniqueActors.add(c.actor);
            }
        }
        return uniqueActors;
    } // return unique actors

    // NEW CHARACTER //
    static void generateRandomCharacter(ArrayList <Character> characters){
        int randIndex; // random number generator
        int length;
        // String name = "";
        
        String name = "", fictionalWorld = "", creator = "", gender = "", mediaType = "", actor = "";
        int birthDay, birthMonth, birthYear;
        boolean hero, cartoon;

        // name
        List <String> names = returnNames(characters);

        length = names.size();
        randIndex = randInt(0, length);

        // String name;
        for(String s : names){
            if(names.indexOf(s) == randIndex) name = s;
        }
        System.out.println(name);
        
        // for(String s : names){
        //     if(names.indexOf(s) == randIndex){
        //         String name = s;
        //     }
        // }

        // String name;
        // for(int i = 0; i < length; i++){
        //     if (i == randIndex) name = names.get(i);
        // }

        // System.out.println(name);

        // fictionalWorld
        // creator
        // birthDay
        // birthMonth
        // birthYear
        // gender
        // hero
        // cartoon
        // mediaType
        // actor
    }

    static int randInt(int min, int max){
        return (int) ((max - min + 1) * Math.random() + min);
    }

}


class Character {
    String name, fictionalWorld, creator, gender, mediaType, actor;
    int birthDay, birthMonth, birthYear;
    boolean hero, cartoon;

    Character (String name, 
               String fictionalWorld, 
               String creator, 
               int birthDay, 
               int birthMonth, 
               int birthYear, 
               String gender, 
               boolean hero, 
               boolean cartoon, 
               String mediaType, 
               String actor){
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

    public String toString(){
        return (name);
    }
}
