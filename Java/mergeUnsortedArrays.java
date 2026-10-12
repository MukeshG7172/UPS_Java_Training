import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int size1 = input.nextInt();
    int[] first = new int[size1];

    for (int i = 0; i < size1; i++) {
      first[i] = input.nextInt();
    }

    int size2 = input.nextInt();
    int[] second = new int[size2];

    for (int i = 0; i < size2; i++) {
      second[i] = input.nextInt();
    }

    int[] merged = new int[size1 + size2];

    for (int i = 0; i < size1; i++) {
      merged[i] = first[i];
    }

    for (int i = 0; i < size2; i++) {
      merged[size1 + i] = second[i];
    }

    int length = merged.length;

    for (int i = 0; i < length - 1; i++) {
      for (int j = 0; j < length - i - 1; j++) {
        if (merged[j] > merged[j + 1]) {
          int temp = merged[j + 1];
          merged[j + 1] = merged[j];
          merged[j] = temp;
        }
      }
    }

    for (int i = 0; i < length; i++) {
      System.out.print(merged[i] + " ");
    }

    input.close();
  }
}
