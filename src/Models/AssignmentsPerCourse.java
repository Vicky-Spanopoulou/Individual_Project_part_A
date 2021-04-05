/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author vicky
 */
public class AssignmentsPerCourse {

    //returns an ArrayList of the assignments per course
    public static ArrayList<Assignment> findAssignmentsPerCourse(Course course) {
        int counter = 0;

        ArrayList<Assignment> assignmentPerCourse = new ArrayList();

        for (Course c : Course.getCourseList()) {

            for (Assignment assignment : c.getCourseAssignmentList()) {

                if (c.equals(course)) {
                    assignmentPerCourse.add(assignment);
                    counter++;
                }
            }
        }
        if (counter == 0) {
            System.out.println("There are no assignments for this course");
        }
        return assignmentPerCourse;
    }

    //prints the Arraylist of the assignments per course
    public static void printAssignmentsPerCourse(Course course) {
        int listIndex = 1;
        for (Assignment assignment : findAssignmentsPerCourse(course)) {
            System.out.println(listIndex + ". " + assignment.getTitle() + ": "
                    + assignment.getDescription() + " - Submission date: "
                    + assignment.getSubDate());
            listIndex++;
        }

    }

}//end of class
