package functionalinterface;

import java.util.function.Function;

public class LearnFunction {
    public static void main(String[] args) {

        Integer val = increment(0);
        System.out.println(val);    //1

        //Function
        val = incrementByOne.andThen(multiplyByTwo).apply(val);
        System.out.println(val);    //4

        val = incrementByOne
                .andThen(multiplyByTwo
                        .andThen(multiplyByTwo)
                        .andThen(incrementByOne)
                        .andThen(multiplyByTwo))
                .apply(val);
        System.out.println(val);    //42
    }

    static int increment(Integer a){return ++a;}

    static Function<Integer, Integer> incrementByOne = num -> ++num;
    static Function<Integer, Integer> multiplyByTwo = num -> 2*num;


}
