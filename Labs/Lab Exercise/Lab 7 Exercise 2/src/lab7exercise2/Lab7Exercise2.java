/* PROJECT:  Lab 7 Exercises
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Task 2
 ******************************************************************************/
package lab7exercise2;
import java.util.Scanner;

public class Lab7Exercise2 {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        Scanner scan = new Scanner(System.in);
        String input;
        
        String[][] country =new String[2][6];
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                if(i == 0)
                {
                System.out.println("Enter the country");
                input = scan.nextLine();
                country[i][j] = input;
                }
                if(i == 1)
                {
                System.out.println("Enter the population for " + country[0][j]);
                input = scan.nextLine();
                country[i][j] = input;
                }
                
            }
        
        }
        
        System.out.println();
        for(int i = 0; i < 6; i++)
        {
                System.out.println(country[0][i] + " : " + country[1][i]);
        }
        
        
        
        
    }

}//End of main
