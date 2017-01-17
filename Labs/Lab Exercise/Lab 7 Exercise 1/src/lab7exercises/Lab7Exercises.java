/* PROJECT:  Lab 7 Exercises
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Tasl 1
 ******************************************************************************/
package lab7exercises;


public class Lab7Exercises {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        int i = 0;
        int total = 0;
        
        String[] name = {"Einstein", "Newton", "Copernicus", "Kepler"};
        for(i = 0; i < name.length; i++)
        {
            System.out.print(name[i] + " ");
        }
        System.out.println();
        
        for(i = 0; i < name.length; i++)
        {
            System.out.println(name[i] + ": " + name[i].length());
            total += name[i].length();
            
        }
        System.out.println("The total : " + total);
        
        
    }

}//End of main
