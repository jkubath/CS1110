/* PROECT:  BMI   (BODY MASS INDEX)
 * AUTHOR:
 * THE PROBLEM:  BMI is often used to determine whether a person with a 
 *      sedentary lifestyle is overweight or underweight for their height.
 *      BMI is calculated as follows:
 *              BMI = Weight X 703 / Height 2
 *              (where weight is in pounds and height is in inches).
 * [NOTE:  Project based on problem from our Gaddis' textbook].
 * PROGRAM DESCRIPTION:  This calculates and displays a person's BMI and
 *      indicates whether they're of optimal BMI or under/over-weight.
 * INPUT: (3 dialog boxes):
 *          weight (in pounds)
 *          height (using 2 dialog boxes:  feet & inches separately).
 * OUTPUT:  (to Console - appropriately labelled):
 *          BMI
 *          message indicating whether the person has optimal weight, 
 *                  is underweight, or is overweight.  
 *          NOTE:  A sedentary person’s weight is
 *                  - optimal for a BMI between 18.5 and 25 (inclusive)
 *                  – BMI values less than 18.5 are underweight
 *                  - BMI values greater than 25 are overweight.
 ******************************************************************************/
package bmi;

import javax.swing.JOptionPane;

public class BMI {

    public static void main(String[] args) {

        // ---------------------------------------------------------- VARIABLES
        double weight = 0;
        int heightFT = 0;
        int heightIN = 0;
        double bMI;
        double height;
        
        String inputIN, inputFT, inputWeight;
        
        
        
// -------------------------------------------------------------- INPUT
        inputWeight = JOptionPane.showInputDialog("Enter your weight in pounds");
        inputFT = JOptionPane.showInputDialog("Enter your height: only feet part.");
        inputIN = JOptionPane.showInputDialog("Enter your height: Remaining inches");
        
        
        // --------------------------------------------------------- PROCESSING
        
        weight = Double.parseDouble(inputWeight);
        heightFT = Integer.parseInt(inputFT);
        heightIN = Integer.parseInt(inputIN);
        height = (heightFT * 12)+ heightIN;
        height = height * 0.025;
        bMI = (weight * .45) / (height * height);
        System.out.println(heightIN);
        System.out.println(heightFT);
        
        // ------------------------------------------------------------- OUTPUT
        System.out.println("BMI = " + bMI);
        if (bMI >= 18.5 && bMI < 25)
            System.out.println("You are in the optimal range for your BMI");
        else if (bMI < 18.5)
            System.out.println("You are underweight.");
        else if (bMI >= 25)
            System.out.println("You are overweight.");
        
        // ------------------------------------------------------------ CLEANUP
        System.exit(0);
    }
}
