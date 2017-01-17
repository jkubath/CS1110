/* CLASS:  Lab 10 Exercise 2
 * AUTHOR: Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 2
 ******************************************************************************/

package inheritancejavaapplication;


public class TandemBike extends Bicycle{

    // WRITE CODE HERE
    private int riders;

    public int getRiders() {
        return riders;
    }

    public void setRiders(int riders) {
        this.riders = riders;
    }
    
    @Override
    public double getAirDrag(){
        return getSpeed() * airDrag * riders;
    }
    
    @Override
    public double getAccelerationPwr(){
        return this.accelerationPwr * riders;
    }
    
    // the MountainBike subclass has one constructor
    public TandemBike(int startCadence, int startSpeed, int riders) {
        super(startCadence, startSpeed);
        setRiders(riders);
     
    }
    
    public TandemBike(){
        mass = (double) 20.9;
        cadence = 120;
        gear = 1;
        airDrag = (double) 1.14;
        accelerationPwr  = 160;
        rollingResistance =  0.0025;
        speed = 2;
        riders = 2;
    }
}
