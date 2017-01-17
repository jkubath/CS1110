/* CLASS:  Sorts            used by TwoSortAlgor
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  This class contains the actual sorts, each as a self-contained
 *      method, so they easily "re-used" in a different program.
 * ASSUMPTION:  ascending order
 * NOTE:  See separate file of notes describing the 2 algorithms
 *****************************************************************************/
package twosortalgor;

public class Sorts {
    // --------------------------------------------------------- INSERTION SORT
    // (NOTE: Outer FOR loop only goes from [1] to [lastElement]
    //        since array[0] is initially in the SORTED part).
    // PSEUDOCODE:  Each time around outer loop:
    //  1) SAVE NEXT ELEMENT:  Take the NEXT ELEMENT from the UNSORTED part
    //      & copy it to saveElement variable
    //      (so we can now over-write the value in NEXT ELEMENT's spot).
    //  2) SHIFT LOOP - Starting at the right end of the SORTED part,
    //      keep SHIFTing elements 1 spot to the right,
    //      as long as the elements are > saveElement.
    //      OK, you've found the CORRECT SPOT!
    //      (Use a WHILE (pre-test) loop, in case NO shifting is needed).
    //  3) PUT SAVED ELEMENT BACK - put saveElement back into array in its
    //      correct spot (for now - it may get shifted in future iterations
    //      of this outer loop).
    // --------------------------------------------------------------- for INTS
    public static void insertionSort(int[] array) {

        int saveElement;
        int i;

        for (int iNextEl = 1; iNextEl < array.length; iNextEl++) {
            saveElement = array[iNextEl];              // 1 - SAVE NEXT ELEMENT

            i = iNextEl;
            while ((i > 0) && (array[i - 1] > saveElement)) { // 2 - SHIFT LOOP
                array[i] = array[i - 1];
                i--;
            }
            array[i] = saveElement;               // 3 - PUT SAVED ELEMENT BACK
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  for STRINGS
    public static void insertionSort(String[] array) {

        String saveElement;
        int i;

        for (int iNextEl = 1; iNextEl < array.length; iNextEl++) {
            saveElement = array[iNextEl];                                 // #1

            i = iNextEl;
            while ((i > 0) && (array[i - 1].compareTo(saveElement) > 0)) {// #2 
                array[i] = array[i - 1];
                i--;
            }
            array[i] = saveElement;                                       // #3
        }
    }
    // --------------------------------------------------------- SELECTION SORT
    // (NOTE: Outer FOR loop only goes from [0] to [2nd from lastElement]
    //        since by the time the algorithm's done with all that SWAPping,
    //        the very last element is ALREADY the biggest element].
    // PSEUDOCODE:   Each time around the outer loop:
    //  1) FIND INDEX OF MIN VALUE - Look through UNSORTED part for the minimum
    //          value's INDEX [See FindMinAlgor in separate project].
    //  2) SWAP - (takes 3 = operations):
    //      The smallest element in the UNSORTED part has been found,
    //          and its index is stored in iOfTempMin.
    //      Call SWAP to exchange that element (at location iOfTempMin)
    //      with the leftmost element in the UNSORTED part (at location i)
    //      (which is the element "just to the right of the SORTED part").
    // --------------------------------------------------------------- for INTS
    public static void selectionSort(int[] array) {
        int iOfTempMin;

        for (int i = 0; i < array.length - 1; i++) {
            iOfTempMin = i;                            // 1 - FIND INDEX OF MIN
            
            for (int index = i + 1; index < array.length; index++) {
          
                if (array[index] < array[iOfTempMin])
                    iOfTempMin = index;            
            }
            swap(array, i, iOfTempMin);                             // 2 - SWAP
        }
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}

