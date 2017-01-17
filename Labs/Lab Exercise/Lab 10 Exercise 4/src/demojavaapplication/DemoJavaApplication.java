/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaapplication;

/**
 *
 * @author Vinay Gavirangaswamy
 */
public class DemoJavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //object of child class square  
           Shape sq = new Square();  
           //object of child class rectangle  
           Shape rec = new Rectangle();  
           //object of child class circle  
           Shape cir = new Circle();  
             
           //call the area methods of all child class to   
           //get the area of different objects  
           System.out.println(sq.calculateArea());  
           System.out.println(rec.calculateArea());  
           System.out.println(cir.calculateArea());  
        
    }
    
}
