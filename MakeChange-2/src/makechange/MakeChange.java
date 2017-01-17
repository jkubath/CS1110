/* PROJECT:  MakeChange
 * AUTHOR:  Dr. Kaminski with modifications by: ____________________________ 
 * DESCRIPTION:  This program calculates the change owed to a customer.
 *      INPUT (Dialog Boxes):  customer's total bill & amount customer paid
 *      OUTPUT (Console):  (SEE SAMPLE BELOW IN OUTPUT SECTION COMMENT)
 *          total amount of change as a single number
 *          and this amount broken down into the number of:
 *                  $20 bills, $10 bills, . . . nickels, pennies
 *          with preference given to the largest bills/coins possible.
 *---------------------------------------------------------------------------*/
package makechange;

import javax.swing.JOptionPane;

public class MakeChange {

    public static void main(String[] args) {

        // -------------------------------------------------- DECLARE VARIABLES
        //                                          for INPUT
        // CODE GOES HERE >>>
        
        double theBill = 0, custPaid;
        String inputBill, inputPaid;
        //                                          for OUTPUT
        // CODE GOES HERE >>>

        int twenty = 0, ten = 0, five = 0, single = 0, 
                quarter = 0, dime = 0, penny = 0 , nickel = 0;
        
        //                                          for INTERMEDIATE RESULTS
        double actualChange = 0;
        int changeInPennies;
        int leftOver;                       // use repeatedly in calculations
        
        // -------------------------------------------------------------- INPUT
        // STAGE 1 OF TESTING:  Instead of asking user for 2 input values,
        //      the program just uses HARDCODED "input" test data.
        // STAGE 2 OF TESTING:  Change 2 amounts to various other values
        //      & check that it works correctly.
        // STAGE 3 OF TESTING:  Change this section to ask  user for these 2.

//        theBill = 3.47;                   // UNCOMMENT THESE 2 LINES WHEN
//        custPaid = 100.64;                 //      READY TO RUN TEST
           
        // ------------------------------------------------------- CALCULATIONS
        // Calculate the actual change and then all of the 8 individual numbers
        //      of bills and coins
        
        // CODE GOES HERE >>>
        inputBill = JOptionPane.showInputDialog("Enter the amount of the bill. $");
        theBill = Double.parseDouble(inputBill);
        
        inputPaid = JOptionPane.showInputDialog("Enter the amount" +
                " the customer paid");
        custPaid = Double.parseDouble(inputPaid);
        
        
        
        actualChange = custPaid - theBill;
        
        changeInPennies = (int) Math.round(actualChange * 100);
        twenty = changeInPennies / 2000;
        leftOver = changeInPennies % 2000;
//        System.out.println(twenty);


        ten = leftOver / 1000;
        leftOver = leftOver % 1000;
//        System.out.println(leftOver);
        
        five = leftOver / 500;
        leftOver = leftOver % 500;
//        System.out.println(leftOver);
        
        single = leftOver / 100;
        leftOver = leftOver % 100;
//        System.out.println(leftOver);
        
        quarter = leftOver / 25;
        leftOver = leftOver % 25;
//        System.out.println(leftOver);
        
        dime = leftOver / 10;
        leftOver = leftOver % 10;
//        System.out.println(leftOver);
        
        penny = leftOver / 1;
        leftOver = leftOver % 1;
//        System.out.println(leftOver);
        
        // CODE GOES HERE >>>
        
        
        
        
        

        
        // ------------------------------------------------------------- OUTPUT
        // OUTPUT LOOKS LIKE THIS (we'll fix some things later with printf):
        /*
            Bill is $3.47 and customer paid $10.0
            Change back to customer is 6.529999999999999 (= 653 in pennies)
            GIVE CUSTOMER THESE:
                    0 twenty dollar bills
                    0 ten dollar bills
                    1 five dollar bills
                    1 dollar bills
                    2 quarters
                    0 dimes
                    0 nickels
                    3 pennies
        */
        // CODE GOES HERE >>>
        System.out.println("Bill is $" + theBill + " and the customer paid $10.00");
        System.out.println("GIVE CUSTOMER CHANGE: " + actualChange);
        System.out.println("---------------------------------");
        System.out.println("\t" + twenty + " twenty dollar bills");
        System.out.println("\t" + ten + " ten dollar bills");
        System.out.println("\t" + five + " five dollar bills");
        System.out.println("\t" + single + " single dollar bills");
        System.out.println("\t" + quarter + " quarters");
        System.out.println("\t" + dime + " dimes");
        System.out.println("\t" + nickel + " nickels");
        System.out.println("\t" + penny + " pennies");
        
        
        //--------------------------------------------------------------------
        System.exit(0);
    }
}
