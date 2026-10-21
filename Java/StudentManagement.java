import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
  private final int id;
  private String name;
  private int age;
  private String course;
  private String email;

  public Student(int id, String name, int age, String course, String email) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.course = course;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getCourse() {
    return course;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", age="
        + age
        + ", course='"
        + course
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
}

class StudentService {
  private final List<Student> students;
  private final StudentFileRepository repository;

  public StudentService() {
    repository = new StudentFileRepository();
    students = repository.loadAll();
  }

  public boolean addStudent(Student student) {
    if (getStudentById(student.getId()) != null) {
      return false;
    }

    students.add(student);

    try {
      repository.saveAll(students);
      return true;
    } catch (IOException e) {
      students.remove(student);
      System.out.println("Error saving student: " + e.getMessage());
      return false;
    }
  }

  public List<Student> getAllStudents() {
    return new ArrayList<>(students);
  }

  public Student getStudentById(int id) {
    for (Student student : students) {
      if (student.getId() == id) {
        return student;
      }
    }

    return null;
  }

  public boolean updateStudent(int id, String name, int age, String course, String email) {
    Student student = getStudentById(id);

    if (student == null) {
      return false;
    }

    String oldName = student.getName();
    int oldAge = student.getAge();
    String oldCourse = student.getCourse();
    String oldEmail = student.getEmail();

    student.setName(name);
    student.setAge(age);
    student.setCourse(course);
    student.setEmail(email);

    try {
      repository.saveAll(students);
      return true;
    } catch (IOException e) {
      student.setName(oldName);
      student.setAge(oldAge);
      student.setCourse(oldCourse);
      student.setEmail(oldEmail);

      System.out.println("Error updating student: " + e.getMessage());
      return false;
    }
  }

  public boolean deleteStudent(int id) {
    Student student = getStudentById(id);

    if (student == null) {
      return false;
    }

    students.remove(student);

    try {
      repository.saveAll(students);
      return true;
    } catch (IOException e) {
      students.add(student);
      System.out.println("Error deleting student: " + e.getMessage());
      return false;
    }
  }
}

class StudentFileRepository {
  private final String filePath = "students.txt";

  public void saveAll(List<Student> students) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

      for (Student student : students) {
        String record =
            student.getId()
                + "|"
                + student.getName()
                + "|"
                + student.getAge()
                + "|"
                + student.getCourse()
                + "|"
                + student.getEmail();

        writer.write(record);
        writer.newLine();
      }
    }
  }

  public List<Student> loadAll() {
    List<Student> students = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

      String line;

      while ((line = reader.readLine()) != null) {
        String[] fields = line.split("\\|", -1);

        if (fields.length != 5) {
          continue;
        }

        int id = Integer.parseInt(fields[0]);
        String name = fields[1];
        int age = Integer.parseInt(fields[2]);
        String course = fields[3];
        String email = fields[4];

        Student student = new Student(id, name, age, course, email);

        students.add(student);
      }

    } catch (IOException | NumberFormatException e) {
      System.out.println("Error loading students: " + e.getMessage());
    }

    return students;
  }
}

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

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter ID: ");
          int id = sc.nextInt();
          sc.nextLine();

          System.out.print("Enter name: ");
          String name = sc.nextLine();

          System.out.print("Enter age: ");
          int age = sc.nextInt();
          sc.nextLine();

          System.out.print("Enter course: ");
          String course = sc.nextLine();

          System.out.print("Enter email: ");
          String email = sc.nextLine();

          Student student = new Student(id, name, age, course, email);

          if (service.addStudent(student)) {
            System.out.println("Student added successfully.");
          } else {
            System.out.println("Student could not be added.");
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
          int searchId = sc.nextInt();

          Student found = service.getStudentById(searchId);

          if (found != null) {
            System.out.println(found);
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 4:
          System.out.print("Enter student ID to update: ");
          int updateId = sc.nextInt();
          sc.nextLine();

          System.out.print("Enter new name: ");
          String newName = sc.nextLine();

          System.out.print("Enter new age: ");
          int newAge = sc.nextInt();
          sc.nextLine();

          System.out.print("Enter new course: ");
          String newCourse = sc.nextLine();

          System.out.print("Enter new email: ");
          String newEmail = sc.nextLine();

          if (service.updateStudent(updateId, newName, newAge, newCourse, newEmail)) {
            System.out.println("Student updated successfully.");
          } else {
            System.out.println("Student update failed.");
          }
          break;

        case 5:
          System.out.print("Enter student ID to delete: ");
          int deleteId = sc.nextInt();

          if (service.deleteStudent(deleteId)) {
            System.out.println("Student deleted successfully.");
          } else {
            System.out.println("Student deletion failed.");
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
