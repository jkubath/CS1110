/* PROJECT:  StatsFor2DArray
 * AUTHOR:    Jonah Kubath      (designer:  Dr. Kaminski)
 * DESCRIPTION:  This initializes a 2D array to the data specified.
 *      It then calls methods to calculate various stats for the array.
 *      It does the stats for BOTH the WHOLE array,
 *              and then SEPARATELY for EACH ROW.
 * TODO:  Declare & initialize the array.
 *          Write the necessary methods in the SEPARATE Stats class file.
 *          Gradually uncomment the calls below as you write the Stats methods
 *                  to test whether they work correctly.
 * NOTE:  Program executable as it's shown here - though it pretty much
 *          "does nothing".
 ****************************************************************************/
package statsfor2darray;
import javax.swing.JOptionPane;

public class StatsFor2DArray {

    public static void main(String[] args) {

        // Declare 2D array called a and initialize it with these values:
        //          { {10,20,17,11,25}, {16,27,21,18,13}, {24,12,23,14,15} }
        
        // WRITE CODE HERE
        int[][] a = { {10,20,17,11,25}, {16,27,21,18,13}, {24,12,23,14,15} };

        //---------------------------------------------------------------------
        // Show array by calling a method to print it as rectangular matrix
        Stats.showArray(a);
        // WRITE CODE HERE
        
        
        
        
        //---------------------------------------------------------------------
        
        System.out.println("FOR WHOLE ARRAY\n---------------");
        
        System.out.printf("TOTAL:  %3d,  AVERAGE: %2.2f\n",
                  Stats.getTotal(a), Stats.getAverage(a));
        // FIX LINE ABOVE TO CALL THE 2 METHODS instead of those 2 constants
        
        System.out.printf("MAX VALUE:  %d,  MIN VALUE: %d\n",
                  Stats.getMaxValue(a), Stats.getMinValue(a));
        // FIX LINE ABOVE TO CALL THE 2 METHODS instead of those 2 constants
        
        //---------------------------------------------------------------------
        
        System.out.println("\n\nFOR EACH ROW\n------------");
            String input = JOptionPane.showInputDialog("Enter the row");
            int row = Integer.parseInt(input) - 1;
            while(row < 0 || row > 2)
            {
                input = JOptionPane.showInputDialog("Invalid row\n" +
                        "Enter 1 - 3.");
                row = Integer.parseInt(input) - 1;
            }
            
//        for (int row = 0; row < a.length; row++) {
            System.out.printf("[%d]  TOTAL:  %3d,  AVERAGE: %2.2f \n",
                  (row + 1), Stats.getTotal(a, row), Stats.getAverage(a, row));
          // FIX LINE ABOVE TO CALL THE 2 METHODS instead of those 2 constants
        
             System.out.printf("[%d]  MAX VALUE:  %d,  MIN VALUE: %d\n\n",
                    (row + 1), Stats.getMaxValue(a, row), Stats.getMinValue(a, row));
          // FIX LINE ABOVE TO CALL THE 2 METHODS instead of those 2 constants
//        }
    }
}
