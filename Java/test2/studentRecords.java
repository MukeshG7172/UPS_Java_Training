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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}

class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private HashSet<Integer> employeeIds = new HashSet<>();
    private final String fileName = "employees.txt";

    public void addEmployee(Employee e) {
        if (employeeIds.contains(e.getId())) {
            System.out.println("Employee ID already exists.");
            return;
        }

        employees.add(e);
        employeeMap.put(e.getId(), e);
        employeeIds.add(e.getId());

        System.out.println("Employee added successfully.");
    }

    public void searchEmployee(int id) {
        Employee e = employeeMap.get(id);

        if (e == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println(e);
        }
    }

    public void updateSalary(int id, double salary) {
        Employee e = employeeMap.get(id);

        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }

        e.setSalary(salary);
        System.out.println("Salary updated successfully.");
    }

    public void deleteEmployee(int id) {
        Employee e = employeeMap.remove(id);

        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }

        employees.remove(e);
        employeeIds.remove(id);

        System.out.println("Employee deleted successfully.");
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

    public void saveEmployees() {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(fileName))) {

            for (Employee e : employees) {
                bw.write(e.getId() + "|" + e.toString().substring(
                    e.toString().indexOf("|") + 3
                ));
                bw.newLine();
            }

            System.out.println("Records saved successfully.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
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

                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());

                    if (id <= 0 || name.isEmpty()
                            || department.isEmpty() || salary < 0
                            || employeeIds.contains(id)) {
                        continue;
                    }

                    Employee e = new Employee(
                        id, name, department, salary
                    );

                    employees.add(e);
                    employeeMap.put(id, e);
                    employeeIds.add(id);

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid record.");
                }
            }

            System.out.println("Employee records loaded.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        if (id <= 0) {
                            System.out.println("ID must be positive.");
                            break;
                        }

                        System.out.print("Enter name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter department: ");
                        String department = sc.nextLine().trim();

                        System.out.print("Enter salary: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        if (name.isEmpty() || department.isEmpty()
                                || salary < 0 || !Double.isFinite(salary)) {
                            System.out.println("Invalid employee details.");
                            break;
                        }

                        manager.addEmployee(
                            new Employee(id, name, department, salary)
                        );
                        break;
                    }

                    case 2: {
                        System.out.print("Enter employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        manager.searchEmployee(id);
                        break;
                    }

                    case 3: {
                        System.out.print("Enter employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new salary: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        if (salary < 0) {
                            System.out.println("Invalid salary.");
                            break;
                        }

                        manager.updateSalary(id, salary);
                        break;
                    }

                    case 4: {
                        System.out.print("Enter employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        manager.deleteEmployee(id);
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

            } catch (NumberFormatException e) {
                System.out.println("Enter valid numeric input.");
            }
        }
    }
}
