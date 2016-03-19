/****************************************************************************
*   StudenAssignment.java                                                   *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           *
*   This class controls the other classes.  A studentAssignment object is   *
*   needed to create the other classes. It is also used to read and write   *
*   to the files                                                            *
*                                                                           *
****************************************************************************/
package gradetraker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StudentAssignment {
    
    final int NUMBER_OF_CATEGORIES = 5;                      // Number of assignmentCategory objects to create
    private ArrayList<AssignmentCategory> assignCategories;  // Arraylist to hold the assignment categories
    private GradingScale gradingScale;                       // create the grading scale used in displaying grade reports  
    
    public StudentAssignment()
    {
        this.gradingScale = new GradingScale();
        this.assignCategories = new ArrayList();
           
        // create the Assignment category objects to put correct assignments.
        for (int index = 0;index < NUMBER_OF_CATEGORIES;index++)
        {
            assignCategories.add(new AssignmentCategory(index));
        } // end for
    } // end constructor.
    
    public void addAssignment(int cat,int points, int maxPoints)
    {
        // add appropriate new assignment to arraylist in correct AssignmentCategory object
        assignCategories.get(cat).addAssignment(new Assignment(points,maxPoints));
    } // end addAssignment
    
    // read the input file
    public void readGradeFile(String inputFileName)
    {
        try 
        {
            
            int tempMaxPoints = 0; // temp variable to hold max points
            Scanner file = new Scanner(new File(inputFileName));
            
            // if statement to get maxpoints of input file
            if(file.hasNext())
            {
                gradingScale.setMaxPoints(file.nextInt());
                tempMaxPoints = gradingScale.getMaxPoints();
            }// end if  
          
            // get grading scale information
            while (file.hasNext())
            {
                String tempString = file.next();
                // break out of loop on star char in file
                if (tempString.equals("*"))
                {
                    break;
                }// end if
                int tempInt = file.nextInt();
                
                // calculating the percentage while creating the new gradingScale object
                gradingScale.addGradeLevels(new GradeLevel(tempString,tempInt,(double)(tempInt*100)/tempMaxPoints));
            } // end while
            
            // get assignment information
            while(file.hasNext())
            {
                int tempCategory = 0;          // temp variable to hold category            
                int tempNumAssignments = 0;    // temp variable to hold number of assignments in each category
                
                tempCategory = file.nextInt();
                tempNumAssignments = file.nextInt();
                
                
                if (tempNumAssignments > 0);
                {
                    for (int index = 1; index <= tempNumAssignments;index++)
                    {
                       assignCategories.get(tempCategory).addAssignment(new Assignment(file.nextInt(),file.nextInt()));
                    } // end for loop
                    
                    assignCategories.get(tempCategory).setPointsAssigned();
                    assignCategories.get(tempCategory).setPointsEarned();
                } // end if
            } // end while
            file.close();
        } // end try
        catch (FileNotFoundException fnfe) 
        {
            JOptionPane.showMessageDialog(null, fnfe, "ERROR", JOptionPane.ERROR_MESSAGE);
        } // end catch
    } // end readGradFile
    
    // save the output file
    public void saveGradeFile(String outputFileName)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(outputFileName,false);
            
            PrintWriter pw = new PrintWriter(fos);
            
            // write the gradingScale information
            pw.print(gradingScale.toString());
            pw.println("*");
            
            for (AssignmentCategory assignCategorie : assignCategories) {
                pw.print(assignCategorie.toString());
            }
            pw.close();
        } // end try
        catch (FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(null, fnfe, "ERROR", JOptionPane.ERROR_MESSAGE);
        } // end catch
        
    } // end saveGradeFile
    
    // create the comprehensive grade report
    public String getGradeReport()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String tempString ="Grade Report\n\n";  // temp string variable to concatinate all the information into one string
        
        // adding the categories and assignments to the string
        for (int outer = 0;outer < NUMBER_OF_CATEGORIES;outer++)
        {
            tempString += Category.toString(outer) +" " +assignCategories.get(outer).getPointsEarned() +"/" +assignCategories.get(outer).getPointsAssigned() +"Points\n";
            for (int inner = 0;inner < assignCategories.get(outer).getNumAssignments();inner++)
            {
                tempString += assignCategories.get(outer).getAssignments(inner).toStringCategoryDisplay() +"\n";
            } // end for loop
            tempString += "\n";
        } // end for loop
        
        // variables and for loops to add total points and points earned
        int totalPointsAssigned = 0; // variable to hold total points assigned
        int totalPointsEarned = 0;   // variable to hold total points earned
            
        for (AssignmentCategory assignCategorie : assignCategories) 
        {
            totalPointsAssigned += assignCategorie.getPointsAssigned();
        } // end for loop to calculate total assigned points
            
        for (AssignmentCategory assignCategorie : assignCategories)
        {
            totalPointsEarned += assignCategorie.getPointsEarned();
        } // end for loop to calculate total points earned
            
        // add total points earned and assigned as well as percentage to string
        tempString += "Total: " +totalPointsEarned +"/" +totalPointsAssigned +" " +df.format((double)(totalPointsEarned*100)/totalPointsAssigned) +"%\n\n";
            
        // add grading scale to string
        tempString += "Grading Scale\n";
        for (int index = 0; index < gradingScale.getNumGradeLevels();index++)
        {
            tempString += gradingScale.getGradeLevels(index).toString() +" " +df.format(gradingScale.getGradeLevels(index).getPercentage()) +"%\n";
        } // end for loop to add grading scale to string
        
        return tempString;
    }// end getGradeReport

    public AssignmentCategory getAssignCategories(int index) {
        return assignCategories.get(index);
    } // end getAssignCategories

    public void setAssignCategories(int index, AssignmentCategory assignmentCategory) {
        this.assignCategories.add(index, assignmentCategory);
    } // end setAssignCategories

    public GradingScale getGradingScale() {
        return gradingScale;
    } // end getGradingScale

    public void setGradingScale(GradingScale gradingScale) {
        this.gradingScale = gradingScale;
    } // end setGradingScale
    
    //additional methods for ArrayList assignCategories
    public int getNumAssignCategories()
    {
        return assignCategories.size();
    } // end getNumAssignCategories
    
    public void addAssignmentCategory(AssignmentCategory assignmentCategory)
    {
        assignCategories.add(assignmentCategory);
    } // end addAssignmentCategory
    
    public void removeAssignmentCategory(int index)
    {
        assignCategories.remove(index);
    } //end removeAssignmentCategory
    
    // Grade report is easiest way to view the object, so I have toString set up to 
    // display that.  I do not call it in this program.
    public String toString()
    {
        return this.getGradeReport();
    } // end toString
    
} // end StudentAssignment
