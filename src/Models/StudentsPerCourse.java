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
public class StudentsPerCourse {
    
    //returns an arraylist of a students per course
    public static ArrayList<Student> findStudentsPerCourse(Course course) {
        //create an arraylist to store the students within the given course
        ArrayList<Student> studentPerCourse = new ArrayList();
        int counter = 0;
        for (Student student : Student.getStudentList()) {
            
            for (Course studentCourse : student.getStudentsCourses()) {
                
                if (studentCourse.equals(course)) {
                    studentPerCourse.add(student);
                    counter++;
                }
            }
        }
        if (counter == 0) {
            System.out.println("There are no students for this course");
        }
        return studentPerCourse;
    }
   
   //prints an arraylist of students per course
   public static void printStudentsPerCourse(Course course) {
       int listIndex = 1;
       for (Student student : findStudentsPerCourse(course)) {
           System.out.println(listIndex + ". " + student.getFirstName() + " " 
                   + student.getLastName());
           listIndex++;
       }
       
   }

   
    
    
}//end of class
