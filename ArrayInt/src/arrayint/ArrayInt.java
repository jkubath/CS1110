/* PROJECT:  Int Array
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Making a simple array
 ******************************************************************************/
package arrayint;

public class ArrayInt {

    public static void main(String[] args) {

        // WRITE main's CODE HERE
        final int EMPLOYEE = 100;
        int[] employeeNumbers = new int[EMPLOYEE];
        for (int i = 0; i < EMPLOYEE; i++) {
            employeeNumbers[i] = i + 1;
        }
        for (int i = 0; i < EMPLOYEE; i++) {
            System.out.println(employeeNumbers[i]);
        }
        array();
        array1();
    }

    //This is the problem on page 424 7.9
    public static void array() {
        int[] numbers1 = {1, 3, 6, 9};
        int[] numbers2 = {2, 4, 6, 8};
        int result;
        for (int i = 0; i < numbers1.length; i++) {
            result = numbers1[i] * numbers2[i];
            System.out.println((i + 1) + ": " + result);

        }

    }

    //This is the problem on page 424 7.12
    public static void array1() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[7];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
            System.out.println("A: " + a[i]);
            System.out.println("B: " + b[i]);
        }
    }
}
