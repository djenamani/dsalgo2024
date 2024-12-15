package com.dj.ds.algo;

import java.util.Arrays;

public class ThreeSumProblem {

    static boolean findSumOfThree(int[] nums, int target){

        // first sort the array in asc order
        // time complexity O(nlog(n)) and space complexity is O(log(n))
        Arrays.sort(nums);
        //Arrays.stream(nums).forEach(System.out::println);

        // Post sorting the array in ascending order we need to traverse the array
        // by keeping the loop iteration restricted to length-2 as i, j and k can't be same
        int triples, low, high;

        for(int i = 0; i < nums.length - 2; i++){

            low = i+1;
            high = nums.length - 1;
            // traverse the list to find the triplets
            while(low < high) {
                triples = nums[i] + nums[low] + nums[high];
                if (triples == target) {
                    return true;
                } else if (triples < target) {
                    // increase the low index
                    low++;
                } else {
                    // reduce the index of high
                    high--;
                }
            }
        }

        // no match found so return false
        return false;
    }

    public static void main(String[] args) {
        boolean isTripletsFound = findSumOfThree(new int[]{2, 4, 3, 10, 1}, 17);
        System.out.println(isTripletsFound);
        isTripletsFound = findSumOfThree(new int[]{3, 7, 1, 2, 8, 4, 5}, 10);
        System.out.println(isTripletsFound);

    }
}
