/* PROJECT:  MathClass
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Demonstrates some commonly used methods in the Math class
 *      (in the Java library).
 *      Also shows casting a double to an int.
 *****************************************************************************/
package mathclass;

public class MathClass {
    
    public static void main(String[] args) {
        
        int num = Math.abs(-14);
        System.out.println("Math.abs(-14) is " + num);
        System.out.println("Math.abs(14) is " + Math.abs(14));
       
        System.out.println("\nMath.sqrt(25) is " + Math.sqrt(25));
        System.out.println("\t(int) Math.sqrt(25) is " + (int) Math.sqrt(25));
        
        System.out.println("\nMath.round(57.4999) is " + Math.round(57.4999));
        System.out.println("Math.round(57.5) is " + Math.round(57.5));
        
        System.out.println("\nMath.ceil(57.111) is " + Math.ceil(57.111));
        System.out.println("\t(int) Math.ceil(57.111) is " +
                (int) Math.ceil(57.111));

        System.out.println("Math.floor(57.999) is " + Math.floor(57.999));
        System.out.println("\t(int) Math.floor(57.999) is " +
                (int) Math.floor(57.999));
        
        System.out.println("\nMath.min(92,48) is " + Math.min(92,48));
        System.out.println("Math.min(2.1,8.3) is " + Math.min(2.1,8.3));

        System.out.println("\nMath.max(92,48) is " + Math.max(92,48));

        System.out.println("Math.max(Math.max(Math.max(4,5),9),7) is " + 
                Math.max(Math.max(Math.max(4,5),9),7));
    
        // NO parentheses after PI since it's a CONSTANT not a METHOD
        System.out.println("\nthe CONSTANT Math.PI is " + Math.PI);
        System.out.printf("\tDISPLAYED with 2 dec places:  %,.2f\n",
                Math.PI);
        System.out.printf("\tactually STORED as an int:  %d\n",
                (int) Math.PI);
    }  
}
