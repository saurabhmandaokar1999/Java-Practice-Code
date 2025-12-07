import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountStringswithSpecificPrefix {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        
        //long count = names.stream().filter(s -> s.startsWith("Al")).count();
        long count = names.stream().filter(s -> s.startsWith("Al")).collect(Collectors.counting());
        System.out.println("Count of strings starting with 'Al': " + count);
        
    }
}
