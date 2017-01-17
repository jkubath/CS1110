/* PROJECT:  SortSearchArrayOfObj
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Demonstrates:
 *      - sorting an ARRAY of OBJECTS on a SORT KEY (i.e., one of the instance
 *              variables)
 *      - searching an ARRAY of OBJECTS for a target SEARCH KEY value,
 *              when you want:
 *              1) ALL matches
 *              2) ANY match
 *      - searching for an EXACT match when using a FLOATING POINT NUMBER
 *              vs. searching for an APPROXIMATE match instead.
 *****************************************************************************/
package sortsearcharrayofobj;
import java.io.*;
import java.util.Scanner;

public class SortSearchArrayOfObj {

    public static void main(String[] args) throws IOException {

        //-------------------------------------------------------- DECLARATIONS
        File theFile = new File("Clean5ColWorldData.csv");
        Scanner inFile = new Scanner(theFile);       
        final int MAX_N = 300;
        int n;
        String line;
        String[] field = new String[5];
                
        OneCountry[] country = new OneCountry[MAX_N];           // create array
        //---------------------------------------------------------- FILL ARRAY
        int i = 0;
        while (inFile.hasNext()) {
            line = inFile.nextLine();
            field = line.split(",");
            if (field[1].compareTo("Europe") == 0) {
                country[i] = new OneCountry();                 // create object
                country[i].setName(field[0]);
                country[i].setRegion(field[2]);
                country[i].setPop(Integer.parseInt(field[3]));
                country[i].setLifeExp(Double.parseDouble(field[4]));
                i++;
            }
        }
        n = i;
        // ARRAY of OBJECTS now has data in the 1st N locations of the array.
        System.out.printf("FYI: N is %d\n", n);
        inFile.close();
        //-------------------------------------------------- PRINT SOME REPORTS
        showAllCountries(country, n, "Europe in INPUT ORDER");
        SortArrOfObj.sort(country, n);
        showAllCountries(country, n, "Europe in LIFE EXPECTANCY ORDER");
        showTheseCountries(country, n, "Eastern Europe",
                "Eastern Europe in LIFE EXPECTANCY ORDER");
        showThisCountry(country, n, true, 73.2,
                "European Country with LIFE EXPECTANCY of EXACTLY ");
        showThisCountry(country, n, false, 77,
                "European Country with LIFE EXPECTANCY of APPROXIMATELY ");
    }
    //*************************************************************************
    private static void showAllCountries(OneCountry[] country, int n,
                                                                String label)
    throws IOException {
        System.out.printf("\n%s\n", label);
        for (int i = 0; i < n; i++)
            System.out.println(country[i]);                    // uses toString
        PrintWriter print = new PrintWriter("allCountries.txt");
        print.printf("\n%s\n", label);
        for (int i = 0; i < n; i++)
            print.println(country[i]);
        
        print.close();
        
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void showTheseCountries(OneCountry[] country, int n,
                                           String targetRegion, String label) 
    throws IOException {
        System.out.printf("\n%s\n", label);    
        for (int i = 0; i < n; i++)
            if (country[i].getRegion().compareTo(targetRegion) == 0)
                System.out.println(country[i]);                // uses toString
        PrintWriter print = new PrintWriter("theseCountries.txt");
        print.printf("\n%s\n", label);    
        for (int i = 0; i < n; i++)
            if (country[i].getRegion().compareTo(targetRegion) == 0)
                print.println(country[i]);
        
        
        print.close();
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void showThisCountry(OneCountry[] country, int n,
                   boolean exactMatch, double targetLifeExp, String label) {
        System.out.printf("\n%s %.1f\n", label, targetLifeExp);
        int index;
        if (exactMatch)
            index = SearchArrOfObj.search(targetLifeExp, country, n);
        else
            index = SearchArrOfObj.searchApproxEq(targetLifeExp, country, n);
        if (index == -1)
            System.out.println("NONE");
        else
            System.out.println(country[index]);                // uses toString
    }
}
