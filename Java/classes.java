class Student {
  private int id;
  private String name;

  Student(int a, String s) {
    id = a;
    name = s;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // public void display() {
  //   System.out.println("User ID: " + id);
  //   System.out.println("User Name: " + name);
  // }
}

class A {
  public static void main(String args[]) {
    // Scanner sc = new Scanner(System.in);
    // ArrayList<Student> arr = new ArrayList<>();
    //
    // while (true) {
    //   System.out.println("Enter 1 to Entry new User, 2 to exit");
    //   int a = sc.nextInt();
    //
    //   if (a == 1) {
    //     System.out.println("Enter user id: ");
    //     String id = sc.next();
    //
    //     System.out.println("Enter user name: ");
    //     String name = sc.next();
    //
    //     Student obj = new Student(id, name);
    //     arr.add(obj);
    //   } else if (a == 2) {
    //     break;
    //   } else {
    //     System.out.println("Invalid choice");
    //   }
    // }
    //
    // System.out.println("Students: ");
    // for (Student i : arr) {
    //   i.display();
    // }

    Student s1 = new Student(1, "Mukesh");
    s1.setId(7);
    s1.setName("Mukesh G");
    int cur_id = s1.getId();
    String cur_name = s1.getName();
    System.out.println(cur_id);
    System.out.println(cur_name);
  }
}
