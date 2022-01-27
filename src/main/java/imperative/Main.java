package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Person> importantPeople = List.of(
                new Person("Kitty",Gender.Female),
                new Person("Doggo",Gender.Male),
                new Person("Shrek",Gender.Male),
                new Person("Donkey",Gender.Male),
                new Person("Dragon",Gender.Female),
                new Person("Princess",Gender.Female)
        );

        //imperative approach
        System.out.println("imperative approach");

        List<Person> imperativeFemaleList = new ArrayList<>();
        for (Person person: importantPeople)
            if(person.getGender().equals(Gender.Female))
                imperativeFemaleList.add(person);

        for (Person person : imperativeFemaleList)
            System.out.println(person);

        //Declarative approach
        System.out.println("\n\n Declarative approach");

        List<Person> declarativeFemaleList = importantPeople.stream()
                .filter(person -> person.getGender().equals(Gender.Female))
                .collect(Collectors.toList());

        declarativeFemaleList.forEach(System.out::println);

    }


}
