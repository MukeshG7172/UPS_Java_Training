import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    Map<Character, Integer> frequency = new LinkedHashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
