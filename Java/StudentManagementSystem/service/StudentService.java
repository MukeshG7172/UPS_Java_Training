package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import repository.StudentFileRepository;

public class StudentService {
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
