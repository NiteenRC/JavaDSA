package programs.functional;

import java.util.Optional;

public class OptionalUsage {
    public static void main(String[] args) {
        String str = null;

        Optional<String> optional = Optional.ofNullable(str);

        String result = optional.map(String::toUpperCase)
                .orElse("String is null");
        //.orElseGet(() -> "String is null");
        //.orElseThrow(() -> new IllegalArgumentException("String is null"));

        // optional.map(String::toUpperCase).ifPresent(System.out::println);
        // Above prints only if the value is non null

        System.out.println(result);
    }

    /**
     * Use Optional.of(value) when you are sure that the value is not null.
     * This throw NullPointerException if given value is null
     *
     * Use Optional.ofNullable(value) when you are not sure that value may be null.
     *
     */
}
