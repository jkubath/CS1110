/* PROJECT:  Take data from a file and output correct information
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  
 ******************************************************************************/
package smallpersoninfo;

import java.io.*;
import java.util.Scanner;

public class SmallPersonInfo {

    public static void main(String[] args) throws IOException {

        // WRITE main's CODE HERE
        String fileName = "SmallPersonInfo.txt";
        File input = new File(fileName);
        Scanner scan = new Scanner(input);
        String[][] info = new String[100][4];
        int index = 0;

        while (scan.hasNext()) {
            info[index][0] = scan.nextLine();
            
            info[index][1] = scan.nextLine();
            info[index][2] = scan.nextLine();
            info[index][3] = scan.nextLine();
            index++;
        }

        //___________________________________________
        System.out.println("Person Report");
        System.out.println();
        System.out.printf("%8s  " + "%8s  " + "%4s  " + "%10s",
                "Name", "Picture", "Age", "Income");
        System.out.println();
        for (int i = 0; i < index; i++) {
            System.out.printf("%8s  " + "%8s  " + "%4s  " + "%10s",
                    info[i][0], info[i][1], info[i][2], info[i][3]);
            System.out.println();
        }
        System.out.println();
        System.out.printf("Total income: %.2f" , getTotal(info, index));
        System.out.println();
        
        scan.close();

    }
    
    public static double getTotal(String info[][],int index) throws IOException{
        double totalSalary = 0;
        for(int i = 0; i < index; i++)
        {
            totalSalary += (int) Double.parseDouble(info[i][3]);
        }

    
            return totalSalary;
}
}
