/* PROJECT:  AnalyzePopulations
 * AUTHOR:        Jonah Kubath        DESIGNER:  Kaminski  
 * DESCRIPTION:  This program looks at the lifeExpecancy of Africa vs. Europe
 *      in terms of greater or less than the median value (70) for all countries
 *      of the world.  So 4 totallers are needed - stored in a 2D array:
 *      After doing the tallies, print the report like:
 *
 *                      # OF COUNTRIES WITH LifeExp
 *                           <= 70       > 70 
 *                      ---------------------------
 *              Africa         ???        ???
 *              Europe         ???        ???
 *
 * NOTE:  No objects or array-of-all-input-data involved in this project.
 * NOTE:  The task here does not need a STORAGE BIN for the data since it can
 *          be done with a more space-efficient STREAM processing approach.
 *****************************************************************************/
package analyzepopulations;
import java.io.*;
import java.util.Scanner;

public class AnalyzePopulations {

    public static void main(String[] args) throws IOException {
        
        File theFile = new File("Clean5ColWorldData.csv");
        Scanner inFile = new Scanner(theFile);
        
        PrintWriter outFile = new PrintWriter("TheReport.txt");
        
        boolean debugSwitch = true;
        
        final int MAX_N = 300;
        int n = 0;
                
        String line;
        String[] field = new String[5];
        int[] africa = new int[2];
        int[] europe = new int[2];
        
        // WRITE CODE HERE TO DECLARE THE 2D ARRAY
        
        int i = 0;
        // name,continent,region,pop,lifeExp
        while (inFile.hasNext()) {
           
            // WRITE CODE HERE TO READ THE FILE AND KEEP THE TALLIES
            // NOTE:  Don't unComment the loop part until you have code inside
            //          the loop which will eventually turn the hasNext to false.
            line = inFile.nextLine();
            field = line.split(",");
            if(field[1].compareToIgnoreCase("Africa") == 0){
                if(field[4].compareToIgnoreCase("70") <= 0){
                    africa[0]++;
                }
                if(field[4].compareToIgnoreCase("70") > 0){
                    africa[1]++;
                }
            }
            if(field[1].compareToIgnoreCase("Europe") == 0){
                if(field[4].compareToIgnoreCase("70") <= 0){
                    europe[0]++;
                }
                if(field[4].compareToIgnoreCase("70") > 0){
                    europe[1]++;
                }
            }
            i++;
            
        }
        
        n = i;
        
        System.out.printf("FYI: N is %d\n", n);
        inFile.close();
        
        // WRITE CODE HERE TO PRINT THE REPORT TO A FILE
        // NOTE:  Besides writing to the FILE, write to the Console window
        //          if the debugSwitch is true
        
//                        # OF COUNTRIES WITH LifeExp
// *                           <= 70       > 70 
// *                      ---------------------------
// *              Africa         ???        ???
// *              Europe         ???        ???
        outFile.print("        # OF COUNTRIES WITH LifeExp\r\n");
        outFile.print("             <= 70       > 70\r\n"); 
        outFile.print("        ---------------------------\r\n"); 
        outFile.printf("%s         %3s        %3s\r\n", "Africa", africa[0], africa[1]);
        outFile.printf("%s         %3s        %3s\r\n", "Europe", europe[0], europe[1]);
        
//        System.out.print("        # OF COUNTRIES WITH LifeExp\r\n");
//        System.out.print("             <= 70       > 70\r\n"); 
//        System.out.print("        ---------------------------\r\n"); 
//        System.out.printf("%s         %3s        %3s\r\n", "Africa", africa[0], africa[1]);
//        System.out.printf("%s         %3s        %3s\r\n", "Europe", europe[0], europe[1]);
        
        
        outFile.close();
    }   
}
