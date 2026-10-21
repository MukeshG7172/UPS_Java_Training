import java.util.Scanner;

public class RemoveSpaces {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (!Character.isWhitespace(ch)) {
        sb.append(ch);
      }
    }

    System.out.println(sb);
  }
}
