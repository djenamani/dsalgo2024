package com.dj.ds.algo;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(SingleTonClass.SingleTonHelper.getInstance());

        // Use Stream API to filter even numbers from a list
        List<Integer> numbers = Arrays.asList(1,2,3,5,6);
        System.out.println(numbers);
        List<Integer> evenNums = numbers.stream().filter(n -> n%2 == 0).collect(Collectors.toUnmodifiableList());
        System.out.println(evenNums);

        List<Integer> is = Stream.of("aa", "b", "abnd").flatMap(s -> s.chars().boxed()).toList();
        System.out.println(is);

        // Sorting objects in a list based on any attribute value for example person's age
        // and return a sorted list without overriding .equals method
        List<Person> persons = Arrays.asList(new Person("Vivaan", 2), new Person("Jadumani", 56),
                new Person("Dibyendu", 25));
        persons.stream().forEach(Person::printName);

        System.out.println("----- POST SORTING ------");
        persons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(Person::printName);

        //sortedList.stream().forEach(Person::printName);

        // Reduce Stream API : It's an intermediate operation to reduce stream of elements in a stream,
        // using a binary operation. For example finding the max number or sum of all the numbers in an integer stream
        Integer sum = Stream.of(1, 4, 34, 5).reduce(Integer::sum).get();
        System.out.println("The sum is : "+ sum);

        // Optinal
        Optional<Integer> max = Stream.of(1,1,1).min(Integer::compareTo);
        System.out.println(max.get());

        // Use predicate<T> functional interface to return non empty strings
        List<String> nonEmptyStrings = Stream.of("", "ab", "abc", "").filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(nonEmptyStrings);

        // Optional<T> is a class which works as an object container and may contain non-null values.
        // This is used to avoid NPE during runtime and to have more readable and cleaner code
        // instead of using old way of Null check handling within the code. Its available since Java 8.
        Optional<String> strOpt = Optional.ofNullable("Reactor is running");
        strOpt.ifPresent(n -> System.out.println(n));


    }

    static class Person implements TestFuncational{
        String name;
        int age;

        public Person(String name, int age){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public void printName() {
            System.out.println(this.name +" :: " +this.age);
        }
    }
}
