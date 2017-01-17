/* PROJECT:  WMichCityDistances
 * AUTHOR:    Jonah Kubath       DESIGNER:  Dr. Kaminski
 * DESCRIPTION:  Gets mileage data from user to fill a 2D array and then
 *      prints out a nicely labelled matrix.  HOWEVER, the cities should be
 *      sorted alphabetically - that should be done BEFORE getting user data.
 * NOTE:  The diagonal values are 0.
 * NOTE:  The data in the top right triangle is a mirror image of the lower
 *      left triangle.  So only ask the user for one of the triangles, and
 *      then store the miles data in both [r][c] and [c][r].
 * NOTE:  Since there are only 5 cities, the user will only have to enter 10
 *      distances, that is, 4 + 3 + 2 + 1.  Because the city array will be
 *      sorted by the time the user's asked for miles, the data will be
 *      entered in this order for the lower left triangle:
 * DATA:  BC to:  GR (80), KZ (27), SH (68), SJ (76)
 *        GR to:  KZ (50), SH (58), SJ (83)
 *        KZ to:  SH (39), SJ (56)
 *        SH to:  SJ (27)
 *      That is:  80  27  68  76  50  58  83  39  56  27
 ******************************************************************************/
package wmichcitydistances;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class WMichCityDistances {

    public static void main(String[] args) {

        String[] city = {"Kalamazoo", "Grand Rapids", "Battle Creek",
            "South Haven", "St. Joe"};

        // set up 2D array for miles - a square matrix of what size?  Don't
        //      hardcode that as 5 - be generic so it'll work if we add cities)
        int[][] miles2D = new int[city.length][city.length];

        // sort city array into alphabetical order
        Arrays.sort(city);

        String input;
        int miles = 0;
        // put 0's in the diagonal of miles
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j) {
                    miles2D[i][j] = 0;
                } else {
                    miles = getMiles(city[i],city[j]);
                    miles2D[i][j] = miles;
                    miles2D[j][i] = miles;
                }
            }
        }

//       for(int i = 0; i < city.length; i++)
//       {
//            for(int j = 0; j < city.length ; j++)
//            {
//                System.out.print(miles2D[i][j]);
//            }
//            System.out.println();
//       }
        // use nested for loops to get lower left triangle's 10 values
        //      from user for miles[r][c]
        //      ALSO store [r][c] value in [c][r] for upper right triangle.
        // HELP on nested loop:  ROW:  r goes from 1 to ???
        //                       COL:  c goes from 0 to some function of row
        //      (Draw matrix yourself with r & c values shown & you'll see
        //          what those stopping points are)
        // print header line
        System.out.print("              ");
        for (int i = 0; i < city.length; i++) {
            System.out.printf("%-14s", city[i]);
        }
        System.out.println();
        for (int i = 0; i < city.length; i++) {
            System.out.printf("%-14s", city[i]);
            for (int j = 0; j < city.length; j++) {
                System.out.printf("%-14d", miles2D[i][j]);
            }
            System.out.println();
        }

        // print matrix - where each line starts with city name for its label
        // [Help for formatString:  use %-14d for miles & %-14s for city label
    }

    //-------------------------------------------------------------------------
    static int getMiles(String city1, String city2) {
        String userData = JOptionPane.showInputDialog(
                "Enter miles from " + city1 + " to " + city2);
        return Integer.parseInt(userData);
    }
}
