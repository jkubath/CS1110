/* PROJECT:  Assignment 6 - Contacts
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Main - selection
 ******************************************************************************/
package javaapplication;

import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Jonah Kubath
 */
public class Assignment6 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        boolean easyRun = false;
        boolean print = false;
        String input;
        if (easyRun) {
            JOptionPane.showMessageDialog(null, "A CSV File will be read and stored in objects.");
            input = JOptionPane.showInputDialog("Enter the name of the file");
        } else {
            input = "Assign6Input.txt";
        }
        String file = input;
        File inFile = new File(input);
        Scanner scan = new Scanner(inFile);

        //Create Contact List
        ArrayList<Contact> contactList = new ArrayList();
        //Read file
        int count = 0;
        while (scan.hasNextLine()) {
            String aLine = scan.nextLine();

            String[] field;
            field = aLine.split(",");

            PersonName name = new PersonName(field[0], field[1], field[2]);
            PersonPhoneNumber number = new PersonPhoneNumber(field[8], field[9], field[10]);
            PersonAddress address = new PersonAddress(field[3], field[4], field[5],
                    field[6], field[7]);

            //Create Contact
            Contact contact1 = new Contact(name, number, address);
            //Add Contact to List
            contactList.add(contact1);
            count++;
        }
        System.out.println("The file has been read.");
        System.out.println(count + " contacts have been created.\n");

        do {
            int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to print the list.\n"
                    + "Enter 2 to add a person to the list.\n"
                    + "Enter 3 to remove a person from the list.\n"
                    + "Enter 4 to sort the contacts\n"
                    + "Enter 5 to save the list to a new file."));
            //Validation
            while (choice < 1 || choice > 5) {
                choice = Integer.parseInt(JOptionPane.showInputDialog(
                        "Invalid input.\n"
                        + "Enter 1 to print the list.\n"
                        + "Enter 2 to add a person to the list.\n"
                        + "Enter 3 to remove a person from the list.\n"
                        + "Enter 4 to sort the contacts\n"
                        + "Enter 5 to save the list to a new file."));
            }

            switch (choice) {
                case (1):
                    print(contactList);
                    break;
                case (2):
                    add(contactList);
                    break;
                case (3):
                    remove(contactList);
                    break;
                case (4):
                    sort(contactList);
                    break;
                case (5):
                    saveFile(contactList, file);
                    break;
            }
            System.out.println("-------------------------------------------");

        } while (continueWhile());

        if (print) {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(contactList.get(i));
                System.out.println();
            }
        }

        scan.close();

    }

    public static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println();
        }
    }

    public static void add(ArrayList list) {
        char choice;
        do {
            PersonName name = new PersonName();
            PersonPhoneNumber number = new PersonPhoneNumber();
            PersonAddress address = new PersonAddress();
            String input;

            //Name
            input = JOptionPane.showInputDialog("Enter their first name");
            name.setFirstName(upperCase(input));
            input = JOptionPane.showInputDialog("Enter their middle initial");
            name.setMiddleName(upperCase(input));
            input = JOptionPane.showInputDialog("Enter their last name");
            name.setLastName(upperCase(input));

            //Number
            input = JOptionPane.showInputDialog("Enter their phone number.\n"
                    + "Example: 123-456-7890");
            String[] array = input.split("-");
            number.setAreaCode(array[0]);
            number.setExchgCode(array[1]);
            number.setLocalNumber(array[2]);

            //Address
            JOptionPane.showMessageDialog(null, "Enter: \n"
                    + "Address Line 1\n"
                    + "Address Line 2\n"
                    + "City\n"
                    + "State\n"
                    + "Zip Code");
            input = JOptionPane.showInputDialog("Enter their address line 1.");
            address.setFirstLineOfStreet(input);
            input = JOptionPane.showInputDialog("Enter their address line 2.\n"
                    + "Press enter to skip.");
            address.setSecondLineOfStreet(input);
            input = JOptionPane.showInputDialog("Enter their city.");
            address.setCity(upperCase(input));
            input = JOptionPane.showInputDialog("Enter their state abbreviation.");
            address.setState(input.toUpperCase());
            input = JOptionPane.showInputDialog("Enter their zip code.");
            address.setZipCode(input);

            Contact person = new Contact(name, number, address);

            list.add(person);

            input = JOptionPane.showInputDialog("Would you like to add another?"
                    + "\nYes or No.");
            input = input.toUpperCase();
            choice = input.charAt(0);
            //Validation
            while (choice != 'Y' && choice != 'N') {
                input = JOptionPane.showInputDialog("Invalid entry.\n"
                        + "Enter Yes or No.");
                input = input.toUpperCase();
                choice = input.charAt(0);
            }
        } while (choice == 'Y');
    }

    public static void remove(ArrayList list) {
        String temp = "";
        //I want to pull the PersonName.toString but it only allows me to call
        //the Contact.toString
        for (int i = 0; i < list.size(); i++) {
            Contact tempCont = (Contact) list.get(i);
            temp += (i + 1) + ": " + tempCont.getName() + "\n";
        }
        String input = JOptionPane.showInputDialog("Enter the number to remove.\n"
                + temp);
        char first = input.charAt(0);
        input = "" + first;
        int choice = Integer.parseInt(input);
        //Validation
        while (choice < 1 || choice > list.size()) {
            input = JOptionPane.showInputDialog("Invalid entry.\n"
                    + temp);
            first = input.charAt(0);
            input = "" + first;
            choice = Integer.parseInt(input);
        }

        list.remove(choice - 1);
    }

    public static void sort(ArrayList list) {
        Contact saveElement1, saveElement2;
        int compare;
        int nextEl;
        for (int i = 1; i < list.size(); i++) {
            saveElement1 = (Contact) list.get(i);
            saveElement2 = (Contact) list.get(i - 1);
            nextEl = i;
            compare = Contact.compareTo(saveElement1, saveElement2);
            while (nextEl > 0 && compare < 0) {
                nextEl--;
                saveElement2 = (Contact) list.get(nextEl);
                compare = Contact.compareTo(saveElement1, saveElement2);
                if (compare > 0) {
                    nextEl++;
                }

            }
            list.add(nextEl, saveElement1);
            list.remove(i + 1);

        }
    }

    public static void saveFile(ArrayList list, String file) throws FileNotFoundException {
        Contact tempContact;
        String newFile = JOptionPane.showInputDialog("Enter the file name with the extension.\n"
                + "Example: abc.txt");
        
        char userChar = 'N';
        while(newFile.compareTo(file) == 0 && userChar == 'N'){
            String userChoice = JOptionPane.showInputDialog("You chose the same" +
                    " name as the original file.  Would you like to erase the original file?\n"+
                    "Enter: Yes or No");
            userChoice = userChoice.toUpperCase();
            userChar = userChoice.charAt(0);
            //Data Validation
            while(userChar != 'Y' && userChar != 'N'){
                userChoice = JOptionPane.showInputDialog("Invalid choice.\n" +
                        "Enter: Yes or No");
            userChoice = userChoice.toUpperCase();
            userChar = userChoice.charAt(0);
            
            }
            if(userChar == 'N'){
                newFile = JOptionPane.showInputDialog("Enter the file name with the extension.\n"
                + "Example: abc.txt");              }
        }
        
        String format = "%s,%s,%s\n\r";
        PrintWriter print = new PrintWriter(newFile);
        for (int i = 0; i < list.size(); i++) {
            tempContact = (Contact) list.get(i);
            String write = String.format(format, tempContact.getName().returnCSV(),
                    tempContact.getAddress().returnCSV(), tempContact.getPhoneNum().returnCSV());
            print.print(write);
        }
        
        print.close();

    }

    public static String upperCase(String word) {
        char firstChar = word.charAt(0);
        String first = "" + firstChar;
        first = first.toUpperCase();
        for (int i = 1; i < word.length(); i++) {
            firstChar = word.charAt(i);
            first += firstChar;
        }

        return first;
    }

    public static boolean continueWhile() {
        boolean more = false;
        String input = JOptionPane.showInputDialog("Would you like to continue?\n"
                + "Enter Yes or No");
        input = input.toUpperCase();

        char inputChar = input.charAt(0);

        if (inputChar == 'Y') {
            more = true;
        }

        return more;
    }
}
