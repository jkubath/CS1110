/* PROJECT:  Lab Assignment 4
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION: Decryption and Encryption     October 25, 2016
 ******************************************************************************/
package assignment.pkg4;

import java.util.Scanner;
import java.util.Arrays;

public class Assignment4 {

    public static void main(String[] args) {

        do {
            // WRITE main's CODE HERE
            String input;
            char choice;

            System.out.println("Would you like to encrypt or decrypt?\n"
                    + "Enter encrypt or decrypt");
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();

            input = input.toUpperCase();
            choice = input.charAt(0);

            //Data validation
            while (choice != 'E' && choice != 'D') {
                System.out.println("Invalid entry.\n"
                        + "Enter encrypt or decrypt");
                input = scan.nextLine();
                input = input.toUpperCase();
                choice = input.charAt(0);

            }
            int encryption = encryptChoice(choice);
            //Calling the correct encryption or decryption choice
            switch (choice) {
                case ('E'):
                    switch (encryption) {
                        case (1):
                            printArray(reverseEncryptandDecrypt(messageInput()));
                            break;
                        case (2):
                            printArray(pigLatinEncrypt(messageInput()));
                            break;
                        case (3):
                            simpleEncrypt(getKey(), asciiInput());

                    }
                    break;
                case ('D'):
                    switch (encryption) {
                        case (1):
                            printArray(reverseEncryptandDecrypt(messageInput()));
                            break;
                        case (2):
                            printArray(pigLatinDecrypt(messageInput()));
                            break;
                        case (3):
                            simpleDecrypt(getKey(), simpleDecryptInput());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. \n"
                            + "Choose to encrypt or decrypt.");
            }

        } while (anotherMessage());

    }//End of Main

