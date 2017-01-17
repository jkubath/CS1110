/* PROJECT:  Lab7 Exercise
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Task 4
 ******************************************************************************/
package lab7exercise3;
import java.util.Scanner;

//import java.util.Arrays;
public class Lab7Exercise4 {

    public static void main(String[] args) {

        // WRITE main's CODE HERE
//        int[] my_array1 = {1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456};
//        String[] my_array2 = {"Java", "Python", "PHP", "C#", "C Programming", "C++"};
//        System.out.println("Original numeric array : " + Arrays.toString(my_array1));
//        Arrays.sort(my_array1);
//        System.out.println("Sorted numeric array : " + Arrays.toString(my_array1));
//        System.out.println("Original string array : " + Arrays.toString(my_array2));
//        Arrays.sort(my_array2);
//        System.out.println("Sorted string array : " + Arrays.toString(my_array2));
        {
            int[] arr = {23, 2, 4, 56, 80, 23, 4, 5, 6, 10};
//searching by using the sequential search technique
            Scanner scan = new Scanner(System.in);
            System.out.println("What number would you like to search for? ");
            int input = scan.nextInt();

            int pos = seqsearch(arr, input, arr.length);
            if (pos != -1) {
                System.out.println("The values is found at the position of " + pos);
            } else {
                System.out.println("The values was NOT found");
            }
        }
    }

    public static int seqsearch(int[] dataset, int target, int n) {
        int found = 0;
        int i;
        int pos = -1;
        for (i = 0; i < n && found != 1; i++) {
            if (target == dataset[i]) {
                pos = i;
                found = 1;
            }
        }
        return pos;
    }

}
