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
public class Trainer {
    
    private String firstName;
    private String lastName;
    private String subject;
    //list of trainer's courses
    private ArrayList<Course> trainersCourses = new ArrayList();
    //list of all trainers
    private static ArrayList<Trainer> trainerList = new ArrayList();
    
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Course> getTrainersCourses() {
        return trainersCourses;
    }

    public void setTrainersCourses(ArrayList<Course> trainersCourses) {
        this.trainersCourses = trainersCourses;
    }   

    public static ArrayList<Trainer> getTrainerList() {
        return trainerList;
    }

    public static void setTrainerList(ArrayList<Trainer> trainerList) {
        Trainer.trainerList = trainerList;
    }
      
    
    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
    
    //adds a trainer to the list
    public void addTrainer() {
        trainerList.add(this);
    }
    
    //adds a course to the trainer
    public void addTrainersCourse(Course course) {
        trainersCourses.add(course);
    }
    
    //prints a list of all trainers
    public static void listAllTrainers() {
        
        int listIndex = 1;
        System.out.println("Trainer List:");
        for(Trainer trainer : trainerList) {
            System.out.println(listIndex + ". " + trainer);
            listIndex++;
        } 
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - Subject: " + subject;
    }
    
    
    
}//end of class trainer
