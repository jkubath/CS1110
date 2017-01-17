/* PROJECT:  TimeCalculator
 * AUTHOR:  Jonah Kubath
 * [NOTE:  Project based on problem from our Gaddis' textbook].
 * PROGRAM DESCRIPTION:  This program calculate & displays (to Console window):
 *      1) generic intermediate data used in subsequent calculations:
 *          the number of seconds in a day,
 *          the number of seconds in an hour,
 *          the number of seconds in a minute (just generic 
 *      2) (for valid input data)
 *              the number of days, hours, minutes & seconds equivalent to input
 *         (for invalid input data)
 *              an error message 
 * USER INPUT DATA (from a dialog box):  a number of seconds
 *      (which must be a positive integer with 2 to 6 digits).
 *****************************************************************************/

package timecalculator;

import javax.swing.JOptionPane;

public class TimeCalculator {

    public static void main(String[] args) {
        
        // ---------------------------------------------------------- VARIABLES
        int seconds, minutes, hours, days, userInput;
        int secondDay, secondHour, time;
        String inputSeconds;
        
        secondDay = 60 * 60 * 24;
        secondHour = 60 * 60;
        
        
        // -------------------------------------------------------------- INPUT
        inputSeconds = JOptionPane.showInputDialog("Enter the number of seconds.");
        userInput = Integer.parseInt(inputSeconds);
        
        // --------------------------------------------------------- PROCESSING
        time = userInput;
        days = userInput / secondDay;
        userInput = userInput % secondDay;
        
        hours = userInput / secondHour;
        userInput = userInput % secondHour;
        
        minutes = userInput / 60;
        userInput = userInput % 60;
        
        seconds = userInput;
        
        
        // ------------------------------------------------------------- OUTPUT
        if (time > 9 && time < 1000000)
        {
            System.out.println("You entered: " + time + " seconds.");
            System.out.println();  //line space
            System.out.println("_______________________________");
            System.out.println(days + " days");
            System.out.println(hours + " hours");
            System.out.println(minutes + " minutes");
            System.out.println(seconds + " seconds");
        }
        else
            System.out.println("Invalid Entry");
        // ------------------------------------------------------------- ENDING
        System.out.println("\nTHE END");
        System.exit(0);
    }
}
