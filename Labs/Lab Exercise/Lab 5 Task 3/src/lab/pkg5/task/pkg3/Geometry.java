/* CLASS:  
 * AUTHOR: Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package lab.pkg5.task.pkg3;

import java.util.Scanner;

public class Geometry {

    // WRITE CODE HERE
    public static int printMenu() {
        int choice;
        System.out.println("This is a geometry calculator.");
        System.out.println("Choose what you would like to calculate.");
        System.out.println("1. Find the area of a circle.");
        System.out.println("2. Find the area of a rectangle.");
        System.out.println("3. Find the area of a triangle.");
        System.out.println("Enter the number of your choice: ");
        //Scanning for choice
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();

        return choice;
    }

    public static double circleArea() {
        int radius = 0;
        double area = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radius.");
        radius = scan.nextInt();

        area = (Math.PI * radius * radius);
        return area;

    }

    public static double rectangleArea() {
        int length = 0, width = 0;
        double area = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length.");
        length = scan.nextInt();
        System.out.println("Enter the width.");
        width = scan.nextInt();

        area = length * width;
        return area;
    }

    public static double triangleArea() {
        int height = 0, base = 0;
        double area = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the height.");
        height = scan.nextInt();
        System.out.println("Enter the width.");
        base = scan.nextInt();

        area = (height * base * .5);
        return area;
    }

}
