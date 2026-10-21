package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentFileRepository {
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

        try {
          int id = Integer.parseInt(fields[0]);
          String name = fields[1];
          int age = Integer.parseInt(fields[2]);
          String course = fields[3];
          String email = fields[4];

          students.add(new Student(id, name, age, course, email));
        } catch (NumberFormatException e) {
          System.out.println("Skipping invalid student record.");
        }
      }

    } catch (IOException e) {
      if (!(e instanceof java.io.FileNotFoundException)) {
        System.out.println("Error loading students: " + e.getMessage());
      }
    }

    return students;
  }
}
