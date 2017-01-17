/* PROJECT:  Bank Account Assignment 7
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Bank/Savings Account
 ******************************************************************************/
package assignment7;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Assignment7 {

    public static void main(String[] args) {
        double balance = accountBalance();
        double interest = interestRate();
        double serviceCharge = serviceCharge();
        String pin = pinCode();

        BankAccount account = new BankAccount(balance, interest);
        
        account.setServiceCharge(serviceCharge);
        account.setInterest(interest);
        account.setPin(pin);
        boolean continueChoice = true;
        do{
        
        int userChoice = choice();
        switch(userChoice){
            case(1):
                //if(account.pinCode()){
                JOptionPane.showMessageDialog(null, account.toString());
                //}
//                else
//                    JOptionPane.showMessageDialog(null, "Invalid pin");
                break;
            case(2):
                
                account.deposit();
                break;
            case(3):
                account.withdraw();
                break;
            case(4):
                continueChoice = false;
                break;
            default:
                break;   
        }
        
        }while(continueChoice);
        
        System.out.println("\nFinished");

    }//End of Main

    public static double accountBalance() {
        //Account Balance
        String input = JOptionPane.showInputDialog("Enter the balance.");
        //Validation
        String inputCheck = input.replaceAll("[^0-9.]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid input. \n"
                    + "Enter only numbers");
            inputCheck = input.replaceAll("[^0-9.]", "~");
        }

        return Double.parseDouble(input);
    }

    public static double interestRate() {
        //Interest Rate
        String input = JOptionPane.showInputDialog("Enter the yearly interest rate.\n"
                + "Example: 5.4");
        //Validation
        String inputCheck = input.replaceAll("[^0-9.]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid input. \n"
                    + "Enter only numbers");
            inputCheck = input.replaceAll("[^0-9.]", "~");
        }

        return Double.parseDouble(input) / 100;
    }

    public static double serviceCharge() {
        //Service Charge
        String input = JOptionPane.showInputDialog("Enter the monthly service charge.");
        //Validation
        String inputCheck = input.replaceAll("[^0-9.]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid input. \n"
                    + "Enter only numbers");
            inputCheck = input.replaceAll("[^0-9.]", "~");
        }

        return Double.parseDouble(input);
    }

    public static String pinCode() {
        
        String password = "";
           JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Set Pin Code", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
          password = new String(pf.getPassword());
        }

        return password;
    }

    public static int choice() {
        String one = "1: To list the account balance and number of withdraws/deposits";
        String two = "2: To make a deposit";
        String three = "3: To make a withdrawal";
        //String four = "4: To perform monthly maintenance";
        String five = "4: To Exit";
        String format = String.format("%s\n%s\n%s\n%s", one, two, three, five);
        String input = JOptionPane.showInputDialog("What action would you like to take?\n\n"
                + format);
        String inputCheck = input.replaceAll("[^0-9.]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid input. \n"
                    + "Enter only numbers 1-4");
            inputCheck = input.replaceAll("[^0-9.]", "~");
        }
        int userChoice = Integer.parseInt(input);
        while (userChoice > 4 || userChoice < 1) {
            input = JOptionPane.showInputDialog("invalid choice.\n"
                    + "Enter 1-4\n" + format);
            while (inputCheck.compareTo(input) != 0) {
                input = JOptionPane.showInputDialog("Invalid input. \n"
                        + "Enter only numbers" + format);
                inputCheck = input.replaceAll("[^0-9.]", "~");
            }
            userChoice = Integer.parseInt(input);
        }
        
        return userChoice;

    }
    
    //Not needed
    public static boolean userContinue(){
        
        String input = JOptionPane.showInputDialog("Would you like to continue?\n"+
                "Yes or No");
        input = input.toUpperCase();
        char inputChar = input.charAt(0);
        while(inputChar != 'Y' && inputChar != 'N'){
            input = JOptionPane.showInputDialog("Invalid input. \n" +
                    "Enter: Yes or No");
            input = input.toUpperCase();
            inputChar = input.charAt(0);
        }
        boolean userChoice = false;
        if(inputChar == 'Y'){
            userChoice = true;
        }
        return userChoice;
    }

}
