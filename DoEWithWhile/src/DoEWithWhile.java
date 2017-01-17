/* PROJECT:  DoEWithWhile       (draw a big E using WHILE loops)
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Programs draws a big letter E (in console window) based on
 *      user-supplied parameters (dialog boxes):  drawing char, height, width.
 * RULES FOR E's - see comment in code below
 * ASSUMPTION for drawing in Console window: - it prints from top to bottom,
 *      and for a particular row, it prints from left to right
 * THINKING about the size of the 2 verticals. . .
 *      - part of the entire char's HEIGHT is taken up by the 3 horizontals
 *      - the remainder of HEIGHT is used by the 2 verticals, with the top one
 *          being slightly smaller, if the leftover's an odd number
 *****************************************************************************/
import javax.swing.JOptionPane;

public class DoEWithWhile {

    public static void main(String[] args) {

        // ---------------------------------------------------------- VARIABLES
        String userInput;
        int height, vertical;
        int width;
        char pen;
        // -------------------------------------------------------------- INPUT
        // TEMPORARY HARD-CODED "input"
//        height = 10;
//        width = 15;
//        pen = 'X';
        
        userInput = JOptionPane.showInputDialog("Enter height (pos int 5-24)");
        height = Integer.parseInt(userInput);

        userInput = JOptionPane.showInputDialog("Enter width (pos int 5-24)");
        width = Integer.parseInt(userInput);
        
        userInput = JOptionPane.showInputDialog("Enter drawing character");
        pen = userInput.charAt(0);       
        
        // --------------------------------------------------- DRAW THE 5 LINES
        // RULES FOR E's
        //      - top & bottom horizontals both full width
        //      - middle horizontal is 1/2 width
        //      - top & bottom verticals are same size when height is odd,
        //          but for even heights, bottom vertical is slightly taller
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 1) TOP HORIZONTAL
        int i = 1;
        while (i <= width)
        {
            System.out.print(pen);
            i++;
        }
        
        System.out.println(); //used to push to the next line   
        
        
        // 2) TOP VERTICAL
        vertical = (height - 3)/2;
        i = 1;
        while(i <= vertical )
        {
            System.out.println(pen);
            i++;
        }
        
        // 3) MIDDLE HORIZONTAL
        i = 1;
        while (i <= width / 2)
        {
            System.out.print(pen);
            i++;
        }
        
        System.out.println(); //push down another line
        
        // 4) BOTTOM VERTICAL
        vertical = (height - 3)/2;
        i = 0;
        while(i <= vertical )
        {
            System.out.println(pen);
            i++;
        }
        
        // 5) BOTTOM HORIZONTAL
        i = 1;
        while (i <= width)
        {
            System.out.print(pen);
            i++;
        }       
        
        // ---------------------------------------------------------- FINISH-UP
        System.out.printf("\n\nHeight: %d, width: %d\n", height, width);
        System.exit(0);
    }  
}
