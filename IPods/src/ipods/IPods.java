/* PROJECT:  IPods
 * AUTHOR:  Jonah Kubath     Built by: Dr. Kaminski
 * DESCRIPTION:  This OOP project contains:
 *      1) the main method (in THIS file)
 *      2) a Product class containing members for:
 *          - fields for storing object attributes
 *          - methods for handling an individual product object.
 * TO DO:
 *      - This main IPods class is already finished.
 *        But do incremental development - i.e.,
 *              - gradually add code to Product class
 *              - uncomment corresponding code here as more of Product class 
 *                      code is written
 *              - compile/run project to always keep it in a working state
 *      
 * (YES THIS IS OLD DATA!)
 *****************************************************************************/
package ipods;

public class IPods {
    
    public static void main(String[] args) {
        //----------------------------------------------------- DECLARE OBJECTS
        Product shuffle = new Product();
        Product nano8   = new Product();
        Product nano16  = new Product();
        Product touch8  = new Product();
        Product touch32 = new Product();
        Product touch64 = new Product();
        
        //----------------------------------------- SEND IN VALUES TO BE STORED
        // PARAMETERS:
        // capacity, price, height, width, weight, hasCamera, wifi,playsVideo
        
        shuffle.setValues(  2,  49, 1.14, 1.24, 0.44, false, "no",  'N' );
        nano8.setValues(    8, 149, 1.48, 1.61, 0.74, false, "no",  'N' );
        nano16.setValues(  16, 179, 1.48, 1.61, 0.74, false, "no",  'N' );
        touch8.setValues(   8, 229, 4.4,  2.3,  3.56, true,  "yes", 'Y' );
        touch32.setValues( 32, 299, 4.4,  2.3,  3.56, true,  "yes", 'Y');
        touch64.setValues( 64, 399, 4.4,  2.3,  3.56, true,  "yes", 'Y' );

        //--------------------------------- HERE'S A SPECIAL OBJECT DECLARATION
        Product classic = new Product(
                160, 249, 4.1,  2.4,  3.56, false, "no",  'Y' );    
        
        //-------------------------------------------- ACCESS & PRINT SOME INFO
        System.out.printf("iPod Touch's dimensions: %.2f x %.2f\n\n",
                touch8.getHeight(),
                touch8.getWidth());
                
        System.out.printf("iPod Class features:\n\thas a camera:  %b" +
                "\n\thas wifi:  %s\n\tplays video:  %c\n\n",
                classic.getHasCamera(),
                classic.getWifi(),
                classic.getPlaysVideo());
        
        System.out.printf("Comparing the 2 iPod Nano's:" +
                "\n\tthe  %dGB one costs %.2f (with tax it's %.2f)" +
                "\n\tthe %dGB one costs %.2f (with tax it's %.2f)\n\n",
                nano8.getCapacity(), nano8.getPrice(), nano8.calcTotalPrice(),
                nano16.getCapacity(), nano16.getPrice(),
                nano16.calcTotalPrice());
        
        System.out.printf("Number of songs iPod will hold:" + 
                "\n\tshuffle holds %.0f, the biggest touch holds %f.0, " +
                "the classic holds %.0f\n",
                shuffle.calcNumSongs(),
                touch64.calcNumSongs(),
                classic.calcNumSongs());
        //-------------------------------------------------------------- ENDING
        System.out.println("\nTHE END");
    }
}
