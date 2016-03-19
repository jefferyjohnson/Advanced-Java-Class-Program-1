/****************************************************************************
*   Main.java                                                               *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           *
*   This is the main method that is used to start the program.              *
*   It only creates and displays and object of the gradeTrackerForm class.  *
*                                                                           *
*   You may enter file name by using command line arguments when staring    *
*   this program, or use the file chooser.                                  *
****************************************************************************/
package gradetraker;

import javax.swing.JOptionPane;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GradeTrackerForm gtf; //declare GradeTrackerForm object 
        
        // check to see if command line argument was passed 
        // and start or end program appropriately
        if (args.length == 1)
        {
            gtf = new GradeTrackerForm(args[0]);
            gtf.setVisible(true);
        } // end if
        
        else if (args.length == 0)
        {
            gtf = new GradeTrackerForm();
            gtf.setVisible(true);
        } // end else
        else
        {
            JOptionPane.showMessageDialog(null, "More than one command line argumnet was passed.\nUse only one argument","ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }

        
    } // end main
    
} // end classMain
