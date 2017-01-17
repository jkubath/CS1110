/* PROJECT:  PaintARoom
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Program calculates how much paint is needed to paint a room.
 * INPUT:   size of room (length & width & height),
 *          number of doors & windows
 * OUTPUT:  number of gallons of paint needed (as a whole number)
 * USER INTERFACE:  INPUT:      5 DialogBoxes
 *                  OUTPUT:     IDE Output window
 * ASSUMPTIONS:  square/rectangular room (and no slanted walls),
 *      sizes of doors & windows are average (default sizes),
 *      doors/windows/floor/ceiling are NOT being painted
 * PROCESSING:  Do the algorithm in steps by calling methods to "do the work",
 *      rather than doing one big formula (for now). 
 *****************************************************************************/

package paintaroom;

import javax.swing.JOptionPane;

public class PaintARoom {

    public static void main(String[] args) {
        
        //-------------------------------------------------------------- GIVENS
        // (final makes these constants)
        final int sqFtPerGallon = 350;        // for 1 coat
        final int numCoats = 2;               // the default
        final int aveDoorArea = 21;           // 7' x 3' on ave. (incl. molding)
        final int aveWindowArea = 9;          // 3' x 3' on ave. (incl. modling)
        
        //------------------------------------------ VARIABLES FOR CALCULATIONS
        int totalArea;
        int winDoorArea;
        int paintableArea;
        int gallons;
        
        //---------------------------------------------------------- PROCESSING
        // NOTE:  Uncomment next 3 lines after their methods are written
        
        totalArea = findWallArea();// incl. doors & windows
        
        winDoorArea = findWinDoorArea(aveDoorArea,aveWindowArea);
        //System.out.println(winDoorArea);
        paintableArea = totalArea - winDoorArea;
        //System.out.println(paintableArea);
        
        // NOTE:  Uncomment next line after you've written the method        
        gallons = findGallonsNeeded(paintableArea,numCoats,sqFtPerGallon);
        
        //-------------------------------------------------------------- OUTPUT
        // NOTE:  Uncomment next line once gallons has a value
        System.out.println("Need " + gallons + " gallons of paint for " +
              numCoats + " coats");
        
        //---------------------------------------------------------------------
        System.out.println("\nTHE END");
        System.exit(0);
    } // END OF main
    //*************************************************************************
    public static int findWallArea(){
        int subTotal1, subTotal2, total;
        
        String userString = JOptionPane.showInputDialog
                                        ("Room height (8 is normal)?");
        int height = Integer.parseInt(userString);
        
        int length = Integer.parseInt(JOptionPane.showInputDialog
                                        ("Room length (a whole number)?"));
        int width = Integer.parseInt(JOptionPane.showInputDialog
                                        ("Room width (a whole number)?"));
        
        // >>>>> WRITE CODE HERE
        subTotal1 = height * length * 2;
        subTotal2 = height * width * 2;
        
        total = subTotal1 + subTotal2;
        
        
        return total;                       // DUMMY VALUE TO MAKE CODE EXECUTABLE
                                        // - FIX THIS AS PROGRAM IS DEVELOPED
    }
    //*************************************************************************
    public static int findWinDoorArea(int doorSize, int windowSize){
        int totalDoor;
        int totalWindow;
        int total;
        
        
        int numDoors = Integer.parseInt(JOptionPane.showInputDialog
                                        ("Number of doors"));
        int numWindows = Integer.parseInt(JOptionPane.showInputDialog
                                        ("Number of windows"));
        
         // >>>>> WRITE CODE HERE
        totalDoor = numDoors * doorSize; 
        totalWindow = numWindows * windowSize;
        total = totalDoor + totalWindow;
        
        
        return total;                       // DUMMY VALUE TO MAKE CODE EXECUTABLE
                                        // - FIX THIS AS PROGRAM IS DEVELOPED  
    }
    //*************************************************************************
    // >>>>> WRITE CODE HERE FOR THE MISSING METHOD, findGallonsNeeded
    public static int findGallonsNeeded(int paintable, int coats, int ftPerGallon)
    {
        int totalPaint;
        totalPaint = (paintable / ftPerGallon) * coats;
        //System.out.println(paintable % ftPerGallon);
        System.out.println(paintable);
        System.out.println(ftPerGallon);
        if ((paintable % ftPerGallon) == 0)
        {
           //Do nothing
        }
        else
        {
            totalPaint++;
        }
        
        
        
        
        
        return totalPaint;
    }
    
    
    
    
    // HINT:  If there's a remainder when dividing by sqFtPerGallon, then
    //      add another gallon since you can't buy a partial-gallon
    
    //*************************************************************************
} // END OF CLASS (the whole program)
