import java.util.Scanner;

public class ArraySum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the array size: ");
    int n = sc.nextInt();

    if (n < 0) {
      System.out.println("Array size cannot be negative.");
      sc.close();
      return;
    }

    int[] arr = new int[n];
    long sum = 0;

    System.out.println("Enter the array elements:");

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
    }

    System.out.println("Sum: " + sum);
  }
}
