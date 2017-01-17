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
public class Circle extends Shape{

    private double radius=15;
    
    @Override
    public double calculateArea() {
        
        return 3.14 * radius * radius;
        
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

     
}
