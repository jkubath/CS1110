/* CLASS:  Country                    USED BY NorthAmericaReport PROGRAM
 * AUTHOR:        Jonah Kubath      DESIGNER:  Kaminski
 * DESCRIPTION:  This OOP class describes a SINGLE country, including:
 *      - storage for code, name, area, population
 *      - setters for each instance variable, with this special handling:
 *              - remove the INSERT INTO 'Country' VALUES (
 *                      on the front of the code field (how about substring?)
 *              - trim off the surrounding ' marks on the code and name fields
 *              - convert area and population to numeric types, probably int's,
 *                      (ROBUSTNESS:  might you need a long in the future?
 *                              China's got a big population
 *                              Russia's got a big area)                     
 *      - getters for each, with this special handling:
 *              - only the first 15 characters of name are returned
 *      - a toString method nicely formats the data for printing (though
 *          it is MAIN that actually does the printing) using:
 *                  - the getters rather than the actual instance variables
 *                  - String.format to produce the string
 *                  - a nice formatString to "pretty-print" the data
 *                      [numeric fields are right-justified & have appropriate
 *                              embedded commas, like 278,357,000
 *                       and alphabetic fields are left-justified]
 *****************************************************************************/
package northamericareport;

public class Country {

    //------------------------------------------------------ INSTANCE VARIABLES
    // <WRITE CODE HERE>
    String code;
    String name;
    String area;
    String population;
    
    //---------------------------------------------------------- GETTER METHODS
    // <WRITE CODE HERE>
    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public String getArea(){
        return area;
    }
    public String getPopulation(){
        return population;
    }
    
    //---------------------------------------------------------- SETTER METHODS
    // <WRITE CODE HERE>
    public void setCode(String pCode){
        code = pCode;
    }
    public void setName(String pName){
        name = pName;
    }
    public void setArea(String pArea){
        area = pArea;
    }
    public void setPopulation(String pPopulation){
        population = pPopulation;
    }
    
    //----------------------------------------------------- CONSTRUCTOR METHODS
    // not needed - the "default constructor" will automatically be included
        
    //--------------------------------------------------------- toString METHOD
    // <WRITE CODE HERE>
    public String toString(){
        String arrayString = String.format("%4s %28s %10s %10s",getCode(), getName(),getArea() 
                , getPopulation());
        
        
        
        return arrayString;
    }
}