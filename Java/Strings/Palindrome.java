import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    StringBuilder sb = new StringBuilder(str);

    if (str.equalsIgnoreCase(sb.reverse().toString())) {
      System.out.println("Palindrome");
    } else {
      System.out.println("Not a palindrome");
    }
  }
}
