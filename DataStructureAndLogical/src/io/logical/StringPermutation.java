package io.logical;

public class StringPermutation {

    public static void permute(String s, String answer) {
        if (s.length() == 0) {
            System.out.print(answer + "  ");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }

    public static void main(String[] args) {
        String input = "abc";// abc, acb, bac, bca, cab, cba
        //ab, ba, bc, cb, ca, ac -> abc, cab, bac, cab, abc, bca, cab, bac, cba, bac
        permute(input, "");
    }
}
