/****************************************************************************
*   GradingScale.java                                                       *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           *
*   This class creates a grading scale that can be used for displaying      *
****************************************************************************/
package gradetraker;

import java.util.ArrayList;

public class GradingScale {
    
    private ArrayList<GradeLevel> gradeLevels;  // ArrayList to hold gradeLevel objects used to create grading scale
    private int maxPoints;                      // holds value for max points in the class
    
    public GradingScale()
    {
        this.gradeLevels = new ArrayList();
        
    }// end default constructor
    
    public GradingScale(int maxPoints)
    {
        this.gradeLevels = new ArrayList();
        this.maxPoints = maxPoints;
    }// end constructor with parameters

    public GradeLevel getGradeLevels(int index) {
        return gradeLevels.get(index);
    } // end getGradeLevels

    public void setGradeLevels(int index,GradeLevel gradeLevel) {
        this.gradeLevels.add(index, gradeLevel);
    } // end setGradeLevels

    public int getMaxPoints() {
        return maxPoints;
    } // end getMaxPoints

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    } // end setMaxPoints
    
    // additional methods for handling arraylist gradeLevels
    public int getNumGradeLevels()
    {
        return gradeLevels.size();
    } // end getNumGradeLevels
    
    public void addGradeLevels(GradeLevel gradeLevel)
    {
        gradeLevels.add(gradeLevel);
    }// end addGradeLevels
    
    public void removeGradeLevel(int index)
    {
        gradeLevels.remove(index);
    }// end removeGradeLevel
    
    // toString for PrintWriter and display the grade report
    public String toString()
    {
        String tempString = "";
        for (GradeLevel gradeLevel : gradeLevels) {
            tempString += gradeLevel.toString() +System.getProperty("line.separator");
        }
        
        return maxPoints +System.getProperty("line.separator") +tempString; 
    } // end toString
    
} // end GradingScale class
