import java.util.Scanner;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();

        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<n;i++) {
            int c = sc.nextInt();
            hs.add(c);
        }

        for(int i:hs) {
            System.out.print(i + " ");
        }
        System.out.println("The order is not preserved because it depends on hash values, internal table size and implementation details");
    }
}
