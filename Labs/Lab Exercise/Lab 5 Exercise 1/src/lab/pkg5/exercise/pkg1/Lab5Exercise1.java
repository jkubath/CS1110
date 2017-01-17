/* PROJECT:  Lab 5 Exercise 1
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 1
 ******************************************************************************/
package lab.pkg5.exercise.pkg1;

public class Lab5Exercise1 {

    public static void main(String[] args) {

        //calls the method 5 times
        for (int i = 1; i <= 5; i++) {
            counter();
        }

    }

    //Prints out 1-5
    public static void counter() {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            count++;
            System.out.println(count);
        }

    }

}
