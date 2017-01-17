/* PROJECT:  Lab Assignment 5
 * AUTHOR:  Jonah Kubath   Wed 12:30
 * DESCRIPTION: Work Schedule Optimizer     October 31, 2016
 ******************************************************************************/
package assignment5;

import javax.swing.JOptionPane;

/**
 * This is the main worker for the program. It should implement methods to do
 * all the important calculations. As an example template method totalShiftHrs
 * is given.
 *
 * @author Vinay Gavirangaswamy
 */
public class WorkScheduleStatisticsWorker {

    //returns total hours in a shift
    public static int totalShiftHrs(int shift, int[][] workShiftHrs) {
        int totalHours = 0;
        //0 = morning 1 = afternoon 2 = night 3 = total
        int total[] = new int[4];
        int morningShift = 0;
        int afternoonShift = 0;
        int nightShift = 0;

        for (int i = 0; i < workShiftHrs.length; i++) {
            {
                for (int j = 0; j < workShiftHrs[i].length; j++) {
                    totalHours += workShiftHrs[i][j];
                    if (j == 0) {
                        morningShift += workShiftHrs[i][0];
                    }
                    if (j == 1) {
                        afternoonShift += workShiftHrs[i][1];
                    }
                    if (j == 2) {
                        nightShift += workShiftHrs[i][2];
                    }
                }
            }

            total[0] = morningShift;
            total[1] = afternoonShift;
            total[2] = nightShift;
            total[3] = totalHours;

        }
        return total[shift];

    }

    //returns which shift has least hrs worked
    public static String minShiftHrs(int[][] workShiftHrs) {
        int shift = 0;
        int minWorked = 0;
        int day = 0;
        String minDay;
        String minShift = "";

        minWorked = DataStore.workShiftSchedule[0][0];
        for(int i = 0; i < DataStore.workShiftSchedule.length; i++)
        {
            for(int j = 0; j < DataStore.workShiftSchedule[i].length; j++)
            {
                
                if(DataStore.workShiftSchedule[i][j] < minWorked)
                {
                    
                    minWorked = DataStore.workShiftSchedule[i][j];
                    shift = j;
                    day = i;
                }
                
            }
        }
        if(shift == 0)
            minShift = "morning shift";
        if(shift == 1)
            minShift = "afternoon shift";
        if(shift == 2)
            minShift = "night shift";
        
        minDay = String.format("%ss during %s\n\tTotal hours for this shift: %d"
                , day(day), minShift, DataStore.workShiftHrs[day][shift]);
        
        return minDay;
    }

    //returns which shift had most hours worked
    public static String maxShiftHrs(int[][] workShiftHrs) {
        int shift = 0;
        int maxWorked = 0;
        int day = 0;
        String maxDay;
        String maxShift = "";

        maxWorked = DataStore.workShiftSchedule[0][0];
        for(int i = 0; i < DataStore.workShiftSchedule.length; i++)
        {
            for(int j = 0; j < DataStore.workShiftSchedule[i].length; j++)
            {
                
                if(DataStore.workShiftSchedule[i][j] > maxWorked)
                {
                    
                    maxWorked = DataStore.workShiftSchedule[i][j];
                    shift = j;
                    day = i;
                }
                
            }
        }
        if(shift == 0)
            maxShift = "morning shift";
        if(shift == 1)
            maxShift = "afternoon shift";
        if(shift == 2)
            maxShift = "night shift";
        
        maxDay = String.format("%ss during %s\n\tTotal hours for this shift: %d"
                , day(day), maxShift, DataStore.workShiftHrs[day][shift]);
        
        return maxDay;
    }

    //No longer used
    /**
     * @deprecated 
     * @return inputDay
     */
    public static int inputDay() {

        String input = JOptionPane.showInputDialog("Enter the day number to output"
                + " earnings.\n"
                + "0(Sunday)-6(Saturday)");
        String inputCheck = input.replaceAll("[^0-6]", "~");
        while (inputCheck.compareTo(input) != 0) {
            input = JOptionPane.showInputDialog("Invalid entry. \n"
                    + "Only numbers 0-6");
            inputCheck = input.replaceAll("[^0-6]", "~");
        }

        int inputDay = Integer.parseInt(input);

        return inputDay;
    }

