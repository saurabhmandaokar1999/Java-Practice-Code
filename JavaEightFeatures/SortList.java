import java.util.Arrays;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 4, 2);
        // Sort the list using Java 8 lambda expression
        //numbers.sort((i,j) -> i - j);
        //numbers.sort(Integer::compareTo);
        //numbers.sort(Integer::compare);
        numbers.sort((i,j) -> i.compareTo(j));
        System.out.println("Sorted List: " + numbers);
    }
    
}
