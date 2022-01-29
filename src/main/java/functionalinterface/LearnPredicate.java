package functionalinterface;

import java.util.function.Predicate;

public class LearnPredicate {

    public static void main(String[] args) {

        String ph1 = "+91-89654236";
        String ph2 =  "+91-8965423623";
        String ph3 =  "+92-8965423623";

        //Simple Function
        System.out.println(isValidPhoneNumber(ph1));
        System.out.println(isValidPhoneNumber(ph2));
        System.out.println(isValidPhoneNumber(ph3) + "\n");

        //Predicate Functional Interface
        System.out.println(isValidPhonePredicate.test(ph1));
        System.out.println(isValidPhonePredicate.test(ph2));
        System.out.println(isValidPhonePredicate.test(ph3));

    }

    static boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.length()==14 && phoneNumber.substring(0,4).equals("+91-");
    }

    static Predicate< String> isValidPhonePredicate =
            phoneNumber -> phoneNumber.length()==14 && phoneNumber.substring(0,4).equals("+91-");

}
