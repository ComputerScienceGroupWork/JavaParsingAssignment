import java.util.ArrayList;

public class Grade {
    private Student student;
    private String course;
    private ArrayList<Double> quizzes, tests, assignments, projects;
    private double finalExam;

    public Grade(Student student, String course, ArrayList<Double> quizzes,ArrayList<Double> tests,
    ArrayList<Double> assignments,ArrayList<Double> projects,double finalExam)
    {
        this.student = student;
        this.course = course;
        this.quizzes = quizzes;
        this.tests = tests;
        this.assignments = assignments;
        this.projects =projects;
        this.finalExam = finalExam;
    }
  
    //Overing the to string method [The intention is so that is can be used in the print grade]
    public String toString()
    {
        String s = "";
        s += "|  " + student.name + "  |  " + student.computerNumber;
        s += "  |  ";
        for (Double x : quizzes) {
            s += " Quizzes: " + x +",";
        }
        s += "  |  ";
        for (Double x : assignments) {
            s += " Assignments: " + x +",";
        }
        s += "  |  ";
        for (Double x : tests) {
            s += " Tests:" + x +",";
        }
        s += "  |  ";
        for (Double x : projects) {
            s += " Projects:" + x +",";
        }
        s += "  |  Final Exams";
        s += finalExam;
        return s;
    }
}
