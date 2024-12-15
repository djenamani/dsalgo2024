package com.dj.ds.algo;

/**
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string. Otherwise, return FALSE.
 *
 * A certain word "calendar" can be abbreviated as follows:
 *
 * "cal3ar" ("cal end ar" skipping three characters "end" from the word "calendar" still matches the provided abbreviation)
 * "c6r" ("c alenda r" skipping six characters "alenda" from the word "calendar" still matches the provided abbreviation)
 */
public class WordAbbreviation {

    public static boolean validWordAbbreviation(String word, String abbr) {
        // define two pointers as 0 for word and abbr
        int wordIdx = 0;
        int abbrIdx = 0;

        // traverse the abbr till it reaches the end
        while(abbrIdx < abbr.length()){
            // check if the char at abbrIdx is a digit
            if(Character.isDigit(abbr.charAt(abbrIdx))){
                // return false if the digit is 0
                if(abbr.charAt(abbrIdx) == '0'){
                    return false;
                }
                int num = 0;
                // if leading character is a digit
                while(abbrIdx < abbr.length() && Character.isDigit(abbr.charAt(abbrIdx))){
                    num = num * 10 + abbr.charAt(abbrIdx) - '0';
                    abbrIdx++;
                }

                wordIdx += num;

            }
            else{
                if(wordIdx >= word.length() || word.charAt(wordIdx) != abbr.charAt(abbrIdx)){
                    return false;
                }
                wordIdx++;
                abbrIdx++;
            }
        }
        // Replace the following return statement with your code
        return abbrIdx == abbr.length() && wordIdx == word.length();
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("calendar", "cal3ar"));
        System.out.println(validWordAbbreviation("calendar", "c6r"));
        System.out.println(validWordAbbreviation("calendar", "c8r"));
        System.out.println(validWordAbbreviation("calendar", "c06r"));
        System.out.println(validWordAbbreviation("internationalization", "13iz4n"));

    }

}
