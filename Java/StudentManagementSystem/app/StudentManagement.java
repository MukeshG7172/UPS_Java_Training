package app;

import java.util.List;
import java.util.Scanner;
import model.Student;
import service.StudentService;

public class StudentManagement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentService service = new StudentService();

    boolean running = true;

    while (running) {
      System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
      System.out.println("1. Add Student");
      System.out.println("2. View All Students");
      System.out.println("3. Search Student by ID");
      System.out.println("4. Update Student");
      System.out.println("5. Delete Student");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");

      int choice;

      try {
        choice = Integer.parseInt(sc.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid menu number.");
        continue;
      }

      switch (choice) {
        case 1:
          System.out.print("Enter ID: ");
          int id;
          try {
            id = Integer.parseInt(sc.nextLine().trim());
          } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            break;
          }

          System.out.print("Enter name: ");
          String name = sc.nextLine();

          System.out.print("Enter age: ");
          int age;
          try {
            age = Integer.parseInt(sc.nextLine().trim());
          } catch (NumberFormatException e) {
            System.out.println("Invalid age.");
            break;
          }

          System.out.print("Enter course: ");
          String course = sc.nextLine();

          System.out.print("Enter email: ");
          String email = sc.nextLine();

          Student student = new Student(id, name, age, course, email);

          if (service.addStudent(student)) {
            System.out.println("Student added successfully.");
          } else {
            System.out.println("Student could not be added. Check the ID or file.");
          }
          break;

        case 2:
          List<Student> students = service.getAllStudents();

          if (students.isEmpty()) {
            System.out.println("No students found.");
          } else {
            for (Student s : students) {
              System.out.println(s);
            }
          }
          break;

        case 3:
          System.out.print("Enter student ID: ");
          try {
            int searchId = Integer.parseInt(sc.nextLine().trim());
            Student found = service.getStudentById(searchId);

            if (found != null) {
              System.out.println(found);
            } else {
              System.out.println("Student not found.");
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
          }
          break;

        case 4:
          System.out.print("Enter student ID to update: ");
          try {
            int updateId = Integer.parseInt(sc.nextLine().trim());

            if (service.getStudentById(updateId) == null) {
              System.out.println("Student not found.");
              break;
            }

            System.out.print("Enter new name: ");
            String newName = sc.nextLine();

            System.out.print("Enter new age: ");
            int newAge;
            try {
              newAge = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
              System.out.println("Invalid age.");
              break;
            }

            System.out.print("Enter new course: ");
            String newCourse = sc.nextLine();

            System.out.print("Enter new email: ");
            String newEmail = sc.nextLine();

            if (service.updateStudent(updateId, newName, newAge, newCourse, newEmail)) {
              System.out.println("Student updated successfully.");
            } else {
              System.out.println("Student update failed.");
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
          }
          break;

        case 5:
          System.out.print("Enter student ID to delete: ");
          try {
            int deleteId = Integer.parseInt(sc.nextLine().trim());

            if (service.deleteStudent(deleteId)) {
              System.out.println("Student deleted successfully.");
            } else {
              System.out.println("Student deletion failed. Student may not exist.");
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
          }
          break;

        case 6:
          running = false;
          System.out.println("Exiting Student Management System.");
          break;

        default:
          System.out.println("Invalid choice. Try again.");
      }
    }

    sc.close();
  }
}