    //Print minPay and maxPay
    public static void minMaxPayPrint() {

        double totalDay = 0;
        double totalEarning = 0;
        int countMinDay = 0;
        int countMaxDay = 0;
        int countMin = 0;
        int countMax = 0;
        double minEarning = Integer.MAX_VALUE;
        double maxEarning = Integer.MIN_VALUE;

        for (int i = 0; i < DataStore.monthlyEarnings.length; i++) {
            for (int j = 0; j < DataStore.monthlyEarnings[i].length; j++) {
                totalDay = DataStore.monthlyEarnings[i][j];
                if (totalDay < minEarning) {
                    minEarning = totalDay;
                    countMin = i;
                    countMinDay = j;
                }
                if (totalDay > maxEarning) {
                    maxEarning = totalDay;
                    countMax = i;
                    countMaxDay = j;
                }
            }
        }
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 3; j++){
                totalEarning += DataStore.shiftEarnings[i][j];
            }
        }

        String monthMin = month(countMin);
        String monthMax = month(countMax);

        System.out.printf("\n%-75s%25.2f\n", "The minimum earning shift was :", minEarning);
        System.out.println("\t" + day(countMinDay) + "'s in " + monthMin);
        System.out.printf("\n%-75s%25.2f\n", "The maximum earnings :", maxEarning);
        System.out.println("\t" + day(countMaxDay) + "'s in " + monthMax);
        System.out.printf("\n%-75s%25.2f\n", "The total earnings   :",
                totalEarning);

    }

    //returns min money earned on a specific day in one shift
    public static double minPayDay(int[][] shiftEarnings) {
        int day = inputDay();
        double[] earning = new double[2];

        double minEarning = shiftEarnings[day][0];

        if (shiftEarnings[day][1] < minEarning) {
            minEarning = shiftEarnings[day][1];
        }
        if (shiftEarnings[day][2] < minEarning) {
            minEarning = shiftEarnings[day][2];
        }

        return minEarning;
    }

    public static double maxPayDay(int[][] shiftEarnings) {
        int day = inputDay();

        double maxEarning = shiftEarnings[day][0];

        if (shiftEarnings[day][1] > maxEarning) {
            maxEarning = shiftEarnings[day][1];
        }
        if (shiftEarnings[day][2] > maxEarning) {
            maxEarning = shiftEarnings[day][2];
        }
        return maxEarning;
    }

    //returns which shift has min earnings
    public static String minShiftPay(double[][] shiftEarnings) {
        int shift = 0;
        double minEarned = 0;
        int day = 0;
        String minDay;
        String minShift = "";

        minEarned = shiftEarnings[0][0];
        for(int i = 0; i < shiftEarnings.length; i++)
        {
            for(int j = 0; j < shiftEarnings[i].length; j++)
            {
                
                if(shiftEarnings[i][j] < minEarned)
                {
                    
                    minEarned = shiftEarnings[i][j];
                    shift = j;
                    day = i;
                }
                
            }
        }
        if(shift == 0)
            minShift = "morning shift";
        if(shift == 1)
            minShift = "afternoon shift";
        if(shift == 2)
            minShift = "night shift";
        
        minDay = String.format("%ss during %s\n\tTotal earned for this shift: $%.2f"
                , day(day), minShift, shiftEarnings[day][shift]);
        
        return minDay;
    }

    //Returns which shift has max earnings
    public static String maxShiftPay(double[][] shiftEarnings) {
        int shift = 0;
        double maxEarned = 0;
        int day = 0;
        String maxDay;
        String maxShift = "";

        maxEarned = shiftEarnings[0][0];
        for(int i = 0; i < shiftEarnings.length; i++)
        {
            for(int j = 0; j < shiftEarnings[i].length; j++)
            {
                
                if(shiftEarnings[i][j] > maxEarned)
                {
                    
                    maxEarned = shiftEarnings[i][j];
                    shift = j;
                    day = i;
                }
                
            }
        }
        if(shift == 0)
            maxShift = "morning shift";
        if(shift == 1)
            maxShift = "afternoon shift";
        if(shift == 2)
            maxShift = "night shift";
        
        maxDay = String.format("%ss during %s\n\tTotal earned for this shift: $%.2f"
                , day(day), maxShift, shiftEarnings[day][shift]);
        
        return maxDay;
    }

    //returns average monthly salary
    public static double averageSalary(double[][] shiftEarnings) {
        double totalEarnings = 0;
        double averageEarnings = 0;
        for (int i = 0; i < shiftEarnings.length; i++) {
            for (int j = 0; j < shiftEarnings[i].length; j++) {
                totalEarnings += shiftEarnings[i][j];
            }
        }

        averageEarnings = totalEarnings / 3;

        return averageEarnings;
    }

    public static String day(int dayNumber) {
        String dayOfWeek = "";
        switch (dayNumber) {
            case (0):
                dayOfWeek = "Sunday";
                break;
            case (1):
                dayOfWeek = "Monday";
                break;
            case (2):
                dayOfWeek = "Tuesday";
                break;
            case (3):
                dayOfWeek = "Wednesday";
                break;
            case (4):
                dayOfWeek = "Thursday";
                break;
            case (5):
                dayOfWeek = "Friday";
                break;
            case (6):
                dayOfWeek = "Saturday";
                break;
        }

        return dayOfWeek;
    }

    public static int day(String day) {
        int dayOfWeek = 0;
        switch (day) {
            case ("sunday"):
                dayOfWeek = 0;
                break;
            case ("monday"):
                dayOfWeek = 1;
                break;
            case ("tuesday"):
                dayOfWeek = 2;
                break;
            case ("wednesday"):
                dayOfWeek = 3;
                break;
            case ("thursday"):
                dayOfWeek = 4;
                break;
            case ("friday"):
                dayOfWeek = 5;
                break;
            case ("saturday"):
                dayOfWeek = 6;
                break;
        }

        return dayOfWeek;
    }

    public static String month(int month) {
        String monthString = "";
        if (month == 0) {
            monthString = "September";
        }
        if (month == 1) {
            monthString = "October";
        }
        if (month == 2) {
            monthString = "November";
        }

        return monthString;
    }

}
