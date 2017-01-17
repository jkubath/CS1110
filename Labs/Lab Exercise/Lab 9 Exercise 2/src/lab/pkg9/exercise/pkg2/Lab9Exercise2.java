/* PROJECT:  Lab 9 Exercise 2
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 2
 ******************************************************************************/
package lab.pkg9.exercise.pkg2;
import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;

public class Lab9Exercise2 {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        // WRITE main's CODE HERE
        int i = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of file.");
        String input = scan.nextLine();
        input = input + ".txt";
        FileReader file = new FileReader(input);
        String line;
        BufferedReader inputFile = new BufferedReader(file);
        while ((line = inputFile.readLine()) != null) {
            i++;
        }
        System.out.println(i);
        inputFile.close();
    }

}
