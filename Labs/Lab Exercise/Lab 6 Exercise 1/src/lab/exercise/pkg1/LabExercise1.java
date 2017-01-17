/* PROJECT:  Lab Exercise 1
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Finding which data type a number will fit in
 ******************************************************************************/
package lab.exercise.pkg1;

import java.util.*;
import java.io.*;

public class LabExercise1 {

    public static void main(String[] args) {
        // WRITE main's CODE HERE

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to try?");
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {

            try {
                System.out.println("Enter the number.");
                long x = sc.nextLong();
                
                System.out.println(x + " can be fitted in:");
                
                if (x >= -128 && x <= 127) {
                    System.out.println("* byte");
                }
                if (x >= -32768 && x <=32767)
                    System.out.println("* short");
                if (x >= Math.pow(-2, 31) && x <=(Math.pow(2, 31) -1))
                    System.out.println("* int");
                if (x >= Math.pow(-2, 63) && x <= Math.pow(2, 63) -1)
                    System.out.println("* long");
            } 
            catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}
