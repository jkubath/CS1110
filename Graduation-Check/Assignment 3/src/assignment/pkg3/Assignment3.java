/* PROJECT:  Assignment 3 - Graduate High School
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Program to see if a student will graduate or not.
 ******************************************************************************/
package assignment.pkg3;

import javax.swing.JOptionPane;

public class Assignment3 {

    public static void main(String[] args) {

        int history = 0, math = 0, physics = 0, english = 0, biology = 0;
        int lowestScore, highestScore;
        double averageScore;
        boolean graduate;

        //Get the inputs from the user
        history = testInput(1);
        math = testInput(2);
        physics = testInput(3);
        english = testInput(4);
        biology = testInput(5);

        //Saving the scores
        lowestScore = Graduate.minGrade(history, math, physics,
                +english, biology);
        highestScore = Graduate.maxGrade(history, math, physics,
                +english, biology);
        averageScore = Graduate.averageGrade(history, math, physics,
                +english, biology);

        //Will they graduate
        graduate = Graduate.evaluate(history, math, physics,
                +english, biology);

        //If they haven't graduate yet, they will roll the dice
        graduate = feelingLucky(graduate, lowestScore, highestScore);

        //Printing if they graduated
        printGraduation(graduate, lowestScore, highestScore, averageScore);

    }//End of Main

    //Getting the scores
    public static int testInput(int i) {
        String input;
        int testScore = 0;
        if (i == 1) {
            input = JOptionPane.showInputDialog("Enter the History test score.\n"
                    + "Only integers (0-100)");
            testScore = Integer.parseInt(input);
            testScore = testValid(testScore);
        }
        if (i == 2) {
            input = JOptionPane.showInputDialog("Enter the Math test score.\n"
                    + "Only integers (0-100)");
            testScore = Integer.parseInt(input);
            testScore = testValid(testScore);
        }
        if (i == 3) {
            input = JOptionPane.showInputDialog("Enter the Physics test score.\n"
                    + "Only integers (0-100)");
            testScore = Integer.parseInt(input);
            testScore = testValid(testScore);
        }
        if (i == 4) {
            input = JOptionPane.showInputDialog("Enter the English test score.\n"
                    + "Only integers (0-100)");
            testScore = Integer.parseInt(input);
            testScore = testValid(testScore);
        }
        if (i == 5) {
            input = JOptionPane.showInputDialog("Enter the Biology test score.\n"
                    + "Only integers (0-100)");
            testScore = Integer.parseInt(input);
            testScore = testValid(testScore);
        }

        return (testScore);

    }

    //Rolling the dice if they need it and pass the first two parameters
    public static boolean feelingLucky(boolean graduate, int lowestScore,
            int highestScore) {
        if (graduate == false) {
            if (lowestScore >= 55) {
                if (highestScore >= (lowestScore + 10)) {
                    graduate = Dice.chance();
                }
            }
        }

        return graduate;

    }

    //Printing if they graduated or not
    public static void printGraduation(boolean graduate, int lowestScore,
            int highestScore, double averageScore) {
        System.out.println("You're lowest score was:  " + lowestScore);
        System.out.println("You're highest score was: " + highestScore);
        System.out.printf("You're average score was: %.0f\n", averageScore);
        System.out.println();

        if (graduate) {
            System.out.println("Congratulations, you graduated.");
        } else {
            System.out.println("You did not graduate.");
        }
    }

    public static int testValid(int testScore) {
        while (testScore < 0 || testScore > 100) {
            String input;
            input = JOptionPane.showInputDialog("Invalid test score. \nEnter 0-100");
            testScore = Integer.parseInt(input);
        }
        return testScore;
    }

}
