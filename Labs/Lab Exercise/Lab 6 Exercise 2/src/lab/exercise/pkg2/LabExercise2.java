/* PROJECT:  Lab Exercise 2
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Lab Exercise 2
 ******************************************************************************/
package lab.exercise.pkg2;
import java.util.*; 


public class LabExercise2 {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        
    Scanner scan = new Scanner(System.in);
    System.out.println("How many numbers do you want to enter.");
    int n = scan.nextInt();
    int[] array = new int[n];
    
    for(int i = 0 ; i < n; i++)
    { 
        int val = scan.nextInt();
        array[i] = val;
    } 
    scan.close(); 
// Prints each sequential element in array a
    for (int i = 0; i < n; i++)
    {
        System.out.println("Spot " + i + ": " + array[i]);
    }
    
    
    }

}
