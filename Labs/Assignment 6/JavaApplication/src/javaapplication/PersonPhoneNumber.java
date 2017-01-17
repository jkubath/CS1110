/* PROJECT:  Assignment 6 - Contacts
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Phone Number Object
 ******************************************************************************/
package javaapplication;

/**
 *
 * @author Jonah Kubath
 */
public class PersonPhoneNumber {

    private String areaCode;
    //first 3 digits
    private String exchgCode;
    //remaining 4
    private String localNumber;

    
    public PersonPhoneNumber(String area, String first, String last){
        setAreaCode(area);
        setExchgCode(first);
        setLocalNumber(last);
    }
    //no inputs
    public PersonPhoneNumber(){
        
    }
    
    
    public String getAreaCode() {
        return areaCode;
    }

    public String getExchgCode() {
        return exchgCode;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode.trim();
    }

    public void setExchgCode(String exchgCode) {
        this.exchgCode = exchgCode.trim();
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber.trim();
    }
    
    public String toString(){
        String phone = String.format("(%s) %s - %s", getAreaCode(), getExchgCode(),
                getLocalNumber());
        return phone;
    }
    
    public String returnCSV(){
        String csv = String.format("%s,%s,%s", getAreaCode(), getExchgCode(),getLocalNumber());
        
        return csv;
    }

}
