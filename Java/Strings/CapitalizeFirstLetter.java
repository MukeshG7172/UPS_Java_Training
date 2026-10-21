import java.util.Scanner;

public class CapitalizeFirstLetter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    StringBuilder sb = new StringBuilder(str);

    for (int i = 0; i < sb.length(); i++) {
      if (!Character.isWhitespace(sb.charAt(i))) {
        sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        break;
      }
    }

    System.out.println(sb);
  }
}
