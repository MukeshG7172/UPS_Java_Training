// class A extends Thread {
//   public void run() {
//     try {
//       sleep(1000);
//       System.out.println("Task A");
//     } catch (Exception e) {
//       System.out.println(e);
//     }
//   }
// }
//
// class B extends Thread {
//   public void run() {
//     System.out.println("Task B");
//   }
// }

class Main {
  public static void main(String[] args) {
    // A t1 = new A();
    // B t2 = new B();
    //
    // t1.start();
    // t2.start();

    Object obj = new Object();
    Thread t1 =
        new Thread(
            () -> {
              synchronized (obj) {
                System.out.println("Thread 1 is running");
                try {
                  obj.wait();
                } catch (InterruptedException e) {
                  System.out.println(e);
                }
                System.out.println("Thread 1 is resumed");
              }
            });

    t1.start();
    Thread t2 =
        new Thread(
            () -> {
              synchronized (obj) {
                System.out.println("Thread 2 is running");
                obj.notify();
                System.out.println("Thread 1 is notified");
              }
            });
    try {
      t1.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }

    t2.start();
  }
}
