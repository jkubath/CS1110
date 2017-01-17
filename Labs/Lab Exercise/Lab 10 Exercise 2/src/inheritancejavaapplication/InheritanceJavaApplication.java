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
public class InheritanceJavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Wind speed
        double windSpeed = 1;
        // Height above sea level (influences air density) in meters
        double heightAbvSeaLvl;
        // Air temperature, in ° Kelvin (influences air density)
        double temperature;
        // Inclination (grade) of road, in percent
        double grade = 1;
        // ("beta") Inclination angle, = arctan(grade/100)
        double beta = (double) Math.atan(grade);
        //Mass of the rider (influences rolling friction, slope pulling force, and the rider's frontal area via body volume)
        double riderMass = (double) 157.2;
        // Total frontal area (bicycle + rider) in m2
        double area = (double) 16764;
        //Coefficient for velocity-dependent dynamic rolling resistance, here approximated with 0.1
        double coVeloDep = (double) 0.1;
        //Coefficient for the dynamic rolling resistance, normalized to road inclination; CrVn = CrV*cos(β)
        double coVeloDepN = (double) (coVeloDep * Math.cos(beta));
        // Coefficient for power transmission losses and losses due to tire slippage (the latter can be heard while pedaling powerfully at low speeds)
        double pwrLoss;
        // ("rho") Air density
        double rho;
        // Air density on sea level at 0° Celsius (32°F)in kg/m3 
        double airDensitySeaLvl0;
        // Air pressure on sea level at 0° Celsius (32°F) in psi
        double airPressureSeaLvl0;
        // Gravitational acceleration in  m/s²
        double g = (double) 9.807;
        // Rolling friction (normalized on inclined plane) plus slope pulling force on inclined plane
        double rollingFriction;

        // TODO: create different Bicycles
        MountainBike normalBike = new MountainBike();
        //TandemBike normalBike = new TandemBike();
        //RoadBike normalBike = new RoadBike();
        //Bicycle normalBike = new Bicycle();
        
        // Data modified for Kalamazoo
        heightAbvSeaLvl = 600;
        airDensitySeaLvl0 = 12.25;
        airPressureSeaLvl0 = 14.6959;
        temperature = 282.039;

        // Air density via barometric formula: 
        rho = (double) (airDensitySeaLvl0 * (373 / temperature) * Math.exp(-airDensitySeaLvl0 * g * (heightAbvSeaLvl / airPressureSeaLvl0)));

        rollingFriction = calcRollingResistance(normalBike, g, riderMass, beta);

        double a = cardanicFormulaeA(windSpeed, coVeloDepN, normalBike, area, rho, rollingFriction);
        double b = cardanicFormulaeB(normalBike, rho, rollingFriction, windSpeed, coVeloDepN, area);
        double velocity = (double) 0.0;
        velocity = calcVelocity(a, b, windSpeed, coVeloDepN, normalBike, area, rho);

        System.out.printf("\nVeocity of normal bike for the given configuration is %.4f", velocity);

    }

    public static double calcVelocity(double a, double b, double windSpeed, double coVeloDepN, Bicycle normalBike, double area, double rho) {
        double velocity = 0;
        // Calculate Velocity while going uphill
        if (Math.pow(a, 2) + Math.pow(b, 3) >= 0) {
            velocity = (double) (Math.cbrt(a + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 3))) + Math.cbrt(a - Math.sqrt(Math.pow(a, 2) + Math.pow(b, 3))) - ((2 / 3) * (windSpeed + (coVeloDepN / (normalBike.getAirDrag() * area)))));
        } else if (Math.pow(a, 2) + Math.pow(b, 3) < 0) {
            //  in case of sufficient downhill slope or tailwind speed
            velocity = (double) (2 * Math.sqrt(-b) * Math.cos((1 / 3) * Math.acos(a / Math.sqrt(Math.pow(-b, 3)))) - ((2 / 3) * (windSpeed + (coVeloDepN / (normalBike.getAirDrag() * area )))));
        }

        return velocity;
    }

    public static double cardanicFormulaeB(Bicycle normalBike, double rho, double rollingFriction, double windSpeed, double coVeloDepN, double area) {
        return (double) ((2 / (9 * normalBike.getAirDrag() + rho)) * (3 * rollingFriction - 4 * windSpeed * coVeloDepN - Math.pow(windSpeed, 2) * normalBike.getAirDrag() * area * (rho / 2) - ((2 * coVeloDepN) / (normalBike.getAirDrag() * area))));
    }

    public static double cardanicFormulaeA(double windSpeed, double coVeloDepN, Bicycle normalBike, double area, double rho, double rollingFriction) {
        return (double) (
                ((Math.pow(windSpeed, 3) - Math.pow(coVeloDepN, 3)) / 27) - 
                (windSpeed * (5 * windSpeed * coVeloDepN + (8 * Math.pow(coVeloDepN, 2)) / (normalBike.getAirDrag() * area ) - 6 * rollingFriction)) / (9 * normalBike.getAirDrag() * area ) + 
                (2 * rollingFriction * coVeloDepN) / (3 * Math.pow(normalBike.getAirDrag(), 2)) + 
                normalBike.getAccelerationPwr() / (normalBike.getAirDrag() + rho));
    }

    public static double calcRollingResistance(Bicycle normalBike, double g, double riderMass, double beta) {
        //Rolling friction plus slope pulling force:
        return (double) (g * (normalBike.getMass() + riderMass) * (normalBike.getRollingResistance() * Math.cos(beta) + Math.sin(beta)));
    }

}