    //Returns the users choice
    public static int encryptChoice(char userChoice) {

        String input;
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        if (userChoice == 'E') {
            System.out.println("Type the number of your choice of encryption.\n"
                    + "1. for an entire message reversal encryption\n"
                    + "2. for a Pig-Latin encryption\n"
                    + "3. for a simple Caesar style encryption");
            input = scan.nextLine();
            choice = Integer.parseInt(input);
        }
        if (userChoice == 'D') {
            System.out.println("Type the number of your choice of decryption.\n"
                    + "1. for an entire message reversal decryption\n"
                    + "2. for a Pig-Latin decryption\n"
                    + "3. for a simple Caesar style decryption");
            input = scan.nextLine();
            choice = Integer.parseInt(input);

        }

        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Invalid choice.\n"
                    + "1. for an entire message reversal encryption\n"
                    + "2. for a Pig-Latin encryption\n"
                    + "3. for a simple Caesar style encryption");
            input = scan.nextLine();
            choice = Integer.parseInt(input);

        }

        return choice;

    }

    //Receives the data from user
    public static char[][] messageInput() {
        //Get the input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the message.");
        String input = scan.nextLine();

        //Break into a String array
        String[] messageArray = input.split(" ");

        char[][] charArray = new char[messageArray.length][];

        //Turn String array into a char array
        for (int i = 0; i < messageArray.length; i++) {
            //Makes the column of the length of the word
            charArray[i] = new char[messageArray[i].length()];
            for (int j = 0; j < messageArray[i].length(); j++) {

                //Saves the characters of each word to the spots in the column
                charArray[i][j] = messageArray[i].charAt(j);
            }

        }

        return charArray;
    }

    //Reverses message
    public static char[][] reverseEncryptandDecrypt(char[][] charArray) {

        char[][] reversedArray = new char[charArray.length][];
        int col = 0;
        int row = 0;

        //Starts at the last word/row of charArray
        for (int i = (charArray.length - 1); i >= 0; i--) {
            //Makes the row of reversed array the length of the row from charArray
            reversedArray[row] = new char[charArray[i].length];
            //Resets the col to 0
            col = 0;
            for (int j = (charArray[i].length - 1); j >= 0; j--) {

                //Saves the "bottom right spot to the top left spot" of reversed
                reversedArray[row][col] = charArray[i][j];
                col++;
            }

            row++;
        }

        return reversedArray;

    }

    //Encryption of a message into pigLatin
    public static char[][] pigLatinEncrypt(char[][] charArray) {
//
//        System.out.println("charArray coming into Pig Latin encryption.");
//        for (int i = 0; i < charArray.length; i++) {
//            for (int j = 0; j < charArray[i].length; j++) {
//                System.out.print(charArray[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("__________________________________________");
        boolean vowel = true;
        //Creates a new array with the same number of rows as input array
        char[][] pigArray = new char[charArray.length][];
        //Creates a new array with the column size the same as input array
        //Adds another spot if the first letter of the input array is a vowel
        for (int i = 0; i < charArray.length; i++) {
            int counter = i;
            vowel = isVowel(charArray, counter);
            if (vowel) {
                //adds 3 to the column length since array starts at 0 and adds 3
                pigArray[i] = new char[(charArray[i].length + 3)];

            } else {
                //adds one to the column width since array starts at 0
                pigArray[i] = new char[charArray[i].length + 2];
            }

            //Copies the input Array to pigArray and takes off the first 
            //letter if needed and adds 'ay' to the last two char
            if (vowel) {
                for (int j = 0; j < charArray[i].length; j++) {
                    pigArray[i][j] = charArray[i][j];
                }
                //adds yay to the end
                pigArray[i][pigArray[i].length - 3] = 'y';
                pigArray[i][pigArray[i].length - 2] = 'a';
                pigArray[i][pigArray[i].length - 1] = 'y';

            } else {
                //Stops one one short of the charArray copy so it doesn't create
                //a bounds issue in the for loop
                for (int j = 0; j < charArray[i].length - 1; j++) {
                    pigArray[i][j] = charArray[i][j + 1];
                }
                //Copies the last char of charArray to the pigArray
                pigArray[i][pigArray[i].length - 4]
                        = charArray[i][charArray[i].length - 1];
                pigArray[i][pigArray[i].length - 3] = charArray[i][0];
                //adds ay to the end
                pigArray[i][pigArray[i].length - 2] = 'a';
                pigArray[i][pigArray[i].length - 1] = 'y';
            }
        }

        return pigArray;
    }

    //Checks to see if the first char of each word is a vowel or not
    public static boolean isVowel(char[][] charArray, int counter) {
        boolean vowel = true;
        if (charArray[counter][0] == 'a' || charArray[counter][0] == 'e'
                || charArray[counter][0] == 'i'
                || charArray[counter][0] == 'o'
                || charArray[counter][0] == 'u'
                || charArray[counter][0] == 'y') {
            vowel = true;
        } else {
            vowel = false;
        }
        return vowel;
    }

    public static char[][] pigLatinDecrypt(char[][] charArray) {
        int count = 0;
        //Sets the row number
        char[][] pigDecrypt = new char[charArray.length][];

        //Runs through all the rows(words)
        for (int i = 0; i < charArray.length; i++) {
            //if it ends in yay
            if (pigLatinStart(charArray, count)) {
                pigDecrypt[i] = new char[charArray[i].length - 3];
                for (int j = 0; j < charArray[i].length - 3; j++) {
                    pigDecrypt[i][j] = charArray[i][j];
                }
                System.out.println();
            } //if it ends in ay
            else if (pigLatinStart(charArray, count) == false) {
                //Making the column length - the ay
                pigDecrypt[i] = new char[charArray[i].length - 2];
                //Starts at 0 for the charArray and runs to the end
                for (int j = 1; j < charArray[i].length - 2; j++) {
                    pigDecrypt[i][j] = charArray[i][j - 1];
                }
                //takes the last letter of charArray and saves it to 0 
                //of the pigDecrypt array
                pigDecrypt[i][0] = charArray[i][charArray[i].length - 3];
            }
            count++;
        }
        return pigDecrypt;
    }

    //Determines if the original word starts with a vowel or not
    public static boolean pigLatinStart(char[][] charArray, int count) {
        boolean vowel = false;
        //If the word ends in yay
        if (charArray[count][charArray[count].length - 3] == 'y'
                && charArray[count][charArray[count].length - 2] == 'a'
                && charArray[count][charArray[count].length - 1] == 'y') {
            vowel = true;
        } //Then it ends in ay
        else {
            vowel = false;
        }
        return vowel;
    }

    public static void simpleEncrypt(int key, String inputString) {
        //ASCII to go from Char to number Goes from String to ASCII Number
        byte[] array1 = inputString.getBytes();

        //Add the key to the array1
        System.out.println("\nThe encrypted message is:");
        int[] arrayWithKey = new int[array1.length];
        char[] keyChar = new char[arrayWithKey.length];
        for (int i = 0; i < array1.length; i++) {
            arrayWithKey[i] = array1[i] + key;
            keyChar[i] = (char) arrayWithKey[i];
            System.out.print(keyChar[i]);
            
        }
    }

    public static void simpleDecrypt(int key, String[] inputArray) {
        char[] charArray = new char[inputArray.length];
        char[] firstChar = new char[inputArray.length];
        //convert from string to int and then int to char
        int[] intArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            firstChar[i] = inputArray[i].charAt(0);
            intArray[i] = (int) firstChar[i] - key;
            charArray[i] = (char) (intArray[i]);
        }
        //Print the character array
        System.out.println("\nYour decrypted message: ");
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();
    }

    public static String[] simpleDecryptInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the message to decrypt.");
        String input = scan.nextLine();
        String[] inputArray = input.split("");
        //It is not printing certain characters
        //System.out.println((char) 132 + "this is the char");
        
        return inputArray;
    }

    //Limits keys to (0-100)
    public static int getKey() {
        String checkInput;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the key. Only integers(0-100).");
        String input = scan.nextLine();
        
        //Data validation - only 0-100
        checkInput = input.replaceAll("[0-9]", "~");
        while (checkInput.compareTo(input) == 0) {
            scan = new Scanner(System.in);
            System.out.println("Invalid key");
            System.out.println("Re-enter the key. Only integers(0-100).");
            input = scan.nextLine();
            checkInput = input.replaceAll("[0-9]", "~");
        }
        double key1 = Double.parseDouble(input);
        int key = 0;
        while (key1 % 1 != 0 || (key1 < 0 || key1 > 100)) {
            System.out.println("Invalid key. Only Integers.\n"
                    + "Enter a new key.");
            input = scan.nextLine();
            key1 = Double.parseDouble(input);
        }
        key = (int) key1;
        return key;
    }

    public static String asciiInput() {
        //Get the input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the message.");
        String input = scan.nextLine();

        return input;
    }

    //Prints the arrays
    public static void printArray(char[][] charArray) {
        System.out.println();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    //Would the user like to continue?
    public static boolean anotherMessage() {
        System.out.println();

        String input;
        boolean anotherMessage = false;
        char inputChar;
        Scanner scan = new Scanner(System.in);

        //Get continuation
        System.out.println("Would you like to encrypt or decrypt "
                + "another message?\n"
                + "Yes or No");
        input = scan.nextLine();
        input = input.toUpperCase();
        inputChar = input.charAt(0);

        //Data validation
        while (inputChar != 'Y' && inputChar != 'N') {
            System.out.println("Invalid input. \n"
                    + "Enter Yes or No");
            input = scan.nextLine();
            input = input.toUpperCase();
            inputChar = input.charAt(0);
        }

        //Save boolean as user choice
        if (inputChar == 'Y') {
            anotherMessage = true;
        } else {
            anotherMessage = false;
        }
        System.out.println();

        return anotherMessage;
    }

}
