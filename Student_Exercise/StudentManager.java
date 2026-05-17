package exercises.Student_Exercise;
import java.util.ArrayList;

public class StudentManager {
    ArrayList <Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }
    public void listAllStudents(){
        for (Student s : students){
            System.out.println("Student name: " + s.getName());
            System.out.println("Student age: " + s.getAge());
            System.out.println("Student grade: " + s.getGrade());
        }
    }
    public void findStudent(String name){
        for (Student s : students){
            if (s.getName().equalsIgnoreCase(name)){
                System.out.println("Student Found: " + name);
            }
        }
    }
    public void removeStudent(String name){
        for (Student s : students){
            if (s.getName().equalsIgnoreCase(name)){
                System.out.printf("Student [%s] removed.", s.getName());
                students.remove(s);
            }
        }
        
    }
    public double getAverage(){
        Double sum = 0.0;
        for (Student s : students){
            sum+= s.getGrade();
        }
        return sum/students.size();
    }
    public String getHighestGrade(){
        Student HighestGrade = students.get(0);
        for (Student s : students){
            if (s.getGrade() > HighestGrade.getGrade()){
                HighestGrade = s;
            }
        }
        return HighestGrade.getName() + " (" + HighestGrade.getGrade() + ")";
    }
    public String getLowestGrade(){
        Student LowestGrade = students.get(0);
        for (Student s : students){
            if (s.getGrade() < LowestGrade.getGrade()){
                LowestGrade = s;
            }
        }
        return LowestGrade.getName() + " (" + LowestGrade.getGrade() + ")";
    }
    
}
