/* PROJECT:  RanNumStream
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  This project:
 *      - generates a stream of N random integers (between 0 and 100)
 *      - print each out along with a counter, like:
 *              01 >> 25
 *              02 >> 48
 *              ..
 *              20 >> 02
 *      - finds the biggest and smallest numbers of those N numbers
 *          and prints them out
 *      - determines how many are even and how many are odd
 *          and prints those out
 ****************************************************************************/
package rannumstream;

import java.util.Random;

public class RanNumStream {

    public static void main(String[] args) {
        
       int n = 20;
        
       Random r = new Random(12345);
       makeNumber(r, n);
       
    }  
    
    public static void makeNumber(Random r, int n)
    {
        int randomNumber = 0;
        int counter = 0;
        int odd = 0, even = 0;
        int smallest = 100 , biggest = 0;
        for(int i = 1; i <=n; i++)
        {
            randomNumber = r.nextInt(101);
            counter++;
            System.out.println(counter + " >> " + randomNumber);
            //Saving the biggest and smallest
            if (randomNumber > biggest)
                biggest = randomNumber;
            else if ( randomNumber < smallest)
                smallest = randomNumber;
            //determining if odd or even
            if (randomNumber % 2 == 0)
                even++;
            else
                odd++;
                
        }
        System.out.println();
        System.out.println("The smallest number is: " + smallest);
        System.out.println("The biggest number is:  " + biggest);
        System.out.println("There were " + odd + " odd numbers.");
        System.out.println("There were " + even + " even numbers.");
        
    }
    
}
