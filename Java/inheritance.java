class Animal {
  String a;

  Animal(String a) {
    System.out.println(a);
    this.a = a;
  }

  protected void display() {
    System.out.println("I am an Animal");
  }

  protected void canFly(boolean cf) {
    if (cf) System.out.println("I can Fly");
    else System.out.println("I cannot Fly");
  }
}

class Sound extends Animal {
  protected void display() {
    System.out.println("Sounding");
  }

  Sound(String name) {
    super(name);
    System.out.println("Sound");
  }

  protected void makeSound(String cs) {
    System.out.println("I " + cs);
  }
}

class Lion extends Sound {
  String ms = "Roar";

  Lion() {
    super("Lion");
    System.out.println("Lion");
  }

  // public void sound() {
  //   makeSound(ms);
  // }
  //
  // public void fly() {
  //   canFly(false);
  // }
}

class A {
  public static void main(String args[]) {
    // Lion obj = new Lion();
    // obj.display();
    // obj.sound();
    // obj.fly();
    //
    Lion obj1 = new Lion();
    obj1.display();
  }
}
