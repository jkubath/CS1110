/* CLASS:  Lab 10 Exercise 2
 * AUTHOR: Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 2
 ******************************************************************************/

package inheritancejavaapplication;


public class RoadBike extends Bicycle{

    // WRITE CODE HERE
    RoadBike(){
        mass = (double) 20.9;
        cadence = 120;
        gear = 1;
        airDrag = (double) 1.14;
        //accelerationPwr  = 160;
        rollingResistance =  0.0025;
        speed = 2;
    }
    
}
