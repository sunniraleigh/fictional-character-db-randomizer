import java.util.*;

class uniquePrint{
    public static void main(String [] args){
        List <String> strings = new ArrayList <> (Arrays.asList("frog", "cow", "turtle", "frog"));

        printUniqueVals(strings);
    }

    static List <String> printUniqueVals(List <String> strings){
        List <String> unique = new ArrayList <> ();

        for(String s : strings){
            if(!unique.contains(s)){
                unique.add(s);
            }
        }

        System.out.println(unique);

        return unique;
    }
}