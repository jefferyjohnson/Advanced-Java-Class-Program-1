/****************************************************************************
*   GradeLevel.java                                                         *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           *
*   This class holds the grade level information used for the               *
*   grading scale information                                               *
*                                                                           *
****************************************************************************/
package gradetraker;

public class GradeLevel {
    

    private String letterGrade;  // holds the letter grade for the object
    private int points;          // holds the amount of points needed to recieve the grade
    private double percentage;   // holds the percentage of total points this grade leve is
    
    public GradeLevel()
    {
        
    } // end default constructor
    
    public GradeLevel(String letterGrade,int points,double percentage)
    {
        this.letterGrade = letterGrade;
        this.points = points;
        this.percentage = percentage;
    } // end constructor with parameters

    public String getLetterGrade() {
        return letterGrade;
    } // end getLetterGrade

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    } // end setLetterGrade

    public int getPoints() {
        return points;
    } // end getPoints

    public void setPoints(int points) {
        this.points = points;
    } // end setPoints

    public double getPercentage() {
        return percentage;
    } // end getPercentage

    public void setPercentage(double maxPoints) {
        this.percentage = (double)(points*100)/maxPoints;
    } // end setPercentage
    
    // toString used with PrintWriter
    public String toString()
    {
        return letterGrade +" " +points;
    } // end toString
    
} // end GradeLevel class
