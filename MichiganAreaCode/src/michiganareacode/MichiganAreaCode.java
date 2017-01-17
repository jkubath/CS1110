/* PROJECT:  MichiganAreaCode
 * AUTHOR:  Jonah Kubath
 * DESCRIPTION:  Filtering Michigan area codes

 ******************************************************************************/

/*
User provides a 10-digit phone number (using a dialog box).
The program responds to the user (in the Output window):
- the phone number printed in a "normal phone format:
    like (269) 387-1234
- whether or not it's a Michigan number (based on areaCode)
- if it IS a Michigan number, then what area it's in

Here's the list of Michigan area codes from Wikipedia:
    231 - Northwestern Lower Michigan: Traverse City, Ludington, Muskegon, Petoskey and Cheboygan
    248 - Northern Metro Detroit: All of Oakland County, Northville, and most of Northville Township; overlays with area code 947
    269 - Southwestern Michigan: Battle Creek, Benton Harbor, Allegan, Hastings, Kalamazoo, and St Joseph
    313 - Wayne County: Detroit, Dearborn, Redford Township, and the Grosse Pointes
    517 - South Central Michigan: Lansing, East Lansing, Jackson, Charlotte, Coldwater, Howell, Deerfield, and Addison
    586 - Northeastern Metro Detroit: All of Macomb County
    616 - Western Michigan: Grand Rapids, Holland, Greenville, Grand Haven, Zeeland, and Ionia
    734 - Western and Down River/ Southeastern Michigan Metro Detroit: Ann Arbor, Monroe, Wayne, and Ypsilanti
    810 - Southern Flint and The Thumb: Port Huron, Flint, Flushing, Otisville, Davison, Brighton, Sandusky, and Lapeer
    906 - Upper Peninsula: Marquette, Sault Ste. Marie, St. Ignace, Escanaba, Iron Mountain, Munising, and Mackinac Island
    947 - Northern Metro Detroit: All of Oakland County, Northville, and most of Northville Township; overlays with area code 248
    989 - Central, Tri-Cities and Northeastern Lower Michigan: Alpena, Mt. Pleasant, Bay City, Saginaw, Midland, Owosso, Gaylord, and Bad Axe

Since there's quite a list, use a SWITCH statement to make
decisions and control things.

NOTE:  Don't show the whole list of cities, just the area,
       which is the part before the :

*******************************************************************************/

package michiganareacode;
import javax.swing.JOptionPane;


public class MichiganAreaCode {

    public static void main(String[] args) {
        
        // Variables
        double phoneNumber = 0;
        int areaCode, firstThree, lastFour; //Numbers of the phone number
        int rem = 0;
        String input; //Input phone Number from user
        String two31, two48, two69, three13, five17, five86, six16, seven34;
        String eight10, nine06, nine47, nine89; //Used to create a list of area 
            //codes and cities
        
        
        /**********************************************************************/
        //Input
        input = JOptionPane.showInputDialog("Enter the 10 digit phone number" +
                " - only numbers.");
        phoneNumber = Double.parseDouble(input);
        
        
        /**********************************************************************/
        //Get the area code, first 3 digits, and last 4 digits
        areaCode = (int)(phoneNumber / 10000000);
        rem = (int)(phoneNumber % 10000000);
        firstThree = (int)(rem / 10000);
        rem = (int)(rem % 10000);
        lastFour = (int)(rem);
        
//        System.out.println(areaCode);
//        System.out.println(firstThree);
//        System.out.println(lastFour);

        System.out.printf("(" + areaCode + ")" + " " + firstThree + "-%04d", lastFour);
        System.out.println();
        
       
        /**********************************************************************/
        //Making the area code list
        two31 = "Northwestern Lower Michigan"; //Traverse City, Ludington, 
            //Muskegon, Petoskey and Cheboygan
        two48 = "Northern Metro Detroit"; // All of Oakland County, Northville, 
            //and most of Northville Township
        two69 = "Southwestern Michigan"; // Battle Creek, Benton Harbor, 
            //Allegan, Hastings, Kalamazoo, and St Joseph
        three13 = "Wayne County"; // Detroit, Dearborn, Redford Township, and 
            //the Grosse Pointes
        five17 = "South Central Michigan"; // Lansing, East Lansing, Jackson, 
            //Charlotte, Coldwater, Howell, Deerfield, and Addison
        five86 = "Northeastern Metro Detroit"; // All of Macomb County
        six16 = "Western Michigan"; // Grand Rapids, Holland, Greenville, 
            //Grand Haven, Zeeland, and Ionia
        seven34 = "Western and Down River/ Southeastern Michigan Metro Detroit";
                // Ann Arbor, Monroe, Wayne, and Ypsilanti
        eight10 = "Southern Flint and The Thumb"; // Port Huron, Flint, 
            //Flushing, Otisville, Davison, Brighton, Sandusky, and Lapeer
        nine06 = "Upper Peninsula"; // Marquette, Sault Ste. Marie, St. Ignace, 
            //Escanaba, Iron Mountain, Munising, and Mackinac Island
        nine47 = "Northern Metro Detroit"; // All of Oakland County, Northville, 
            //and most of Northville Township
        nine89 = "Central, Tri-Cities and Northeastern Lower Michigan"; 
               // Alpena, Mt. Pleasant, Bay City, Saginaw, Midland, Owosso, 
               //Gaylord, and Bad Axe
        
        
        /**********************************************************************/
        //Use a switch to determine where the area code is from
        switch (areaCode)
        {
                case(231):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(two31);
                    break;
                case (248):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(two48);
                    break;
                case (269):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(two69);
                    break;
                case (313):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(three13);
                    break;
                case (517):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(five17);
                    break;
                case (586):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(five86);
                    break;    
                case (616):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(six16);
                    break;
                case (734):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(seven34);
                    break;
                case (810):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(eight10);
                    break;
                case (906):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(nine06);
                    break;
                case (947):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(nine47);
                    break;
                case (989):
                    System.out.println("The phone number is from Michigan");
                    System.out.println(nine89);
                    break;
                default:
                    System.out.println("The number is not from Michigan");
        }
                        
        }    
    }
