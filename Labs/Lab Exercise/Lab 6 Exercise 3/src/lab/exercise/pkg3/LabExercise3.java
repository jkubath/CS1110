/* PROJECT:  Lab Exercise 3
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Lab Exercise 3
 ******************************************************************************/
package lab.exercise.pkg3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LabExercise3 {

    public static void main(String[] args) {

        // WRITE main's CODE HERE
        int total1 = 0, total2 = 0, total3 = 0, total4 = 0;
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.println("Enter a number.");
                arr[i][j] = in.nextInt();
            }
        }
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        //Top Left
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(i == 0 || i == 2){
                    total1 += arr[i][j];
                }
                if(i == 1 && j == 1)
                {
                    total1 += arr[i][j];
                }
            }
        }
        
        //top right
        for(int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 6; j++)
            {
                if(i == 0 || i == 2){
                    total2 += arr[i][j];
                }
                if(i == 1 && j == 4)
                {
                    total2 += arr[i][j];
                }
            }
        }
        
        //bottom left
        for(int i = 3; i < 6; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(i == 3 || i == 5){
                    total3 += arr[i][j];
                }
                if(i == 4 && j == 1)
                {
                    total3 += arr[i][j];
                }
            }
        }
        
        //Bottom right
        for(int i = 3; i < 6; i++)
        {
            for (int j = 3; j < 6; j++)
            {
                if(i == 3 || i == 5){
                    total4 += arr[i][j];
                }
                if(i == 4 && j == 4)
                {
                    total4 += arr[i][j];
                }
            }
        }
        
        System.out.println(total1);
        System.out.println(total2);
        System.out.println(total3);
        System.out.println(total4);
        
        int max = total1;
        int row = 0;
        int col = 0;
        if(total2 > max)
        {
            max = total2;
            col = 3;
        }
        if(total3 > max)
        {
            max = total3;
            row = 3;
        }
            
        if(total4 > max)
        {
            max = total4;
            row = 3;
            col = 3;
        }
        
        
        //Printing out the correct hour glass
        System.out.println(arr[row][col] + " " + arr[row][col+1] + " " +
                arr[row][col+2]);
        System.out.println(" " + " " + arr[row+1][col+1] + " " + " ");
        System.out.println(arr[row+2][col] + " " + arr[row+2][col+1] + " " +
                arr[row+2][col+2]);
        
        
        
        
        
        
        
    }
}




