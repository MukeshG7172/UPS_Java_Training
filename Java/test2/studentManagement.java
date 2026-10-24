import java.util.*;

class Student {
    int rollNo;
    String name;
    double mark;

    Student(int rollNo, String name, double mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark = mark;
    }

    public String toString() {
        return rollNo + " | " + name + " | " + mark;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter roll number, name, and mark: ");
            int rollNo = sc.nextInt();
            String name = sc.next();
            double mark = sc.nextDouble();

            students.add(new Student(rollNo, name, mark));
        }

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Display students scoring above 75");
            System.out.println("2. Search student");
            System.out.println("3. Update student mark");
            System.out.println("4. Remove student");
            System.out.println("5. Display students sorted by marks");
            System.out.println("6. Display all students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Student s : students) {
                        if (s.mark > 75) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 2: {
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == rollNo) {
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    boolean updated = false;

                    for (Student s : students) {
                        if (s.rollNo == rollNo) {
                            System.out.print("Enter new mark: ");
                            double mark = sc.nextDouble();

                            if (mark < 0 || mark > 100) {
                                System.out.println("Invalid mark.");
                            } else {
                                s.mark = mark;
                                System.out.println("Mark updated.");
                            }

                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    boolean removed = students.removeIf(
                        s -> s.rollNo == rollNo
                    );

                    System.out.println(
                        removed ? "Student removed." : "Student not found."
                    );
                    break;
                }

                case 5:
                    students.sort(
                        Comparator.comparingDouble(s -> s.mark)
                    );

                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 6:
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
