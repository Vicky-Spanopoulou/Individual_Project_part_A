/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Create_Data.Create_Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author vicky
 * @since March 2021
 */
public class Student {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String tuitionFees;
    private Course course;
    //list of all students
    private static ArrayList<Student> studentList = new ArrayList();
    //list of courses per student
    private ArrayList<Course> studentsCourses = new ArrayList();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(String tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        Student.studentList = studentList;
    }

    public ArrayList<Course> getStudentsCourses() {
        return studentsCourses;
    }

    public void setStudentsCourses(ArrayList<Course> studentsCourses) {
        this.studentsCourses = studentsCourses;
    }

    
    public Student(String firstName, String lastName, String dateOfBirth, String tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    //adds a student to the list
    public void addStudent() {
        studentList.add(this);
    }
    
    //adds a course to the student's list
    public void addStudentsCourses(Course course) {
        studentsCourses.add(course);
    }
    

    //prints a list of all the students
    public static void listAllStudents() {
        int listIndex = 1;
        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println(listIndex + ". " + student);
            listIndex++;
        }
    }
    
    //returns a list of the student's assignments per course
    public ArrayList<Assignment> getAssignmentsPerStudent() { 
        ArrayList<Assignment> studentAssignmentList = new ArrayList();

            for (Course c : this.studentsCourses) {
                for (Assignment assignment : c.getCourseAssignmentList()) {
                    studentAssignmentList.add(assignment);
                }
            }
            
        return studentAssignmentList;
    }
    
    //prints a list of all student's assignments per course
    public static void listAllStudentsAssignments() {
        System.out.println("Assignments:");
        for (Student s : Student.studentList) {
            System.out.println("\n" + s + ":\n");
            int listIndex = 1;
            for (Assignment a : s.getAssignmentsPerStudent()) {  
                System.out.println(listIndex + ". " + a);
                listIndex++;
            }
        }
    }
    
    //prints a list of students who have more than one courses
    public static void listStudentsWithMoreCourses() {
        int listIndex = 1;
        for (Student student : studentList) {
            if(student.getStudentsCourses().size() > 1) {
                System.out.println(listIndex + " " + student.getFirstName() 
                        + " " + student.getLastName());
                listIndex++;
            }
        }
    }
    
    //prints a list of students who need to submit one or more assignments on the
    //same calendar week as the given inputDate   
    public static void getStudentsSubmissionInWeek(LocalDate inputDate) throws ParseException {
        LocalDate assignmentDate;
        int counter = 0;
        for (Student s : studentList) {
            for (Assignment a : s.getAssignmentsPerStudent()) {
                assignmentDate = stringToLocalDate(a.getSubDate());
                if (isInSameWeek(inputDate, assignmentDate)) {
                    System.out.println(s + " - Assignment: " + a.getTitle());
                    counter++;
                }  
            }
        }
        if (counter == 0) {
            System.out.println(Create_Data.ANSI_RED +"There are no due assignments "
                    + "for this week" + Create_Data.ANSI_RESET);
        }
    }
    
    
    //*------------------------METHOD TOOLS----------------------------------*
    
    
    //checks if the date given is in the same week as the assignment's date
    public static boolean isInSameWeek(LocalDate date, LocalDate assignmentDate) {
        Locale locale = Locale.getDefault();
        int givenWeekOfYear = date.get(WeekFields.ISO.of(locale).weekOfYear());
        int givenWeekOfAssignment = assignmentDate.get(WeekFields.ISO.of(locale).weekOfYear());
        return givenWeekOfYear == givenWeekOfAssignment;
    }
    
    //takes a string as an input and turns it into local date  
    public static LocalDate stringToLocalDate(String date) throws ParseException {
        Date dateD = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        LocalDate dateLD = dateD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return dateLD;
    }
        
  
    @Override
    public String toString() {
        return firstName + " " + lastName + " - Date of birth: " 
                + dateOfBirth + " - Tuition Fees: " + tuitionFees;
    }

    
    
}//end of class student
