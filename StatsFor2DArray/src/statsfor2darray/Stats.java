/* CLASS:  Stats     used by StatsFor2DArray.java
 * AUTHOR:    Jonah Kubath     (designer:  Dr. Kaminski)
 * DESCRIPTION:  Contains methods for doing various stats for a 2D array.
 * TODO:  Add code for the bodies of these methods.
 * NOTE:  These have OVERLOADED methods for dealing with either:
 *              - the WHOLE array
 *              - or just the DESIGNATED ROW.
 ****************************************************************************/

package statsfor2darray;

public class Stats {

    public static void showArray(int[][] a) {
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print(a[i][j] + " ");
            }
        System.out.println();
        }
        
    }
    //*************************************************************************
    public static int getTotal(int[][] a) {
        int total = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++)
            {
                total += a[i][j];
            }
        }
        
        
        return total;      
    }
    public static int getTotal(int[][] a, int row) {
        int total = 0;
        int i = row;
            for(int j = 0; j < a[i].length; j++)
            {
                total += a[i][j];
            }
        
        return total;
    }
    //*************************************************************************
    public static double getAverage(int[][] a) {
        int total = 0, count = 0;
        double average = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++)
            {
                count++;
                total += a[i][j];
            }
        }
        average = total / count;
        
        return average;
    }
    public static double getAverage(int[][] a, int row) {
        int total = 0, count = 0;
        double average = 0;
        int i = row;
            for(int j = 0; j < a[i].length; j++)
            {
                count++;
                total += a[i][j];
            }
        
        average = total / count;
        
        return average;
    }
    //*************************************************************************
    public static int getMaxValue(int[][] a) {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++)
            {
               if(a[i][j] > maxValue)
                   maxValue = a[i][j];
            }
        }
        
        return maxValue;
    }
     public static int getMaxValue(int[][] a, int row) {
        int maxValue = Integer.MIN_VALUE;
        int i = row;
            for(int j = 0; j < a[i].length; j++)
            {
               if(a[i][j] > maxValue)
                   maxValue = a[i][j];
            }
        
        return maxValue;
    }
    //*************************************************************************
    public static int getMinValue(int[][] a) {
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++)
            {
               if(a[i][j] < minValue)
                   minValue = a[i][j];
            }
        }
        
        return minValue;
    }
    public static int getMinValue(int[][] a, int row) {
        int minValue = Integer.MAX_VALUE;
        int i = row;
            for(int j = 0; j < a[i].length; j++)
            {
               if(a[i][j] < minValue)
                   minValue = a[i][j];
            }
            
        return minValue;
    }
}
