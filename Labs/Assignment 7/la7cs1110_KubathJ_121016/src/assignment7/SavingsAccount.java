/* CLASS:  Savings Account 
 * AUTHOR: Jonah Kubath
 * DESCRIPTION:  extends BankAccount and is on or off depending on balance
 ******************************************************************************/
package assignment7;

public class SavingsAccount extends BankAccount {

    //Active or inactive
    private boolean status;

    public SavingsAccount() {
        setStatus(true);
    }

    public SavingsAccount(double balance) {
        if (balance > 25) {
            setStatus(true);
        } else {
            setStatus(false);
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public void withdraw() {
        setStatus(false);
    }

    
    public void deposit() {
        setStatus(true);

    }

    
    public void monthlyProcess() {
        //Check number of withdraws
        if (getWithdraw() > 4) {
            int withdrawAbove = getWithdraw() - 4;
            setServiceCharge(getServiceCharge() + withdrawAbove);
        }
        //Call monthly processes
        super.monthlyProcess();
        //Check balance
        if (getBalance() < 25) {
            setStatus(false);
        }
    }

}
