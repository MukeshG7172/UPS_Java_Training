class parent {
  protected void display() {
    System.out.println("Parent display");
  }
}

class child1 extends parent {
  protected void display() {
    System.out.println("Child1 display");
  }
}

class child2 extends parent {
  protected void display() {
    System.out.println("Child2 display");
  }
}

class A {
  public static float add(int a, float b) {
    float res = a + b;
    return res;
  }

  public static float add(float a, int b) {
    float res = a + b;
    return res;
  }

  public static void main(String[] args) {
    float ans = add(10, 10.0f);
    System.out.println(ans);

    child1 obj1 = new child1();
    obj1.display();

    child2 obj2 = new child2();
    obj2.display();

    main(new char[] {'a'});
  }

  public static void main(char[] args) {
    System.out.println("Char main");
  }
}
