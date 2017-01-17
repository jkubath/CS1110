/* PROJECT:  Print my name to a file and read it
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  
 ******************************************************************************/
package filemyname;
import java.io.*;
import java.util.Scanner;

public class FileMyName {

    public static void main(String[] args) throws IOException{
        
        // WRITE main's CODE HERE
        Scanner scan = new Scanner(System.in);
        
        //Creates file if it doesn't exist
        FileWriter file = new FileWriter("MyName.txt", true);
        PrintWriter printFile = new PrintWriter(file);
        
        System.out.println("What is your name?");
        String input = scan.nextLine();
        
        printFile.println(input);
        
        printFile.close();
        
        File readFile =new File("MyName.txt");
        Scanner read = new Scanner(readFile);
        
        //reads all the names
        while(read.hasNext())
        {
        String name = read.nextLine();
        
        System.out.println(name);
        }
        
        read.close();
    }

}
