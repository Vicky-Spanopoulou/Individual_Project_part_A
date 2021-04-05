/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Synthetic_Data;

import Models.Assignment;
import Models.Course;
import Models.Student;
import Models.Trainer;



/**
 *
 * @author vicky
 */
public class Synthetic_Data {
    
    public static void createSyntheticData() {
        
    //courses
    Course c = new Course("CB13", "Java", "part time", "15/02/2021", "15/09/2021");
    c.addCourse();
    Course c1 = new Course("CB11", "C#", "part time", "15/02/2021", "15/09/2021");
    c1.addCourse();
    Course c2 = new Course("CB12", "Javascript", "full time", "15/02/2021", "15/09/2021");
    c2.addCourse();
    Course c3 = new Course("CB10", "Python", "full time", "15/02/2021", "15/09/2021");
    c3.addCourse();
        
    //students
    Student s = new Student("Julian ", "Parsons", "23/10/1990", "2250");    
    s.addStudent();
    s.addStudentsCourses(c);
    s.addStudentsCourses(c3);

    Student s1 = new Student("Garry ", "Santiago", "11/08/1992", "2250");    
    s1.addStudent();
    s1.addStudentsCourses(c);

    Student s2 = new Student("Jane", "Doe", "15/06/1990", "2500");   
    s2.addStudent();
    s2.addStudentsCourses(c);
    s2.addStudentsCourses(c2);

    Student s3 = new Student("Elizabeth ", "Newman", "11/06/1990", "2500"); 
    s3.addStudent();
    s3.addStudentsCourses(c3);
    s3.addStudentsCourses(c1);

    Student s4 = new Student("Alicia  ", "Jones", "01/04/1995", "2500"); 
    s4.addStudent();
    s4.addStudentsCourses(c3);

          
    //trainers
    Trainer t = new Trainer("Nora", "Douglas", "Databases");
    t.addTrainer();
    t.addTrainersCourse(c2);
    t.addTrainersCourse(c3);
    Trainer t1 = new Trainer("Chris", "Lewis", "OOP");
    t1.addTrainer();
    t1.addTrainersCourse(c);
    t1.addTrainersCourse(c3);
    Trainer t2 = new Trainer("Neal", "Caffrey", "Front End");
    t2.addTrainer();
    t2.addTrainersCourse(c);
    t2.addTrainersCourse(c1);
    t2.addTrainersCourse(c3);
        
        
    //assignments
    Assignment a = new Assignment("First Project", "individual project", "31/03/2021", 20, 100);
    a.addAssignment();
    Assignment a1 = new Assignment("Second Project", "make a web app", "23/04/2021", 20, 100);
    a1.addAssignment();
    Assignment a2 = new Assignment("Group project", "make a web app", "30/06/2021", 20, 100);
    a2.addAssignment();
        
        
    //assignments per course
    c.addCoursesAssignment(a);
    c.addCoursesAssignment(a1);
    c1.addCoursesAssignment(a2);
    c2.addCoursesAssignment(a);
    c2.addCoursesAssignment(a1);
    c3.addCoursesAssignment(a2);
    c3.addCoursesAssignment(a);

        
    }//end of method
    
    
}//end of class
