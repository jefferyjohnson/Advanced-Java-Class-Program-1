/****************************************************************************
*   Assignment.java                                                         *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           * 
*   This class is used to create assignment objects that will be held       *
*   in arrayLists that are created in the assignmentCategory class          *
****************************************************************************/
package gradetraker;

public class Assignment {
    
    private int points;    // holds the points earned for each assignment
    private int maxPoints; // holds the max points for each assignment
    
    public Assignment()
    {
        
    } // end default constructor
    
    public Assignment(int points,int maxPoints)
    {
        this.points = points;
        this.maxPoints = maxPoints;
    } // end constructor with parameters

    public int getPoints() {
        return points;
    } // end getPoints

    public void setPoints(int points) {
        this.points = points;
    } // end setPoints

    public int getMaxPoints() {
        return maxPoints;
    } //end getMaxPoints

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    } // end setMaxPoints
    
    // toString for PrintWriter
    public String toString()
    {
        return points +" " +maxPoints;
    } // end toString
    
    // toString for display grade and category reports
    public String toStringCategoryDisplay()
    {
        return points +"/" +maxPoints;
    } // end toStringCategoryDisplay
    
} // end Assignment class