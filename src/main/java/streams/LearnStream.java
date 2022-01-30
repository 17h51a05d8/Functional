package streams;

import imperative.Person;

import java.util.List;
import java.util.function.*;

import static imperative.Gender.Female;
import static imperative.Gender.Male;

public class LearnStream {

    public static void main(String[] args) {

        List<Person> importantPeople = List.of(
                new Person("Kitty", Female),
                new Person("Doggo",Male),
                new Person("Shrek",Male),
                new Person("Donkey",Male),
                new Person("Dragon",Female),
                new Person("Princess",Female)
        );

        Predicate<Person> femalePerson = p -> p.getGender().equals(Female);
        Predicate<Person> malePerson = p -> p.getGender().equals(Male);
        Function <Person,String> mappingFunction = Person::getName;
        Consumer <String> print = System.out::println;
        IntConsumer intPrint = System.out::println;
        ToIntFunction<String> length = String::length;

        importantPeople.stream()
                .map(mappingFunction)
                .forEach(print);

        System.out.println("\n Names of important Female: \n");

        importantPeople.stream()
                .filter(femalePerson)
                .map(mappingFunction)
                .forEach(print);

        System.out.println("\n Names of important Male: \n");

        importantPeople.stream()
                .filter(malePerson)
                .map(mappingFunction)
                .forEach(print);

        importantPeople.stream()
                .map(mappingFunction)
                .mapToInt(length)
                .forEach(intPrint);
    }

}
