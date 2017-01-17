/* PROJECT:  Lab 9 Exercise 3
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 3
 ******************************************************************************/
package lab.exercise.pkg3;

import java.io.*;
import java.util.Scanner;


public class Lab9Exercise3 {

    public static void main(String[] args) throws FileNotFoundException {

        // WRITE main's CODE HERE
        int[] numbers = {10, 20, 30, 40, 50};
        PrintWriter outputFile = new PrintWriter("Values.txt");
        for (int i = 0; i < numbers.length; i++) {
            outputFile.println(numbers[i]);
        }
        outputFile.close();
        
        final int SIZE = 5; // Assuming we know the size.
        int[] numbersRead = new int[SIZE];
        int i = 0;
        File file = new File("Values.txt");
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext() && i < numbersRead.length) {
            numbersRead[i] = inputFile.nextInt();
            i++;
            
        }
        inputFile.close();

    }

}
