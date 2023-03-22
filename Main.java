import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
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
                break;
            case '2':
                break;
            case '3':
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

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}