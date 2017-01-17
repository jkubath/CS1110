/* PROJECT:  Lab 5 Exercise 3
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 3
 ******************************************************************************/
package lab.pkg5.exercise.pkg3;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab5Exercise3 {

    public static void main(String[] args) {
        int number;

        //Adds all the inputs that contain an 8
        MagicSum();

    }

    public static void MagicSum() {
        String input;
        int userInput = 0;
        int total = 0;
        Scanner scan = new Scanner(System.in);

        while (userInput != -1) {
            System.out.println("Enter an integer. (Type -1 to stop)");
            userInput = scan.nextInt();
            if (Integer.toString(userInput).contains("8")) {
                total = total + userInput;
            }

        }
        System.out.println("The magic sum is: " + total);
    }

}
