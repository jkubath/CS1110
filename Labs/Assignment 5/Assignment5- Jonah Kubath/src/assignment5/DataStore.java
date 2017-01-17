/* PROJECT:  Lab Assignment 5
 * AUTHOR:  Jonah Kubath   Wed 12:30
 * DESCRIPTION: Work Schedule Optimizer     October 31, 2016
 ******************************************************************************/
package assignment5;

import static assignment5.WorkScheduleStatisticsWorker.day;
import javax.swing.JOptionPane;

/**
 * This class acts as our main database for the program. It consists of parallel
 * arrays to keep track of •	Shifts during which employee worked for the week. •
 * Total number of hours worked during each shift •	Total shift earnings
 * “populateParallelArry” method should be used inside
 * WorkScheduleStatisticsDriver->populateDataStore method to fill values in
 * parallel arrays. Implementation of calcNumHrsInShift is already given which
 * takes shift start and end time as input to calculate the shift length in
 * hours.
 *
 * @author Vinay Gavirangaswamy
 */
public class DataStore {

    static String weekDays[] = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
    static int workShiftSchedule[][] = new int[7][3];
    static int workShiftHrs[][] = new int[7][3];
    static double shiftEarnings[][] = new double[7][3];
    static double monthlyEarnings[][] = new double[3][7];

    public static void populateParallelArry(String shiftStart, String shiftEnd, int dayofWeek, double shiftPay) throws NumberFormatException {

        String[] shiftHour = new String[2];
        shiftHour = shiftStart.split(":");
        int shiftLength = calcNumHrsInShift(shiftEnd, shiftStart);
        //Adds 1 to the position of the day and shift worked
        //Adds 4 to the hours worked
        switch (dayofWeek) {
            case (0):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (1):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (2):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (3):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (4):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (5):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (6):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            case (7):
                workShiftSchedule(shiftHour, dayofWeek, shiftLength);
                break;
            default:
                break;
        } //end of switch
        
    }

    public static int calcNumHrsInShift(String shiftEnd, String shiftStart) throws NumberFormatException {
        return (int) (Double.parseDouble(shiftEnd.replace(":", ".")) - Double.parseDouble(shiftStart.replace(":", ".")));
    }
    
    public static void workShiftEarning(double[] shiftPay){
        
        for (int i = 0; i < shiftEarnings.length; i++) {
            shiftEarnings[i][0] = workShiftHrs[i][0] * shiftPay[i];
            shiftEarnings[i][1] = workShiftHrs[i][1] * shiftPay[i];
            shiftEarnings[i][2] = workShiftHrs[i][2] * shiftPay[i];
        }
    }

    public static void workShiftSchedule(String[] shiftHour, int dayofWeek, int shiftLength) throws NumberFormatException {
        if (shiftHour[0].compareTo("8") == 0) {
            workShiftSchedule[dayofWeek][0]++;
            workShiftHrs[dayofWeek][0] += shiftLength;
        }
        if (shiftHour[0].compareTo("12") == 0) {
            workShiftSchedule[dayofWeek][1]++;
            workShiftHrs[dayofWeek][1] += shiftLength;
        }
        if (shiftHour[0].compareTo("16") == 0) {
            workShiftSchedule[dayofWeek][2]++;
            workShiftHrs[dayofWeek][2] += shiftLength;
        }

    }

    public static double shiftPay() {
        String input = JOptionPane.showInputDialog("What is the employee's"
                + " base pay?");
        String inputCheck = input.replaceAll("[^.0-9]", "~");

        while (input.compareTo(inputCheck) != 0) {
            input = JOptionPane.showInputDialog("Invalid entry.");
            inputCheck = input.replaceAll("[^.0-9]", "~");
        }

        double shiftPay = Double.parseDouble(input);
        return shiftPay;
    }

    //Populates monthlyEarnings array
    public static void monthlyEarning(String[][] timeSheet, int dayIndex, double[] shiftHourly) {

        for (int i = 0; i < dayIndex; i++) {

            int monthNumber = 0;
            int dayOfWeek = WorkScheduleStatisticsDriver.dayOfWeek(timeSheet[i][0]);
            String monthString = "" + timeSheet[i][1].charAt(1);

            if (monthString.compareTo("/") == 0) {
                monthNumber = 0;
            }
            if (monthString.compareTo("0") == 0) {
                monthNumber = 1;
            }
            if (monthString.compareTo("1") == 0) {
                monthNumber = 2;
            }
            for (int j = 2; j < 5; j++) {
                String[] tempArray = new String[2];
                tempArray = timeSheet[i][j].split("-");
                //September
                monthlyEarnings[monthNumber][dayOfWeek]
                        += DataStore.calcNumHrsInShift(tempArray[1], tempArray[0]);

            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                monthlyEarnings[i][j] = monthlyEarnings[i][j] * shiftHourly[j];

            }
        }

    }
    
    public static int workShift(int shift){
        int totalShift = 0;
        for(int i = 0; i < workShiftSchedule.length; i++){
            totalShift += workShiftSchedule[i][shift];
        }
        
        
        return totalShift;
    }
}
