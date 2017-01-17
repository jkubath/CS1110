/* PROJECT:  Lab Assignment 5
 * AUTHOR:  Jonah Kubath   Wed 12:30
 * DESCRIPTION: Work Schedule Optimizer     October 31, 2016
 ******************************************************************************/
package assignment5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is the main driver for the program. It provide implementation for
 * method populateDataStore, that should read and parse the data in from the
 * data file “timesheets.txt”. Format of the data file is given in input
 * section. In short data file is divided into five columns. First column gives
 * the day of the week, second is the date and followed by 3 columns during
 * which the employee worked. It is assumed that employee did not work if the
 * values in the corresponding column is empty.
 *
 * @author
 */
public class WorkScheduleStatisticsDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "timesheets.txt";
        populateDataStore(fileName); //prints the file

        System.out.println("----------------------------------------------------------------------------------------------------");
        //Originally printed out -- WorkScheduleStatisticsWorker.totalShiftHrs
        System.out.printf("\n%-75s%25d\n", "Total number of morning shifts worked :", DataStore.workShift(Constants.MORNING_SHIFT));
        System.out.printf("\n%-75s%25d\n", "Total number of afternoon shifts worked :", DataStore.workShift(Constants.NOON_SHIFT));
        System.out.printf("\n%-75s%25d\n", "Total number of evening shifts worked :", DataStore.workShift(Constants.EVENING_SHIFT));
        printHrs();
        // Rest to be implemented as instructed in the assignment description.s
        System.out.println("----------------------------------------------------------------------------------------------------");

    }

    public static void populateDataStore(String fileName) throws FileNotFoundException {
        Scanner fsc = new Scanner(new FileInputStream(fileName));
        final int Time_Sheet_Length = 100;
        String day;
        int dayIndex = 0;
        String shiftLength;
        String date;
        String startShift;
        String endShift;
        String checkTime; //Checks to see if the next string is a shift or day
        int shiftWorked; //Used to input the length into timeSheet Array

        //----------------------------------------------------------------------
        //Takes data from txt file and saves into array
        String[][] timeSheet = new String[Time_Sheet_Length][5];
        //Set all values to 0 to start off
        for (int i = 0; i < timeSheet.length; i++) {
            for (int j = 0; j < timeSheet[i].length; j++) {
                timeSheet[i][j] = "0:00-0:00";

            }
        }

        //priming the first input
        day = fsc.next();
        while (fsc.hasNext()) {
            date = fsc.next();
            timeSheet[dayIndex][0] = day;
            timeSheet[dayIndex][1] = date;
            checkTime = fsc.next();
            //Reset the shift
            shiftWorked = 2;

            //Checking if the string is a shift
            while (checkTime.charAt(1) == ':' || checkTime.charAt(2) == ':') {
                //if checkTime passes the test then we know the next two numbers
                //will be our start and end of shift

                startShift = checkTime;
                endShift = fsc.next();

                //Decides which shift the person worked
                if (startShift.charAt(1) == '2') {
                    shiftWorked = 3;
                }
                if (startShift.charAt(1) == '6') {
                    shiftWorked = 4;
                }

                //Calls the method to find the total time
                shiftLength = "" + DataStore.calcNumHrsInShift(endShift, startShift);
                //saves the time to the timeSheet array
                //timeSheet[dayIndex][shiftWorked] = shiftLength;
                timeSheet[dayIndex][shiftWorked] = startShift + "-" + endShift;
                //Saves the next clock to the next spot in the array
                shiftWorked++;
                //Saving checkTime
                if (fsc.hasNext()) {
                    checkTime = fsc.next();
                } else //Creates an exit without saving to the next day
                {
                    checkTime = "Null";
                }
            }

            //Using the exit from above
            if (checkTime.compareTo("Null") != 0) {
                day = checkTime;
            }
            //Iterates the day count
            dayIndex++;
        }
        //----------------------------------------------------------------------
        //Printing the array---------------------------------------------------
//        for (int i = 0; i < dayIndex; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.printf("%-14s", timeSheet[i][j]);
//            }
//            System.out.println();
//        } 
        //Printing the array---------------------------------------------------

        //Calling the populateParallenArry
        String[] shift = new String[2];
        int hoursWorked = 0;
        double basePay = DataStore.shiftPay();
        double[] shiftHourly = {(5 * basePay), (4 * basePay), basePay, (.75 * basePay), basePay,
            (1.5 * basePay), (2 * basePay)};
        double hourlyPay = 0;

        for (int i = 0; i < dayIndex; i++) {
            for (int j = 0; j < 6; j++) {
                //0-6 for the weekday
                int weekDay = dayOfWeek(timeSheet[i][0]);
                if (j >= 2 && j <= 4) {
                    shift = timeSheet[i][j].split("-");
                    startShift = shift[0];
                    endShift = shift[1];

                    hourlyPay = shiftHourly[weekDay];
                    DataStore.populateParallelArry(startShift, endShift, weekDay, hourlyPay);
                }
            }
        }
        
        DataStore.workShiftEarning(shiftHourly);

        DataStore.monthlyEarning(timeSheet, dayIndex, shiftHourly);

    }

    public static int dayOfWeek(String weekDay) throws NumberFormatException {
        int n = 0;
        weekDay = weekDay.toLowerCase();
        switch (weekDay) {
            case ("sunday"):
                n = 0;
                break;
            case ("monday"):
                n = 1;
                break;
            case ("tuesday"):
                n = 2;
                break;
            case ("wednesday"):
                n = 3;
                break;
            case ("thursday"):
                n = 4;
                break;
            case ("friday"):
                n = 5;
                break;
            case ("saturday"):
                n = 6;
                break;
            default:
                n = 0;
        }
        return n;

    }

    public static void printHrs() {
        System.out.printf("\n%-75s%25s\n", "The total hours worked in the period :",
                WorkScheduleStatisticsWorker.totalShiftHrs(3, DataStore.workShiftHrs));
        System.out.printf("\n%-74s%26s\n", "The shift with minimum hours :",
                WorkScheduleStatisticsWorker.minShiftHrs(DataStore.workShiftHrs));
        System.out.printf("\n%-71s%29s\n", "The shift with maximum hours :",
                WorkScheduleStatisticsWorker.maxShiftHrs(DataStore.workShiftHrs));
        WorkScheduleStatisticsWorker.minMaxPayPrint();
        System.out.printf("\n%-69s%31s\n", "The shift with minimum earning :",
                WorkScheduleStatisticsWorker.minShiftPay(DataStore.shiftEarnings));
        System.out.printf("\n%-74s%26s\n", "The shift with maximum earning :",
                WorkScheduleStatisticsWorker.maxShiftPay(DataStore.shiftEarnings));
        System.out.printf("\n%-75s%25.2f\n", "The average income             :",
                WorkScheduleStatisticsWorker.averageSalary(DataStore.shiftEarnings));

    }

}
