/* CLASS:  Assignment 3 - Graduate Class
 * AUTHOR: Jonah Kubath
 * DESCRIPTION:  Class contains: minGrade, MaxGrade, evaluate
 ******************************************************************************/
package assignment.pkg3;

public class Graduate {

    //Calculates the lowest test grade
    public static int minGrade(int h, int m, int p, int b, int e) {
        int lowest = h;

        if (m < lowest) {
            lowest = m;
        }
        if (p < lowest) {
            lowest = p;
        }
        if (b < lowest) {
            lowest = b;
        }
        if (e < lowest) {
            lowest = e;
        }

        return lowest;

    }

    //Calculates the highest test score
    public static int maxGrade(int h, int m, int p, int b, int e) {
        int highest = h;

        if (m > highest) {
            highest = m;
        }
        if (p > highest) {
            highest = p;
        }
        if (b > highest) {
            highest = b;
        }
        if (e > highest) {
            highest = e;
        }

        return highest;

    }

    //Calculate the average of the test scores and rounds up with any decimals
    public static Double averageGrade(int h, int m, int p, int b, int e) {
        double averageGrade = 0;
        double sum = (h + m + p + b + e);
        averageGrade = sum / 5;
        averageGrade = Math.ceil(averageGrade);

        return averageGrade;
    }

    //Calculates if the student passes the 3 requirements
    public static boolean evaluate(int h, int m, int p, int b, int e) {
        boolean graduate = false;
        int low = Graduate.minGrade(h, m, p, b, e);
        int high = Graduate.maxGrade(h, m, p, b, e);
        double average = Graduate.averageGrade(h, m, p, b, e);
        if (low >= 55) {
            if (high > (low + 10)) {
                if (average >= 65) {
                    graduate = true;
                }
            }
        }

        return graduate;

    }

}
