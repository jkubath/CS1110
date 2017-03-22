/* CLASS:  Dice Roll
 * AUTHOR: Jonah Kubath
 * DESCRIPTION:  Rolls a dice 5 times if meets the first two requirements
 ******************************************************************************/
package assignment.pkg3;

import java.util.Random;

public class Dice {

    //Used for rolling the dice 5 times
    public static boolean chance() {
        int dice;
        boolean luck = false;
        Random randNum = new Random();

        System.out.println("Your average is low, but you can still be lucky.");
        System.out.println();
        //rolling 5 times and saving luck to true if a 6 is rolled
        for (int i = 1; i <= 5; i++) {
            dice = randNum.nextInt(6) + 1;
            if (dice == 6) {
                luck = true;
            }
        }
        if (luck == true) {
            System.out.println("The dice roll had at least one 6.");
            System.out.println();
        } else {
            System.out.println("The dice roll did not have a 6.");
            System.out.println();
        }

        return luck;

    }

}
