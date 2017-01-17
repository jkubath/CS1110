/* PROJECT:  BankCharges
 * AUTHOR:
 * THE PROBLEM: The bank charges a base fee of $10 per month (except for 
 *      customers who’ve been with the bank for over 10 years – they only pay
 *      an $8 base fee per month), plus the following check fees (that’s the
 *      price per check) for a commercial checking account:
 *              $.10 each for less than 20 checks
 *              $.08 each for 20-39 checks
 *              $.06 each for 40-59 checks
 *              $.04 each for 60 or more checks
 * [NOTE:  Project based on problem from our Gaddis' textbook].
 * PROGRAM DESCRIPTION:  This program that asks the user for the number of 
 *      checks written for that month and how many years they’ve been a
 *      customer at the bank.  It then calculates and displays the total 
 *      service fees for the month.
 * I/O:  dialog boxes for input, Console window for output.
 *****************************************************************************/
package bankcharges;

import javax.swing.JOptionPane;

public class BankCharges {

    public static void main(String[] args) {

        // ---------------------------------------------------------- VARIABLES
        String input;
        int check = 0, years = 0;
        double fee = 0, checkFee= 0, feeTotal = 0;
        
        // -------------------------------------------------------------- INPUT
        input = JOptionPane.showInputDialog("Enter the checks written this month.");
        check = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Enter the years you have been " +
                "with the bank.");
        years = Integer.parseInt(input);
        
        // --------------------------------------------------------- PROCESSING
        
        //Fee of service
        if (years < 10 && years >=0)
            fee = 10;
        else if (years >= 10)
            fee = 8;
        else
            System.out.println("Invalid Input.");
        
        //Fee for number of checks
        if (check >= 0 && check < 20)
        {
            feeTotal = fee + (.1 * check);
            checkFee = .1 * check;
        }
        else if (check>=20 && check < 40)
        {
            feeTotal = fee + (.08 * check);
            checkFee = .08 * check;
        }
        else if (check>= 40 && check < 60)
        {
            feeTotal = fee + (.06 * check);
            checkFee = .06 * check;
        }
        else if (check > 60)
        {
            feeTotal = fee + (.04 * check);
            checkFee = .04 * check;
        }
        else
            System.out.println("Invalid Check Number");
            
        
        // ------------------------------------------------------------- OUTPUT
        System.out.println("Years with company: " + years + " years");
        System.out.println("Checks written:     " + check + " checks \n");
        System.out.println("Fees: ");
        System.out.println("----------------------------------------");
        System.out.printf("Service:         $%5.2f\n", fee);
        System.out.printf("Checks written:  $%5.2f\n", checkFee);
        System.out.printf("Total:           $%5.2f\n", feeTotal);
        
        // ------------------------------------------------------------ CLEANUP
        
        System.exit(0);
    }
}
