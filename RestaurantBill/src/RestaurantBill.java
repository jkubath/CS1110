/* PROJECT: RestaurantBill
 * AUTHOR:  Dr. Kaminski - amended by _____________________________________
 * DESCRIPTION:  Calculates final amount to pay based on items on the bill,
 *      tax and tip.
 *      INPUT (Dialog boxes):  entree price, drink price, desert price
 *      OUTPUT (Console):  total price for 3 tip values:  10%, 15%, 20%
 *              plus summary of input values & intermediate price summaries
 *              [SEE COMMENT BELOW UNDER "PRINT OUTPUT"]
 *      ASSUMPTION:  Tip is applied AFTER tax is added.
 *****************************************************************************/
import javax.swing.JOptionPane;

public class RestaurantBill {

    public static void main(String[] args) {

        //------------------------------------------------------- DECLARATIONS
        // constants for MI_TAX (which is 6%),
        //      LOW_TIP, AVE_TIP, GOOD_TIP (10%, 15%, 20% respectively)
        
        // WRITE CODE HERE
        double MI_TAX, LOW_TIP, AVE_TIP, GOOD_TIP;
        MI_TAX = 0.06;
        LOW_TIP = 0.1;
        AVE_TIP = 0.15;
        GOOD_TIP = 0.2;
        
        
        
        // variables for 3 input items, inputString,
        //          itemsTotal, totalWithTax,
        //          totalWith10PC, totalWith15PC, totalWith20PC
        
        // WRITE CODE HERE
        double itemsTotal, totalWithTax, totalWith10PC, 
                totalWith15PC, totalWith20PC;
        
        
        
        
        
        
        //---------------------------------------------------------- GET INPUT
        // STAGES OF TESTING:
        //      1) use HARD-CODED input, like 9.99, 4.50, 4.98 for the 3 items
        //          rather than asking user for input, run it, check results
        //      2) try different hard-coded values, run it, check results
        //      3) ask user for input, run it, check results
        
        // WRITE CODE HERE
        String entreeString, drinkString, dessertString;
        double entree, drink, dessert;
        entreeString = JOptionPane.showInputDialog("Enter the cost of your entree ");
        drinkString = JOptionPane.showInputDialog("Enter the cost of your drink ");
        dessertString = JOptionPane.showInputDialog("Enter the cost of your dessert ");
        
        entree = Double.parseDouble(entreeString);
        drink = Double.parseDouble(drinkString);
        dessert = Double.parseDouble(dessertString);
        
        
        System.out.println(entree);
        System.out.println(drink);
        System.out.println(dessert);
        
        
        //---------------------------------------------------- DO CALCULATIONS
        
        // WRITE CODE HERE
        itemsTotal = entree + drink + dessert;
        totalWithTax = itemsTotal + (itemsTotal * MI_TAX);
        System.out.println("Total " + itemsTotal);
        System.out.printf("With Tax " + "%.2f",totalWithTax);
        
        totalWith10PC = totalWithTax + (totalWithTax * .1);
        totalWith15PC = totalWithTax + (totalWithTax * .15);
        totalWith20PC = totalWithTax + (totalWithTax * .20);
        System.out.println();
           
        
        
        
        
        
        
        //------------------------------------------------------- PRINT OUTPUT
        // Things to print, appropriately labelled, nicely formatted:
        //      - the 3 items purchased, with prices:  entree, drink, desert
        //      - total price:
        //                  before tax
        //                  with tax included
        //                  with tax & low (10%) tip
        //                  with tax & ave (15%) tip
        //                  with tax & good (20%) tip
        // HELP for getting doubles to print with just 2 decimal places:
        //      (uses printf rather than print or println)
        //      try un-commenting these 3 lines:
//        double pi = 3.14159265359;
//        System.out.println("pi printed as stored:  " + pi);
//        System.out.printf("pi printed with 2 decimal places:  %.2f\n", pi);
        
        // WRITE CODE HERE
        System.out.println("Your entree cost $" + entree + "\n" +
                "Your drink cost $" + drink + "\n" +
                "Your dessert cost $" + dessert);
        System.out.println("total price:");
        System.out.println("\t before tax $" + itemsTotal);
        System.out.printf("\t with tax included $%.2f\n",totalWithTax);
        System.out.printf("\t with tax & low (10%%) tip $%.2f\n",totalWith10PC);
        System.out.printf("\t with tax & low (15%%) tip $%.2f\n",totalWith15PC);
        System.out.printf("\t with tax & low (20%%) tip $%.2f\n",totalWith20PC);
                
        
        
        
        
        
        
        //---------------------------------------------------------------------
        System.exit(0);
    }   
}
