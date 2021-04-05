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
public class TrainersPerCourse {
    
    //returns an Arraylist of trainers per course
    public static ArrayList<Trainer> findTrainersPerCourse(Course course) {
        
        //creates an arraylist to store the trainers of the given course
        ArrayList<Trainer> trainersPerCourse = new ArrayList();
        int counter = 0;
        
        for (Trainer trainer : Trainer.getTrainerList()) {
            
            for (Course trainersCourse : trainer.getTrainersCourses()) {
                
                if (trainersCourse.equals(course)) {
                    trainersPerCourse.add(trainer);
                    counter++;
                }
            }
        }
        if (counter == 0) {
            System.out.println("There are no trainers for this course");
        }
        return trainersPerCourse;
    }
        
    //prints an Arraylist of trainers per course    
    public static void printTrainersPerCourse(Course course) {
       int listIndex = 1;
       for (Trainer trainer : findTrainersPerCourse(course)) {
           System.out.println(listIndex + ". " + trainer.getFirstName() + " " 
                   + trainer.getLastName());
           listIndex++;
       }
       
   }
    
    

    

    
    
}//end of class
