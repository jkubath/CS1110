/* CLASS: SearchArrOfObj (class of STATIC methods) USED BY SortSearchArrayOfObj
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Does BINARY search, which assumes array is ALREADY in sequence
 *              on the SEARCH KEY field.
 *      Searches an array of OBJECTS.  So the COMPARISON needs a SINGLE FIELD
 *          to compare with TARGET.  So class's getter method for that 
 *          field is used in the comparison.
 * NOTE:  Example uses N (a parameter) not array;s LENGTH (which is MAX_N).
 * ALSO DEMONSTRATES:  comparing 2 double's to be APPROXIMATELY EQUAL,
 *          within a difference of EPSILON.
 *****************************************************************************/
package sortsearcharrayofobj;
public class SearchArrOfObj {

    public static int search(double target, OneCountry[] array, int n) {

        int lowI = 0;
        int highI = n - 1;                              // N not array's length
        int middleI;
        
        while (lowI <= highI) {
            middleI = (lowI + highI) / 2;
            if (target == array[middleI].getLifeExp())            // <<< GETTER
                return middleI;
            else if (target > array[middleI].getLifeExp())        // <<< GETTER
                lowI = middleI + 1;
            else
                highI = middleI - 1;
        }
        return -1;
    }
    //-------------------------------------------------------------------------
    public static int searchApproxEq(double target, OneCountry[] array, int n) {

        int lowI = 0;
        int highI = n - 1;
        int middleI;

        while (lowI <= highI) {
            middleI = (lowI + highI) / 2;
            if (approxEqual(target, array[middleI].getLifeExp()))   // APPROX =
                return middleI;
            else if (target > array[middleI].getLifeExp())
                lowI = middleI + 1;
            else
                highI = middleI - 1;
        }
        return -1;
    }
    //---------------------------------------------------------- PRIVATE METHOD
    private static boolean approxEqual(double num1, double num2) {
        double epsilon = 0.4;
        double difference = Math.abs(num1 - num2);
        if (difference < epsilon)
            return true;
        else
            return false;
    }
}
