package io.logical;

/**
 * String str = "Java Programming Skill";
 * Write a pseudocode to find number of workds in this string
 *
 */
public class StringProblems {

    public static void main(String[] args) {
        String str = "Java Programming Skill";
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            String charValue = str.charAt(i) + " ";
            if (charValue.equals("  ")) {
                count++;
            }
        }
        count++;
        System.out.println(count);
    }
}
