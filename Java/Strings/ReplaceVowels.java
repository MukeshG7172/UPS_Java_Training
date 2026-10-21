import java.util.Scanner;

public class ReplaceVowels {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    StringBuilder sb = new StringBuilder(str);

    for (int i = 0; i < sb.length(); i++) {
      char ch = Character.toLowerCase(sb.charAt(i));

      if ("aeiou".indexOf(ch) != -1) {
        sb.setCharAt(i, '*');
      }
    }

    System.out.println(sb);
  }
}
