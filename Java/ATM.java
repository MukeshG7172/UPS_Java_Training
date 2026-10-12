import java.util.ArrayList;
import java.util.Scanner;

class ATM {
  private int id;
  private int balance;

  ATM(int id, int balance) {
    this.id = id;
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public void withdraw(int amount) {
    if (amount > balance) System.out.println("Insufficient Balance");
    balance -= amount;
    System.out.println("Amount successfully withdrawn, Current Available balance: " + balance);
  }
}

class A {
  public static void main(String args[]) {
    ATM obj1 = new ATM(1, 10000);
    ATM obj2 = new ATM(2, 100000);
    ArrayList<ATM> arr = new ArrayList<>();
    arr.add(obj1);
    arr.add(obj2);

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Enter 1 to perform transactions, 2 to exit");
      int a = sc.nextInt();
      if (a == 1) {
        System.out.println("Enter user id: ");
        int usr = sc.nextInt();
        if (usr > arr.size()) System.out.println("Enter user doesn't exits");
        System.out.println("Enter 1 to withdraw, 2 to get Balance");
        int op = sc.nextInt();
        if (op == 1) {
          System.out.println("Enter the amount to be withdrawn");
          int amount = sc.nextInt();
          arr.get(usr - 1).withdraw(amount);
        } else if (op == 2) {
          int balance = arr.get(usr - 1).getBalance();
          System.out.println("Your balance: " + balance);
        } else {
          System.out.println("Invalid operation");
        }
      } else if (a == 2) break;
      else System.out.println("Invalid operation");
    }
  }
}
