/* CLASS:  OneCountry (OOP class)       USED BY SortSearchArrayOfObj
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Instantiable (OOP) class for a SINGLE country.
 *****************************************************************************/
package sortsearcharrayofobj;
public class OneCountry {
    //------------------------------------------------------ INSTANCE VARIABLES
    private String name;
    private String region;
    private int pop;
    private double lifeExp;
    //----------------------------------------------------------------- SETTERS
    public void setName(String pName)       { name = pName; }
    public void setRegion(String pRegion)   { region = pRegion; }
    public void setPop(int pPop)            { pop = pPop; }
    public void setLifeExp(double pLifeExp) { lifeExp = pLifeExp; }
    //----------------------------------------------------------------- GETTERS
    public String getName()    { return name; }
    public String getRegion()  { return region; }
    public int    getPop()     { return pop; }
    public double getLifeExp() { return lifeExp; }
    //------------------------------------------------------------- CONSTRUCTOR
    // default constructor used
    //--------------------------------------------------------- toString METHOD
    public String toString() {
        String shortName = name;
        if (name.length() > 22)
            shortName = name.substring(0,22);
        return String.format("%-22s %-17s %,12d    %4.1f",
                shortName, region, pop, lifeExp);
    }
}
