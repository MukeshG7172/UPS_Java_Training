import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Streams {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 4, 5, 3, 2);
        // arr.stream().filter(i -> i > 3).
        // forEach(System.out::println);

        // arr.stream().map(i -> i*2).
        // forEach(System.out::println);

        // arr.stream().sorted().
        // forEach(System.out::println);
        
        // arr.stream().distinct().
        // forEach(System.out::println);

        // arr.stream().limit(3).
        // forEach(System.out::println);

        List<Integer> nw = arr.stream().filter(i -> i>2).map(i -> i*i).collect(Collectors.toList());
        for(int i:nw) System.out.println(i);

    }
}
