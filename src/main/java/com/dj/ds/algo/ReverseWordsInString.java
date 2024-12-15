package com.dj.ds.algo;

public class ReverseWordsInString {

    /**
     * Recursive method to reverse the letters in a given char array
     *
     * @param chars
     * @param startRev
     * @param endRev
     */
    private static void reverseString(char[] chars, int startRev, int endRev){
        while (startRev <= endRev){
            char tempChar = chars[startRev];
            chars[startRev] = chars[endRev];
            chars[endRev] = tempChar;
            startRev++; endRev--;
        }
    }


    public static void main(String[] args) {
        String str = " Hello    Dear you are  an awesome person   ";
        str = str.replaceAll("\\s+", " ").trim();
        System.out.println(str);

        char[] chars = str.toCharArray();
        int len = chars.length - 1;

        // reverse the entire string first
        reverseString(chars, 0, len);
        System.out.println(" Reversed String unsorted: \n"+String.valueOf(chars));

        // All reversed words has to be returned to it's actual order one word by one
        for(int start = 0, end = 0; end <= len; end++){
           if((chars[end] == ' ') || end == len){
               int endIdx = (end == len) ? end : end - 1;
               reverseString(chars, start, endIdx);
               start = end + 1;
           }
        }

        System.out.println(" Reversed String: \n ["+String.valueOf(chars)+"]");
    }
}
