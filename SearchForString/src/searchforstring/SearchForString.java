/* PROJECT:  SearchForString
 * AUTHOR:   Jonah Kubath             DESIGNED BY:  Kaminski
 * DESCRIPTION:  This project loads data from WorldDataSortByName3Col.csv FILE
 *      into 3 parallel arrays.  It then lets the user enter a country name
 *      and it gives them that country's continent & life expectancy.
 *      ALSO, it'll use BOTH linear search AND binary search and display the
 *      number of times around the loop for each.
 * INPUT:  WorldDataSortByName3Col.csv FILE
 * INPUT:  user input of a country name in a dialog box
 * OUTPUT:  to Console Window:
 *          (Linear Search did 210 times around loop)
 *          (Binary Search did 27 times around loop)
 *      United States (North America) life expectancy: 77.1
 * NOTE:  (I don't know if those numbers above are accurate???)
 *****************************************************************************/
package searchforstring;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SearchForString {

    public static void main(String[] args) throws IOException {

        File f = new File("WorldDataSortByName3Col.csv");          // OPEN FILE
        Scanner inFile = new Scanner(f);

        final int MAX_N = 1000;
        int n = 0;
        
        String[] name = new String[MAX_N];
        String[] continent = new String[MAX_N];
        String[] lifeExpectancy = new String[MAX_N];
        
        //----------------------------------------------- LOAD FILE INTO ARRAYS
        //            & make sure n is correct by the end of this chunk of code
        String aLine;
        String[] line = new String[3];
       
        
        
        while(inFile.hasNext())
        {
            aLine = inFile.nextLine();
            line = aLine.split(",");
            //System.out.println(aLine);
            name[n] = line[0];
            continent[n] = line[1];
            lifeExpectancy[n] = line[2];
            n++;
        }
        
            
        
        
        
        inFile.close();
        //-------------------------------------------------- INTERACT WITH USER
        // i.e., loop til they indicate DONE (instead of entering country)
        // For EACH interaction (human algorithm)
        //      get country name
        //      do linear search (which reports counter)
        //      do binary search (which reports counter)
        //      report continent & lifeExpectancy
        //              (based on what binary search results returned)
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the country. \n" +
                "Type quite to stop.");
        String input = scan.nextLine();
        input = input.toUpperCase();
        char inputChar = input.charAt(0);
        
        while(inputChar != 'Q')
        {
            int search = SearchesOverloaded.linearSearch(input, name, n);
            int search2 = SearchesOverloaded.binarySearch(input, name, n);
            System.out.println(search2);
            if(search != -1)
            {
                System.out.println(name[search2]);
                System.out.println(continent[search2]);
                System.out.println(lifeExpectancy[search2]);
            }
            else
                System.out.println("Country not found.");
            System.out.println("Enter another country\n" + 
                    "Type quite to stop.");
            input = scan.nextLine();
            input = input.toUpperCase();
            inputChar = input.charAt(0);
        }
        
        
        
        
        
        
        
        //---------------------------------------------------------------------
        System.out.println("\nTHE END");
        System.exit(0);
    }  
}
