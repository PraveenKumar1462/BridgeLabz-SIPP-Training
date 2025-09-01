package Day1_LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> uppercasedNames = employeeNames.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        uppercasedNames.forEach(System.out::println);
    }
}
