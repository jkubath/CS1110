/* PROJECT:  EuropeRoadsWirhFiles
 * AUTHOR:  Jonah Kubath         DESIGNED BY:  Dr. Kaminski
 * DESCRIPTION:  This is a variation of the prior EuropeRoadDistances project.
 *      Except HERE,
 *          1) the raw data comes from FILES (as is normally the case)
 *                  rather than internal hardcoded arrays
 *          2) the output (the nicely printed matrix) goes to a FILE
 *                  rather than to the IDE's Output Window
 * INPUT FILE:  RawNameData.txt
 *              1st line contains N (i.e., the number of records to follow)
 *              rest of records contain cityName - abbreviation
 * INPUT FILE:  RawDistanceData.txt
 *              contains many records of the form:  cityANum cityBNum distance
 *                  where the city numbers correspond to the cities in the
 *                  RawNameData file, starting with 0 (not 1)
 *              Assume all "2-way roads" with distance B-to-A = distance A-to-B
 * OUTPUT FILE:  DistanceMatrix.txt
 *              A nicely printed (with city abbreviations for labels)
 *              distance matrix.
 * OTHER OUTPUT (to screen):  The same nice matrix.
 * CAVEAT:  Assume no errors in input data file!
 ****************************************************************************/
package europeroads;

import java.io.*;                           // needed for file I/O
import java.util.Scanner;                   // needed for reading from file

public class EuropeRoads {

    public static void main(String[] args) throws IOException{
        //                                 ^^^^^^^^^^^^^^^^^^   NEEDED FOR I/O

        //-------------------------------------------------- FILE  DECLARATIONS
        
        File theNameFile = new File("RawNameData.txt");
        Scanner inNameFile = new Scanner(theNameFile);
        
        // below is shortcut, rather than 2 lines above
        Scanner inDistanceFile = new Scanner(new File("RawDistanceData.txt"));
        
        PrintWriter outFile = new PrintWriter("DistanceMatrix.txt");
        
        //------------------------------------------------ STORAGE DECLARATIONS
        // BUT FIRST:  read N from RawNameData file, so you know array sizes
        int n = 0;
        String stringN;
        
        // WRITE CODE HERE  >>>>>>>>>>>>>>>>
        n = Integer.parseInt(inNameFile.next());
        inNameFile.nextLine();
        
        
//        String[] name = new String[n];            // Don't really need names
        String[] abbrev = new String[n];
        int[][] distance = new int[abbrev.length][abbrev.length];
        
        //----------------------------------------------- FILL ARRAYS WITH DATA
        // step 1 - fill abbrev array with data from RawNameData file
        // INSIDE-OUT DESIGN HELP:
        //      for a SINGLE record, do this:
        //          1) read a single record from the file
        //          2) split it into 2 fields (though we don't care about name)
        //          3) store abbreveviation in the array in spot [i]
        //      THEN, this single-record handling needs to be inside a LOOP
        
         // VARIABLES NEEDED:  
        String aLine;
        String[] field= new String[20];     // though only need 2 for this part
        String abbreviation;
        int index = 0;
        String[][] name =new String[20][2];
        
        // WRITE CODE HERE  >>>>>>>>>>>>>>>>
         while(inNameFile.hasNext())
       {
           
           aLine = inNameFile.nextLine();
           name[index] = aLine.split(" - ");
           abbrev[index] = name[index][1];
           index++;
       }
        
        
        // step 2a - initialize matrix's diagonal
        for (int i = 0; i < n; i++)
            distance[i][i] = 0;
        
        // step 2b - load RawDistanceData file's data into matrix
        //                      in both triangles
        // INSIDE-OUT DESIGN HELP:
        //      for a SINGLE record, do this:
        //          1) read the record into aLine
        //          2) split it into 3 parts
        //          3) store 3 fields in cityA cityB miles
        //                      (after convertint to int's)
        //          4) store miles in matrix in spots   [cityA][cityB]
        //                                      and     [cityB][cityA]
        //      THEN, this single-record handling needs to be inside a LOOP
        
        // VARIABLES NEEDED:  and just re-use aLine and field array from above
        int cityA;
        int cityB;
        int miles;
        index = 0;
        String[][] distanceMatrix = new String[40][3];
        
        // WRITE CODE HERE  >>>>>>>>>>>>>>>>

        while(inDistanceFile.hasNext())
       {
           
           aLine = inDistanceFile.nextLine();
           distanceMatrix[index] = aLine.split(" ");
           index++;
       }
        
        for(int i = 0; i < index; i++)
        {
                distance[Integer.parseInt(distanceMatrix[i][0])][Integer.parseInt(distanceMatrix[i][1])] =
                        Integer.parseInt(distanceMatrix[i][2]);
                distance[Integer.parseInt(distanceMatrix[i][1])][Integer.parseInt(distanceMatrix[i][0])] =
                        Integer.parseInt(distanceMatrix[i][2]);
            
        }
        
        
        
                
        // --------------------------------------------- PRINT MATRIX TO SCREEN
        System.out.print("     ");                              // HEADER LINE
        for (int i = 0; i < abbrev.length; i++)
            System.out.printf("%5s",abbrev[i]);
        System.out.println();     
                                                                // DETAIL LINES
        for (int row = 0; row < distance.length; row++) {
            System.out.printf("%5s",abbrev[row]);
            for (int col = 0; col < distance[0].length; col++)
                System.out.printf("%5d",distance[row][col]);
            System.out.println();
        }
        // --------------------------------------------- PRINT MATRIX TO FILE
        
        // WRITE CODE HERE  >>>>>>>>>>>>>>>>
        PrintWriter print = new PrintWriter("Distance Matrix.txt");
        print.print("     ");                              // HEADER LINE
        for (int i = 0; i < abbrev.length; i++)
            print.printf("%5s",abbrev[i]);
        print.println();     
                                                                // DETAIL LINES
        for (int row = 0; row < distance.length; row++) {
            print.printf("%5s",abbrev[row]);
            for (int col = 0; col < distance[0].length; col++)
                print.printf("%5d",distance[row][col]);
            print.println();
        }
        // ------------------------------------------------------ CLOSE 3 FILES
        
        // WRITE CODE HERE  >>>>>>>>>>>>>>>>
        inNameFile.close();
        inDistanceFile.close();
        print.close();
        
    }   
}
