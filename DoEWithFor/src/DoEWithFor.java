/* PROJECT:  DoEWithFor       (draw a big E using FOR loops)
 * AUTHOR:  
 * DESCRIPTION:  Programs draws a big letter E (in console window) based on
 *      user-supplied parameters (dialog boxes):  drawing char, height, width.
 * RULES FOR E's - see comment in code below
 * ASSUMPTION for drawing in Console window: - it prints from top to bottom,
 *      and for a particular row, it prints from left to right
 * THINKING about the size of the 2 verticals. . .
 *      - part of the entire char's HEIGHT is taken up by the 3 horizontals
 *      - the remainder of HEIGHT is used by the 2 verticals, with the top one
 *          being slightly smaller, if that remainder is an odd number
* FLOCUP
 *****************************************************************************/

import javax.swing.JOptionPane;

public class DoEWithFor {

    public static void main(String[] args) {
        // ---------------------------------------------------------- VARIABLES
        String userInput;
        int height;
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
        // 1) Making the F
        for (int i = 1; i <= height; i++) {
            if (i == 1 || i == height) {
                for (int w = 1; w <= width; w++) {
                    System.out.print(pen);
                }
                System.out.println();
            }
            if (i > 1 && i < (height / 3)) {
                for (i = 1; i < (height / 3); i++) {
                    System.out.println(pen);
                }
            }
            if (i == (height / 3)) {
                for (int w = 1; w <= (width); w++) {
                    System.out.print(pen);
                }
                System.out.println();
            }

            if (i > (height / 3) && i < (height - 1)) {
                for (i = (height / 3); i <= (height - 1); i++) {
                    System.out.println(pen);
                }
            }
        }
        System.out.println();

        //Making the L or Taking it
        for (int i = 1; i <= height; i++) {
            if (i < height) {
                System.out.println(pen);
            }
            if (i == height) {
                for (int w = 1; w <= width; w++) {
                    System.out.print(pen);
                }
                System.out.println();
            }
        }
        System.out.println();

        //Making the O
        for (int i = 1; i <= height; i++) {
            if (i == 1 || i == height) {
                for (int w = 1; w <= width; w++) {
                    System.out.print(pen);
                }
                System.out.println();
            } else {
                System.out.print(pen);
                for (int w = 2; w < (width); w++) {
                    System.out.print(" ");
                }
                System.out.print(pen);
                System.out.println();
            }
        }
        System.out.println();

        //Making the C
        for (int i = 1; i <= height; i++) {
            if (i == 1 || i == height) {
                for (int w = 1; w <= width; w++) {
                    System.out.print(pen);
                }
                System.out.println();
            } else {
                System.out.println(pen);
            }
        }
        System.out.println();

        //Making the U
        for (int i = 1; i <= height; i++) {
            if (i == height) {
                for (int w = 1; w <= width; w++) {
                    System.out.print(pen);
                }
            } else {
                System.out.print(pen);
                for (int y = 2; y < width; y++) {
                    System.out.print(" ");
                }
                System.out.println(pen);
            }
        }
        System.out.println();
        System.out.println();

        //Making the P
        for (int i = 1; i <= height; i++) {
            if (i == 1 || i == (height / 3)) {
                for (int w = 1; w <= width; w++) {
                    System.out.print(pen);
                }
                System.out.println();
            } else if (i > 1 && i <= height / 3) {
                for (int y = 2; y <= height / 3; y++) {
                    System.out.print(pen);
                    for (int w = 2; w < width; w++) {
                        System.out.print(" ");
                    }
                    System.out.println(pen);
                }
            } else if (i > (height / 3) && i < height) {
                System.out.println(pen);
            }
        }

        // ---------------------------------------------------------- FINISH-UP
        System.out.printf("\n\nheight: %d, width: %d\n", height, width);
        System.exit(0);
    }
}
