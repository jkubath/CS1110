/* PROJECT:  Lab 3 exercises
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Lab 3
 ******************************************************************************/
package lab3.exercise;
import java.util.Scanner;

public class Lab3Exercise {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        String firstName, lastName, fullName;
        char firstChar;
        
        
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your first name.");
        firstName = keyboard.nextLine();
        System.out.println("Enter your last name.");
        lastName = keyboard.nextLine();
        
        fullName = firstName + " " + lastName;
        
        System.out.println(fullName);
        
        firstChar = firstName.charAt(0);
        
        System.out.println(firstChar);
        
        fullName = fullName.toUpperCase();
        System.out.println(fullName);
        
        int len=fullName.length();
        
        System.out.println(len);
        
        int count = 0, num;
        
        System.out.println();
        System.out.println("Enter a number.");
        num = keyboard.nextInt();
        
        while (num > 1)
        {
            num = num / 2;
            count++;
        }
        
        System.out.println(count);
        
       
        
    }

}
