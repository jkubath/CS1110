/* PROJECT:  LittlePeopleCsvArray
 * AUTHOR: 
 * DESCRIPTION:  The data values are hard-coded into the array as csv lines.
 * TO DO:  Write a report showing 1 little person per line.
 *          Columns must align, with ___-justification:
 *              - for alpha fields,   name & pic   - left-justified
 *              - for numeric fields, age & salary - right-justified.      
 *****************************************************************************/
package littlepeoplecsvarray;

public class LittlePeopleCsvArray {

    public static void main(String[] args) {

        //-------------------------------------------------------- "INPUT" DATA
        // an array of strings (data values specified as an initializer list),
        //          where each string is a "CSV line"

        String[] line = {
            "Happy,:-),55,50000.00",
            "Grumpy,:-(,65,35000.00",
            "Doc,|:-),80,100000.00",
            "Sneezy,:<),40,54321.99",
            "Sleepy,-),45,21111.11",
            "Bashful,:-|,40,64000.88",
            "Dopey,<:-],50,10000.01"
        };      
        //----------------------------------------------- VARIABLE DECLARATIONS
        double totalSalary = 0;
        int totalAge = 0;
        double averageAge = 0;
        
        String name;
        String pic;
        int age;
        double salary;
        
        String aLine;
        
        // TO DO:  need fields to SPLIT a line into, so program can access
        //          individual fields later for printing & use in calculating       
        
        
        
        
        //-------------------------------------------- WRITE REPORT HEADER LINE
        System.out.printf("NAME     AGE   PIC       SALARY\n");
        //-------------------------------------------------- WRITE DETAIL LINES
        // TO DO:  Write the 7 individual lines of the report
        //          AND, while you're doing that, keep running totals as needed
        // [Here's a format string for printf  "%-7s  %3d   %-5s %,10.2f\n"
        //          to use with:  name, age, pic, salary (in that order)]
        // NOTE:  Treat big array like a STREAM of "input" data
        //          i.e., loop til done {"read" one & completely "deal with it"}
        
        
        
        

        
        
        
        
        
        
        
        
        // ------------------------------------------------ WRITE SUMMARY LINES
        System.out.printf("\n%-7s  %3s  %-5s  %,10.2f\n",
                "TOTAL", "", "", totalSalary);
        System.out.printf("\nAVERAGE  %.1f\n", averageAge); 
    }
}
