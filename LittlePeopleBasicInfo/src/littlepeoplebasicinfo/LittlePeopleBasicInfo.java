/* PROJECT:  LittlePeopleBasicInfo
 * AUTHOR:  
 * DESCRIPTION:  This project sets up 4 parallel arrays for the data below.
 *          It prints out a nicely aligned "report" (in the output window)
 *          showing all the data.  It also prints a TOTAL salary line and
 *          a line containing oldest and youngest ages at the bottom.
 * NAMES:  Happy, Grumpy, Doc, Sneezy, Sleepy, Bashful, Dopey
 * AGES:  55, 65, 80, 40, 45, 40, 50
 * PICS:  ":-)", ":-(", "|:-)", ":<)", "-)", ":-|", "<:-]"
 * SALARIES:
 *      50000.00, 35000.00, 100000.00, 54321.99, 9123.45, 64000.88, 10000.01
 *****************************************************************************/
package littlepeoplebasicinfo;

public class LittlePeopleBasicInfo {

    public static void main(String[] args) {

        //--------------------------------------------- DECLARE & FILL 4 ARRAYS
        // (use initializer lists) (cut & paste data from top comment)
        String[] names = {"Happy", "Grumpy", "Doc", "Sneezy", "Sleepy",
            "Bashful", "Dopey"};
        String[] pics = {":-)", ":-(", "|:-)", ":<)", "-)", ":-|", "<:-]"};
        int[] ages = {55, 65, 80, 40, 45, 40, 50};
        double[] salaries = {50000.00, 35000.00, 100000.00, 54321.99,
            9123.45, 64000.88, 10000.01};
        double totalSalary = 0;

        //--------------------------------------------------- FIND TOTAL SALARY
        for (int i = 0; i < salaries.length; i++) {

            totalSalary = totalSalary + salaries[i];

        }

        //----------------------------------------- FIND OLDEST & YOUNGEST AGES
        int oldest = Integer.MIN_VALUE, youngest = Integer.MAX_VALUE;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < youngest) {
                youngest = ages[i];
            }
            if (ages[i] > oldest) {
                oldest = ages[i];
            }
        }

        //-------------------------------------------------------- WRITE REPORT     
        // Header line
        System.out.printf("NAME     AGE   PIC       SALARY\n");
        System.out.println("_______________________________");

        // The 7 detail lines (using the parallel arrays) (using length, not 7)
        // Here's a format string for printf  "%-7s  %3d   %-5s %,10.2f\n"
        //          to use with name, age, pic, salary (in that order)
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-7s  %3d   %-5s %,10.2f\n", names[i], ages[i],
                    pics[i], salaries[i]);
        }

        // Ending lines
        System.out.printf("\n%-7s  %3s  %-5s  %,10.2f\n",
                "TOTAL", "", "", totalSalary);
        System.out.printf("\nAGE RANGE is from %d to %d\n", youngest, oldest);
    }
}
