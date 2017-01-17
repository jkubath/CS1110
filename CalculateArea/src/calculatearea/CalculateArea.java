/* PROJECT:  CaculateArea
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION: This calculates the area of a square, circle, rectangle
 *      or triangle, depending on which the user specifies.  The user also
 *      specifies the appropriate dimensions.
 * NOTE:  Program uses OVERLOADED METHODS.
 *****************************************************************************/
package calculatearea;

import javax.swing.JOptionPane; 

public class CalculateArea {

    public static void main(String[] args) {
               
//        char shape = getShapeFromUser();                  // S, C, R, T
        
        String userData;
        int side = 0;
        int radius = 0;
        int height = 0;
        int width = 0;
        char input = getShapeFromUser();
        
        // TO DO:  use a switch statement to:
        //          1) get appropriate dimensions from user - that is,
        //                  for Square:                side
        //                  for Circle:                radius
        //                  for Rectangle & Triangle:  length & width
        //          2) print dimensions to Console with labels
        // use these printf's - cut & paste as needed:
//        System.out.printf("Square's side is %d\n", side);
//        System.out.printf("Circle's radius is%d\n", radius);
//        System.out.printf("Rectangle's height & width are %d and %d\n",
//                height, width);
//        System.out.printf("Triangle's height & width are %d and %d\n",
//                height, width);

    switch(input)
            {
        case ('s'):
        case ('S'):
            side = 4;
            userData = JOptionPane.showInputDialog("Enter the height.");
            height = Integer.parseInt(userData);
            userData = JOptionPane.showInputDialog("Enter the width.");
            width = Integer.parseInt(userData);
            System.out.printf("Square's side is %d\n", side);
            System.out.printf("Square's height & width are %d and %d\n",
                height, width);
            
            break;
        case ('r'):
        case ('R'):
            side = 4;
            userData = JOptionPane.showInputDialog("Enter the height.");
            height = Integer.parseInt(userData);
            userData = JOptionPane.showInputDialog("Enter the width.");
            width = Integer.parseInt(userData);
            System.out.printf("Rectangle's side is %d\n", side);
            System.out.printf("Rectangle's height & width are %d and %d\n",
                height, width);
            break;
        case ('t'):
        case ('T'):
            side = 3;
            userData = JOptionPane.showInputDialog("Enter the height.");
            height = Integer.parseInt(userData);
            userData = JOptionPane.showInputDialog("Enter the width.");
            width = Integer.parseInt(userData);
            System.out.printf("Triangle's side is %d\n", side);
            System.out.printf("Triangle's height & width are %d and %d\n",
                height, width);
            break;
        case ('c'):
        case ('C'):
            side = 0;
            width = 0;
            userData = JOptionPane.showInputDialog("Enter the radius.");
            radius = Integer.parseInt(userData);
            System.out.printf("Circle's radius is %d\n", radius);
            height = radius;
        
            
        
    }
          
        double area = 0;
        area = findArea(height, width, side);        // TO DO: specify parameter(s)
        
        System.out.printf("Area is %.1f\n", area);
        System.exit(0);
    }
    //*************************************************************************
    // TO DO:  Write these methods:
    //          getShapeFromUser
    //          findArea   OVERLOADED, as needed
    // FYI:  Math.PI is a constant for pi's value.
    
    //Gets the shape from the user
    public static char getShapeFromUser()
    {
        String input;
        char shape;
        input = JOptionPane.showInputDialog("Enter the shape you would like to draw.\n"
                + "Square, Circle, Rectangle, or Triangle");
        shape = input.charAt(0);
        return shape;
    }
    
    
    //Calculates the area based on # of sides from the switch
    public static double findArea(int height, int width, int side)
    {
        double area = 0;
        if (side == 4)
        {
            area = height * width;
        }
        if (side == 3)
        {
            area = height * width / 2;
        }
        
        if (side == 0)
        {
            area = height * height * Math.PI;
           
        }
        return area;
    }
    
}
