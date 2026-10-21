import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private int[] marks;
    private double average;
    private char grade;
    private int sum;

    Student(int rollNo, String name, int[] marks){
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;

        sum = 0;
        for(int i:marks) sum += i;
        average = sum/5;

        if(average >= 90) grade = 'A';
        else if(average >= 75) grade = 'B';
        else if(average >= 60) grade = 'C';
        else if(average >= 40) grade = 'D';
        else grade = 'F';
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Total: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }

    public double getAverage() {
        return average;
    }
    public String getName() {
        return name;
    }
}

class studentResSystem {
    public static void main(String[] args) {
        double c = 0.0, cur = 0.0;
        String topper = "";
        Student s1 = new Student(1, "Arun", new int[]{100, 100, 90, 85, 75});
        Student s2 = new Student(2, "Priya", new int[]{100, 100, 80, 60, 40});
        s1.display();
        cur = s1.getAverage();
        if(cur > c){
            c = cur;
            topper = s1.getName();
        }
        System.out.println("Topper: " + topper);
        System.out.println();

        s2.display();
        cur = s2.getAverage();
        if(cur > c){
            cur = c;
            topper = s2.getName();
        }
        System.out.println("Topper: " + topper);

    }
}
