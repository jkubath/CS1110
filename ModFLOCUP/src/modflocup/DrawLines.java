/* CLASS:  DrawLines
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Contains methods for drawing:
 *          - horizontal line
 *          - vertical line at LEFT margin
 *          - double vertical lines at LEFT & RIGHT margins, with spaces between
 *      where caller specifies pen & line size as parameters.
 * NOTE:  The methods in DoLetters call these line drawing methods below.
 * NOTE:  The w and h parameters are the DESIRED LINE LENGTH,
 *          and NOT the width or height of the whole character.
******************************************************************************/
package modflocup;

public class DrawLines {
    
    public static void drawHorizLine(int w, char pen) {
        
       for (int col = 1; col <= w; col++) 
           System.out.print(pen);

       System.out.println();
    }
    //-------------------------------------------------------------------------
    public static void drawVertLine(int h, char pen) {
        
       for (int row = 1; row <= h; row++) 
           System.out.println(pen);
    }
    //-------------------------------------------------------------------------
    public static void drawDoubleVertLine(int w, int h, char pen) { 
        
       for (int row = 1; row <= h; row++) {
           System.out.print(pen);
           for (int col = 1; col <= w - 2; col++)
               System.out.print(' ');
           System.out.println(pen);
       }
    }
}

