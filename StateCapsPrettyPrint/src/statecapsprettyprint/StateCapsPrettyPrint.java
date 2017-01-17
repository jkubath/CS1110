/* PROJECT:  StateCapsPrettyPrint
 * Modified:  Jonah Kubath        Author: Kaminski
 * DESCRIPTION:  Prints a nicely aligned report in the Console window AND to a
 *      FILE based on data in the INPUT FILE.
 * INPUT FILE:  StateCapitals.csv has 2 fields per line:  state, capitalCity
 * OUTPUT FILE:  Report.txt with
 *      Header lines (use println's):       State Capitals Report
 *                                          <2 blank lines>
 *                                          the date/time
 *                                          <1 blank line>
 *      Detail lines (use printf's):        1 state/dity per line, double-spaced
 *                                          (i.e., 1 blank line after each pair)
 * STORAGE BIN vs. STREAM processing?
 *      No arrays (STORAGE BINS) needed since the problem can be solved by just
 *      processing the data as a STREAM of data (i.e., readARecord, writeARecord
 *      in a loop)- which is much more space-efficient.
 * ONE PASS (vs. 2-pass) through the input stream?
 *      Even though there are TWO output reports (Console & File), only a
 *      SINGLE PASS through the input data file is needed.
 * CARRIAGE RETURN ISSUE:
 *      This is a tiny, but potentially troublesome issue you're likely to
 *      encounter in future programming:  the <CR><LF> vs. <LF> issue.
 *      In order to see this for yourself, you MUST USE:
 *              - println's for the header lines
 *              - printf's for the detail lines.
 * INCREMENTAL DEVELOPMENT:
 *      1st)  Do report to Console window
 *              [Make sure to have a \n in the printf for detail line printing]
 *      2nd)  Use copy/paste to add similar code to also print to file.
 *      3rd)  Look at resulting Report.txt file in IDE's editor window
 *              [do:   File / Open File / locate THIS project folder /
 *                      choose Report.txt file]
 *      4th)  At OS-level, open Report.txt file in WordPad (Windows)
 *      5th)  At OS-level, open Report.txt file in NotePad (Windows)
 *      6th)  Correct the problem by using \r\n rather than just \n in
 *              printf's format string (i.e., both CarriageReturn & LineFeed) 
 *      7th)  Run program again and check Report.txt file in NotePad
 *      8th)  Comment out the close of the output file
 *              Run the program and look at Report.txt
 ****************************************************************************/
package statecapsprettyprint;

import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class StateCapsPrettyPrint {

    public static void main(String[] args) throws IOException {
       File file = new File("StateCapitals.csv");
       Scanner scan = new Scanner(file);
       PrintWriter pwriter = new PrintWriter("Report.txt");
       
        
        System.out.println("State Capital's Report\n\n");
        //Title with cr and line return
        pwriter.printf("State Capital's Report\n\n\r");
        String date = showDateTime();
        //Date with cr and next line
        pwriter.printf("%s\r", date);
        System.out.println();
        while(scan.hasNextLine())
        {
            String nextLine = scan.nextLine();
            System.out.printf("%s\n\n" , nextLine);
            pwriter.printf("%s\n\r" , nextLine);        
        }
        
        
        showDateTime();
        scan.close();
        pwriter.close();

    }
    //------------------------------------------------------------- DATE & TIME
    // from http://javatechniques.com
    static String showDateTime() {
        // Make a new Date object. It will be initialized to the current time.
        Date now = new Date();
        System.out.println(now.toString());
        return now.toString();
    }
}
