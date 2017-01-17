/* PROJECT:  Lab 9 Exercises
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 1
 ******************************************************************************/
package lab.exercise.pkg9;

import java.util.Scanner; // needed to use Scanner for input
import java.io.*;

public class KeyboardScanner {

    public static void main(String[] args) throws FileNotFoundException {

        // WRITE main's CODE HERE
        int num1;
        double num2;
        String name;
        double sum;
        // Setup a Scanner called in to scan the keyboard (System.in)
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        num1 = in.nextInt(); // use nextInt() to read int
        System.out.print("Enter a floating point number: ");
        num2 = in.nextDouble(); // use nextDouble() to read double
        System.out.print("Enter your name: ");
        name = in.next(); // use next() to read String
        // Display
        sum = num1 + num2;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(sum);
        System.out.println(name);
        
        PrintWriter printFile = new PrintWriter("file.txt");
        printFile.printf("Hi %s, the sum of %d and %f is %f.", 
                name, num1, num2, sum);
        
        
        // Close the input stream
        printFile.close();

    }

}
