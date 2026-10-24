
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("You have entered an empty String");
            return;
        }

        LinkedHashMap<String, Integer> mpp = new LinkedHashMap<>();
        String[] data = s.split("\\s+");

        String mostFreq = "";
        int mx = 0;

        for (String i : data) {
            String word = i.toLowerCase();
            int count = mpp.getOrDefault(word, 0) + 1;
            mpp.put(word, count);

            if (count > mx) {
                mx = count;
                mostFreq = word;
            }
        }

        for (Map.Entry<String, Integer> i : mpp.entrySet()) {
            System.out.println(i.getKey() + " : " + i.getValue());
        }

        System.out.println("Most frequently occurred: " + mostFreq);
    }
}
