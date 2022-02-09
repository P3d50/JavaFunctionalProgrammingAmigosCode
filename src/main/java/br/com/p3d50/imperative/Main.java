package br.com.p3d50.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static br.com.p3d50.imperative.Main.Person.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Pedro", MALE),
                new Person("Rafael", MALE),
                new Person("Andrea", FEMALE),
                new Person("Rafaela", FEMALE),
                new Person("Márcia", FEMALE),
                new Person("Alice", FEMALE)
        );
        System.out.println("Imperative approach");
        List<Person> females = new ArrayList<>();

        for(Person person:people){
           if(FEMALE.equals(person.gender))
               females.add(person);
        }

        for(Person person: females){
            System.out.println(person);
        }

        System.out.println("Declarative approach");

        Predicate<Person> isMale = person -> MALE.equals(person.gender);

        people.stream()
                .filter(isMale)
                //.collect(Collectors.toList()) its usefull to return stream resul to a referenced list
                .forEach(System.out::println);

    }



    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        enum Gender{
            MALE,FEMALE
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
