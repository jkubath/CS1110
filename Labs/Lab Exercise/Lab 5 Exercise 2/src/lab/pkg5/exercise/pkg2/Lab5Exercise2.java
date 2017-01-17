/* PROJECT:  
 * AUTHOR:  Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package lab.pkg5.exercise.pkg2;

import javax.swing.JOptionPane;

public class Lab5Exercise2 {

    public static void main(String[] args) {

        String input;
        int number;
        boolean isOdd = false;
        boolean hasEight = false;
        input = JOptionPane.showInputDialog("Enter a positive integer.");
        number = Integer.parseInt(input);
        while (number < 0) {
            input = JOptionPane.showInputDialog("Error. The integer was "
                    + "negative. \nEnter a new number.");
            number = Integer.parseInt(input);
        }

        //Print the input
        System.out.println("Integer: " + number);

        //Test for even or odd
        isOdd = OddTest.isOdd(number);
        if (isOdd == false) {
            System.out.println("Even.");
        } else {
            System.out.println("Odd.");
        }

        //Calling hasEight
        hasEight = hasEight(number);
        if (hasEight == true) {
            System.out.println("The number has an 8.");
        } else {
            System.out.println("The number does not have an 8.");
        }

    }

    public static boolean hasEight(int number) {
        
        boolean hasEight = false;
        
        //Checking if the string has a 8
        hasEight = Integer.toString(number).contains("8");
        
        
        return hasEight;
    }

}
