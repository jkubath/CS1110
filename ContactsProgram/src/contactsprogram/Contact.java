/* CLASS:  OOP for Contacts Program
 * AUTHOR: Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package contactsprogram;

public class Contact {

    // WRITE CODE HERE
    private String name;
    private long phone;

    //-------------------------------------------------------------------------
    public void setName(String pName) {
        name = pName;
    }
    public void setPhone(long pPhone){
        phone = pPhone;
    }
    
    //-------------------------------------------------------------------------
    public String getName(){
        return name;
    }
    public long getPhone(){
        return phone;
    }
    public char getFirstChar(){
        return name.charAt(0);
    }
    
    //-------------------------------------------------------------------------
    public long getAreaCode(){
        long areaCode = getPhone() / 10000000;
        return areaCode;
    }
    public long getLocalNumber(){
        long localNumber = getPhone() % 10000000;
        return localNumber;
    }
    
    //-------------------------------------------------------------------------
    public boolean is269AreaCode(){
        boolean inMichigan = false;
       
        if(getAreaCode() == 269)
        {
            inMichigan = true;
        }
        return inMichigan;
    }
    
    public void showData(){
        System.out.println("Name  : " + getName());
        System.out.println("Phone : " + getPhone());
    }
    
    public String toString(){
        String objectValue = String.format("The contents of the string are : "
                + "%s    %s",getName(), getPhone());
        return objectValue;
    }
    

}
