/* PROJECT:  
 * AUTHOR:  Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package randomnumber;
import java.util.Random;
import javax.swing.JOptionPane;


public class RandomNumber {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        
        int number1;
        int number2;
        int sum;
        int userAnswer;
        String input;
        
        Random randomNumber = new Random();
        number1 = randomNumber.nextInt(7);
        number2 = randomNumber.nextInt(7);
        
        sum = number1 + number2;
       
        input = JOptionPane.showInputDialog("What is " + number1 + " + " 
                + number2 + "?");
        userAnswer = Integer.parseInt(input);
        
        if (userAnswer == sum)
        {
            System.out.println("Correct.");
        }
        else
            System.out.println("Sorry, wrong answer.");
        
        
        
        
        
        
        
        
        
        
    }

}
