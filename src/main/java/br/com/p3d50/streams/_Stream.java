package br.com.p3d50.streams;

import br.com.p3d50.imperative.Person;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static br.com.p3d50.imperative.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Pedro", MALE),
                new Person("Rafael", MALE),
                new Person("Andrea", FEMALE),
                new Person("Rafaela", FEMALE),
                new Person("Márcia", FEMALE),
                new Person("Alice", FEMALE),
                new Person("Bob",  PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.getName())
                .mapToInt(String::length)
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> person.getGender().equals(FEMALE);
        boolean containsOnlyFemales =
                people.stream().allMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        boolean containsFemales =
                people.stream().anyMatch(personPredicate);
        System.out.println(containsFemales);

        boolean noneMatch =
                people.stream().noneMatch(personPredicate);
        System.out.println(noneMatch);

    }
}
