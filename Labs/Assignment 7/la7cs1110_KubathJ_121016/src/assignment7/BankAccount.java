/* CLASS:  Bank Account
 * AUTHOR: Jonah Kubath
 * DESCRIPTION:  Individual bank account objects
 ******************************************************************************/
package assignment7;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class BankAccount {

    private double balance;
    private int deposits;
    private int withdraw;
    private double interest;
    private double serviceCharge;
    private String pin;
    SavingsAccount savings;

    public BankAccount(double pBalance, double pInterest) {
        setBalance(pBalance);
        setInterest(pInterest);
        savings = new SavingsAccount(balance);

    }

    public BankAccount() {
    }

    public int getDeposits() {
        return deposits;
    }

    public double getInterest() {
        return interest;
    }

    public double getBalance() {
        return balance;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public String getPin() {
        return pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDeposits(int deposits) {
        this.deposits = deposits;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void deposit() {
        //if(pinCode()){
        String input = JOptionPane.showInputDialog("What is the deposit amount?");
        //Validation
        String inputCheck = input.replaceAll("[^0-9.]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid input. \n"
                    + "Enter only numbers");
            inputCheck = input.replaceAll("[^0-9.]", "~");
        }
        //Add to balance
        double deposit = Double.parseDouble(input);
        double balance = getBalance() + deposit;
        setBalance(balance);
        //Increment number of deposits
        int numberDeposit = getDeposits();
        numberDeposit++;
        setDeposits(numberDeposit);

        if(getBalance() > 25)
            savings.deposit();

    }

//        else
//            JOptionPane.showMessageDialog(null, "Incorrect Pin");
//        
//    }
    public void withdraw() {
        //if(savings.isStatus){
        String input = JOptionPane.showInputDialog("What is the amount to withdraw?");
        //Validation
        String inputCheck = input.replaceAll("[^0-9.]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid input. \n"
                    + "Enter only numbers");
            inputCheck = input.replaceAll("[^0-9.]", "~");
        }

        //Subtract from balance
        double withdraw = Double.parseDouble(input);
        //Check withdrawal amount and balance
        if (getBalance() - withdraw < 0) {
            System.out.println("Insefficient funds");
            JOptionPane.showMessageDialog(null, "Insefficient funds. Transaction failed.");
        } else if (!savings.isStatus()) {
            
            System.out.println("Account is inactive");
            JOptionPane.showMessageDialog(null, "Account is at or below $25\n"+
                    "Account is inactive and transaction failed");
        } else {
            double balance = getBalance() - withdraw;
            setBalance(balance);
            //Increment number of withdrawals
            int numberWithdraw = getWithdraw();
            numberWithdraw++;
            setWithdraw(numberWithdraw);
        }
        if(getBalance() <= 25)
            savings.withdraw();

    }
//        else
//            JOptionPane.showMessageDialog(null, "Incorrect Pin");
//
//    }

    //called by monthly process - Pin is already checked
    public void calcInterest() {
        double interest;
        //Check for interest rate
        if (getInterest() == 0) {
            String input = JOptionPane.showInputDialog("What is the annual interest rate?\n"
                    + "Example: 5.4");
            String inputCheck = input.replaceAll("[^0-9.]", "~");
            while (inputCheck.compareTo(input) != 0) {
                input = JOptionPane.showInputDialog("Invalid input. \n"
                        + "Enter only numbers");
                inputCheck = input.replaceAll("[^0-9.]", "~");
            }

            interest = Double.parseDouble(input) / 100;
            setInterest(interest);
        }//End of if
        else {
            interest = getInterest();
        }
        double monthlyInterest = interest / 12;
        double monthlyEarned = interest * getBalance();
        System.out.printf("Earned interest: $%.2f\n", monthlyEarned);
        double balance = getBalance() + monthlyEarned;
        setBalance(balance);

    }

    public void monthlyProcess() {
        //if(pinCode()){
        double serviceCharge;
        //Check for process fee
        if (getServiceCharge() == 0) {
            String input = JOptionPane.showInputDialog("What is the cost of service?\n"
                    + "Example: 25");
            String inputCheck = input.replaceAll("[^0-9.]", "~");
            while (inputCheck.compareTo(input) != 0) {
                input = JOptionPane.showInputDialog("Invalid input. \n"
                        + "Enter only numbers");
                inputCheck = input.replaceAll("[^0-9.]", "~");
            }

            serviceCharge = Double.parseDouble(input);
            setServiceCharge(serviceCharge);
        } else {
            serviceCharge = getServiceCharge();
        }

        //Subtract from balance
        setBalance(getBalance() - serviceCharge);

        //Calculate interest
        calcInterest();
        System.out.printf("Cost of service: $%.2f\n", serviceCharge);

        //Set to deposits, withdraws,  and service charge, to 0
        setDeposits(0);
        setWithdraw(0);
        setServiceCharge(0);
    }
//        else
//            JOptionPane.showMessageDialog(null, "Incorrect Pin");
//    }

    public String toString() {
        String format = String.format("Balance: %.2f\nNumber of Withdrawals: "
                + "%d\nNumber of Deposits: %d", getBalance(), getWithdraw(), getDeposits());
        return format;

    }

    public boolean pinCode() {
        boolean isCorrect = false;
        String password = "";
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Pin Code", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            password = new String(pf.getPassword());
        }

        if (this.pin.compareTo(password) == 0) {
            isCorrect = true;
        }
        return isCorrect;
    }

}
