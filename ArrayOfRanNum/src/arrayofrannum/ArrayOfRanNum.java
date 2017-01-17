/* PROJECT:  ArrayOfRanNum
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  This program:
 *      - fills an array of size N (where N is specified by the user)
 *              with random gpa's between 0.0 and 4.0
 *      - prints array, 1 element per line (with 1 decimal place) along with i
 *      - finds average, max & min gpa's
 *      - print those results, nicely labelled
 *****************************************************************************/
package arrayofrannum;

import javax.swing.JOptionPane;
import java.util.Random;

public class ArrayOfRanNum {

    public static void main(String[] args) {

        //----------------------------------------------------- GET N FROM USER
        int n = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter number of gpa's (< 20)"));
        //-------------------------------------------------------- DECLARATIONS
        Random r = new Random();
        double gradeDecimal = 0;
        double gradeInteger = 0;
        double grade = 0;
        double maxGrade = Integer.MIN_VALUE;
        double minGrade = Integer.MAX_VALUE;
        double average = 0;
        int count = 0;
        double total = 0;

        //---------------------------------------------------------- FILL ARRAY
        // IMPORTANT NOTE:  You're filling a STORAGE BIN with a STREAM of data
        //      as input, coming from the RandomNumberGenerator.  So don't do
        //      this as 2 distinct steps, i.e., 1) fill array, 2) process array.
        //      INSTEAD DO the processing of an element just after generating/
        //      storing it.
        // SUGGESTION:  List all the steps you need to do with ONE ELEMENT.
        //          Then put that code inside a loop.
        // QUESTION:  What's the appropriate type of loop to use?
        //---------------------------------------------------------------------
        double[] grades = new double[n];
        for (int i = 0; i < grades.length; i++) {
            gradeInteger = r.nextInt(4);
            gradeDecimal = r.nextDouble();
            grade = gradeInteger + gradeDecimal;
            
            grades[i] = grade;
            System.out.printf("Number %d : %.2f\n", i, grade);
            
            if (grade > maxGrade) {
                maxGrade = grade;
            }
            if (grade < minGrade) {
                minGrade = grade;
            }
            count++;
            total += grade;

        }
        average = total / count;

        //----------------------------------------------------- PRINT RESULTS        
        System.out.printf("\nAve is %.1f, Max is %.1f, Min is %.1f\n",
                average, maxGrade, minGrade);
        System.out.println("THE END");
        System.exit(0);
    }
}
