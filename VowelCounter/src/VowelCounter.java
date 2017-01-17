/* PROJECT:  VowelCounter
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  This uses a while loop to count the number of vowels, spaces
 *      and consonants/other char's are in a name entered by the user.
 *      It then displays these 3 counts in the Console window.
 * NOTE:  charAt(i) will get you the char at position im where
 *      - positions start at 0, not 1
 *      - positions end at theString.length() - 1, not theString.length()
 * NOTE:  Use a SWITCH statement to determine which counter to add 1 to.
 ****************************************************************************/

import javax.swing.JOptionPane;

public class VowelCounter {

    public static void main(String[] args) {
                
        // ---------------------------------------------- VARIABLE DECLARATIONS
        int inputLength;
        int i =0;
        char check; // the current character being checked
        int vowel = 0, space = 0, other = 0;
                
        // -------------------------------------------------------------- INPUT
        String inputStr = JOptionPane.showInputDialog
            ("Enter name (like your university)");
        // --------------------------------------------------------- PROCESSING
        inputLength = inputStr.length() - 1;
        while (i <= inputLength)
        {
            check = inputStr.charAt(i);
            switch (check)
            {
                case ('a'):
                case ('e'):
                case ('i'):
                case ('o'):
                case ('u'):
                case ('A'):    
                case ('E'):
                case ('I'):
                case ('O'):
                case ('U'):
                        vowel++;
                        break;
                case (' '):
                    space++;
                    break;
                default:
                    other++;
            }
            i++;
        }
        

        // ------------------------------------------------------------- OUTPUT
        System.out.println(inputStr);
        System.out.println(vowel);
        System.out.println(space);
        System.out.println(other);
               
       
        
        // ---------------------------------------------------------- FINISH-UP
        System.exit(0);
    }
}
