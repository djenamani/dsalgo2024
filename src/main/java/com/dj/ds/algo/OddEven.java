package com.dj.ds.algo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a list of positive numbers, print Even or Odd for the numbers
 * The List may contain duplicates. Skip duplicates and don't take any action on the duplicate number.
 *
 */
public class OddEven {
    /**
     * Predicate function for checking the number is Even or not.
     */
    private Predicate<Integer> isEven = n -> n%2 == 0;

    /**
     * Maintains a Set for checking duplicate entries.
     */
    private Set<Integer> numSet = new HashSet<>();

    /**
     * Print EVEN or ODD on console for every element present inside the list
     *
     * @param numList given list of positive numbers with duplicates
     */
    private void printOddEven(List<Integer> numList){
        numList.stream().forEach(n -> {
            if(!numSet.contains(n)){ // Time complexity of contains(e) is O(1)
                if (isEven.test(n)) {
                    System.out.println(n + " IS EVEN");
                } else {
                    System.out.println(n + " IS ODD");
                }
            }
           numSet.add(n);
        });
    }

    //main method
    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(1,2,3, 1, 5).collect(Collectors.toUnmodifiableList());
        OddEven oddEven = new OddEven();
        oddEven.printOddEven(numbers);
    }
}
