import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = 0;
        int second = 0;
        boolean hasLargest = false;
        boolean hasSecond = false;

        for (int x : arr) {
            if (!hasLargest || x > largest) {
                if (hasLargest) {
                    second = largest;
                    hasSecond = true;
                }
                largest = x;
                hasLargest = true;
            } else if (x < largest && (!hasSecond || x > second)) {
                second = x;
                hasSecond = true;
            }
        }

        if (hasSecond) {
            System.out.println("Second largest: " + second);
        } else {
            System.out.println("No second-largest distinct element");
        }
    }
}
