/* PROJECT:  Assignment 6 - Contacts
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Individual Contact Object
 ******************************************************************************/
package javaapplication;

/**
 *
 * @author Jonah Kubath
 */
public class Contact {

    private PersonName name;
    private PersonPhoneNumber phoneNum;
    private PersonAddress address;

    public Contact(PersonName pName, PersonPhoneNumber pPhoneNum, PersonAddress pAddress) {
        setName(pName);
        setPhoneNum(pPhoneNum);
        setAddress(pAddress);
    }

    //No Input
    public Contact() {

    }

    public PersonName getName() {
        return name;
    }

    public PersonPhoneNumber getPhoneNum() {
        return phoneNum;
    }

    public PersonAddress getAddress() {
        return address;
    }

    public void setName(PersonName name) {
        this.name = name;
    }

    public void setPhoneNum(PersonPhoneNumber phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(PersonAddress address) {
        this.address = address;
    }

    public String toString() {
        String[] name = getName().toString().split(" ");
        String[] address = new String[5];
        address[0] = getAddress().getFirstLineOfStreet();
        address[1] = getAddress().getSecondLineOfStreet();
        address[2] = getAddress().getCity();
        address[3] = getAddress().getState();
        address[4] = getAddress().getZipCode();

        String[] phone = new String[3];
        phone[0] = getPhoneNum().getAreaCode();
        phone[1] = getPhoneNum().getExchgCode();
        phone[2] = getPhoneNum().getLocalNumber();
        String format;
        String formatString;
        
        //Output depends on if Address Line 2 is used or not
        if (address[1].compareTo("") != 0) {
            format = "%s,%s,%s\n%s,%s,%s,%s,%s\n%s,%s,%s";
            formatString = String.format(format, name[0], name[1], name[2],
                    address[0], address[1], address[2], address[3], address[4],
                    phone[0], phone[1], phone[2]);
        } else {
            format = "%s,%s,%s\n%s,%s,%s,%s\n%s,%s,%s";
            formatString = String.format(format, name[0], name[1], name[2],
                    address[0], address[2], address[3], address[4],
                    phone[0], phone[1], phone[2]);
        }

        return formatString;
    }
    
    public static int compareTo(Contact c1, Contact c2){
        return PersonName.compareTo(c1.getName(), c2.getName());
        
    }

}
