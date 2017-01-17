/* PROJECT:  Lab 10 Exercise 1
 * AUTHOR:  Jonah Kubath and Andrew Rayl
 * DESCRIPTION:  Exercise 1
 ******************************************************************************/
package lab.pkg10.exercise.pkg1;


public class Lab10Exercise1 {

    public static void main(String[] args) {
        
        // WRITE main's CODE HERE
        EncapsulationDemo obj = new EncapsulationDemo();
        
        obj.setEmpName("Mario");
        obj.setEmpAge(32);
        obj.setSsn(112233);
        System.out.println("Employee Name: " + obj.getEmpName());
        System.out.println("Employee SSN: " + obj.getSsn());
        System.out.println("Employee Age: " + obj.getEmpAge());
        System.out.println(obj.toString());
        
        
        
        
        
    }

}
