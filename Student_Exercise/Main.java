
package exercises.Student_Exercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n1. Add student");
            System.out.println("\n2. Remove Student");
            System.out.println("\n3. Find Student");
            System.out.println("\n4. List All Students");
            System.out.println("\n5. Statistics");
            System.out.println("\n6. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Age: ");
                    int age = sc.nextInt();
                    double grade;
                    do{
                        System.out.println("Grade: ");
                         grade = sc.nextDouble();
                        if (grade < 1 || grade > 10 ){
                            System.out.println("Invalid Grade.");
                        }
                    }while (grade < 1 || grade > 10);
                    manager.addStudent(new Student(name, age, grade));
                    break;
                case 2:
                    System.out.println("Name: ");
                    String RemoveStudent = sc.nextLine();
                    manager.removeStudent(RemoveStudent);
                    break;
                case 3:
                     System.out.println("Name: ");
                     String FindStudent = sc.nextLine();
                     manager.findStudent(FindStudent);
                     break;
                case 4:
                    manager.listAllStudents();
                    break;
                case 5:

                    System.out.println("Average Grade: " + manager.getAverage());
                    System.out.println("Highest Grade: " + manager.getHighestGrade());
                    System.out.println("Lowest Grade: " + manager.getLowestGrade());
                    break;
            }
        }while (choice != 6);
        sc.close();
    }
}
