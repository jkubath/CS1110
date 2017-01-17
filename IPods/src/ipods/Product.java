/* CLASS:  Product              used by PROJECT:  IPods
 * AUTHOR:    Jonah Kubath      DESIGNER:  Dr. Kaminski
 * DESCRIPTION:  Product class contains:
 *          - fields for storing an object's attributes
 *          - methods for handling an individual product object.
 * TO DO in the Product class:
 *          - 8 instance variables are needed
 *          - are getters needed?
 *          - are 8 individual setters needed
 *                  OR is just 1 big setter method which includes setting
 *                          all 8 of the instance variables (individually)?
 *          - is a constructor needed?
 *          - an overloaded constructor?
 *          - what public service methods are needed?
******************************************************************************/
package ipods;

public class Product {
    
    //------------------------------------------------------ INSTANCE VARIABLES
    // capacity, price, height, width, weight, hasCamera, wifi,playsVideo
        
//        shuffle.setValues(  2,  49, 1.14, 1.24, 0.44, false, "no",  'N' );
    private final double TAX = 0.06;
    private int capacity = 0;
    private double price = 0;
    private double height = 0;
    private double width = 0;
    private double weight = 0;
    private boolean hasCamera = false;
    private String wifi;
    private char playsVideo;
    
    //---------------------------------------------------------- SETTER METHODS
    public void setValues(int pCapacity, double pPrice, double pHeight, double pWidth,
            double pWeight, boolean pHasCamera, String pWifi, char pPlaysVideo)
    {
        capacity = pCapacity;
        price = pPrice;
        height = pHeight;
        width = pWidth;
        weight = pWeight;
        hasCamera = pHasCamera;
        wifi = pWifi;
        playsVideo = pPlaysVideo;
    }
    
    //---------------------------------------------------------- GETTER METHODS
    public int getCapacity(){
        return capacity;
    }
    public double getPrice(){
        return price;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    public double getWeight(){
        return weight;
    }
    public boolean getHasCamera(){
        return hasCamera;
    }
    public String getWifi(){
        return wifi;
    }
    public char getPlaysVideo(){
        return playsVideo;
    }
    
    //------------------------------------------------------ CONSTRUCTOR METHOD
    public Product()
    {
        
    }
    public Product(int pCapacity, double pPrice, double pHeight, double pWidth,
            double pWeight, boolean pHasCamera, String pWifi, char pPlaysVideo){
        setValues(pCapacity, pPrice, pHeight, pWidth, pWeight, pHasCamera,pWifi, 
                pPlaysVideo);
        
    }
    //-------------------------------------------------- PUBLIC SERVICE METHODS
 
    public double calcTotalPrice(){
        double totalPrice = getPrice() + (getPrice() * TAX);
        return totalPrice;
    }
    
    public double calcNumSongs(){
        double totalSongs = getCapacity() * 200; 
        return totalSongs;
    }
    
    //--------------------------------------------------------- PRIVATE METHODS
 
    
    //-------------------------------------------------------------------------
}
