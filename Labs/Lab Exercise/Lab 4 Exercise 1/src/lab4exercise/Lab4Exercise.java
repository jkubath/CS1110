/* PROJECT:  Lab4 Exercise
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION: Exercises done in class on  October 3, 2016
 ******************************************************************************/
package lab4exercise;
import java.util.Scanner;
import java.io.*;


public class Lab4Exercise {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        String inputString1, inputString2, inputString3;
        int inputInt1 = 0, inputInt2 = 0, inputInt3 = 0;
        
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a string."
                + "  10 characters max.");
        inputString1 = keyboard.nextLine();
        
        System.out.println("Enter an integer. "
                + "  3 digts max from 0 <x> 999");
        inputInt1 = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.println("Enter a string."
                + "  10 characters max.");
        inputString2 = keyboard.nextLine();
        
        System.out.println("Enter an integer. "
                + "  3 digts max from 0 <x> 999");
        inputInt2 = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.println("Enter a string."
                + "  10 characters max.");
        inputString3 = keyboard.nextLine();
        
        System.out.println("Enter an integer. "
                + "  3 digts max from 0 <x> 999");
        inputInt3 = keyboard.nextInt();
        
        System.out.println("==============================");
        System.out.printf("%-15s", inputString1);
        System.out.printf("%03d", inputInt1);
        System.out.println();
        
        System.out.printf("%-15s", inputString2);
        System.out.printf("%03d", inputInt2);
        System.out.println();
        
        System.out.printf("%-15s", inputString3);
        System.out.printf("%03d", inputInt3);
        System.out.println();
        System.out.println("==============================");
        
        
        
        
        
    }

}
