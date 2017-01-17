/* PROJECT:  NorthAmericaReport
 * AUTHOR:        Jonah Kubath            DESIGNER:  Kaminski
 * DESCRIPTION:  This program reads CountryData.csv file, selects all countries
 *      in North America (i.e., continent is field[3]), and stores them in an 
 *      ARRAY OF OBJECTS.
 *      It saves just 4 fields for each country:
 *              code, name, area, population (which are fields 0, 2, 5, 7).
 *      NOTE:  Some cleanup and conversion of the data is needed, which is done
 *              in the SETTER methods in Country class.
 *      It prints a simple report to a FILE, using the toString method inside 
 *          the Country object to nicely format each detail line.
 *****************************************************************************/
package northamericareport;

import java.io.*;
import java.util.Scanner;

public class NorthAmericaReport {

    public static void main(String[] args) throws IOException {

        File theFile = new File("CountryData.csv");
        Scanner inFile = new Scanner(theFile);
        
        final int MAX_N = 100;                          // PLENTY BIG ENOUGH
        int n = 0;                      // counter for ACTUAL number of records
        
        // Declare array of MAX_N Country OBJECTS
        Country[] countryArray = new Country[MAX_N];
                
        // <WRITE CODE HERE>
        
        String aLine;
        String[] field = new String[20];
        String continent;
        int i = 0;
        
        while (inFile.hasNext()) {
            aLine = inFile.nextLine();
            field = aLine.split(",");
            continent = field[3].replaceAll("\'", "");
            if (continent.compareTo("North America") == 0) {
                // DECLARE A COUNTRY OBJECT
                countryArray[i] = new Country();
                       

                // CALL THE 4 SETTERS WITH FIELDS 0,2,5,7
                //              (WITH THE "DIRTY DATA", ALL STILL AS STRINGS)
                countryArray[i].setCode(field[0]);
                countryArray[i].setName(field[1]);
                countryArray[i].setArea(field[5]);
                countryArray[i].setPopulation(field[7]);
            
           
                i++;
            }
        }
        n = i;
        System.out.printf("FYI: n is %d\n\n", n);
        inFile.close();
        
        // Write report to FILE.  Use toString method (in Country class) to 
        //      produce each detail line.  (No header line needed).
        for(i = 0 ; i < n; i++)
        {
            System.out.println(countryArray[i].toString());
        }
        // <WRITE CODE HERE>
        PrintWriter pWriter = new PrintWriter("report.txt");
        for(i = 0 ; i < n; i++)
        {
            pWriter.println(countryArray[i].toString());
        }
        
        pWriter.close();
        
        System.out.println("THE END:  See report file in project folder");
    }
}