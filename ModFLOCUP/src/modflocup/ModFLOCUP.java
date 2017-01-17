/* PROJECT:  ModFLOCUP
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Writes "LED sign" to Console window for FLOCUP.
 *      Uses 2-level hierarchy of methods/calls.
 *****************************************************************************/
package modflocup;

import javax.swing.JOptionPane;

public class ModFLOCUP {

    public static void main(String[] args) {

        int height; //= 10;
        int width; //= 12;
        char pen; //= 'X';
        
       
        height = getHeight();
        width = getWidth();
        pen = getChar();
        
        
        printF(height, width, pen);
        printL(height, width, pen);
        printO(height, width, pen);
        printC(height, width, pen);
        printU(height, width, pen);
        printP(height, width, pen);
        // TODO:  call each of the 6 methods in DoLetters, specifying the
        //          letter's height, width and pen

        
        
        
        
        System.out.println("\n\nTHE END");
    }
    
    public static int getHeight()
    {
        String input;
        int height, width;
        input = JOptionPane.showInputDialog("Enter the height");
        height = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Enter the width");
        width = Integer.parseInt(input);
        return height;
    }
    
    public static int getWidth()
    {
        String input;
        int width;
        input = JOptionPane.showInputDialog("Enter the width");
        width = Integer.parseInt(input);
        return width;
    }
    
    public static char getChar()
    {
        String input;
        char userInput;
        input = JOptionPane.showInputDialog("Enter the character");
        userInput = input.charAt(0);
        return userInput;
    }
    
    
    
    
    public static void printF(int height, int width, char pen)
    {
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
    }
    
    public static void printL(int height, int width, char pen)
    {
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
    }
    
    public static void printO(int height, int width, char pen)
    {
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
    }
    
    //Making the C
    public static void printC(int height, int width, char pen){
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
    }

        //Making the U
    public static void printU(int height, int width, char pen)
    {
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
    }

        //Making the P
    public static void printP(int height, int width, char pen)
    {
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
    }
    
    
    
    
}
