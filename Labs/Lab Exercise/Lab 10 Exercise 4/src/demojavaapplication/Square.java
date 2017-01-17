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
public class Square extends Shape{

    int length = 12;
    
    @Override
    public double calculateArea() {
        
        return length * length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    
    
}
