/* PROJECT:  Lab4ExerciseC
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise C done in class on October 3, 2016
 ******************************************************************************/
package lab4exercisec;
import java.util.*;
import java.io.*;

public class Lab4ExerciseC {

    public static void main(String[] args) {
        
        int method;
        int seriesNumber;
        // WRITE main's CODE HERE
        System.out.println("Enter the number of queries you have.");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++){
            System.out.println("Enter the first integer.");
            int a = in.nextInt();
            System.out.println("Enter the second integer.");
            int b = in.nextInt();
            System.out.println("Enter the third integer.");
            int n = in.nextInt();
            System.out.println();
            
            method = calcNth(b, n);
            
            seriesNumber = a;
            for(int count = 0; count < n; count++)
            {
                seriesNumber += calcNth(count, b);
                
                System.out.println(seriesNumber + " ");
            }
            
            
        }
        
        
    }
    
    public static int calcNth(int count, int b)
        {
            return ((int) Math.pow(2, count) * b);
                   
        }

}
