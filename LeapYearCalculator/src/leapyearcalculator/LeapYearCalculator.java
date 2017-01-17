/* PROJECT:  LeapYearCalculator
 * AUTHOR:  D.Kaminski
 * DESCRIPTION:  User enters a 4-digit year, and the program tells user
 *      whether that's a leap year or not.
 * CHECK YOUR RESULTS AGAINST either:
 *      a calculator:      http://www.onlineconversion.com/leapyear.htm
 *      a stored table of years:  http://kalender-365.de/leap-years.php
 ****************************************************************************/


package leapyearcalculator;
import javax.swing.JOptionPane;


                                            // <<<<< import . . .

public class LeapYearCalculator {

    public static void main(String[] args) {

        // -------------------------------------------------- DECLARE VARIABLES

        int year;
        String inputYear;
        boolean itsALeapYear;
        
        // ---------------------------------------------------------- GET INPUT

        inputYear = JOptionPane.showInputDialog("Input the year in question.");
        year = Integer.parseInt(inputYear);
        System.out.println(year);

        
        // ------------------------------------------------------ DO PROCESSING
        // USE THIS ALGORITHM to determine if it IS or IS NOT a leap year:
        // 0 - INITIALIZE the true/false type "flag" variable (say,
        //      itsALeapYear) to false.  The steps below may change it (back
        //      and forth, perhaps).
        // "LEAP YEAR RULES"
        // 1 - a year which is evenly divisible by 4 IS a leap year
        // 2 - BUT, it's NOT a leap year if year is evenly divisible by 100
        // 3 - BUT, an exception to rule 2:
        //      YES, it IS a leap year if year is evenly divisible by 400
        // -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

        // STEP 0
        itsALeapYear = false;
        
        // STEP 1
        if (year % 4 == 0)
        {
            itsALeapYear = true;
            System.out.println( year % 4);
            
            if (year % 100 == 0)
            {
                itsALeapYear = false;
                System.out.println( year % 100);
                
                if (year % 400 == 0)
                {
                    itsALeapYear = true;
                    System.out.println( year % 400);
                }
            
                else
                    itsALeapYear = false;
            }
            else
                itsALeapYear = true;
        }
        else 
            itsALeapYear = false;
                        
                
        
        // STEP 2
        
        
        // STEP 3


        // ------------------------------------------------------ OUTPUT ANSWER
        System.out.println("THE YEAR:  " + year);
        if (itsALeapYear == true)
               System.out.println("Is a leap year.");
        else 
               System.out.println("Is not a leap year.");



        
        // ---------------------------------------------------------- "CLEANUP"
        System.exit(0);
    }
}
