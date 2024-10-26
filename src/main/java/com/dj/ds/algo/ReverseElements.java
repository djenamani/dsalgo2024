package com.dj.ds.algo;

/**
 * Reverse elements in a string by using the pattern of 2 pointers
 *
 * @author Dibyendu Jenamani
 * @Date   26-OCT-2024
 */
public class ReverseElements {

    static String reverse(String input){
        char[] chars = input.toCharArray();

        int i = 0, j = input.length() - 1;

        //System.out.println(i +" "+ j);
        // start the pointers from both the directions i starting from index 0 and
        // j starts from last index till both the pointers cross each other
        // [s, t, r, i, n, g]

        while(i < j){
            System.out.println(chars[i] + " " + chars[j]);
            // swap them
            char x = chars[i];
            chars[i] = chars[j];
            chars[j] = x;
            i++; j--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("HELLO WINTER!"));
    }
}
