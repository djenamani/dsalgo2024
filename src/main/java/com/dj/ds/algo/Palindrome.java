package com.dj.ds.algo;

/**
 * Class file to check whther an input array or string is palindrome or not.
 * Palindrome Definition: Is the sequence which can be read same forward and backward.
 * Ex: 'madam', 'racecar' are palindrome but 'xyzabc' is not palindrome
 *
 * Solution: Use two pointer pattern to verify and return a boolean value
 *
 * @author Dibyendu Jenamani
 * @Date   26-OCT-2024
 */
public class Palindrome {

    static boolean isPalindrome(String input){

        char[] chars = input.toCharArray();
        int i = 0, j = input.length() - 1;
        // traverse elements in the array till they meet
        while (i < j){
            if(chars[i] == chars[j]){
                i++; j--;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
    }
}
