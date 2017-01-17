/* PROJECT:  Lab2 Exercises
 * AUTHOR:  Andrew Rayl and Jonah Kubath
 * DESCRIPTION:  Task D
 ******************************************************************************/
package lab2.exercises.continued;
import java.util.Scanner;

public class Lab2ExercisesContinued {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        
        int n=0;
        String input;
        
        System.out.println("Enter an Integer.");
        Scanner keyboard = new Scanner(System.in);
        n = keyboard.nextInt();
        
        System.out.println(n);
        
        
        switch(n%2)
        {
            case 0:
                switch(n)
                {
                    case 1:
                    case 2:
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        System.out.println("Not Weird");
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:    
                    case 13:
                    case 14:    
                    case 15:
                        System.out.println("Weird");
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        System.out.println("Not Weird");
                        
                }
                break;
                
            case 1:
                System.out.println("Weird");
                break;
                
        }
        
    }

}
