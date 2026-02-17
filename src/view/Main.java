package view;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Student Management System =====");
            System.out.println("Press =>1 Add Student");
            System.out.println("Press =>2 View All Students");
            System.out.println("Press =>3 Update Student Marks");
            System.out.println("Press =>4 Delete Student");
            System.out.println("Press =>5 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();
                    sc.close();
                    dao.addStudent(new Student(name, email, course, marks));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " +
                                s.getEmail() + " | " + s.getCourse() + " | " + s.getMarks());
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();
                    dao.updateStudent(id, newMarks);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
