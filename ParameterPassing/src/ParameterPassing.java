/* PROJECT:  ParameterPassing
 * AUTHOR:  Dr. Kaminski
 * ToDo:  Write the missing methods using INCREMENTAL DEVELOPMENT.
 *      NOTE:  Program currently runs, it just doesn't DO anything.
 *              Always try to keep the program in a run-able state which
 *              produces SOME output.
 *      Write a method, then uncomment it's call, run the program and check
 *      the output to make sure the method works correctly.
 *      Proceed until all methods are working.
 *      Note that the earlier methods are called by both main 
 *              and by statements in the last calcMagicNum method.
 ****************************************************************************/

import javax.swing.JOptionPane;

public class ParameterPassing {

    public static void main(String[] args) {

        int a = getInt();
        int b = getInt();

        int num = calcSum(a, b);
        System.out.printf("Sum of %d and %d is %d\n", a, b, num);

        System.out.printf("Product of %d and %d is %d\n",
                a, b, calcProduct(a, b));
//
        System.out.printf("Product of %d and %d is %d\n",
                5, 10, calcProduct(5, 10));
        
        System.out.printf("Product of %d and %d is %d\n",
                Math.max(a,b), Math.min(a,b),
                calcProduct(Math.max(a,b), Math.min(a,b)));
        
        System.out.printf("Magic number for %d and %d is %d\n",
                a,b,calcMagicNum(a,b));
        
        System.out.println("\nTHE END");
        System.exit(0);
    }
    //-----------------------------------------------------------------------
    // getInt method gets a small integer from user & send it back to caller.
    
    // >>>>> WRITE CODE HERE
    public static int getInt()
    {
        String input;
        int number;
        input = JOptionPane.showInputDialog("Enter an integer.");
        number = Integer.parseInt(input);
        return number;
        
    }
    
    //-----------------------------------------------------------------------
    // calcSum method gets 2 values from caller & sends back sum of those 2
    
    // >>>>> WRITE CODE HERE
    public static int calcSum(int a, int b)
    {
        String input;
        int number1, number2;
        int sum;
        
        number1 = a;
        
        
        number2 = b;
        
        sum = number1 + number2;
        return sum;
    }
    
    //-----------------------------------------------------------------------
    // calcProduct method gets 2 values from caller & sends back product of those
    
    // >>>>> WRITE CODE HERE
    public static int calcProduct(int a, int b)
    {
        int product;
        product = a * b;
        return product;
        
    }

    
    //-----------------------------------------------------------------------
    // calcSquared method gets a value from caller & sends back the value squared
    
    // >>>>> WRITE CODE HERE
    public static int calcSquared(int a)
    {
        int square;
        square = a * a;
        return square;
    }

 

    //-----------------------------------------------------------------------
    public static int calcMagicNum(int x, int y) {
        int xCubed = calcSquared(x);
        int yTo4thPowerUsingProduct =
                calcProduct(y, calcProduct(y, calcProduct(y,y)));
        int yTo4thUsingMathClass = (int) Math.pow(y,4);
        int sumOfThose = calcSum(xCubed, yTo4thPowerUsingProduct);
        int result = Math.max(yTo4thUsingMathClass,
                            Math.max(y,
                                    Math.max(yTo4thUsingMathClass,
                                            Math.max(xCubed,sumOfThose)
                                            )
                                    )
                            );
        return result;
    } //-----------------------------------------------------------------------
}
