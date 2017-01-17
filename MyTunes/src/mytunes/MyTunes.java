/* PROJECT:  MyTunes
 * AUTHOR:       Jonah Kubath            DESIGNER: Kaminski
 * DESCRIPTION:  This prints a report to a FILE based on raw data in an input
 *      FILE.  Certain cleanup and processing needs to be done on the raw input
 *      data records before it's ready for the report.
 * NOTE:  The stream processing "design pattern" can be used, rather than a
 *          storage bin approach (i.e., loop til done { readm write }
 *****************************************************************************/
package mytunes;

import java.io.*;
import java.util.Scanner;

public class MyTunes {

    public static void main(String[] args) throws IOException {

        //-------------------------------------------------------- DECLARATIONS
        boolean debug = true;
        
        File theFile = new File("RawDataSongs.csv");
        Scanner inFile = new Scanner(theFile);
        String aLine;
        String[] field = new String[9];
        
        PrintWriter outFile = new PrintWriter("TheReport.txt");
        String headerFormatStr;
        
        //--------------------------------------------------------- HEADER LINE
        // Read header record from input, write header line on report
        aLine = inFile.nextLine();
        field = aLine.split(",");
        headerFormatStr = "%-21s %-15s %-5s %-4s %6s %-8s %c%c:%c%c %s\n\n";
        outFile.printf(headerFormatStr,
                field[0],field[1],field[3],field[2],field[5],field[4],
                field[6].charAt(0),field[6].charAt(0),
                field[7].charAt(0),field[7].charAt(0),
                field[8]); 
        if (debug)
            System.out.printf(headerFormatStr,
                field[0],field[1],field[3],field[2],field[5],field[4],
                field[6].charAt(0),field[6].charAt(0),
                field[7].charAt(0),field[7].charAt(0),
                field[8]);        
        //-------------------------------------------------------- DATA RECORDS
        // STEP 1 - make program work for just ONE record.  When that works...
        // STEP 2 - add a loop structure to process the whole file
        while(inFile.hasNextLine()){
        aLine = inFile.nextLine();        
        Song aSong = new Song(aLine);
        if (debug)
            System.out.println(aSong);               // assumes toString method
        outFile.println(aSong);
        }
        //--------------------------------------------------------- CLOSE FILES
        inFile.close();
        outFile.close();
        System.out.println("\n\nDone.  See TheReport.txt in top-level folder "
                + " of project.");
    }
}
