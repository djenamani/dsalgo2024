package com.dj.ds.algo;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Sort an unsorted array of integers by using two pointers pattern.
 * The unsorted array only have
 */
public class SortColors {

    public static int[] sortColors(int[] colors){
        // Define three pointers start, current and end
        // start and current will point to the first element of the array and
        // end will point at the end index
        int start = 0; int current = 0; int end = colors.length - 1;

        // Traverse through the array till current is greater than end
        // 1. If current value is 0 then swap the value at start with current and then
        //    increment current and start pointers.
        // 2. If current value is 1 then no swapping required and increment the current pointer
        // 3. Otherwise if the current value is 2 then swap the value at end index and
        //    decrement the end index
        while(current <= end){
            if(colors[current] == 0)
            {
                // swap the current value with the value at start index
                int temp = colors[current];
                colors[current] = colors[start];
                colors[start] = temp;
                start++; current++;
            }
            else if(colors[current] == 1){
                // No need to swap start will stay where it was and increment the current index
                current++;
            }
            else{
                // Otherwise the value is 2, so swap the end value with the current value
                // and decrement the end index
                int temp = colors[end];
                colors[end] = colors[current];
                colors[current] = temp;
                end--;
            }
        }
        return colors;
    }

    public static void main(String[] args) {

        int[] unsortedArray = {1,0,0,2};
        System.out.println(Arrays.toString(unsortedArray));
        System.out.println(Arrays.toString(sortColors(unsortedArray)));

        unsortedArray = new int[]{0, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(unsortedArray));
        System.out.println(Arrays.toString(sortColors(unsortedArray)));

        unsortedArray = new int[]{1, 2, 0};
        System.out.println(Arrays.toString(unsortedArray));
        System.out.println(Arrays.toString(sortColors(unsortedArray)));

    }
}
