/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Data;

import Models.Assignment;
import Models.AssignmentsPerCourse;
import Models.Course;
import Models.Student;
import Models.StudentsPerCourse;
import Models.Trainer;
import Models.TrainersPerCourse;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author vicky
 */
public class Create_Data {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";


    //creates new Students by user input
    public void createStudent() throws ParseException {
        String inputFirstName;
        String inputLastName;
        String inputDateOfBirth;
        String inputTuitionFees;
        String exitInput = "";
        boolean exitLoop = true;
        Scanner scanner = new Scanner(System.in);
        DateValidatorUsingDateFormat validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");

        while (exitLoop) {

            System.out.println(ANSI_CYAN + "Enter the student's details:" + ANSI_RESET);

            System.out.println("First name:");
            inputFirstName = stringValidation(scanner);

            System.out.println("Last name:");
            inputLastName = stringValidation(scanner);

            System.out.println("Date of birth DD/MM/YYYY:");
            inputDateOfBirth = scanner.next();
            while (!validator.isValid(inputDateOfBirth)) {
                System.out.println(ANSI_RED + "Please give a valid date format: DD/MM/YYYY" + ANSI_RESET);
                inputDateOfBirth = scanner.next();
                validator.isValid(inputDateOfBirth);
            }

            System.out.println("Tuition fees:");
            inputTuitionFees = Integer.toString(giveOnlyNumbers());

            //create a new student and add it to the list
            Student student = new Student(inputFirstName, inputLastName,
                    inputDateOfBirth, inputTuitionFees);
            student.addStudent();
            boolean exit = true;

            while (exit) {
                System.out.println("Course:");
                
                //list of all courses
                Course.listAllCourses();         
                int inputListNumber = checkNumbersRange(1, Course.getCourseList().size());
                inputListNumber = inputListNumber - 1;
                student.addStudentsCourses(Course.getCourseList().get(inputListNumber));

                System.out.println(ANSI_CYAN + "\nDo you want to add this student to another course?" + ANSI_RESET);
                System.out.println("Press Yes to add more or No to continue");
                exit = yesOrNoMenu();
            }

            System.out.println(ANSI_CYAN + "\nWhat do you want to see?" + ANSI_RESET);
            programMenu();

            exitLoop = exitMenu(exitInput, " students");

        }//end of while loop

    }//end of createStudent
    

