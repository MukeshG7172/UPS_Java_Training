import java.util.*;

// class B<T> {
//     public T data;
//
//     public B(T data) {
//         this.data = data;
//     }
// }

// class Student {
//     private int id;
//     private String name;
//
//     Student(int id, String name){
//         this.id = id;
//         this.name = name;
//     }
//
//     public void display() {
//         System.out.println(id + ": " + name);
//     }
// }

class A {
    public static void main(String[] args) {
        // Set<Object> set = new TreeSet<>();
        // set.add("2");
        // set.add("1");
        // set.add("Sharan");
        // set.add("Mukesh");
        //
        // for(Object i:set) System.out.println(i);

        // List<B<Integer>> arr = new ArrayList<>();
        //
        // for (int i = 1; i <= 5; i++) {
        //     arr.add(new B<>(i));
        // }
        //
        // for (B<Integer> obj : arr) {
        //     System.out.println(obj.data);
        // }

        // List<Student> students = new ArrayList<>();
        // Scanner sc = new Scanner(System.in);
        // while(true) {
        //     System.out.println("Enter 1 to add, 2 to display, 3 to Exit");
        //     int a = sc.nextInt();
        //
        //     if(a == 1){
        //         System.out.println("Enter id");
        //         int id = sc.nextInt();
        //         System.out.println("Enter name");
        //         String name = sc.next();
        //         students.add(new Student(id, name));
        //     }
        //     else if(a == 2){
        //         for(Student i: students) i.display();
        //     }
        //     else break;
        // }


        // Map<Integer, String> mpp = new HashMap<>();
        // mpp.put(1, "Mukesh");
        // mpp.put(2, "Sharan");
        //
        // System.out.println(mpp.getOrDefault(1, null));
        // System.out.println(mpp.getOrDefault(3, null));
        // System.out.println(mpp.getOrDefault(2, null));
        //
        // for(var i : mpp.entrySet()) System.out.println(i.getKey() + " " + i.getValue());
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=5;i++) que.offer(i);
        System.out.println(que.peek());
        System.out.println(que.poll());
        System.out.println(que.peek());
    }

