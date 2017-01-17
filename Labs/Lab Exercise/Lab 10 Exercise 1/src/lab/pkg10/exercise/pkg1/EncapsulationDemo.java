/* CLASS:  
 * AUTHOR: Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package lab.pkg10.exercise.pkg1;

public class EncapsulationDemo {

    // WRITE CODE HERE
    private int ssn;
    private String empName;
    private int empAge;
//Generate Getter and Setter methods

    public int getSsn() {
        return ssn;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }
    
    @Override
    public String toString(){
        String obj = String.format("This is our data:\n%s %s %s", getSsn(), getEmpName(), getEmpAge());
        
        return obj;
    }
}
