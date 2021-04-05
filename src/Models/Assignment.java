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
 * @since March 2021
 */
public class Assignment {
    
    private String title;
    private String description;
    private String subDate;
    private double oralMark;
    private double totalMark;
    //list of all assignments
    private static ArrayList<Assignment> assignmentList = new ArrayList();
    //list of assignments per course
    private ArrayList<Course> assignmentCourse = new ArrayList();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubDate() {
        return subDate;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }

    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(double oralMark) {
        this.oralMark = oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    public static ArrayList<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public static void setAssignmentList(ArrayList<Assignment> assignmentList) {
        Assignment.assignmentList = assignmentList;
    }

    public ArrayList<Course> getAssignmentCourse() {
        return assignmentCourse;
    }

    public void setAssignmentCourse(ArrayList<Course> assignmentCourse) {
        this.assignmentCourse = assignmentCourse;
    }
    

    public Assignment(String title, String description, String subDateTime, 
            double oralMark, double totalMark) {
        this.title = title;
        this.description = description;
        this.subDate = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }
    
    //adds an assignment to the list
    public void addAssignment() {
        assignmentList.add(this);
    }
    
    //brings all the assignments
    public static void listAllAssignments() {
        int listIndex = 1;
        System.out.println("Assignment List:");
        for(Assignment assignment : assignmentList) {
            System.out.println(listIndex + ". " + assignment);
            listIndex++;
        } 
    }
       

    @Override
    public String toString() {
        return title + ": " + description + " - Submit until: " + subDate;
    }
    
    
    
    
    
}//end of class assignment
