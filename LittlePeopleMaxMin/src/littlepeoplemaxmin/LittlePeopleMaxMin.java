/* PROJECT: LittlePeopleMaxMin 
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  This program gives the user 6 options for getting further
 *      data about the group of 7 little people - e.g., richest, youngest, etc.
 * INPUT:  user chooses from menu:
 *              R - richest,  P - poorest,  O - oldest,  Y - youngest,
 *              F - alphabetically First by name, L - alpha. Last by name
 * OUTPUT:  selected person's name & picture in output window
 * TO DO:  You need to write:
 *      - the actual parameters for the 6 CALLS
 *      - the formal parameters for the 6 METHODS
 *      - the 6 methods' bodies
 *****************************************************************************/
package littlepeoplemaxmin;

import javax.swing.JOptionPane;

public class LittlePeopleMaxMin {

    public static void main(String[] args) {

        //------------------------------------------------------ HARDCODED DATA
        String[] name = {"Happy", "Grumpy", "Doc", "Sneezy", "Sleepy",
                            "Bashful", "Dopey"};
        int[] age = {55, 65, 80, 40, 45, 40, 50};
        String[] pic = {":-)", ":-(", "|:-)", ":<)", "-)", ":-|", "<:-]"};
        double[] salary = {50000.00, 35000.00, 100000.00, 54321.99, 9123.45,
                            64000.88, 10000.01};
        //----------------------------------- DISPLAY DATA (TO HELP IN TESTING)
        for (int i = 0; i < name.length; i++)
            System.out.printf("[%d]  %-8s %5s  %d  %,10.2f\n",
                    i, name[i], pic[i], age[i], salary[i]);
        System.out.println();
        //--------------------------------------------------- GET USER RESPONSE
        char choice = getUserOption();
        //------------------------------------------------- HANDLE USER REQUEST
        // >>>>>>>  TO DO:  FILL IN PARAMETERS IN THESE CALLS
        int position = 0;
        
        switch (choice) {
            case 'P':
            case 'p':
                position = showPoorest(salary);
                break;
            case 'R':
            case 'r':
                position = showRichest(salary);
                break;
            case 'O':
            case 'o':
            case '0':                                   // zero, just in case
                position = showOldest(age);
                break;
            case 'Y':
            case 'y':
                position = showYoungest(age);
                break;
            case 'F':
            case 'f':
                position = showFirst(name);
                break;
            case 'L':
            case 'l':
            case '1':                                   // one, just in case
                position = showLast(name);
                break;
            default:
                System.out.println("\nERROR:  option was invalid");
        }
        System.out.println("Name: " + name[position]);
        System.out.println("Picture: " + pic[position]);
       
        System.exit(0);
    }
    //*************************************************************************
    public static char getUserOption() {
        
        String menu = "CHOOSE OPTION:\n"
                + "P:  poorest\n"
                + "R:  richest\n"
                + "O:  oldest\n"
                + "Y:  youngest\n"
                + "F:  first (by name)\n"
                + "L:  last (by name)\n";
        String userResponse = JOptionPane.showInputDialog(menu);
        char choice = userResponse.charAt(0);
        return choice;
    }
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    // >>>>>>>  TO DO:  fill in parameters below & write method bodies
    //*************************************************************************
    public static int showPoorest(double[] salary) {
        double least = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < salary.length; i++)
        {
            if (salary[i] < least)
            {
                least = salary[i];
                position = i;
            }
        }
        return position;
    }
    //*************************************************************************
    public static int showRichest(double[] salary) {
        double max = Integer.MIN_VALUE;
        int position = 0;
        for (int i = 0; i < salary.length; i++)
        {
            if (salary[i] > max)
            {
                max = salary[i];
                position = i;
            }
        }
        return position;

    }
    //*************************************************************************
    public static int showOldest(int[]age)  {
        int oldest = Integer.MIN_VALUE;
        int position = 0;
        for (int i = 0; i < age.length; i++)
        {
            if (age[i] > oldest)
            {
                oldest = age[i];
                position = i;
            }
        }
        return position;
    }
    //*************************************************************************
    public static int showYoungest(int[] age) {
        int youngest = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < age.length; i++)
        {
            if (age[i] < youngest)
            {
                youngest = age[i];
                position = i;
            }
        }
        return position;

    }
    //*************************************************************************
    // First alphabetically, by name (not the first name in the array)
    public static int showFirst(String[] name) {
        String lowestName = name[0];
        int position = 0;
        for(int i = 0; i<name.length; i++)
        {
            if(name[i].compareTo(lowestName) < 0)
            {
                lowestName = name[i];
                position = i;
            }
                
            
        }
        return position;

    }
    //*************************************************************************
    // Last alphabetically, by name (not the last name in the array)
    public static int showLast(String[] name) {
        String highestName = name[0];
        int position = 0;
        for(int i = 0; i<name.length; i++)
        {
            if(name[i].compareTo(highestName) > 0)
            {
                highestName = name[i];
                position = i;
            }
                
            
        }
        return position;
    }
}