    //creates new Trainers by user input
    public void createTrainer() throws ParseException {
        String inputFirstName;
        String inputLastName;
        String inputSubject;
        String exitInput = "";
        boolean exitLoop = true;
        Scanner scanner = new Scanner(System.in);

        while (exitLoop) {

            System.out.println(ANSI_CYAN + "Enter the trainer's details" + ANSI_RESET);

            System.out.println("First name:");
            inputFirstName = stringValidation(scanner);

            System.out.println("Last name:");
            inputLastName = stringValidation(scanner);

            System.out.println("Subject?");
            inputSubject = stringValidation(scanner);
            
            System.out.println("Course?");
            //list of all courses
            Course.listAllCourses();
            int inputListNumber = checkNumbersRange(1, Course.getCourseList().size());
            inputListNumber -= 1;

            //create a new trainer and add it to the list
            Trainer trainer = new Trainer(inputFirstName, inputLastName, inputSubject);
            trainer.addTrainer();
            trainer.addTrainersCourse(Course.getCourseList().get(inputListNumber));

            System.out.println(ANSI_CYAN + "What do you want to see?" + ANSI_RESET);
            programMenu();

            exitLoop = exitMenu(exitInput, " trainers");

        }//end of while loop

    }//end of createTrainer

    
    
    
    //creates new Course by user input
    public void createCourse() throws ParseException {
        String inputTitle;
        String inputStream;
        String inputType;
        String start_date;
        String end_date;
        String exitInput = "";
        boolean exitLoop = true;
        Scanner scanner = new Scanner(System.in);
        DateValidatorUsingDateFormat validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");

        while (exitLoop) {

            System.out.println(ANSI_CYAN + "Enter the course's details:" + ANSI_RESET);

            System.out.println("Title:");
            inputTitle = scanner.nextLine();

            System.out.println("Stream:");
            inputStream = scanner.nextLine();

            System.out.println("Type:");
            inputType = scanner.nextLine();

            System.out.println("Start date DD/MM/YYYY:");
            start_date = scanner.next();
            while (!validator.isValid(start_date)) {
                System.out.println(ANSI_RED + "Please give a valid date format: "
                        + "DD/MM/YYYY" + ANSI_RESET);
                start_date = scanner.next();
                validator.isValid(start_date);
            }

            System.out.println("End date DD/MM/YYYY:");
            end_date = scanner.next();
            while (!validator.isValid(end_date)) {
                System.out.println(ANSI_RED + "Please give a valid date format: "
                        + "DD/MM/YYYY" + ANSI_RESET);
                end_date = scanner.next();
                validator.isValid(end_date);
            }

            //create a new course and add it to the list
            Course course = new Course(inputTitle, inputStream, inputType,
                    start_date, end_date);
            course.addCourse();

            System.out.println(ANSI_CYAN + "What do you want to see?" + ANSI_RESET);
            programMenu();

            exitLoop = exitMenu(exitInput, " courses");

        }//end of while loop

    }//end of createCourse

    
    
    
    //creates new Course by user input
    public void createAssignment() throws ParseException {
        String inputTitle;
        String inputDescription;
        String inputSubDateTime;
        double inputOralMark;
        double inputTotallMark;
        String exitInput = "";
        boolean exitLoop = true;
        Scanner scanner = new Scanner(System.in);
        DateValidatorUsingDateFormat validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");

        outerLoop:
        while (exitLoop) {

            System.out.println(ANSI_CYAN + "Enter assignment's details:" + ANSI_RESET);

            System.out.println("Title:");
            inputTitle = scanner.nextLine();

            System.out.println("Description:");
            inputDescription = scanner.nextLine();

            System.out.println("Submission date:");
            inputSubDateTime = scanner.nextLine();

            while (!validator.isValid(inputSubDateTime)) {
                System.out.println(ANSI_RED + "Please give a valid date format: "
                        + "DD/MM/YYYY" + ANSI_RESET);
                inputSubDateTime = scanner.nextLine();
                validator.isValid(inputSubDateTime);
            }

            System.out.println("Oral mark:");
            inputOralMark = giveOnlyNumbers();
            

            System.out.println("Total mark:");
            inputTotallMark = giveOnlyNumbers();
            
            System.out.println("Course?");
            //list of all courses
            Course.listAllCourses();
            int inputListNumber = checkNumbersRange(1, Course.getCourseList().size());
            inputListNumber -= 1;

            //create a new assignment and add it to the list
            Assignment assignment = new Assignment(inputTitle, inputDescription,
                    inputSubDateTime, inputOralMark, inputTotallMark);
            assignment.addAssignment();
            Course.getCourseList().get(inputListNumber).addCoursesAssignment(assignment);

            System.out.println(ANSI_CYAN + "What do you want to see?" + ANSI_RESET);
            programMenu();

            exitLoop = exitMenu(exitInput, " assignments");

        }//end of while loop

    }//end of createAssignment
    
    
    
    //*-------------------------METHOD TOOLS------------------------------*
   
