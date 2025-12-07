import java.util.Arrays;
import java.util.List;

public class Maximum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        //int max = numbers.stream().max(Integer::compare).get();
        //int max = numbers.stream().max((i,j)-> i.compareTo(j)).get();
        int max = numbers.stream().max((i,j)-> i - j).get();
        System.out.println("Maximum number: " + max);   
    }
}
