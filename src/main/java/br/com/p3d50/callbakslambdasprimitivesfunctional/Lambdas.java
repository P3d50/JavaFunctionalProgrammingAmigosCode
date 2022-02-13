package br.com.p3d50.callbakslambdasprimitivesfunctional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Function<String,String> upperCaseName = name ->{
            if(name.isBlank())
                throw new IllegalArgumentException("blank name");
                return name.toUpperCase();
        };


        BiFunction<String,Integer, String> upperCaseNameBi = (name, age) ->{
            if(name.isBlank())
                throw new IllegalArgumentException("blank name");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("P3d50"));
        System.out.println(upperCaseNameBi.apply("",31));

    }
}
