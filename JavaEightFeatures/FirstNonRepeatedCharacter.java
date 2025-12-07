import java.util.Optional;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "swiss";
        Optional<Character> result = input.chars().mapToObj(c -> (char) c).filter(c -> input.indexOf(c) == input.lastIndexOf(c)).findFirst();
        result.ifPresentOrElse(
            c -> System.out.println("First non-repeated character: " + c),
            () -> System.out.println("No non-repeated character found")
        );

    }
}
