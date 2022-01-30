package io.logical;

import java.util.Arrays;

public class AnagramString {

    static int NO_OF_CHARS = 256;

    /**
     * function to check whether two strings are anagram of each other
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isAnagram(char[] str1, char[] str2) {
        // Get lenghts of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same, then they cannot be anagram
        if (n1 != n2)
            return false;
        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * function to check if two strings are anagrams of each other
     * @param str1
     * @param str2
     * @return
     */
    public static boolean areAnagram(char[] str1, char[] str2) {

        // Create a count array and initialize all values as 0
        int[] count = new int[NO_OF_CHARS];
        int i;

        // For each character in input strings, increment count in the corresponding count array
        for (i = 0; i < str1.length; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }

        // If both strings are of different length.
        // Removing this condition will make the program fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;

        // See if there is any non-zero value in count array
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        char str1[] = {'t', 'e', 's', 't'};
        char str2[] = {'t', 't', 'e', 'w'};
        if (areAnagram(str1, str2))
            System.out.println("The two strings are anagram of each other");
        else
            System.out.println("The two strings are not anagram of each other");
    }
}

