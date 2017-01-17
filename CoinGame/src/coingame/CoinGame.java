/* PROJECT:  CoinGame
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  2 players toss their coin and compare results.
 *      Assume HEADS beats TAILS (and use true for heads, false for tails).
 *      Do N sets of coin tosses (each player tosses their coin).
 *      For each toss, print out the 2 results, like   heads heads
 *      Keep counts for (& print out at end):
 *          player 1 wins:  
 *          player 2 wins:
 *          a draw:
 * NOTE:  To make testing easier, use a SEED for the random number generator
 *      (e.g., the 12345 in Random parameter)
 *      so that each time you run the program you get the same exact results.
 *      By default, the seed is generally some function of system time.
 ****************************************************************************/
package coingame;

import java.util.Random;                

public class CoinGame {

    public static void main(String[] args) {

        int n = 20;
        boolean one, two;
        Random player1 = new Random(12345);
        Random player2 = new Random(54321);
        
        //running n times, comparing results, and counting
        
        nToss(n, player1, player2);
      
        
        // WRITE CODE HERE
      
        System.out.println("THE END");
    }
    
    //player one output
    public static void player1Toss(boolean one)
    {
        
         if (one)
         {
             System.out.println("Heads");
         }
         else
         {
             System.out.println("Tails");
         }
    }
    
    //Player two output
    public static void player2Toss(boolean two)
    {
         
         if (two)
         {
             System.out.println("Heads");
         }
         else
         {
             System.out.println("Tails");
         }
    }
    
    public static void nToss(int n,Random player1, Random player2)
    {
        int won;
        int player1Count = 0, player2Count = 0, draw = 0;
        for (int i = 1; i <=n; i++)
        {
            boolean one = player1.nextBoolean();
            boolean two = player2.nextBoolean();
            //Taking the random number and outputting heads or tails
            player1Toss(one);
            player2Toss(two);
            
            won = compareToss(one, two);
            if (won == 1)
            {
                player1Count++;
            }
            else if(won == 2)
            {
                player2Count++;
            }
            else
            {
                draw++;
            }
            
            
        }
        System.out.println("Player 1 won: " + player1Count + " flips");
        System.out.println("Player 2 won: " + player2Count + " flips");
        System.out.println("There were " + draw + " draws");
        
   
    }
    //Compares the toss
    public static int compareToss(boolean one, boolean two)
    {
        
        int player1;
        int player2;
        if(one)
            {
                player1 = 1;
            }
            else
            {
                player1 = 0;
            }
            
        if(two)
            {
                player2 = 1;
            }
            else
            {
                player2 = 0;
            }
        System.out.println(player1 + " " + player2);
        if(player1 > player2)
        {
            return 1;
        }
        else if(player2 > player1)
        {
            return 2;
            
        }
        else
            return 3;
            
    }
    
    
    
}
