/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancejavaapplication;

/**
 *
 * @author Vinay Gavirangaswamy
 */
public class Bicycle {

    // the Bicycle class has
    // three fields
    protected int cadence;
    protected int gear;
    protected int speed;
    protected double mass;
    protected double airDrag;
    protected double rollingResistance;
    protected double accelerationPwr;  
    
    protected double velocity;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
 

    public double getAirDrag() {
        return airDrag;
    }

    public void setAirDrag(double airDrag) {
        this.airDrag = airDrag;
    }

    public double getRollingResistance() {
        return rollingResistance;
    }

    public void setRollingResistance(double rollingResistance) {
        this.rollingResistance = rollingResistance;
    }

    public double getAccelerationPwr() {
        return accelerationPwr;
    }

    public void setAccelerationPwr(double accelerationPwr) {
        this.accelerationPwr = accelerationPwr;
    }


    Bicycle(){
        mass = (double) 20.9;
        cadence = 90;
        gear = 1;
        airDrag = (double) 1.14;
        accelerationPwr  = 160;
        rollingResistance =  0.0025;
    }

    
    Bicycle(int cadence, int speed, int gear) {
        this.gear = gear;
        this.cadence = cadence;
        this.speed = speed;
    }

    /*
     * TODO: Give following override implementations for constructor      
     * 1. Constructor using all 8 fields in class.
     */
    Bicycle(int cadence, int gear, int speed, double mass, double airDrag, 
            double rollingResistance, double accelerationPwr, double velocity){
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
        this.mass = mass;
        this.airDrag = airDrag;
        this.rollingResistance = rollingResistance;
        this.accelerationPwr = accelerationPwr;
        this.velocity = velocity;
    }
    
    Bicycle(int cadence, int speed){
        this.cadence = cadence;
        this.speed = speed;
    }
    
    // the Bicycle class has
    // four methods
    void setCadence(int newValue) {
        cadence = newValue;
    }

    void setGear(int newValue) {
        gear = newValue;
    }

    void applyBrake(int decrement) {
        speed -= decrement;
    }

    void speedUp(int increment) {
        speed += increment;
    }  
}
