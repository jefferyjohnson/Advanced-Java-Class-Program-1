/****************************************************************************
*   AssignmentCategory.java                                                               *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           *
*   This class holds an arrayList of assignments for each category          *
*                                                                           *
****************************************************************************/
package gradetraker;

import java.util.ArrayList;

public class AssignmentCategory {
    
    private ArrayList<Assignment> assignments; // list of assignments for each category
    private int category;                      // holds the category ID information
    private int pointsEarned;                  // holds total points earned for all assignments in this category
    private int pointsAssigned;                // holds total points assigned for all assignments in this category
    
    public AssignmentCategory()
    {
        this.assignments = new ArrayList();
    } // end default constructor
    
    public AssignmentCategory(int category)
    {
        this.assignments = new ArrayList();
        this.category = category;
    } // end constructor with parameters

    public Assignment getAssignments(int index) {
        return assignments.get(index);
    } // end getAssignments

    public void setAssignments(int index,Assignment assignment) {
        this.assignments.add(index, assignment);
    } // end setAssignments

    public int getCategory() {
        return category;
    } // end getCategory

    public void setCategory(int category) {
        this.category = category;
    } // end setCategory

    public int getPointsEarned() {
        return pointsEarned;
    } // end getPointsEarned

    // no arguements passed since I will have the method calculate amount from the assignments themsleves
    public void setPointsEarned() {
        int points = 0;
        for (Assignment assign: assignments)
        {
            points += assign.getPoints();
        } // end for
        this.pointsEarned = points;
    } // end setPointsEarned

    public int getPointsAssigned() {
        return pointsAssigned;
    } // end getPointsAssigned

    // no arguements passed since I will have the method calculate amount from the assignments themsleves
    public void setPointsAssigned() {
        int points = 0;
        for (Assignment assign : assignments)
        {
            points += assign.getMaxPoints();
        } // end for loop
        this.pointsAssigned = points;
    } // end setPointsAssigned
    
    // additional methods for handling ArrayList Assignments
    public int getNumAssignments()
    {
        return assignments.size();
    } // end getNumAssignments
    
    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    } // end addAssignment
    
    public void removeAssignment(int index)
    {
        assignments.remove(index);
    } // end removeAssignment
    
    // toString for PrintWriter
    public String toString()
    {
        String tempString = category +" " +assignments.size() +System.getProperty("line.separator");
        if (assignments.size() >0)
        {
            for (Assignment assignment: assignments)
            {
                tempString += assignment.toString() +System.getProperty("line.separator");
            } // end for loop
        } // end if statement
        return tempString;
    } // end toString
    
    // toString for category and grade report display
    public String toStringCategoryDisplay(int categorySelection)
    {
        String tempString = Category.toString(categorySelection)+"\n" ;
        if (assignments.size() >0)
        {
            for (Assignment assignment: assignments)
            {
                tempString += assignment.toStringCategoryDisplay() +"\n";
            } // end for loop
        } // end if statement
        return tempString;
    } // end toStringCategoryDisplay
    
} // end AssignmentCategory class
