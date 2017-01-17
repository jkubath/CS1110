/* PROJECT:  Lab 2 - Monthly Salary
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION: This program takes user input for laptops sold and calculates
 *  their monthly salary.
 *  October 2, 2016
 */
package lab2;

import javax.swing.JOptionPane;

public class Lab2 {


    public static void main(String[] args) {

        String name, nameCheck, input, salaryTier, newTier = "";
        String salaryCheck1, salaryCheck2;
        double baseSalary = 0;
        int    basicSale = 0, premSale = 0, deluxSale = 0;
        double monthlySalary = 0;
        double basic = 650.90, premium = 950.50, deluxe = 1350.95; //Cost of laptops
        double basicCom = 0, premCom = 0, deluxeCom = 0; //Commission for laptops sold
        double totalBasic = 0, totalPrem = 0, totalDeluxe = 0, totalSale = 0; //Total sales for laptops
        double saleCom = 0; //Commission based off of total sales
        double laptopCom = 0; //Commission off of individual laptops
        double totalCom = 0; //total commission(laptop and sale)
        char userInput;
        int n; //used in do-while loop for name check
        char salaryChar, a, b, c; //Character used to check Salary Tier

        //Does the program once to start 
        //then asks the user if they have more to enter          
        do {
            do {
                input = JOptionPane.showInputDialog("Enter the employee's name");
                name = input;

                //Checking if the name is only A-Z or a-z
                nameCheck = name.replaceAll("[^a-zA-Z]", "~");

                if (name.compareTo(nameCheck) == 0) {
                    n = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid entry. \n"
                            + "Please enter a valid name containing: 'a-z'" +
                            " or 'A-Z' lower or upper case.");
                    n = 1;
                }
            } while (n == 1);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Base Salary
            do {
                input = JOptionPane.showInputDialog("Enter their base salary.");

                salaryCheck1 = input;

                //Checking if the base salary only has numbers
                salaryCheck2 = salaryCheck1.replaceAll("[^0-9.$]", "~");

                //Checking if the base salary has a $
                if (salaryCheck2.compareTo(salaryCheck1) == 0) {

                    n = 0;
                    char inputChar = input.charAt(0);
                    //if it does this parts the number into the two and sets the baseSalary
                    if (inputChar == '$') {
                        String splitInput = salaryCheck1;
                        String[] parts = splitInput.split("[$]");
                        String part1 = parts[0];
                        String part2 = parts[1];

                        baseSalary = Double.parseDouble(part2);
                        //System.out.println(baseSalary);
                    } else {
                        baseSalary = Double.parseDouble(input);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid entry. \n"
                            + "Please enter a valid salary amount containing:" +
                            " '0'-'9', and/or beginning '$', and/or '.'");
                    n = 1;
                }
            } while (n == 1);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Salary Tier
            input = JOptionPane.showInputDialog("Enter the tier of their salary."
                    + " (A,B, or C)");
            salaryTier = input;

            salaryTier = salaryTier.toUpperCase();
            salaryChar = salaryTier.charAt(0);
            a = 'A';
            b = 'B';
            c = 'C';  //parameters for while loop
            while ((salaryChar != a) && (salaryChar != b) && (salaryChar != c)) {
                salaryTier = JOptionPane.showInputDialog("Invalid salary tier\n"
                        + "Enter A, B, or C.");
                salaryTier = salaryTier.toUpperCase();
                salaryChar = salaryTier.charAt(0);

            }

            //Laptops Sold
            //Basic
            do {
                input = JOptionPane.showInputDialog("Enter the number of basic" +
                    " laptops sold.");
                String number = input;

                //Checking if basic laptops is a positive integer
                String numberCheck = number.replaceAll("[^0-9]", "~");

                if (number.compareTo(numberCheck) == 0) {
                    n = 0;
                    basicSale = Integer.parseInt(input);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid entry. \n"
                            + "Only positive integers.");
                    n = 1;
                }
            } while (n == 1);
            //Premium
            do {
                input = JOptionPane.showInputDialog("Enter the number of" +
                        " premium laptops sold.");
                String number = input;

                //Checking if the name is only A-Z or a-z
                String numberCheck = number.replaceAll("[^0-9]", "~");

                if (number.compareTo(numberCheck) == 0) {
                    n = 0;
                    premSale = Integer.parseInt(input);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid entry. \n"
                            + "Only positive integers.");
                    n = 1;
                }
            } while (n == 1);
            //Deluxe
            do {
                input = JOptionPane.showInputDialog("Enter the number of" +
                        " deluxe laptops sold.");
                String number = input;

                //Checking if the name is only A-Z or a-z
                String numberCheck = number.replaceAll("[^0-9]", "~");

                if (number.compareTo(numberCheck) == 0) {
                    n = 0;
                    deluxSale = Integer.parseInt(input);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid entry. \n"
                            + "Only positive integers.");
                    n = 1;
                }
            } while (n == 1);
            

            //Calculating the commission from laptops sold
            basicCom = basicSale * 50;
            premCom = premSale * 100;
            deluxeCom = deluxSale * 150;
            laptopCom = basicCom + premCom + deluxeCom;

            //Total Sales
            totalBasic = basicSale * 650.90;
            totalPrem = premSale * 950.50;
            totalDeluxe = deluxSale * 1350.95;
            totalSale = totalBasic + totalPrem + totalDeluxe;

            if (totalSale > 0 && totalSale < 2500) {
                saleCom = 0;
            } else if (totalSale >= 2500 && totalSale < 5500) {
                saleCom = totalSale * .01;
            } else if (totalSale >= 5500 && totalSale < 10500) {
                saleCom = 75 + (0.02 * (totalSale - 5500));
            } else if (totalSale >= 10500 && totalSale < 13500) {
                saleCom = 125 + (0.03 * (totalSale - 10500));
            } else if (totalSale >= 13500) {
                saleCom = 375;
            } else {
                saleCom = 0;
            }

            //determining if they move up in tiers from low to high A<B<C
            totalCom = laptopCom + saleCom;
            if (totalCom > (.75 * baseSalary)) {
                switch (salaryTier) {
                    case "a":
                    case "A":
                        newTier = "B";
//                        System.out.println("Congratulations, " +
//                                name.toUpperCase()
//                                + " you have been promoted to the " + newTier
//                                + " salary tier.");
                        break;
                    case "b":
                    case "B":
                        newTier = "C";
//                        System.out.println("Congratulations " + 
//                                name.toUpperCase()
//                                + " you have been promoted to the \n" + newTier
//                                + " salary tier.");
                        break;
                    case "c":
                    case "C":
                        System.out.println("You are already at the highest"
                                + " salary tier.");
                        System.out.println("You earned a $1,000 bonus");
                        totalCom = totalCom + 1000;
                        break;
                }
            }

            monthlySalary = totalCom + baseSalary;
            // The Output
            name = name.toUpperCase();
            System.out.println("Salesperson: " + name);
            System.out.println("Tier: " + salaryTier);
            System.out.printf("Base Salary:       $%10.2f\n", baseSalary);
            System.out.printf("Commission 1:      $%10.2f\n", saleCom);
            System.out.printf("Commission 2:      $%10.2f\n", laptopCom);
            System.out.printf("Total Commission:  $%10.2f\n", totalCom);
            System.out.printf("Monthly Salary:    $%10.2f\n", monthlySalary);
            System.out.println();
            if (totalCom > (.75 * baseSalary)) {
                switch (salaryTier) {
                    case "b":
                    case "B":
                        System.out.println("Congratulations " + 
                                name.toUpperCase()
                                + " you have been promoted to the \n" + newTier
                                + " salary tier.");
                        break;
                    case "c":
                    case "C":
                        System.out.println("You are already at the highest"
                                + " salary tier.");
                        System.out.println("You earned a $1,000 bonus");
                        break;
                }
            }
                        
                        
            //Continue or end the do while loop
            input = JOptionPane.showInputDialog("Would you like to enter another"
                    + " employee? Yes or No");
            userInput = input.charAt(0);
            
            while (userInput !='y' && userInput !='Y' && userInput !='n' && 
                    userInput != 'N')
            {
                input = JOptionPane.showInputDialog("Invalid entry. \n" +
                       "Enter Yes, YES, No, no, Y, y, N, n.");
                userInput = input.charAt(0);
            }
            

        } while (userInput == 'y' || userInput == 'Y');

        System.out.println("done");

    }

}
