import java.util.Scanner;

public class WordCount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine().trim();
    int count = 0;
    boolean inWord = false;

    for (int i = 0; i < str.length(); i++) {
      if (!Character.isWhitespace(str.charAt(i))) {
        if (!inWord) {
          count++;
          inWord = true;
        }
      } else {
        inWord = false;
      }
    }

    System.out.println("Word count: " + count);
  }
}
