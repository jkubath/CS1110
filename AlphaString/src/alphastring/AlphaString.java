/* PROJECT:  AlphaString
 * AUTHOR: D Kaminski
 * DESCRIPTION:  Shows one way to check if user's input data is all alphabetic
 *      char's - that is,  a-z or A-Z.
 *
 * String class's replaceAll METHOD (in String class):
 *      1st parameter: a "regular expressions" describing what the search is
 *              looking for in order to replace those specified char's.
 *              [^a-zA-Z] is a custom class specifying:
 *                  "any char NOT within the range a-z or A-Z"
 *      2nd parameter is the replacement char - don't use a $ or a \
 ******************************************************************************/
package alphastring;

import javax.swing.JOptionPane;

public class AlphaString {

    public static void main(String[] args) {

        String inputStr;
        String newStr;
        
        inputStr = JOptionPane.showInputDialog("Enter a word (all-alpha)");
        
        newStr = inputStr.replaceAll("[^a-zA-Z]", "#");
        System.out.printf("Original [%s], New [%s]\n", inputStr, newStr);
        
        if (inputStr.compareTo(newStr) == 0)
            System.out.println("OK, it's a good alpha string");
        else
            System.out.println("ERROR, the string has non-alpha chars");
    }
}