    //checks if a string contains only digits
    public static int giveOnlyNumbers() {
        Scanner scanner = new Scanner(System.in);
        int resultNum;
        while (true) {
            try {
                String input = scanner.next();
                int number = Integer.parseInt(input);
                resultNum = number;
                break;
            }
            catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Please give only numbers" + ANSI_RESET);
            }
        }
    return resultNum;
    }
    
    //checks if the number given is in range
    public static int checkNumbersRange(int min, int listMax) {
        int num = giveOnlyNumbers();
        while (num < min || num > listMax) {
            System.out.println(ANSI_RED + "Please give a valid number" + ANSI_RESET);
            num = giveOnlyNumbers();
        }
        return num;
    }   

    //checks if a string contains only letters
    public boolean checkIfLetters(String str) {
        return (str.matches("[a-zA-Z]+"));
    }

    //checks if the string given contains only letters
    public String stringValidation(Scanner scan) {
        String userInput = scan.nextLine();
        while (!checkIfLetters(userInput)) {
            System.out.println(ANSI_RED + "Input is invalid, type only letters" + ANSI_RESET);
            userInput = scan.nextLine();
        }
        return userInput;
    }

    //exits the create new data returning to the main menu
    public boolean exitMenu(String exitInput, String objName) {
        Scanner scan = new Scanner(System.in);
        System.out.println(ANSI_CYAN + "\nDo you want to add more" + objName + "?" + ANSI_RESET);
        System.out.println("Press: Yes to continue or No to exit");

        return yesOrNoMenu();
    }

    //shows a menu of program's choices
    public static void programMenu() throws ParseException {
        DateValidatorUsingDateFormat validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        listOfProgramChoices();
        
        outerLoop:
        while(true) {
            String inputChoiceNumber = scanner.next();

            switch (inputChoiceNumber) {
                case "1":
                    Student.listAllStudents();
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a "
                            + "number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "2":
                    Trainer.listAllTrainers();
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a "
                            + "number from the list" + Create_Data.ANSI_RESET);                   
                    break;
                case "3":
                    Assignment.listAllAssignments();
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a "
                            + "number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "4":
                    Course.listAllCourses();
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a"
                            + " number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "5":
                    System.out.println("Choose a number from list:");
                    Course.listAllCourses();
                    int choiceNumber = checkNumbersRange(1, Course.getCourseList().size()) - 1;
                    StudentsPerCourse.printStudentsPerCourse(Course.getCourseList().get(choiceNumber));
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose "
                            + "a number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "6":
                    System.out.println("Choose a number from list:");
                    Course.listAllCourses();
                    choiceNumber = checkNumbersRange(1, Course.getCourseList().size()) - 1;
                    TrainersPerCourse.printTrainersPerCourse(Course.getCourseList().get(choiceNumber));
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose "
                            + "a number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "7":
                    System.out.println("Choose a number from list:");
                    Course.listAllCourses();
                    choiceNumber = checkNumbersRange(1, Course.getCourseList().size()) - 1;
                    AssignmentsPerCourse.printAssignmentsPerCourse(Course.getCourseList().get(choiceNumber));
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a"
                            + " number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "8":
                    Student.listAllStudentsAssignments();
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a "
                            + "number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "9":
                    System.out.println("The students who have more than one course are:");
                    Student.listStudentsWithMoreCourses();
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a "
                            + "number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "10":
                    System.out.println("Enter submission date DD/MM/YYYY:");
                    inputChoiceNumber = scanner.next();
                    while (!validator.isValid(inputChoiceNumber)) {
                        System.out.println(ANSI_RED + "Please give a valid date "
                                + "format: DD/MM/YYYY" + ANSI_RESET);
                        inputChoiceNumber = scanner.nextLine();
                        validator.isValid(inputChoiceNumber);
                    }
                    LocalDate inputDate = Student.stringToLocalDate(inputChoiceNumber);
                    Student.getStudentsSubmissionInWeek(inputDate);
                    System.out.println(Create_Data.ANSI_CYAN + "\nTo see more choose a"
                            + " number from the list" + Create_Data.ANSI_RESET);
                    break;
                case "0":
                    break outerLoop;
                default:
                    System.out.println(ANSI_RED + "Wrong input" + ANSI_RESET);
            }
        }
    }

    //lists all the programm's output choices
    public static void listOfProgramChoices() {
        System.out.println("1. A list of all the students");
        System.out.println("2. A list of all the trainers");
        System.out.println("3. A list of all the assignments");
        System.out.println("4. A list of all the courses");
        System.out.println("5. All the students per course");
        System.out.println("6. All the trainers per course");
        System.out.println("7. All the assignments per course");
        System.out.println("8. All the assignments per student");
        System.out.println("9. A list of students that belong to more "
                            + "than one courses");
        System.out.println("10. Students who need to submit an assignment");
        System.out.println("0 . ----------Go Back----------");
    }
    
        //welcome menu
    public static void welcomeMenu() {
        System.out.println(ANSI_CYAN + "*-------- Welcome --------*" + ANSI_RESET);
        System.out.println("Press:");
        System.out.println(" 1.   To add your own data");
        System.out.println(" 2.   To use synthetic data");
        System.out.println("Exit. To stop the program");
    }

    //menu to create new data
    public static void createUserData() throws ParseException {
        Create_Data data = new Create_Data();
        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println(ANSI_CYAN + "Choose a number from list:" + ANSI_RESET);
            System.out.println("1. Create a new Course");
            System.out.println("2. Create a new Trainer");
            System.out.println("3. Create a new Student");
            System.out.println("4. Create a new Assignment");
            String userInput = scan.next();
            switch (userInput) {                
                case "1":
                    data.createCourse();
                    break;
                case "2":
                    data.createTrainer();
                    break;
                case "3":
                    data.createStudent();
                    break;
                case "4":
                    data.createAssignment();
                    break;
                default:
                    System.out.println(ANSI_RED + "Wrong input, try again" + ANSI_RESET);
                    continue;
            }
            System.out.println(ANSI_CYAN + "\nDo you want to add more?" + ANSI_RESET);
            System.out.println("Press Yes to continue or No to exit");

            exit = Create_Data.yesOrNoMenu();
        }
    }
    
    //yes or no menu for the user to choose if he wants to continue or exit
    public static boolean yesOrNoMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        String inputChoice = scanner.next();
        
        while ((!inputChoice.equalsIgnoreCase("yes")) && (!inputChoice.equalsIgnoreCase("no"))) {
            System.out.println(ANSI_RED + "Wrong input, please try again" + ANSI_RESET);
            inputChoice = scanner.next();
        }
        if (inputChoice.equalsIgnoreCase("yes")) {
            exit = true;
        } else if (inputChoice.equalsIgnoreCase("no")) {
            exit = false;
        }
        return exit;
    }
    
    
    
}//end of class create_data
