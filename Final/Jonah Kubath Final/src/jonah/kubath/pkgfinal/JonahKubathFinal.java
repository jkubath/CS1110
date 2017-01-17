/* PROJECT:  CS1110 Final
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  
 ******************************************************************************/
package jonah.kubath.pkgfinal;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class JonahKubathFinal {

    public static void main(String[] args) throws FileNotFoundException {
        //Data array size
        final int SIZE = 1000;
        final int WIDTH = 3;

        //Enter the file name
        File readFile = new File("CountryData8Col.csv");
        Scanner inFile = new Scanner(readFile);

        String aLine;
        String[] tempArray;
        String[] line;
        String[][] data = new String[SIZE][WIDTH];
        String cleanLine;
        int count = 0;
        int widthCount;
        //Take first line
        aLine = inFile.nextLine();
        System.out.println("First array _________________________________");
        //Split each line by the comma
        while (inFile.hasNext()) {
            aLine = inFile.nextLine();
            line = aLine.split("INSERT INTO Country VALUES ");
            cleanLine = line[1].trim();
            cleanLine = cleanLine.replaceAll("[();'']", "");
            //Data has been cleaned
            //System.out.println(cleanLine);
            //Life expectancy is 6

            tempArray = cleanLine.split(",");
            for (int i = 0; i < tempArray.length; i++) {
                if (tempArray[i].length() > 15) {
                    tempArray[i] = tempArray[i].substring(0, 15);
                }
            }
            //Don't include life expectancy of 0
            //name continent life expectancy

            if (tempArray[6].compareTo("0") != 0) {
                widthCount = 0;
                for (int i = 0; i < tempArray.length; i++) {
                    if (i == 0 || i == 3 || i == 4 || i == 5 || i == 7) {

                    } else {
                        data[count][widthCount] = tempArray[i];
                        System.out.print(data[count][widthCount] + " ");
                        widthCount++;
                    }

                }
                //System.out.print(" " + count);
                System.out.println();

                count++;
            }

        }
        System.out.println("\n\nSecond array _________________________________");
        insertionSort(data, count);
        //selectionSort(data);
        System.out.println("Done");
        //Print to a file
        PrintWriter printFile = new PrintWriter("Report.txt");

        for (int i = 0; i < count; i++) {
            printFile.printf("%-15s   %-15s    %4s", data[i][0], data[i][1], data[i][2]);
            for (int j = 0; j < 3; j++) {
                System.out.print(data[i][j] + " ");

            }
            System.out.println();
            printFile.println();
        }

        printFile.println();

        //lowest life
        System.out.println("Low");
        int low = lowestLife(data, count);
        int high = highestLife(data, count);
        double average = averageLife(data, count);

        System.out.println(low);
        String lowCountry = String.format(data[low][2] + " for " + data[low][0]
                + " in " + data[low][1]);
        String highCountry = String.format(data[high][2] + " for " + data[high][0]
                + " in " + data[high][1]);
        double median = medianLife(data, count);
        double americaLife = usLife(data, count);
        printFile.printf("Life Expectancy: highest is %s\n"
                + "                 lowest is %s\n"
                + "                 average is %.2f\n"
                + "                 median is %.2f\n"
                + "                 United States is %.2f\n"
                , lowCountry, highCountry, average, median, americaLife);

        printFile.println();
        
        printFile.print("                < 60   60-70   70.1-75    > 75\n");
        printFile.print("               |------------------------------\n");
        printFile.print("" + africa(data, count) + " \n");
        printFile.print("" + Asia(data, count) + "\n");
        printFile.print("" + Europe(data, count) + "\n");
        printFile.print("" + NA(data, count) + "\n");
        printFile.print("" + Oceania(data, count) + "\n");
        printFile.print("" + South(data, count) + "\n");
        
        
        printFile.close();
    }

    public static void insertionSort(String[][] array, int count) {
        String saveFirst, saveSecond, saveThird;
        int i;

        for (int iNextEl = 1; iNextEl < count; iNextEl++) {
            saveSecond = array[iNextEl][1];
            saveFirst = array[iNextEl][0];
            saveThird = array[iNextEl][2];

            i = iNextEl;

            //Compare values
            while ((i > 0) && (array[i - 1][1].compareTo(saveSecond) > 0)) {
                array[i][1] = array[i - 1][1];
                array[i][0] = array[i - 1][0];
                array[i][2] = array[i - 1][2];
                i--;
            }

            //Save value at new spot
            array[i][1] = saveSecond;
            array[i][0] = saveFirst;
            array[i][2] = saveThird;
        }

    }

    public static void medianSort(String[][] array, int count) {
        String saveFirst, saveSecond, saveThird;
        int i;

        for (int iNextEl = 1; iNextEl < count; iNextEl++) {
            saveSecond = array[iNextEl][1];
            saveFirst = array[iNextEl][0];
            saveThird = array[iNextEl][2];

            i = iNextEl;

            //Compare values
            while ((i > 0) && (array[i - 1][2].compareTo(saveThird) > 0)) {
                array[i][1] = array[i - 1][1];
                array[i][0] = array[i - 1][0];
                array[i][2] = array[i - 1][2];
                i--;
            }

            //Save value at new spot
            array[i][1] = saveSecond;
            array[i][0] = saveFirst;
            array[i][2] = saveThird;
        }

    }

    public static int lowestLife(String[][] array, int count) {
        String lowest = array[0][2];
        int lowestI = 0;
        for (int i = 0; i < count; i++) {

            if (array[i][2].compareTo(lowest) < 0) {
                lowest = array[i][2];

                lowestI = i;
            }

        }
        return lowestI;
    }

    public static int highestLife(String[][] array, int count) {
        String lowest = array[0][2];
        int lowestI = 0;
        for (int i = 0; i < count; i++) {

            if (array[i][2].compareTo(lowest) > 0) {
                lowest = array[i][2];

                lowestI = i;
            }

        }
        return lowestI;
    }

    public static double averageLife(String[][] array, int count) {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += Double.parseDouble(array[i][2]);

        }
        return total / count;
    }

    public static double medianLife(String[][] array, int count) {
        medianSort(array, count);
        return Double.parseDouble(array[count / 2][2]);
    }
    
    public static double usLife(String[][] array, int count){
        int j = 0;
        for(int i = 0; i < count; i++)
            if(array[i][0].compareTo("United States") == 0)
                j = i;
        
        return Double.parseDouble(array[j][2]);
    }
    
    public static String africa(String[][] array, int count){
        int less = 0;
        int sixtySeventy = 0;
        int seventyFive = 0;
        int greater = 0;
        for(int i = 0; i < count; i++){
            if(array[i][1].compareTo("Africa") == 0)
            {
                if(Double.parseDouble(array[i][2]) < 60)
                    less++;
                if(Double.parseDouble(array[i][2]) >= 60 && Double.parseDouble(array[i][2]) <= 70)
                    sixtySeventy++;
                if(Double.parseDouble(array[i][2]) > 70 && Double.parseDouble(array[i][2]) <= 75)
                    seventyFive++;
                if(Double.parseDouble(array[i][2]) > 75)
                    greater++;    
                }           
        }
        
        String country = String.format("%-15s|%5d%5d%5d%5d", "Africa", 
                less, sixtySeventy, seventyFive, greater);
        
        return country;
    }
    
    public static String Asia(String[][] array, int count){
        int less = 0;
        int sixtySeventy = 0;
        int seventyFive = 0;
        int greater = 0;
        for(int i = 0; i < count; i++){
            if(array[i][1].compareTo("Asia") == 0)
            {
                if(Double.parseDouble(array[i][2]) < 60)
                    less++;
                if(Double.parseDouble(array[i][2]) >= 60 && Double.parseDouble(array[i][2]) <= 70)
                    sixtySeventy++;
                if(Double.parseDouble(array[i][2]) > 70 && Double.parseDouble(array[i][2]) <= 75)
                    seventyFive++;
                if(Double.parseDouble(array[i][2]) > 75)
                    greater++;    
                }           
        }
        
        String country = String.format("%-15s|%5d%5d%5d%5d", "Asia", 
                less, sixtySeventy, seventyFive, greater);
        
        return country;
    }

    public static String Europe(String[][] array, int count){
        int less = 0;
        int sixtySeventy = 0;
        int seventyFive = 0;
        int greater = 0;
        for(int i = 0; i < count; i++){
            if(array[i][1].compareTo("Europe") == 0)
            {
                if(Double.parseDouble(array[i][2]) < 60)
                    less++;
                if(Double.parseDouble(array[i][2]) >= 60 && Double.parseDouble(array[i][2]) <= 70)
                    sixtySeventy++;
                if(Double.parseDouble(array[i][2]) > 70 && Double.parseDouble(array[i][2]) <= 75)
                    seventyFive++;
                if(Double.parseDouble(array[i][2]) > 75)
                    greater++;    
                }           
        }
        
        String country = String.format("%-15s|%5d%5d%5d%5d", "Europe", 
                less, sixtySeventy, seventyFive, greater);
        
        return country;
    }
    
    public static String NA(String[][] array, int count){
        int less = 0;
        int sixtySeventy = 0;
        int seventyFive = 0;
        int greater = 0;
        for(int i = 0; i < count; i++){
            if(array[i][1].compareTo("North America") == 0)
            {
                if(Double.parseDouble(array[i][2]) < 60)
                    less++;
                if(Double.parseDouble(array[i][2]) >= 60 && Double.parseDouble(array[i][2]) <= 70)
                    sixtySeventy++;
                if(Double.parseDouble(array[i][2]) > 70 && Double.parseDouble(array[i][2]) <= 75)
                    seventyFive++;
                if(Double.parseDouble(array[i][2]) > 75)
                    greater++;    
                }           
        }
        
        String country = String.format("%-15s|%5d%5d%5d%5d", "North America", 
                less, sixtySeventy, seventyFive, greater);
        
        return country;
    }
    
    public static String Oceania(String[][] array, int count){
        int less = 0;
        int sixtySeventy = 0;
        int seventyFive = 0;
        int greater = 0;
        for(int i = 0; i < count; i++){
            if(array[i][1].compareTo("Oceania") == 0)
            {
                if(Double.parseDouble(array[i][2]) < 60)
                    less++;
                if(Double.parseDouble(array[i][2]) >= 60 && Double.parseDouble(array[i][2]) <= 70)
                    sixtySeventy++;
                if(Double.parseDouble(array[i][2]) > 70 && Double.parseDouble(array[i][2]) <= 75)
                    seventyFive++;
                if(Double.parseDouble(array[i][2]) > 75)
                    greater++;    
                }           
        }
        
        String country = String.format("%-15s|%5d%5d%5d%5d", "Oceania", 
                less, sixtySeventy, seventyFive, greater);
        
        return country;
    }
    
    public static String South(String[][] array, int count){
        int less = 0;
        int sixtySeventy = 0;
        int seventyFive = 0;
        int greater = 0;
        for(int i = 0; i < count; i++){
            if(array[i][1].compareTo("South America") == 0)
            {
                if(Double.parseDouble(array[i][2]) < 60)
                    less++;
                if(Double.parseDouble(array[i][2]) >= 60 && Double.parseDouble(array[i][2]) <= 70)
                    sixtySeventy++;
                if(Double.parseDouble(array[i][2]) > 70 && Double.parseDouble(array[i][2]) <= 75)
                    seventyFive++;
                if(Double.parseDouble(array[i][2]) > 75)
                    greater++;    
                }           
        }
        
        String country = String.format("%-15s|%5d%5d%5d%5d", "South America", 
                less, sixtySeventy, seventyFive, greater);
        
        return country;
    }
}
