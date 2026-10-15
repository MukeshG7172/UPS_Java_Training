import java.util.ArrayList;
import java.util.List;

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
  private final List<Student> students = new ArrayList<>();

  public boolean addStudent(Student student) {
    for (Student existing : students) {
      if (existing.getId() == student.getId()) {
        return false;
      }
    }

    students.add(student);
    return true;
  }
}

public class StudentManagement {
  public static void main(String[] args) {
    StudentService service = new StudentService();

    Student first = new Student(101, "Arun", 20, "Computer Science", "arun@example.com");

    Student second = new Student(102, "Priya", 21, "Information Technology", "priya@example.com");

    Student duplicate = new Student(101, "Kumar", 22, "Mechanical", "kumar@example.com");

    System.out.println(service.addStudent(first));
    System.out.println(service.addStudent(second));
    System.out.println(service.addStudent(duplicate));
  }
}
