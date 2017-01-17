/* CLASS:  SearchesOverloaded
 * AUTHOR:                              DESIGNER:  Kaminski
 * DESCRIPTION:  linearSearch & binarySearch
 * TODO:
 *      1) overload both methods to be able to do a search for a STRING target
 *              and a STRING array
 *      2) add another parameter for N and use THAT rather than LENGTH for
 *              loop condition (otherwise you're using MAX_N of 1000 (WRONG!)
 *      3) add a counter to the loop so you know how many times it goes around
 *              the loop
 *      4) print out that counter JUST BEFORE THE RETURN(s) STATEMENTS
 *****************************************************************************/
package searchforstring;

public class SearchesOverloaded {
    // ************************************************************************
    public static int linearSearch(int target, int[] a, int index) {
        
        for (int i = 0; i < index; i++)
            if (a[i] == target){
                System.out.println(i);
                return i;
            }
        return -1;
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // ToDo:  Write linearSearch for Strings
    //          which also prints out a count for number times around loop
    public static int linearSearch(String target, String[] a, int index) {
        for (int i = 0; i < index; i++)
            if (a[i].compareToIgnoreCase(target) == 0){
                System.out.println("Times around the linary loop :" + i);
                return i;
            }
        return -1;
    }
    
    
    // ************************************************************************
    public static int binarySearch(int target, int[] a, int index) {
        
        int lowI = 0;
        int highI = index;
        int middleI;

        while (lowI <= highI) {
            middleI = (lowI + highI) / 2;
            if (target == a[middleI])
                return middleI;                 // <<<<<<<<<<<<<<<<<<<
            else if (target > a[middleI])
                lowI = middleI + 1;
            else
                highI = middleI - 1;
        }
        return -1;
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // ToDo:  Write binarySearch for Strings
    //          which also prints out a count for number times around loop
    public static int binarySearch(String target, String[] a, int index) {
        
        int lowI = 0;
        int highI = index;
        int middleI;
        int counter = 0;
        
        while (lowI <= highI) {
            middleI = (lowI + highI) / 2;
            counter++;
            if (target.compareToIgnoreCase(a[middleI]) == 0)
            {
                System.out.println("Times around the binary loop :" + counter);
                return middleI; 
            }                // <<<<<<<<<<<<<<<<<<<
            else if (target.compareToIgnoreCase(a[middleI]) > 0)
                lowI = middleI + 1;
            else
                highI = middleI - 1;
        }
        System.out.println("Times around the binary loop :" + counter);
        return -1;
    }
    
    
    // ************************************************************************
}
