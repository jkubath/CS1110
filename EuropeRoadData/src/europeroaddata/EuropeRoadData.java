/* PROJECT:  EuropeRoadDistances
 * AUTHOR:   Jonah Kubath              DESIGNED BY:  Dr. Kaminski
 * DESCRIPTION:  This project would normally read in data from a file.
 *      But since we haven't covered file I/O yet, the program gets its data 
 *      from the hard-coded arrays of raw data at the top of this program.
 *      There are several kinds of data:
 *          1) city names - abbreviations
 *          2) road distances between 2 cities.
 *              (Note" not all pairs of cities have connecting roads).
 *      The program should do the steps listed in the comments below.
 * CAVEAT:  I've put everything in one LONG main method to avoid having to
 *      do parameter passing.  This isn't the ideal way to program.
 ****************************************************************************/
package europeroaddata;

public class EuropeRoadData {

    public static void main(String[] args) {

        //******************************************************** "INPUT" DATA
        // This RAW DATA would normally be in a data FILE rather than hardcoded
        //          here in the program as a big array.
        // So rather than reading in data from a FILE with a while loop
        // instead "read" in data from an ARRAY with a for loop.
        // Each item:  name - abbrev
        String[] rawNameData = {
            "Amsterdam - AMS", "Belgrade - BEL", "Berlin - BER",
            "Bern - BRN", "Brussels - BRU", "Budapest - BUD",
            "Copenhagen - COP", "Genoa - GEN", "Hamburg - HAM",
            "Lisbon - LIS", "Madrid - MAD", "Munich - MUN",
            "Naples - NAP", "Paris - PAR", "Prague - PRA",
            "Rome - ROM", "Trieste - TRI", "Vienna - VIE",
            "Warsaw - WAR"};

        // Each item:  cityA cityB distance
        // Assume that city numbers correspond to the cities in rawNameData
        //      in the order that they're shown above, so
        //      0 3 558 means Amsterdan to Bern is 558 miles (& vice versa)
        String[] rawDistanceData = {
            "0 3 558",
            "0 4 164",
            "0 8 338",
            "0 11 526",
            "1 5 263",
            "1 16 403",
            "1 17 501",
            "2 3 628",
            "2 8 182",
            "2 14 219",
            "2 18 345",
            "3 7 304",
            "3 10 1104",
            "3 11 311",
            "3 16 489",
            "4 3 497",
            "4 7 740",
            "4 13 225",
            "5 16 384",
            "5 17 155",
            "5 18 394",
            "6 8 180",
            "7 10 951",
            "7 13 629",
            "7 15 328",
            "7 16 361",
            "9 10 339",
            "10 13 805",
            "11 14 174",
            "11 15 582",
            "11 17 280",
            "12 15 134",
            "14 17 185",
            "14 18 479",
            "15 16 442",
            "16 17 317",
            "17 18 464"};
        //***************************************************** DECLARE STORAGE
        // 1) SET UP 2 PARALLEL 1-Dim ARRAYS for name and for abbrev
        String[] name = new String[rawNameData.length];
        String[] abbrev = new String[rawNameData.length];

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 2) SET UP A 2D MATRIX (a 2-Dim ARRAY) for distance
        String[][] distance = new String[name.length][name.length];

        //******************************************************** FILL STORAGE
        // Treat both of the hardcoded RAW DATA arrays as if they were STREAMS
        //      of data coming into the program (rather than STORAGE BINS).
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 3) LOAD RAW NAME DATA (name & abbrev) INTO 2 ABOVE 1-Dim ARRAYS
        // HINT:  FOR loop or WHILE loop?
        //      Program KNOWS size of "input" data (rawNameData) , so ...
        // HINT:  What needs to be done for ONE input?  e.g.,"Amsterdam - AMS"
        //      That goes in the body of the loop..
        // HINT:  Would the split function be useful (on " - ")?
        String aLine;
        String[] field = new String[2];
        String oneName;
        String oneAbbrev;
        for (int i = 0; i < rawNameData.length; i++) {
            field = rawNameData[i].split(" - ");
            name[i] = field[0];
            abbrev[i] = field[1];
        }

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 4) INITIALIZE 2D MATRIX WITH ALL 0's
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                distance[i][j] = "0";
            }
        }

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 5) LOAD RAW DISTANCE DATA INTO 2D MATRIX
        // HINT:  FOR loop or WHILE loop?
        //      Program KNOWS size of "input" data (rawDistanceData) , so ...
        // HINT:  What needs to be done for ONE input?  e.g.,"0 3 558"
        //      That goes in the body of the loop..
        //      NOTE: "0 3 558" means BOTH
        //                  it's 558 miles from city [0] to city [3]
        //                  it's 558 miles from city [3] to city [0]
        // HINT:  Would the split function be useful (on " ")?
        //          DECLARE THE NECESSARY VARIABLES HERE:
        
        
        
        String[][] distanceGap = new String[rawDistanceData.length][3];
        for (int i = 0; i < rawDistanceData.length; i++) {
            distanceGap[i] = rawDistanceData[i].split(" ");
        }
        

        for (int i = 0; i < rawDistanceData.length; i++) {
            int row = Integer.parseInt(distanceGap[i][0]);
            int col = Integer.parseInt(distanceGap[i][1]);
            distance[row][col] = distanceGap[i][2];
            distance[col][row] = distance[row][col];
        }
        
        System.out.print("          ");
        for(int i = 0; i < name.length; i++)
        {
            System.out.printf("%12s", name[i]);
        }
        System.out.println();
        
        for(int i = 0; i < distance.length; i++)
        {
            System.out.printf("%12s   ", name[i]);
            for(int j = 0; j < distance[i].length; j++){
                System.out.printf("%-12s", distance[i][j]);
            }
            System.out.println();
        }

        //***************************************************** PRINT 2D MATRIX
        // 6) Print 2D matrix out nicely.  Align abbreviations printed along
        //      the top and the left side of the matrix.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 6a) PRINT TOP HEADING
        // HINT:  Write column headings using abbrev's (not names).
        //        Write blanks in 1st 10 columns,
        //              then use %5s as formatter for each abbrev.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 6b) PRINT DETAIL LINES:
        // HINT:  for EACH line do:
        //      print city's abbrev (not name),
        //      then all the columns from 2D array FOR THAT ROW
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        System.out.println("\nTHE END");
    }
}
