package optionals;

import java.util.Optional;

public class LearnOptional {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println(optional1);
        System.out.println(optional1.isPresent());
        System.out.println(optional1.isEmpty());

        Optional<String> optional2 = Optional.of("Value");
        System.out.println(optional2);
        System.out.println(optional2.isPresent());
        System.out.println(optional2.isEmpty());

        String val1 = optional1.orElse("It's empty");
        System.out.println(val1);

        String val2 = optional2.orElse("It's empty");
        System.out.println(val2);

        String val3 = optional1.orElseGet(optional2::get);
        System.out.println(val3);

        String val4 = optional1
                .map(String::toUpperCase)
                .orElse("no value");
        System.out.println(val4);

        String val5 = optional1
                .map(String::toUpperCase)
                .orElseGet(() -> optional2
                        .map(String::toUpperCase)
                        .orElse("No value")
                );
        System.out.println(val5);

        optional1.ifPresentOrElse(System.out::println,
                () -> System.out.println("Optional1 is empty")
        );

        optional2.ifPresentOrElse(System.out::println,
                () -> System.out.println("Optional2 is empty")
        );

    }
}
