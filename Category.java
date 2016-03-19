/****************************************************************************
*   Category.java                                                           *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   9/30/15                                                                 *
*                                                                           *
*   This class holds the numbers of each category and returns               *
*   its string representation used for display purposes                     *
*                                                                           *
*   No special requirements for this class                                  *
*                                                                           *
****************************************************************************/
package gradetraker;

public class Category {
    
    //instance variables all constants
    final public static int QUIZZES = 0;    // category ID
    final public static int EXAMS = 1;      // category ID
    final public static int LABS = 2;       // category ID
    final public static int PROGRAMS = 3;   // category ID
    final public static int FINALEXAM = 4;  // category ID
    
    // returns string of category name
    public static String toString(int category)
    {
        switch (category)
        {
            case 0:
                return "Quizzes";
            case 1: 
                return "Exams";
            case 2:
                return "Labs";
            case 3:
                return "Programs";
            case 4:
                return "Final Exam";
            default:
                return "Invalid selection";
        }// end switch
    } // end toString method
    
    
} // end class Category
