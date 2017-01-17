/* PROJECT:  Lab7 Exercise
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Task 5
 ******************************************************************************/
package lab7exercise5;
import java.util.Scanner;

public class Lab7Exercise5 {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        int length = 0;
        int i = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many numbers are you going to enter?");
        length = scan.nextInt();
        int array[] = new int[length];
        
        //Get array
        for(i = 0; i < length; i++)
        {
            System.out.println("Enter an integer");
            int number = scan.nextInt();
            array[i] = number;
        }
        
        //Print the array
        for(i = 0; i < length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        //Reverse array method 1
//        int temp[] = new int[length];
//        int count = length - 1;
//        for(i = 0; i < length; i++){
//            
//            temp[i] = array[count];
//            count--;
//            
//        }
        //Reverse array method 2
        int current = 0;
        //Count backwards
        int count = length - 1;
        for(i = 0; i < length/2; i++)
        {
            current = array[i];
            array[i] = array[count];
            array[count] = current;
            count--;
        }
        
        
        
        
        //Print the reversed array
        for(i = 0; i < length; i++)
        {
            //array[i] = temp[i];
            System.out.print(array[i] + " ");
        }
        
        
        
        
        
        
        
        
        
        
        
    }

}
