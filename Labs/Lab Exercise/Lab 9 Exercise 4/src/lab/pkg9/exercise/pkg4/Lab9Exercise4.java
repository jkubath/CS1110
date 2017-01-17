/* PROJECT:  Lab 9 Exercise 4
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 4
 ******************************************************************************/
package lab.pkg9.exercise.pkg4;
import java.io.*;
import java.util.Scanner;

public class Lab9Exercise4 {

    public static void main(String[] args) throws FileNotFoundException {
        final int numberStudent = 1000; 
        final int numberAssignment = 6;
        // WRITE main's CODE HERE
        File file = new File("grades.csv");
        Scanner inFile = new Scanner(file);
        String aLine = inFile.nextLine();
        int count = 0;
        
        String[][] student = new String[numberStudent][numberAssignment + 1];
        while(inFile.hasNextLine())
        {
            aLine = inFile.nextLine();
            student[count] = aLine.split(",");
            count++;
        }
        
//        for(int i = 0; i < count; i++){
//            for(int j = 0; j < 7; j++)
//            {
//                System.out.println(student[i][j] + " ");
//            }
//            
//        }
        int assignmentCount;
        double[] averageGrade = new double[count];
        for(int i = 0; i < count; i++)
        {
            assignmentCount = 0;
            for(int j = 1; j < student[i].length; j++)
            {
                averageGrade[i] += Double.parseDouble(student[i][j]);
                assignmentCount++;
                
            }
            averageGrade[i] = averageGrade[i] / assignmentCount;
            System.out.printf("%9s : %.2f\n", student[i][0],averageGrade[i]);
        }

        
        
        
        
        
        
        inFile.close();
    }

}
