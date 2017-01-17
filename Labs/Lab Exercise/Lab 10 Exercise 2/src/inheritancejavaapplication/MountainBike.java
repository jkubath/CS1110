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
public class MountainBike extends Bicycle{
     // the MountainBike subclass adds one field
    public int seatHeight;  
    public int reductionFactor;
    

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }	

    public int getReductionFactor() {
        return reductionFactor;
    }

    public void setReductionFactor(int reductionFactor) {
        this.reductionFactor = reductionFactor;
    }
	
    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    
    public int getHeight(){
        return seatHeight;
    }

    @Override
    public double getAirDrag(){
        return getSpeed() * airDrag * reductionFactor;
    }
    
    
    @Override
    public double getAccelerationPwr(){
        return this.accelerationPwr * gear;
    }
    
    MountainBike(){
        mass = (double) 20.9;
        cadence = 120;
        gear = 1;
        airDrag = (double) 1.14;
        accelerationPwr  = 160;
        rollingResistance =  0.0025;
        reductionFactor = 2;
        speed = 2;
    }
    
}
