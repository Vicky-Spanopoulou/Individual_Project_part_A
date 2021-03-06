/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Create_Data.Create_Data;
import static Synthetic_Data.Synthetic_Data.createSyntheticData;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author vicky
 * @since March 2021
 * @version 
 */
public class Main {

    /**
     * @param args the command line arguments
     */   

    public static void main(String[] args) throws ParseException {

        //MAIN MENU add data - use synthetic data - exit the programm
        boolean runProgram = true;
        Scanner scan = new Scanner(System.in);

        //brings the synthetic data
        createSyntheticData();
 
        while (runProgram) {
            
            Create_Data.welcomeMenu();
            String userInput = scan.next();

            if (userInput.equalsIgnoreCase("1")) {
                
                //first choice - add your own data
                Create_Data.createUserData();
                
                System.out.println(Create_Data.ANSI_CYAN + " \nDo you want to go"
                        + " to the main menu?" + Create_Data.ANSI_RESET);
                System.out.println("Press Yes to continue or No to exit");
                runProgram = Create_Data.yesOrNoMenu();
            } 
            else if (userInput.equalsIgnoreCase("2")) {

                //second choice - use synthetic data
                System.out.println(Create_Data.ANSI_CYAN + "\nChoose a number "
                        + "from list:" + Create_Data.ANSI_RESET);
                Create_Data.programMenu();

                System.out.println(Create_Data.ANSI_CYAN + "\nDo you want to go "
                        + "to the main menu?" + Create_Data.ANSI_RESET);
                System.out.println("Press Yes to continue or No to exit");
                runProgram = Create_Data.yesOrNoMenu();
            } 
            else if (userInput.equalsIgnoreCase("exit")) {
                //exits the loop - ends the programm
                runProgram = false;
            }
            else {
                System.out.println(Create_Data.ANSI_RED + "Wrong input, please "
                        + "try again" + Create_Data.ANSI_RESET);
            }

        }//end of loop
        
        

    }//end of main

}//end of class
