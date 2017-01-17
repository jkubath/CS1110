/* CLASS:  SortArrOfObj (class of STATIC methods)  USED BY SortSearchArrayOfObj
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Sorts (using selection sort) an array of OBJECTS
 *          vs. prior examples of sorting an array of ACTUAL VALUES (like int's).
 * Two important differences:
 * 1) the SORT KEY:  the comparison compares 2 DATA VALUES - i.e., a FIELD
 *          stored in each of the 2 objects
 *      - it does NOT compare the 2 objects as a whole *          
 * 2) the SWAP:  what's moved around in the swap method are the 2 REFERENCES to
 *          the 2 objects (via using temp)
 *          [NOTE:  for an array of objects, the array elements are actually
 *                  REFERENCES ("pointers") to where in memory the object itself
 *                  (i.e., its instance variables) are stored.
 *      - it does NOT swap DATA VALUES (in instance variables) in the 2 objects.
 * NOTE:  This example uses N (a parameter) not array.length (which = MAX_N)
 *          for loop control.
 *****************************************************************************/
package sortsearcharrayofobj;
public class SortArrOfObj {
                                                              // SELECTION SORT
    public static void sort(OneCountry[] array, int n) {
        
        int iOfTempMin;
        double lifeExp1;                            // for the field to compare
        double lifeExp2;                            // for the field to compare

        for (int i = 0; i < n - 1; i++) {
            iOfTempMin = i;
            
            for (int index = i + 1; index < n; index++) {
                lifeExp1 = array[index].getLifeExp();
                lifeExp2 = array[iOfTempMin].getLifeExp();
                if (lifeExp1 < lifeExp2)          // compare ACTUAL DATA VALUES
                    iOfTempMin = index;            
            }
            swap(array, i, iOfTempMin);
        }
    }
    //-------------------------------------------------------------------------
    // FYI:  BASIC SORT (for array of int's)
    //-------------------------------------------------------------------------
//    public static void selectionSort(int[] array) {
//        int iOfTempMin;
//    
//        for (int i = 0; i < array.length - 1; i++) {
//            iOfTempMin = i;          
//            for (int index = i + 1; index < array.length; index++) {      
//                if (array[index] < array[iOfTempMin])
//                    iOfTempMin = index;            
//            }
//            swap(array, i, iOfTempMin);
//        }
//    }
    //-------------------------------------------------------------------------
    // The array does NOT store ACTUAL DATA VALUES (for name, region, pop, ...).
    // It just stores REFERENCES to where the OBJECT'S data is stored.
    // The OBJECTS themselves STORE the DATA VALUES (for name, region, pop,...).
    // So this does NOT actually swap the 2 OBJECTS' DATA,
    //      it just swap the REFERENCES to the 2 OBJECTS.
    // NOTE:  if we'd implemented the problem as PARALLEL ARRAYS, then ALL the
    //      individual fields would have to be swapped.    
    //-------------------------------------------------------------------------
    private static void swap(OneCountry[] array, int i1, int i2) {
        OneCountry temp;               // matches the array element's data type
        
        temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
    //-------------------------------------------------------------------------
    // FYI:  BASIC SWAP (for 2 int's)
    //------------------------------------------------------------------------
//    private static void swap(int[] array, int i1, int i2) {
//        int temp;                    // matches the array element's data type
//    
//        temp = array[i1];
//        array[i1] = array[i2];
//        array[i2] = temp;
//    }
}
