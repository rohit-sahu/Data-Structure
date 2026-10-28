package io.java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");
        Person alex2 = new Person(4, "Alex4", "Kolen");
        Person alex3 = new Person(5, "Alex5", "Kolen");
        Person alex4 = new Person(6, "Alex5", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(alex2, lokesh, brian, alex, lokesh, brian, lokesh, alex3, alex4);

        List<Person> distinctElements = list.stream()
                .filter(person -> person.getId() != 4)
                .distinct()
                .collect(Collectors.toList());

        distinctElements.forEach(person -> System.out.println(person.getId()));

        System.out.println("==================================New Elements==========================");

        distinctElements = list.stream()
                .filter(person -> person.getId() == 4)
                .collect(Collectors.toList());

        distinctElements.forEach(person -> System.out.println(person.getId()));

        System.out.println("==================================New Element Distinct By Name==========================");

        Function<? super Person, Object> keyExtractor = new Function<Person, Object>() {
            @Override
            public Object apply(Person name) {
                return name.getFname();
            }
        };

        list.stream()
                .filter(person ->  person.getId() != 4)
                //.filter(distinctByName(Person::getFname))
                .filter(distinct(keyExtractor))
                .forEach(person -> System.out.println(person.getId()));

        System.out.println("==================================New Element Distinct By Key==========================");

        HashMap<Integer, Person> map = new HashMap<>();
        map.put(1, lokesh);
        map.put(2, brian);
        map.put(3, alex);
        map.put(4, alex2);
        map.put(5, alex3);
        map.put(6, lokesh);
        map.put(7, alex4);

        System.out.println("==================================Even Num Infinite Stream==========================");

        Stream<Integer> evenNumInfiniteStream = Stream.iterate(2, n -> n + 2);
        List<Integer> newList = evenNumInfiniteStream.filter(i -> i != 6).limit(10)
                .collect(Collectors.toList());
        newList.forEach(System.out::println);

        System.out.println("================================== Function map==========================");

        List<String> names = List.of("alice", "bob", "charlie");
        // Convert each string to uppercase (1:1 mapping)
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperNames); // Output: [ALICE, BOB, CHARLIE]

        System.out.println("================================== Function flatMap==========================");
        List<List<String>> nestedList = List.of(
                List.of("Apple", "Banana"),
                List.of("Orange", "Mango")
        );

        // Flatten the list of lists into a single list of strings
        List<String> flatList = nestedList.stream()
                .flatMap(List::stream) // Converts each List into a Stream
                .collect(Collectors.toList());

        System.out.println(flatList); // Output: [Apple, Banana, Orange, Mango]

        System.out.println("================================== Function sorted natural order==========================");

        List<Integer> numbers = List.of(5, 2, 8, 1, 3);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);// Output: [1, 2, 3, 5, 8]

        System.out.println("================================== Function sorted descending order==========================");
        numbers.stream()
                .sorted((a, b) -> b - a) // Sort in descending order
                .forEach(System.out::println); // Output: 8, 5, 3, 2, 1

        List<String> fruits = List.of("Banana", "Apple", "Orange");
        List<String> reverseFruits = fruits.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(reverseFruits); // Output: [Orange, Banana, Apple]

        List<Person> sortedPersonByName = list.stream()
                .sorted(Comparator.comparing(Person::getFname))
                //.sorted((p1, p2) -> p1.getFname().compareTo(p2.getFname()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(sortedPersonByName); // Output: [Alex, Brian, Lokesh]
    }

    private static <T> Predicate<T> distinct(Function<? super T, Object> keyExtractor) {
        HashMap<Object, Boolean> seen = new HashMap<>();
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
            }
        };
        //return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
