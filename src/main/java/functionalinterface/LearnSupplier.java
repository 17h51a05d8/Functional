package functionalinterface;

import java.util.function.Supplier;

public class LearnSupplier {

    public static void main(String[] args) {

        System.out.println(getURL());

        System.out.println(getSuppliedURL.get());

    }

    static String getURL(){
        return "jdbc://localhost:8080/SimpleFunction";
    }

    static Supplier<String> getSuppliedURL = () ->  "jdbc://localhost:8080/Supplier";

}
