import java.util.Scanner;

class b{
    char section;
    b(){
        section = 'D';
    }
}

class a{
    public static void main(String args[]){
        boolean attendance = true;
        char gender = 'm';
        short age = 20;
        int register_no = 133;
        float cgpa = 8.92f;
        long phone = 9944576888l;
        double temp = 98.45678964;
        b obj = new b();
        String name = "mukesh";
        String[] courses = {"java", ".net"};
        System.out.println("name : " + name);
        System.out.print("courses : ");
        for (String i : courses){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("section : " + obj.section);
        System.out.println("present : " + attendance);
        System.out.println("gender : " + gender);
        System.out.println("age : " + age);
        System.out.println("register no. : " + register_no);
        System.out.println("cgpa : " + cgpa);
        System.out.println("phone : " + phone);
        System.out.println("temperature : " + temp);
    }
}
