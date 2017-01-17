/* PROJECT:  PseudoGameOfCups
 * AUTHOR:  Dr. Kaminski - modified by          Jonah Kubath
 * DESCRIPTION:  [Inspired by Chandler's GameOfCups with Joey in "Friends"].
 *      Program gets zipCode (5-digit, not 9-digit) from user.
 *      It awards points based on a series of silly criteria, and reports the 
 *              total points at the end.
 *      Along the way, it also prints out
 *              "RULE ___ GOT YOU ANOTHER ___ POINTS, SO TOTAL IS ___"
 *          each time more points are awarded.
 * 8 RULES FOR GETTING POINTS (which are an accumulated total):
 *      1) 1 point when sum of 5 digits is between 10 & 20 (inclusive)
 *              2 points when sum is 21 to 30
 *              3 points when sum is 31 to 40
 *              4 points when sum is more than 40
 *      2) 5 points when 1st & last digits match
 *      3) 6 points when 2nd digit is twice the 1st digit AS WELL AS
 *              the 3rd digit being greater than 2nd or 4th digit
 *      4) 7 points when there's a lucky 7 anywhere in zipCode
 *      5) 8 points when there's NO 13 in MIDDLE of zipCode
 *              (like 21322 or 88138 would mean NO points for rule 5)
 *              (but zipCodes like 13777 or 99913 with 13's at start/end are
 *                      irrelevant for rule 5)
 *      6) 9 points when all 3 middle digits match
 *      7) 10 points when 3rd & 4th digits are both 0
 *      8) 11 points when it's a palindrome
 *              (i.e., 1st & 5th match as well as 2nd & 4th match)
 *
 * IMPORTANT:
 * 1) INCREMENTAL DEVELOPMENT:  Whenever you add code for another rule, 
 *      compile/run it (and check output) to always keep program in a
 *      "working state".  It currently compiles/runs cleanly.
 * 2) TESTING:
 *      Test program with different "inputs" & check if results are right.
 *      Test cases should test each rule.
 *      Comment/uncomment "other" rule-checking code when testing a specific
 *          one of the 8 rules.
 ****************************************************************************/

package pseudogameofcups;

import javax.swing.JOptionPane;

public class PseudoGameOfCups {
    
    public static void main(String[] args) {

        // ************************************************** DECLARE VARIABLES
        // Need to store:  zip code (say zip),
        //      the 5 individual digits (say d1, d2, ... d5),
        //      other intermediate results (?),
        //              (depending on how you "split zip into the 5 digits")
        //      total Points (say total),
        //      points for a specific rule (say pts) which needs to be printed,
        //      other ??? as needed
        int zip = 0, d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0;
        int totalDigit = 0; // adds the total of the digits
        int rem = 0, total = 0;
        int pts = 0;
        String input;
        
            
        // ***************************************************** GET USER INPUT
        input = JOptionPane.showInputDialog("Enter your 5 digit zip code.");
        zip = Integer.parseInt(input);
        
        
        // ********************************************************* PROCESSING
        // - - - - - - - - - - - - - - - - - SPLIT zip into 5 individual digits

        d1 = zip / 10000;
        rem = zip % 10000;
        
        d2 = rem / 1000;
        rem = rem % 1000;
        
        d3 = rem / 100;
        rem = rem % 100;
         
        d4 = rem / 10;
        rem = rem % 10;
        
        d5 = rem;
        
        //System.out.println("You entered " + d1 + d2 + d3 + d4 + d5);
        
        
        // UNCOMMENT THIS FOR TESTING, but comment it out for final project
//        System.out.println("FYI:  the 5 individual digits: " +
//                    d1 + " " + d2 + " " + d3 + " " + d4 + " " +  d5);
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 1
        totalDigit = d1 + d2 + d3 + d4 + d5;
        if (totalDigit>= 10 && totalDigit <= 20)
        {
            pts = 1;
            total = pts;
            
        }
        else if ( totalDigit >= 21 && totalDigit <= 30)
        {
            pts = 2;
            total = pts;
            
        }
        else if ( totalDigit >= 31 && totalDigit <= 40)
        {
            pts = 3;
            total = pts;
            
        }
        else if ( totalDigit > 40)
        {
            pts = 4;
            total = pts;
            
        }
        
        
        // RE-USE THIS CODE FOR EACH RULE (copy & paste, then FIX rule number)
        //      [NOTE:  shortcuts for copy & paste:  CTRL-C & CTRL-V ]         
        System.out.printf("RULE 1 GOT YOU ANOTHER %3d" +
              " POINTS, SO TOTAL IS %3d\n", pts, total);
        
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 2
        if (d1 == d5)
        {
            pts = 5;
            total = total + pts;
            System.out.printf("RULE 2 GOT YOU ANOTHER %3d" +
              " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        else
        {
            pts = 0;
            System.out.printf("RULE 2 GOT YOU ANOTHER %3d" +
              " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
//        
//        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 3
        if ( d2 == (2 * d1))
            if (d1 > d2 || d1 > d4)
            {
                pts = 6;
                total = total + pts;
                  System.out.printf("RULE 3 GOT YOU ANOTHER %3d" + 
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
            }
            else
            {
                pts = 0;
                System.out.printf("RULE 3 GOT YOU ANOTHER %3d" + 
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
            }
        else
        {
            pts = 0;
            System.out.printf("RULE 3 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        
//        
//        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 4
        if (d1 == 7 || d2 == 7 || d3 == 7 || d4 == 7 || d5 == 7)
        {
            pts = 7;
            total = total + pts;
            System.out.printf("RULE 4 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        else
        {
            pts = 0;
            System.out.printf("RULE 4 GOT YOU ANOTHER %3d" + 
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
//        
//        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 5
        if (d2 == 1 && d3 == 3)
        {
            pts = 0;
            System.out.printf("RULE 5 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
            
        else if ( d3 == 1 && d4 == 3)
        {
            pts = 0;
            System.out.printf("RULE 3 GOT YOU ANTOHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        else
        {
            pts = 8;
            total = total + pts;
            System.out.printf("RULE 5 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
            
        
//        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 6
        if ( d2 == d3 && d3 == d4 && d2 == d4)
        {
            pts = 9;
            total = total + pts;
            System.out.printf("RULE 6 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        else
        {
            pts = 0;
            System.out.printf("RULE 6 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
//        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 7
        if ( d3 == 0 && d4 ==0)
        {
            pts = 10;
            total = total + pts;
            System.out.printf("RULE 7 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        else
        {
            pts = 0;
            System.out.printf("RULE 7 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
           
        
//        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RULE 8   
        if (d1 == d5 && d2 == d4)
        {
            pts = 11;
            total = total + pts;
            System.out.printf("RULE 8 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
        }
        else
        {
            pts = 0;
            System.out.printf("RULE 8 GOT YOU ANOTHER %3d" +
                        " POINTS, SO TOTAL IS %3d\n", pts, total);
                   
        }
        
        // ******************************************************* FINAL OUTPUT
        System.out.println("\nTotal points:  " + total);
        System.out.println("\nTHE END");
        
        // ********************************************************** "CLEANUP"
        System.exit(0);
    }
}
