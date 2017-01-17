/* PROJECT:  WinHelloWorld
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  Program prints Hello World to a GUI MessageBox window
 *      besides printing Hello World to the IDE Output (RunTime) window.
 ****************************************************************************/

import javax.swing.JOptionPane;     // Need this class from library to do GUI

public class WinHelloWorld {

    public static void main(String[] args) {
        
        System.out.println("Hello World");      // prints to IDE Output window
        
                                                // prints to MessageBox
        JOptionPane.showMessageDialog(null,"Hello World");
        
        System.exit(0);                         // needed in GUI/Windows apps
    }
}
