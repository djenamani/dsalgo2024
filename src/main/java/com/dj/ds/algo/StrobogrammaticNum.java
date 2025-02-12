package com.dj.ds.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Any number which appears same if we rotate it 180 degrees (upside down)
 * For Example: 808 and 69 appears same if we flip it upside down
 */
public class StrobogrammaticNum {

    static Map<Character, Character> dictionary = new HashMap<>();

    static {
        dictionary.put('0', '0');
        dictionary.put('1', '1');
        dictionary.put('6', '9');
        dictionary.put('8', '8');
        dictionary.put('9', '6');
    }

    public static boolean isStrobogrammatic(String numStr){

        // Initialize two pointers one at start and other at the end of the string
        int i = 0;
        int j = numStr.length() - 1;

        while (i <= j){
            if(dictionary.get(numStr.charAt(i)) == null ||
                    !dictionary.get(numStr.charAt(i)).equals(numStr.charAt(j)))
            {
                return false;
            }
            i++; j--;

        }
        return true;
    }

    public static void main(String[] args) {
        Arrays.asList("808","123", "69", "11111").stream().forEach(n -> System.out.println(n +" is "+
                (isStrobogrammatic(n) ? "strobogrammatic num" : "not a strobogrammatic num")));
    }
}
