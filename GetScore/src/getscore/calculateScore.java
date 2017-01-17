/* CLASS:  
 * AUTHOR: Jonah
 * DESCRIPTION:  
 ******************************************************************************/

package getscore;
import javax.swing.JOptionPane;

public class calculateScore {

    // WRITE CODE HERE
    public static void average()
    {
    String input;
    double score;
    double total = 0;
    double maxTerm = -101, minTerm = -101;
    double average;
    int count = 0;
    
    
    input = JOptionPane.showInputDialog("Enter a score (-1 to quit)");
    score = Double.parseDouble(input);
    
    while (score != -1)
    {
        count++;
        maxTerm = score;
        minTerm = score;
        total += score;
        System.out.print(score + " ");
        
        input = JOptionPane.showInputDialog("Enter a score (-1 to quit)");
        score = Double.parseDouble(input);
        
    }
    
    average = total / (count);
    if (count > 0)
    {
        System.out.printf("\nThe average is %.1f\n", average);
        System.out.println("The highest score was " + maxTerm);
        System.out.println("The lowest score was " + minTerm);
        
    }
    else
        System.out.println("No scores were entered.");
    
   
    }
    
    
}
