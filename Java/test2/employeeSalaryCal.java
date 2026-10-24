import java.util.*;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    double calculateSalary() {
        return basicSalary + basicSalary * 0.20;
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[2];

        System.out.println("Enter full-time employee details:");
        int id = sc.nextInt();
        String name = sc.next();
        double basicSalary = sc.nextDouble();

        employees[0] = new FullTimeEmployee(id, name, basicSalary);

        System.out.println("Enter part-time employee details:");
        id = sc.nextInt();
        name = sc.next();
        int hoursWorked = sc.nextInt();
        double hourlyRate = sc.nextDouble();

        employees[1] = new PartTimeEmployee(
            id, name, hoursWorked, hourlyRate
        );

        for (Employee e : employees) {
            System.out.println("\nEmployee Details");
            e.display();
        }
    }
}
