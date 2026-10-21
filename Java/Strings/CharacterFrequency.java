import java.util.*;
import java.util.Scanner;

public class CharacterFrequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    Map<Character, Integer> m = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      m.put(ch, m.getOrDefault(ch, 0) + 1);
    }

    for (char ch : m.keySet()) {
      System.out.println(ch + ": " + m.get(ch));
    }
  }
}
