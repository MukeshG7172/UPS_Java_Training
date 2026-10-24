import java.io.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toFileString() {
        return id + "|" + name + "|" + department + "|" + salary;
    }

    public String toString() {
        return "ID: " + id
            + ", Name: " + name
            + ", Department: " + department
            + ", Salary: " + String.format("%.2f", salary);
    }
}

class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private HashSet<Integer> employeeIds = new HashSet<>();
    private final String fileName = "employees.txt";

    public boolean addEmployee(Employee e) {
        if (employeeIds.contains(e.getId())) {
            System.out.println("Employee ID already exists.");
            return false;
        }

        employees.add(e);
        employeeMap.put(e.getId(), e);
        employeeIds.add(e.getId());

        System.out.println("Employee added successfully.");
        return true;
    }

    public Employee searchEmployee(int id) {
        return employeeMap.get(id);
    }

    public boolean updateSalary(int id, double salary) {
        Employee e = employeeMap.get(id);

        if (e == null) {
            return false;
        }

        e.setSalary(salary);
        return true;
    }

    public boolean deleteEmployee(int id) {
        Employee e = employeeMap.remove(id);

        if (e == null) {
            return false;
        }

        employees.remove(e);
        employeeIds.remove(id);
        return true;
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public void loadEmployees() {
        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split("\\|", -1);

                    if (data.length != 4) {
                        continue;
                    }

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);

                    if (id <= 0 || name.trim().isEmpty()
                            || department.trim().isEmpty()
                            || !Double.isFinite(salary)
                            || salary < 0
                            || employeeIds.contains(id)) {
                        continue;
                    }

                    Employee e = new Employee(
                        id, name, department, salary
                    );

                    employees.add(e);
                    employeeMap.put(id, e);
                    employeeIds.add(id);

                } catch (NumberFormatException ex) {
                    System.out.println("Skipping invalid record.");
                }
            }

            System.out.println("Loaded " + employees.size()
                + " employee records.");

        } catch (IOException e) {
            System.out.println("Unable to load file: "
                + e.getMessage());
        }
    }

    public void saveEmployees() {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(fileName))) {

            for (Employee e : employees) {
                bw.write(e.toFileString());
                bw.newLine();
            }

            System.out.println("Records saved successfully.");

        } catch (IOException e) {
            System.out.println("Unable to save file: "
                + e.getMessage());
        }
    }
}

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    private static double readSalary(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(value) && value >= 0) {
                    return value;
                }

                System.out.println("Salary must be non-negative.");

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid salary.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();

            if (!value.isEmpty() && !value.contains("|")) {
                return value;
            }

            System.out.println(
                "Input cannot be empty or contain |."
            );
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.loadEmployees();

        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Display All");
            System.out.println("6. Save and Exit");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: {
                    int id = readInt("Enter ID: ");

                    if (id <= 0) {
                        System.out.println("ID must be positive.");
                        break;
                    }

                    String name = readText("Enter name: ");
                    String department = readText("Enter department: ");
                    double salary = readSalary("Enter salary: ");

                    manager.addEmployee(
                        new Employee(id, name, department, salary)
                    );
                    break;
                }

                case 2: {
                    int id = readInt("Enter employee ID: ");
                    Employee e = manager.searchEmployee(id);

                    if (e == null) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println(e);
                    }
                    break;
                }

                case 3: {
                    int id = readInt("Enter employee ID: ");
                    double salary = readSalary("Enter new salary: ");

                    if (manager.updateSalary(id, salary)) {
                        System.out.println("Salary updated.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                }

                case 4: {
                    int id = readInt("Enter employee ID: ");

                    if (manager.deleteEmployee(id)) {
                        System.out.println("Employee deleted.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                }

                case 5:
                    manager.displayEmployees();
                    break;

                case 6:
                    manager.saveEmployees();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }
}
