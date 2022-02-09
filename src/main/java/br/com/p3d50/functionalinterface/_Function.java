package br.com.p3d50.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //imperative approach
        int increment = incrementByOne(1);
        System.out.println(increment);

        //declarative approach
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleByTenFunction.apply(increment2);
        System.out.println(multiply);

        int multiply2 = addByOneAndThenMultiplyByTenFunction.apply(3);
        System.out.println(multiply2);

        System.out.println(incrementOneAndMultiplyFunction.apply(4,100));
    }

    //imperative approach
    static int incrementOneAndMultiply(int number, int numToMultiplyBy){
        return (++number)*numToMultiplyBy;
    }

    //declarative approach
    static BiFunction<Integer,Integer,Integer> incrementOneAndMultiplyFunction =
            (numberIncrementByOne,numberToMultiply) ->
                    (++numberIncrementByOne)*numberToMultiply;

    //declarative approach
    static Function<Integer,Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer,Integer> multipleByTenFunction = number -> number*10;

    static Function<Integer,Integer> addByOneAndThenMultiplyByTenFunction =
            incrementByOneFunction.andThen(multipleByTenFunction);

    //imperative approach
    static int incrementByOne(int number){
        return number+1;
    }
}
