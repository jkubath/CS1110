/* PROJECT:  Lab4 Exercise B
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise B done in class on October 3, 2016
 ******************************************************************************/
package lab4exerciseb;
import java.util.Scanner;

public class Lab4ExerciseB {

    public static void main(String[] args) {
        int N;
//        
        System.out.println("Input an integer between 2 and 125.");
        Scanner keyboard = new Scanner(System.in);
        N = keyboard.nextInt();
//        
        
        do {   
            if(N>125 || N<2){
                
            System.out.println("Invalid entry. Input a number between" +
                " 2 and 125.");
            N = keyboard.nextInt();
            }
            
            
        } while (N>125 || N<2);
        
        
        // WRITE main's CODE HERE
        System.out.println();
        for(int i = 1; i <=10; i++)
        {
            System.out.println(N + " x " +  i + " = " + (N * i));
        }
        
        
        
        
        
        
        
        
        
    }

}
