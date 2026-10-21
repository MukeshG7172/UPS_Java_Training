import java.util.Scanner;

public class VowelCount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine().toLowerCase();
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if ("aeiou".indexOf(ch) != -1) {
        count++;
      }
    }

    System.out.println("Vowel count: " + count);
  }
}
