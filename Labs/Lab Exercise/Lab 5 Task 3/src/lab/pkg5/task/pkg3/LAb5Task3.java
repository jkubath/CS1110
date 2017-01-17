/* PROJECT:  Lab 5 Task 3
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Task 3 - Geometry
 ******************************************************************************/
package lab.pkg5.task.pkg3;

import java.util.Scanner;

public class LAb5Task3 {

    public static void main(String[] args) {

        // WRITE main's CODE HERE
        int choice = 0;
        double area;
        char exitChar;

        do {

            choice = Geometry.printMenu();
            String exit;

            switch (choice) {
                case (1):
                    area = Geometry.circleArea();
                    System.out.printf("The area is: %.2f\n", area);
                    break;
                case (2):
                    area = Geometry.rectangleArea();
                    System.out.printf("The area is: %.2f\n", area);
                    break;
                case (3):
                    area = Geometry.triangleArea();
                    System.out.printf("The area is: %.2f\n", area);
                    break;
                default:
                    System.out.println("You did not enter a valid choice.");

            }
            System.out.println("Do you want to exit the program? (Yes or NO)");
            Scanner scan = new Scanner(System.in);
            exit = scan.nextLine();
            exit = exit.toUpperCase();
            exitChar = exit.charAt(0);

        } while (exitChar != 'Y');

    }

}
