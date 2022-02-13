import java.util.*;
import java.io.*;

public class database{
    static Scanner scanUser = new Scanner(System.in).useDelimiter("\n");

    public static void main(String [] args){
        String fileName = "database.csv";

        Scanner scan = null;
        try{
            scan = new Scanner(new File(fileName));
        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }

        // *** READ FILE INTO ARRAYLIST *** //
        ArrayList <FicCharacter> characters = new ArrayList <FicCharacter> ();
        while(scan.hasNext()){
            String [] arr = scan.nextLine().split(","); // split line into array of strings
            characters.add(new FicCharacter(
                arr[0], // String name
                arr[1], // String fictionalWorld
                arr[2], // String creator
                Integer.parseInt(arr[3]), // int birthDay
                Integer.parseInt(arr[4]), // int birthMonth
                Integer.parseInt(arr[5]), // int birthYear
                arr[6], // String gender
                arr[7].equals("TRUE"), // boolean hero
                arr[8].equals("TRUE"), // boolean cartoon
                arr[9], // String mediaType
                arr[10] // String actor
            ));
        }

        // *** MENU *** //
        int option;
        do{
            System.out.println("Menu:");

            System.out.println("\tExplore & Print:");
            System.out.println("\t- 1. Entire database\n\t- 2. Unique names \n\t- 3. Unique fictional worlds\n\t- 4. Unique authors/creators\n\t- 5. Unique birthdays\n\t- 6. Unique birth months\n\t- 7. Unique birth years\n\t- 8. Unique genders\n\t- 9. Unique media types\n\t- 10. Unique actors");
            
            System.out.println("\n\tSort Database By:");
            System.out.println("\t- 11. Name\n\t- 12. World\n\t- 13. Birthday");
            
            System.out.println("\n\tSearch Database By:");
            System.out.println("\t- 14. Name\n\t- 15. World\n\t- 16. Gender\n\t- 17. Hero/Villain\n\t- 18. Cartoon/Person");
            
            System.out.println("\n\tCreate a New Character:");
            System.out.println("\t- 19. Generate your own character\n\t- 20. Randomly generate a new character\n\t- 21. Save database");

            System.out.println("\nEnter number to choose option (0 to exit):");
            option = scanUser.nextInt();
            switch(option){
                case 1: printDB(characters); break;
                case 2: System.out.println(returnNames(characters)); break;
                case 3: System.out.println(returnFictionalWorlds(characters)); break;
                case 4: System.out.println(returnCreators(characters)); break;
                case 5: System.out.println(returnBirthDays(characters)); break;
                case 6: System.out.println(returnBirthMonths(characters)); break;
                case 7: System.out.println(returnBirthYears(characters)); break;
                case 8: System.out.println(returnGenders(characters)); break;
                case 9: System.out.println(returnMediaTypes(characters)); break;
                case 10: System.out.println(returnActors(characters)); break;
                case 11: sortByName(characters); break;
                case 12: sortByWorld(characters); break;
                case 13: sortByBirthdate(characters); break;
                case 14: searchCharacter(characters); break;
                case 15: searchWorld(characters); break;
                case 16: searchGender(characters); break;
                case 17: searchHero(characters); break;
                case 18: searchCartoon(characters); break;
                case 19: characters = addNewCharacter(characters); break;
                case 20: characters = newRandomCharacter(characters); break;
                case 21: updateDB(characters); break;
                case 0: System.out.println("Thanks for exploring the fictional character database."); break;
                default: System.out.println("Invalid input. Please enter numbers between 0 and 21.");
            }
        }while(option != 0);
    }

    // *** PRINT UNIQUE VALUE FUNCTIONS 1-10 *** //
    static void printDB(ArrayList <FicCharacter> characters){
        for(FicCharacter c : characters){
            System.out.println(c.toStringAll());
        }
    } // 1. print entire database

