/* PROJECT:  Print to a File
 * AUTHOR:  Jonah Kubath   
 * DESCRIPTION:  Basic printing to a file - Read from the file
 ******************************************************************************/
package printtofile;

import java.io.*;
import java.util.Scanner;

public class PrintToFile {

    public static void main(String[] args) throws IOException {

        // WRITE main's CODE HERE
        String input;
        String name;
        int friendCount;
        Scanner scan = new Scanner(System.in);

        FileWriter fwriter = new FileWriter("Friends.txt", true);

        //Make the PrintWriter
        PrintWriter file = new PrintWriter(fwriter);

        //Get the number of friends
        System.out.println("How many friends do you want to add?");
        friendCount = scan.nextInt();

        //Consume the enter
        scan.nextLine();

        //Get the names of the friends
        for (int i = 0; i < friendCount; i++) {
            System.out.println("Enter your friend's name");
            name = scan.nextLine();
            file.println(name);
        }

        file.close();
        
        //Read from the file - Friends.txt
        File inputFile = new File("Friends.txt");
        Scanner readFile = new Scanner(inputFile);
        
        //hasNext returns true or false if there is more data
        while(readFile.hasNext())
        {
        String read = readFile.nextLine();
        System.out.println(read);
        
        }
        readFile.close();
        
        
    }

}
