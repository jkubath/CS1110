package demojavaapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinay Gavirangaswamy
 */
public class Rectangle extends Shape {

    int length = 12;
    int height = 10;
    
    @Override
    public double calculateArea() {
        
        return length * height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    
}
