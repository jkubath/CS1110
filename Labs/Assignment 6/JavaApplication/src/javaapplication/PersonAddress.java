/* PROJECT:  Assignment 6 - Contacts
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Address Object
 ******************************************************************************/
package javaapplication;

/**
 *
 * @author Jonah Kubath
 */
public class PersonAddress {
    private String firstLineOfStreet;
    private String secondLineOfStreet = "";
    private String city;
    private String state;
    private String zipCode;
    
    public PersonAddress(String firstLine, String secondLine, String pCity, 
            String pState, String pZip){
        setFirstLineOfStreet(firstLine);
        setSecondLineOfStreet(secondLine);
        setCity(pCity);
        setState(pState);
        setZipCode(pZip);
    }

    //No inputs
    public PersonAddress(){
        
    }
    public String getFirstLineOfStreet() {
        return firstLineOfStreet;
    }

    public String getSecondLineOfStreet() {
        return secondLineOfStreet;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setFirstLineOfStreet(String firstLineOfStreet) {
        this.firstLineOfStreet = firstLineOfStreet.trim();
    }

    public void setSecondLineOfStreet(String secondLineOfStreet) {
        this.secondLineOfStreet = secondLineOfStreet.trim();
    }

    public void setCity(String city) {
        this.city = city.trim();
    }

    public void setState(String state) {
        this.state = state.trim();
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode.trim();
    }
    
    public String toString(){
        String address = String.format("%s\n", getFirstLineOfStreet());
        if(getSecondLineOfStreet().compareTo("") != 0){
            address += String.format("%s\n", getSecondLineOfStreet());
        }
        address += String.format("%s %s %s", getCity(), getState(), getZipCode());
        
        return address;
    }
    
    public String returnCSV(){
        String csv = String.format("%s,%s,%s,%s,%s", getFirstLineOfStreet(),
                getSecondLineOfStreet(), getCity(), getState(), getZipCode());
        
        
        return csv;
    }
}
