/* PROJECT:  SplitNumInChunks
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Split a "number" into sub-parts.
 *****************************************************************************/
package splitnuminchunks;

public class SplitNumInChunks {

    public static void main(String[] args) {

        //------------------------------------------------------------- "INPUT"
        long phone = 2692763101L;           // L is NOT actually stored in phone
                                            //      as part of the number
        int socSecNum = 123040021;
        String room = "D-109";      
        //---------------------------------------- VARIABLES FOR DESIRED OUTPUT
        // NOTE:  These are initialized (not normally necessary) so the OUTPUT
        //          printing works, even before the processing code is done.
        int areaCode = 0;
        int phonePrefix = 0;
        int phoneSuffix = 0;
        
        int ssnFirst3 = 0;
        int ssnNext2 = 0;
        int ssnLast4 = 0;
        
        char buildingArea = '?';                // 'D'
        int floor = 0;                          // 1
        int roomNum = 0;                        // yes, the full 109
        //----------------------------------------------------- OTHER VARAIBLES
        int remainder;
        String subStr;
        //---------------------------------------------------------- PROCESSING
//         number of 0's in divisor indicates:
//              for / it specifies number of digits on right to DROP
//              for % it specifies number of digits on right to KEEP
        areaCode = (int) (phone / 10000000);
        remainder = (int) (phone % 10000000);
        phonePrefix = remainder / 10000;
        phoneSuffix = remainder % 10000;
        
        ssnFirst3 = socSecNum / 1000000;
        remainder = socSecNum % 1000000;
        ssnNext2 = remainder / 10000;
        ssnLast4 = remainder % 10000;
        
        buildingArea = room.charAt(0);
        subStr = room.substring(2);         // gets string starting in col 2
                                            // where col#'s start at 0
        roomNum = Integer.parseInt(subStr);
        floor = roomNum / 100;
 
        //-------------------------------------------------------------- OUTPUT
        // Examples of simplistic format specifiers
        System.out.printf("Phone %d  >>>  (%d) %d-%d\n\n",
                phone, areaCode, phonePrefix, phoneSuffix);
        System.out.printf("SocSecNum %d  >>>  %d-%d-%d\n\n",
                socSecNum, ssnFirst3, ssnNext2, ssnLast4);
        
        // For "pretty printing", use format specifiers which include:
        //      number of desired columns, right-justified, and 0-fill-on-left
        //      (default is space-fill).
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        
        System.out.printf("Phone %d  >>>  (%03d) %03d-%04d\n\n",
                phone, areaCode, phonePrefix, phoneSuffix);
        System.out.printf("SocSecNum %d  >>>  %03d-%02d-%04d\n\n",
                socSecNum, ssnFirst3, ssnNext2, ssnLast4);
        System.out.printf("Room %s  >>>  area %c, floor %d, room %03d\n\n",
                room, buildingArea, floor, roomNum);
        

    }   
}
