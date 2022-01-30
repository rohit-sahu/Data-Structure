package io.logical;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NonRepeatChar {

    public static String getFirstNonRepeatingChar(String sentence) {
        String word = "";
        LinkedHashMap<String, Integer> count = new LinkedHashMap();
        char[] l = sentence.toCharArray();
        for (int c = 0; c < l.length; c++) {
            if (count.get(String.valueOf(l[c])) != null) {
                count.put(String.valueOf(l[c]), count.get(String.valueOf(l[c])) + 1);
            } else {
                count.put(String.valueOf(l[c]), 1);
            }
        }
        System.out.println(count.toString());
        Set<Map.Entry<String, Integer>> entrySet = count.entrySet();
        for (Map.Entry<String, Integer> e : entrySet) {
            if (e.getValue() <= 1) {
                word = e.getKey();
                return word;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        String str = "This is sentence";
        System.out.println(getFirstNonRepeatingChar(str.toLowerCase()));
    }
}