    static List <String> returnNames(ArrayList <FicCharacter> characters){
        List <String> uniqueNames = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueNames.contains(c.name)){
                uniqueNames.add(c.name);
            }
        }
        return uniqueNames;
    } // 2. return unique worlds

    static List <String> returnFictionalWorlds(ArrayList <FicCharacter> characters){
        List <String> uniqueWorlds = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueWorlds.contains(c.fictionalWorld)){
                uniqueWorlds.add(c.fictionalWorld);
            }
        }
        return uniqueWorlds;
    } // 3. return unique worlds

    static List <String> returnCreators(ArrayList <FicCharacter> characters){
        List <String> uniqueCreators = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueCreators.contains(c.creator)){
                uniqueCreators.add(c.creator);
            }
        }
        return uniqueCreators;
    } // 4. return unique creators

    static List <Integer> returnBirthDays(ArrayList <FicCharacter> characters){
        List <Integer> uniqueBirthDays = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueBirthDays.contains(c.birthDay) && c.birthDay != 0){
                uniqueBirthDays.add(c.birthDay);
            }
        }
        return uniqueBirthDays;
    } // 5. return unique birthdays

    static List <Integer> returnBirthMonths(ArrayList <FicCharacter> characters){
        List <Integer> uniqueBirthMonths = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueBirthMonths.contains(c.birthMonth) && c.birthMonth != 0){
                uniqueBirthMonths.add(c.birthMonth);
            }
        }
        return uniqueBirthMonths;
    } // 6. return unique birthmonths

    static List <Integer> returnBirthYears(ArrayList <FicCharacter> characters){
        List <Integer> uniqueYears = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueYears.contains(c.birthYear) && c.birthYear != 0){
                uniqueYears.add(c.birthYear);
            }
        }
        return uniqueYears;
    } // 7. return unique birthyears

    static List <String> returnGenders(ArrayList <FicCharacter> characters){
        List <String> uniqueGenders = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueGenders.contains(c.gender)){
                uniqueGenders.add(c.gender);
            }
        }
        return uniqueGenders;
    } // 8. return unique genders

    static List <String> returnMediaTypes(ArrayList <FicCharacter> characters){
        List <String> uniqueMediaTypes = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueMediaTypes.contains(c.mediaType)){
                uniqueMediaTypes.add(c.mediaType);
            }
        }
        return uniqueMediaTypes;
    } // 9. return unique media types

    static List <String> returnActors(ArrayList <FicCharacter> characters){
        List <String> uniqueActors = new ArrayList <> ();
        for(FicCharacter c : characters){
            if(!uniqueActors.contains(c.actor)){
                uniqueActors.add(c.actor);
            }
        }
        return uniqueActors;
    } // 10. return unique actors

    // *** SORT FUNCTIONS 11-13 *** //
    static void sortByName(ArrayList <FicCharacter> characters){
        ArrayList <FicCharacter> names = characters;
        Collections.sort(names, new Comparator <FicCharacter> (){
            public int compare(FicCharacter c1, FicCharacter c2){
                return c1.name.compareTo(c2.name);
        }});
        printDB(names);
    } // 11. sort by name

    static void sortByWorld(ArrayList <FicCharacter> characters){
        ArrayList <FicCharacter> worlds = characters;
        Collections.sort(worlds, new Comparator <FicCharacter> (){
            public int compare(FicCharacter c1, FicCharacter c2){
                return c1.fictionalWorld.compareTo(c2.fictionalWorld);
        }});
        printDB(worlds);
    } // 12. sort by world

    static void sortByBirthdate(ArrayList <FicCharacter> characters){
        ArrayList <FicCharacter> birthdates = new ArrayList <> ();
        ArrayList <FicCharacter> nonbirthdates = new ArrayList <> ();

        for(FicCharacter c : characters){
            if(c.birthDay == 0 && c.birthMonth == 0 && c.birthYear == 0){
                nonbirthdates.add(c);
            }else{
                birthdates.add(c);
            }
        }
        Collections.sort(birthdates, new Comparator <FicCharacter> (){
            public int compare(FicCharacter c1, FicCharacter c2){
                return c1.birthDay - c2.birthDay;
        }}); // sort by birthday

        Collections.sort(birthdates, new Comparator <FicCharacter> (){
            public int compare(FicCharacter c1, FicCharacter c2){
                return c1.birthMonth - c2.birthMonth;
        }}); // then sort by birthmonth

        Collections.sort(birthdates, new Comparator <FicCharacter> (){
            public int compare(FicCharacter c1, FicCharacter c2){
                return c1.birthYear - c2.birthYear;
        }}); // then sort by birthyear
        
        System.out.println("Characters with birthdays: ");
        printDB(birthdates);
        System.out.println("\nCharacters without known birthdays: ");
        printDB(nonbirthdates);
    } // 13. sort by birthdate

    // *** SEARCH FUNCTIONS 14-18 *** //
    static void searchCharacter(ArrayList <FicCharacter> characters){
        System.out.println("Enter name of character to search for: ");
        String ch = scanUser.next();
        for(FicCharacter c : characters){
            if (c.name.equals(ch)){
                System.out.println(c.toStringAll());
            }
        }
    } // 14. search by character

    static void searchWorld(ArrayList <FicCharacter> characters){
        System.out.println("Enter name of fictional world to search for: ");
        String world = scanUser.next();
        for(FicCharacter c : characters){
            if (c.fictionalWorld.equals(world)){
                System.out.println(c.toStringAll());
            }
        }
    } // 15. search by world

    static void searchGender(ArrayList <FicCharacter> characters){
        System.out.println("Enter gender of character to search for: ");
        String gen = scanUser.next();
        for(FicCharacter c : characters){
            if (c.gender.equals(gen)){
                System.out.println(c.toStringAll());
            }
        }
    } // 16. search by gender

    static void searchHero(ArrayList <FicCharacter> characters){
        System.out.println("Do you want to display all heros (h) or villains (v)?");
        char answer = scanUser.next().charAt(0);
        boolean hv;
        if (answer == 'h') hv = true;
        else hv = false; 
        for(FicCharacter c : characters){
            if (c.hero == hv){
                System.out.println(c.toStringAll());
            }
        }
    } // 17. search for heros/villains

    static void searchCartoon(ArrayList <FicCharacter> characters){
        System.out.println("Do you want to display all cartoons (c) or people (p)?");
        char answer = scanUser.next().charAt(0);
        boolean hv;
        if (answer == 'c') hv = true;
        else hv = false; 
        for(FicCharacter c : characters){
            if (c.cartoon == hv){
                System.out.println(c.toStringAll());
            }
        }
    } // 18. search for cartoons/people

    // *** NEW CHARACTER FUNCTIONS 19-21 *** //
    static FicCharacter newCharacter(){
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
        FicCharacter newC = new FicCharacter(name, fictionalWorld, creator, birthDay, birthMonth, birthYear, gender, hero, cartoon, mediaType, actor);
        
        return newC;
    } // create new character

    static ArrayList <FicCharacter> addNewCharacter(ArrayList <FicCharacter> characters){
        FicCharacter newC = newCharacter();
        System.out.println("This is your new character: ");
        System.out.println(newC.toStringAll());

        System.out.println("\nDo you want to add the character to the database? (1-yes, 0-no): ");
        int addNewC = scanUser.nextInt();

        if(addNewC == 1) characters.add(newC);
        return characters;
    } // 19. add new user-generated character

    static FicCharacter generateRandomCharacter(ArrayList <FicCharacter> characters){
        int randIndex;

        String name = "", fictionalWorld = "", creator = "", gender = "", mediaType = "", actor = "";
        int birthDay, birthMonth, birthYear;
        boolean hero, cartoon;

        // name
        List <String> names = returnNames(characters);
        randIndex = randInt(names.size());
        name = names.get(randIndex);

        // fictionalWorld
        List <String> worlds = returnFictionalWorlds(characters);
        randIndex = randInt(worlds.size());
        fictionalWorld = worlds.get(randIndex);

        // creator
        List <String> creators = returnCreators(characters);
        randIndex = randInt(creators.size());
        creator = creators.get(randIndex);

        // gender
        List <String> genders = returnGenders(characters);
        randIndex = randInt(genders.size());
        gender = genders.get(randIndex);

        // media type
        List <String> medias = returnMediaTypes(characters);
        randIndex = randInt(medias.size());
        mediaType = medias.get(randIndex);

        // actor
        List <String> actors = returnActors(characters);
        randIndex = randInt(actors.size());
        actor = actors.get(randIndex);

        // birthdate
        birthDay = randInt(31);
        birthMonth = randInt(12);
        birthYear = randInt(3000);

        // hero
        randIndex = randInt(2);
        hero = (randIndex == 1)? true : false;

        // cartoon
        randIndex = randInt(2);
        cartoon = (randIndex == 1)? true : false;

        return new FicCharacter(name, fictionalWorld, creator, birthDay, birthMonth, birthYear, gender, hero, cartoon, mediaType, actor);

    } // generate a random character

    static int randInt(int max){
        return (int) ((max) * Math.random());
    }

    static ArrayList <FicCharacter> newRandomCharacter(ArrayList <FicCharacter> characters){
        FicCharacter randC = generateRandomCharacter(characters);
        System.out.println("This is a randomly generated character: ");
        System.out.println(randC.toStringAll());

        System.out.println("\nDo you want to add the character to the database? (1-yes, 0-no): ");
        int addRandC = scanUser.nextInt();

        if (addRandC == 1) characters.add(randC);
        return characters;
    } // 20. add a randomly generated character

    static void updateDB(ArrayList <FicCharacter> characters){
        PrintWriter fout = null;
        File userDB = new File("database.csv"); // Database filename
        
        try{
            if(!userDB.exists()){
                userDB.createNewFile();
            }
            fout = new PrintWriter(userDB);

            for(FicCharacter c : characters) fout.write(c.toStringComma() + "\n");

            fout.close();
        }catch(Exception exception){
            System.out.println("ERROR: " + exception);
        }
    } //21. update database
}

class FicCharacter {
    String name, fictionalWorld, creator, gender, mediaType, actor;
    int birthDay, birthMonth, birthYear;
    boolean hero, cartoon;

    FicCharacter (String name, 
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

    public String toStringComma(){
        return (name + "," + fictionalWorld + "," + creator + "," + birthDay + "," + birthMonth + "," + birthYear + "," + gender + "," + (hero? "TRUE" : "FALSE") + "," + (cartoon? "TRUE" : "FALSE") + "," + mediaType + "," + actor);
    }
}
