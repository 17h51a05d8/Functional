package imperative;

import java.util.ArrayList;
import java.util.List;

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
        List<Person> females = new ArrayList<>();
        for (Person person: importantPeople)
            if(person.getGender().equals(Gender.Female))
                females.add(person);

        for (Person person : females)
            System.out.println(person);

    }


}
