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
}
