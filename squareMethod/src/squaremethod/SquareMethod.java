/* PROJECT:  
 * AUTHOR:  Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package squaremethod;
import javax.swing.JOptionPane;


public class SquareMethod {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        String input;
        int param;
        int result;
        //getting the number
        input = JOptionPane.showInputDialog("Enter an integer.");
        //parsing it
        param = Integer.parseInt(input);
        //calling the square method
        result = square(param);
        //displaying result
        System.out.println(result);
        
    }
    
    public static int square(int x)
    {
        int result;
        result = x * x;
        return result;
    }

}
