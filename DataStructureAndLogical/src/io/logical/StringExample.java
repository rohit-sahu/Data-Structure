package io.logical;

/**
 * enthire.co/codepair/5835/80cb32f2
 */
public class StringExample {
    public static int noOfPalindrome(String str) {
        int indexStart = 0;
        int indexEnd = str.length();
        int count = 1;
        for(int i = 0; i < str.length() / 2; i++) {
            String s1 = str.substring(indexStart, i + 1);
            String s2 = str.substring(str.length() - (i + 1), indexEnd);
            if(s1.equals(s2)) {
                count = count + 2;
                indexStart = i + 1;
                indexEnd = str.length() - (i + 1);
            }
        }
        return count;
    }

    public static void main(String []args) {
        String str = "VOLVO";
        System.out.println(noOfPalindrome(str));
        System.out.println(noOfPalindrome("ghiabcdefhelloadamhelloabcdefghi"));//7
        System.out.println(noOfPalindrome("VALVE"));
    }
}
