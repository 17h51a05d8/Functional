package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class LearnSupplier {

    public static void main(String[] args) {

        System.out.println(getURL());

        System.out.println(getSuppliedURL.get());

        System.out.println(getSuppliedURLS.get());

    }

    static String getURL(){
        return "jdbc://localhost:8080/SimpleFunction";
    }

    static Supplier<String> getSuppliedURL = () ->  "jdbc://localhost:8080/Supplier";

    static Supplier <List<String>> getSuppliedURLS = () ->
            List.of(
                    "jdbc://localhost:8080/Supplier1",
                    "jdbc://localhost:8080/Supplier2",
                    "jdbc://localhost:8080/Supplier3"
            );

}
