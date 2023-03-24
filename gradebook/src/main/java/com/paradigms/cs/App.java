/* This is the Gradebook Project which is going to be analyzed using the JavaParser
 * In this project we have 3 classes
 * The Student Class which is used to create a student 
 * The Grade class which is used to create the grades and the main class
 * It use Java ulility classes like ArrayList, Arrays etc
 */
package com.paradigms.cs;

 //Some comments are just here for us to understand the progress 
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;
 import java.util.Scanner;
 
 public class App {
     private static Scanner input;
     private static List<String> subjects = new ArrayList<>();
     private static List<Student> students = new ArrayList<>();
     private static List<Grade> grades = new ArrayList<>();
     private static boolean running = true;
 
     public static void main(String[] args) {
         input = new Scanner(System.in);
         while (running) {
             clearScreen();
             mainMenu();
         }
     }
 
     public static void mainMenu() {
 
         System.out.println("##### Welcome to the grade book #####");
         System.out.println("What would you want to do? ");
         System.out.println("1) Enter grade");
         System.out.println("2) View grades");
         System.out.println("3) Change grade");
         System.out.println("4) Quit");
 
         char command = input.nextLine().charAt(0);
         switch(command){
             case '1':
                 enterGrade();
                 break;
             case '2':
                 printGrades();
                 break;
             case '3':
                 changeGrade();
                 break;
             case '4':
                 running = false;
                 return;
             default:
                 System.out.println("Wrong command");
                 System.out.println("Press any key to continue");
                 input.nextLine();
         }
     }
 
     //method for entering the grades
     public static void enterGrade()
     {
 
 
         System.out.println("#### Enter a students computer number ####");
         int compNum = input.nextInt();
         input.nextLine();
 
         // Fetch student
         Student student = null;
         for(Student s: students)
         {
             if(s.computerNumber == compNum)
             {
                 student = s;
                 break;
             }
         }
 
         //If Student doesn't exist in the array, a new student created using the createStudent
         if(student == null)
         {
             System.out.println("Student not found!!!!");
             student = createStudent(compNum);
             System.out.println("Student Created");
         }
 
         System.out.println(Arrays.toString(students.toArray()));
         input.nextLine();
 
         //entering the grades
         ArrayList<Double> quizzes, tests , assignments, projects;
         quizzes = fetchResults("Quizzes");
         tests = fetchResults("Tests");
         assignments = fetchResults("Assignments");
         projects = fetchResults("Projects");
         System.out.println("Enter final exam score");
         double fn = input.nextDouble();
         input.nextLine();
 
         //creating and adding the grades to the grades list
         Grade grade = new Grade(student, "CSC 3301", quizzes, tests, assignments, projects, fn);
         grades.add(grade);
         System.out.println("Done!!");
         System.out.println(grade);
         input.nextLine();
     }
 
     //gettting the grades for the activities [Note: The grades are gotten as strings since the total number of activities may vary e.g 5 quizzes and 2 tests] 
     public static ArrayList<Double> fetchResults(String prompt)
     {
         System.out.println("Enter the results for "+ prompt);
         String[] rString = input.nextLine().split(" ");
         ArrayList<Double> res = new ArrayList<>();
         for (String s : rString) {
             res.add(Double.parseDouble(s));
         }
         return res;
     }
 
     //printing all the grades
     public static void printGrades()
     {
         System.out.println("Would you like to see? \n1)All the Results \n2)Results for one Student");
         char ans = input.nextLine().charAt(0);
 
         switch(ans){
             case '1':
                 printAllGrades();
                 break;
             case '2':
                 printStudentGrade();
                 break;
             default:
                 System.out.println("Invalid input");
                 input.nextLine();
         }
     }
 
     //printing a all student
     public static void printAllGrades()
     {
        for (Grade grade : grades) {
            System.out.println(grade);
        }
     }
 
     //printing results for a single student
     public static void printStudentGrade()
     {
        System.out.println("Enter a computer number");
        int num = input.nextInt();
        input.nextLine();
        Student student = null;
        for(Student s: students)
        {
            if(s.computerNumber == num)
            {
                student = s;
                break;
            }
        }

        //If Student doesn't exist in the array, a new student created using the createStudent
        if(student == null)
        {
            System.out.println("### COULD NOT FIND THE STUDENT ###");
        }else{
            
            for(Grade g1: grades)
            {
                if(g1.forStudent(student))
                {
                    System.out.println(g1);
                    break;
                }
            }
            input.nextLine();
        }

     }
 
     //changing a grade
     public static void changeGrade()
     {
         
     }
 
     //creating a student using the Student class
     public static Student createStudent(int compNum)
     {   
         System.out.println("Enter the students name: ");
         String name = input.nextLine();
         Student s = new Student(name, compNum);
         students.add(s);
         return s;
 
     }
 
     public static void clearScreen() {
         System.out.println("\033[H\033[2J");
         System.out.flush();
     }
 
 }