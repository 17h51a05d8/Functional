package streams;

import imperative.Person;

import java.util.ArrayList;
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

        boolean allMale = importantPeople.stream()
                .allMatch(malePerson);
        System.out.println(allMale);

        boolean fewFemale = importantPeople.stream()
                .anyMatch(femalePerson);
        System.out.println(fewFemale);

        boolean noMale = importantPeople.stream()
                .noneMatch(malePerson);
        System.out.println(noMale);

        BiFunction<List<Person>, List<Person>, Boolean> compareList = List::equals;

        //maintains order
        List <Person> originalOrder = importantPeople.stream()
                .filter(femalePerson)
                .toList();
        System.out.println("comparing List "+compareList.apply(originalOrder,originalOrder));

        //doesn't maintain order
        List<Person> streamParallel = new ArrayList<>();
        importantPeople.stream()
                .parallel()
                .filter(femalePerson)
                .forEach(streamParallel::add);
        System.out.println("comparing List "+compareList.apply(originalOrder,streamParallel));

        //doesn't maintain order
        List<Person> parallelStream = new ArrayList<>();
        importantPeople.parallelStream()
                .filter(femalePerson)
                .forEach(parallelStream::add);
        System.out.println("comparing List "+compareList.apply(originalOrder,parallelStream));

        //doesn't maintain order
        List<Person> parallelStreamOrdered = new ArrayList<>();
        importantPeople.parallelStream()
                .filter(femalePerson)
                .forEach(parallelStreamOrdered::add);
        System.out.println("comparing List "+compareList.apply(originalOrder,parallelStreamOrdered));

        //maintains order
        List<Person> streamParallelOrdered = new ArrayList<>();
        importantPeople.stream()
                .parallel()
                .filter(femalePerson)
                .forEachOrdered(streamParallelOrdered::add);
        System.out.println("comparing List "+compareList.apply(originalOrder,streamParallelOrdered));

        //maintains order
        List<Person> parallelStreamParallelOrdered = new ArrayList<>();
        importantPeople.parallelStream()
                .parallel()
                .filter(femalePerson)
                .forEachOrdered(parallelStreamParallelOrdered::add);
        System.out.println("comparing List "+compareList.apply(originalOrder,parallelStreamParallelOrdered));
    }

}
