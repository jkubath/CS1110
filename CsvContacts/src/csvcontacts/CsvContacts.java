/* PROJECT:  CsvContacts
 * AUTHOR:  Jonah Kubath   Designer: Dr. Kaminski
 * DESCRIPTION:  Prints a report based on user input data (in csv form)
 * INPUT:  User supplies a series of contacts in the form:
 *      firstName,lastName,areaCode,phone       like:
 *                        Mary,Doe,269,3871234
 *                        Johnathan Spencer,Miller-Jones,616,4567878
 *      User will type QUIT to indicate DONE.
 * OUTPUT:  A nice report of the data in this form:
 *          NAME                            PHONE
 *          ------------------------------  --------------
 *          Mary Doe                        (269) 387-1234
 *          Johnathan Spencer Miller-Jones  (616) 456-7878
 * OUTPUT REQUIREMENT:  the name field must be as long as the LONGEST name that
 *      was input - i.e., every printed name's length is the SAME, which is:
 *          first & last names & the space between & the 2 spaces after AND
 *          whatever space-padding is needed to make it the correct length.
 * HELP for PROCESSING:  The input & output are both streams.  HOWEVER, you 
 *      can't just handle this with the single stream-processing algorithm, i.e.,
 *              loop til done { "read" one, write one }
 *      because you can't start writing the report until you know the length
 *              of the longest name.
 *      So ALL inputing must be done before ANY outputing is done.
 *      So, you'll need STORAGE BINS for each of the 4 fields. 
 ****************************************************************************/
package csvcontacts;

import javax.swing.JOptionPane;

public class CsvContacts {

    public static void main(String[] args) {

        //------------------------------------------- DECLARE 4 PARALLEL ARRAYS
        final int MAX_N = 100;                              // "plenty big"
        int n = 0;

        // WRITE CODE HERE
        String[] lastName = new String[MAX_N];
        String[] firstName = new String[MAX_N];
        String[] areaCode = new String[MAX_N];
        String[] phone = new String[MAX_N];

        //------------------------------------------------ INPUT, SPLIT & STORE      
        String aLine;                           // a csv line read in from user
        String[] field = new String[4];         // to split aLine into fields

        introMessage();

        aLine = getALine();
        while (aLine.compareToIgnoreCase("QUIT") != 0) {

            field = aLine.split(",");
            // split aLine into field array using "," as splitter
            firstName[n] = field[0];
            lastName[n] = field[1];
            areaCode[n] = field[2];
            phone[n] = field[3];
            // store the 4 fields into the 4 parallel arrays
            n++;
            // increment n

            aLine = getALine();
        }
        System.out.println("THANKS for the input");
        
        //Making the first letter uppercase
        for(int i = 0; i < n; i++)
        {
            char firstLetter = firstName[i].charAt(0);
            String first = "" + firstLetter;
            first = first.toUpperCase();
            String lastFirst = "";
            for(int a = 1; a < firstName[i].length(); a++)
            {
                lastFirst += firstName[i].charAt(a);
            }
            firstName[i] = first + lastFirst;
            System.out.println(firstName[i]);
            
        }
        
        //Making the last name upper case
        for(int i = 0; i < n; i++)
        {
            char firstLetter = lastName[i].charAt(0);
            String first = "" + firstLetter;
            first = first.toUpperCase();
            String lastFirst = "";
            for(int a = 1; a < lastName[i].length(); a++)
            {
                lastFirst += lastName[i].charAt(a);
            }
            lastName[i] = first + lastFirst;
            System.out.println(lastName[i]);
            
        }
        
        
        
        
        
        //----------------------------------------------- DETERMINE maxNameSize
        int maxNameSize = Integer.MIN_VALUE;

        // WRITE CODE HERE
        int counter = 0; //total of first name and last name
        int firstLength = 0, lastLength = 0;
        for (int i = 0; i < n; i++) {
            firstLength = firstName[i].length();
            lastLength = lastName[i].length();
            counter = firstLength + lastLength;
            if (counter > maxNameSize) {
                maxNameSize = counter + 1;  //add one for the space
            }
        }

        //-------------------------------------- DECLARE & FILL printName array
        // NOTE:  Every printName will be the same size:
        //      firstName & a space & lastName & 2 spaces (between fields)
        //          & whatever padding (with spaces) is needed for THIS name
        // WRITE CODE HERE
        String[] printName = new String[n];
        for (int i = 0; i < n; i++) {
            printName[i] = firstName[i] + " " + lastName[i];
        }

        //-------------------------------------------------------- WRITE REPORT
        //- - - - - - - - - - - - - - - - - - - - - - - print TWO heading lines
        String nameInHeading = "NAME";           // needs padding to right size
        // or print right num of spaces

        // WRITE CODE HERE
        System.out.print(padRight(nameInHeading, maxNameSize, ' ') + "  ");
        System.out.println(padRight("Phone", 14, ' '));
        System.out.print(padRight("", maxNameSize, '-') + "  ");
        System.out.println(padRight("", 14, '-'));

        //- - - - - - - - - - - - - - - - - - - - - - - - - print detail lines
        // WRITE CODE HERE
        for (int i = 0; i < n; i++) {
            System.out.print(padRight(printName[i], maxNameSize, ' ') + "  ");
            System.out.print("(" + areaCode[i] + ")" + " ");
            //Print first 3 digits
            for (int a = 0; a < 3; a++) {
                System.out.print(phone[i].charAt(a));
                
            }
            System.out.print("-");
            //Print last 4 digits
            for (int b = 3; b <= 6; b++) {
                System.out.print(phone[i].charAt(b));
            }
            System.out.println();
        }

    }

    //-------------------------------------------------------------------------
    static String getALine() {
        return JOptionPane.showInputDialog("Contact: (QUIT when done)");
    }

    //-------------------------------------------------------------------------
    static void introMessage() {
        JOptionPane.showMessageDialog(null, "Enter contacts in this form:"
                + "\n\tfirstName,lastName,areaCode,phone");
    }

    //-------------------------------------------------------------------------
    static String padRight(String inStr, int newStrLength, char padChar) {
        String newStr = inStr;
        for (int i = inStr.length(); i < newStrLength; i++) {
            newStr += padChar;
        }
        return newStr;
    }
}
