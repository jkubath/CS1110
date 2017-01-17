/* PROJECT:  WriteBigEAlgor3
 * AUTHOR:  
 * DESCRIPTION:  This program prints out a big letter E in the OutputWindow.
 * ALGORITHM TO USE:    Row controller (from 1 to height) with
 *                          a row-decider nested inside of that
 *****************************************************************************/

public class WriteBigEAlgor3 {

    public static void main(String[] args) {

        int height = 16;
        int width = 12;
        char drawingChar = '#';
        for (int i = 1; i <= height; i++) {
            if (i == 1 || i == height / 2 || i == height) {
                doHorizLine(width, drawingChar);
            } else {
                System.out.println(drawingChar);
            }
        }
    }

    // ------------------------------------------------------------------------
    public static void doHorizLine(int howWide, char ch) {
        for (int col = 1; col <= howWide; col++) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
