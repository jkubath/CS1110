/* PROGRAM:  Recursions
 * Author:  Jonah Kubath    Designer: Dr. Kaminski
 * TODO:  Write the 2 methods using RECURSION to print the word forward
 *          and backwards.
 * HELP:    - charAt(0) gets the 1st char of a String
 *          - substring(1,theString.length()) gets the rest of the String
 *****************************************************************************/
package recursion;

public class Recursion {

    public static void main(String[] args) {
        
        String word = "Michigan";
        
        System.out.println(writeWord(word));
        
        System.out.println("--------------------------");
        
        writeWordBackwards(word);
    }
    //-------------------------------------------------------------------------
    private static String writeWord(String word) {
        String rest = word.substring(1, word.length());
        if(word.charAt(0) == 'n')
            return "n";
        else{
            System.out.println("Rest: " + rest);
            return writeWord(rest);
        }

        
    }
    //-------------------------------------------------------------------------
    private static void writeWordBackwards(String word) {
        
        if(word.length() == 0)
            return;
        else{
            String rest = word.substring(1, word.length());
            writeWordBackwards(rest);
            System.out.print(word.charAt(0));
            return;
        }

        
    }
    //-------------------------------------------------------------------------
}
