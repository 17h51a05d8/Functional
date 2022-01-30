package optionals;

import java.util.Optional;

public class Person {
    private final String name;
    private Optional<String> email;

    public Person(String name, String email) {
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.orElse( "Not provided Email");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email=" + email.orElse("Not provided Email") +
                '}';
    }
}
