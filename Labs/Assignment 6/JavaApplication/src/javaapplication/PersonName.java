/* PROJECT:  Assignment 6 - Contacts
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Name Object
 ******************************************************************************/
package javaapplication;

/**
 *
 * @author Jonah Kubath
 */
public class PersonName {

    private String firstName;
    private String lastName;
    private String middleName;

    
    public PersonName(String last, String first, String middle) {
        setFirstName(first);
        setLastName(last);
        setMiddleName(middle);
    }

    //No inputs
    public PersonName() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.trim();
    }

    public String toString() {
        String name = String.format("%s %s %s", getFirstName(), getMiddleName(),
                getLastName());

        return name;
    }

    public static int compareTo(PersonName n1, PersonName n2) {
        int compare = 0;
        String last1 = n1.getLastName();
        last1 = last1.trim();
        String last2 = n2.getLastName();
        last2 = last2.trim();
        if (last1.compareTo(last2) < 0) {
            compare = -1;
        } else if (last1.compareTo(last2) > 0) {
            compare = 1;
        } else if (last1.compareTo(last2) == 0) {
            String first1 = n1.getFirstName();
            String first2 = n2.getFirstName();
            if (first1.compareTo(first2) < 0) {
                compare = -1;
            } else if (first1.compareTo(first2) > 0) {
                compare = 1;
            } else if (first1.compareTo(first2) == 0) {
                String middle1 = n1.getMiddleName();
                String middle2 = n2.getMiddleName();
                if (middle1.compareTo(middle2) < 0) {
                    compare = -1;
                } else
                    compare = 1;
            }
        }

        return compare;
    }

    public String returnCSV() {
        String csv = String.format("%s,%s,%s", getLastName(), getFirstName(), getMiddleName());
        return csv;
    }

}
