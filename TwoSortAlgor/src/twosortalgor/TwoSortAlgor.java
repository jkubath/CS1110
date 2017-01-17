/* PROJECT:  TwoSortAlgor
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  This demonstrates 2 simple sorting algorithms:
 *                  Insertion Sort & Selection Sort.
 *      Main is the "driver" or overall program controller.  The actual sorts
 *              are in a separate class for portability.
 *      This shows sorting of int arrays and a String array.
 *      It also shows examples of
 *          - sorting the original array and thus losing the original data order
 *          - making a copy of the array, and sorting the copy.
* NOTE:  See separate file of notes describing some sort issues
 ****************************************************************************/
package twosortalgor;

import java.util.Arrays;

public class TwoSortAlgor {

    public static void main(String[] args) {

        int[] a1 = {3, 9, 4, 6, 7, 1, 8, 5, 2, 0};

        System.out.println("Using INSERTION SORT");
        showArray(a1, "BEFORE");
        Sorts.insertionSort(a1);
        showArray(a1, "AFTER ");
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        int[] a2 = {7, 1, 0, 3, 6, 9, 2, 4, 8, 5};

        System.out.println("\nUsing SELECTION SORT");
        showArray(a2, "BEFORE");
        Sorts.selectionSort(a2);
        showArray(a2, "AFTER ");
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        String[] a3 = {"cat", "bat", "mat", "rat", "sat", "fat", "yat"};
        String[] a4;
        
        System.out.println("\nSort COPY of array, PRESERVING original");
        showArray(a3, "ORIGINAL BEFORE");
        a4 = Arrays.copyOf(a3, a3.length);
        Sorts.insertionSort(a4);            // sort is overloaded for Strings
        showArray(a4, "SORTED ARRAY   ");
        showArray(a3, "ORIGINAL AFTER ");
    }
    // *************************************************************** for INTS
    static void showArray(int[] array, String label) {
        System.out.printf("%s\t", label);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d  ", array[i]);
        }
        System.out.println();
    }
    //  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - for STRINGS
    static void showArray(String[] array, String label) {       
        System.out.printf("%s\t", label);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s  ", array[i]);
        }
        System.out.println();
    }
}
