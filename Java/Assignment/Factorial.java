import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a non-negative integer: ");
    int n = sc.nextInt();

    if (n < 0) {
      System.out.println("Factorial is not defined for negative numbers.");
    } else if (n > 20) {
      System.out.println("Number is too large for long.");
    } else {
      long factorial = 1;

      for (int i = 2; i <= n; i++) {
        factorial *= i;
      }

      System.out.println("Factorial: " + factorial);
    }
  }
}
