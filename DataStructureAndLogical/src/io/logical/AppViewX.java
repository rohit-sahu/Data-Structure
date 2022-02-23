package io.logical;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Input: “aaaabbbcca”
 *
 * Output: [(“a”,4), (“b”,3), (“c”,2), (“a”,1)]
 */
public class AppViewX {

    public static HashMap<String, Integer> getNoOfCount(String str) {
        HashMap<String, Integer> mapCounter = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (mapCounter.containsKey(str.charAt(i) + "")) {
                mapCounter.put(str.charAt(i) + "", mapCounter.get(str.charAt(i) + "") + 1);
            } else {
                mapCounter.put(str.charAt(i) + "", 1);
            }
        }
        return mapCounter;
    }

    public static void getConsecutiveNoOfCount(String str) {
        String[][] arr = new String[str.length()][2];
        String temp = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                temp = str.charAt(i) + "";
            }
            if (temp.equals(str.charAt(i) + "")) {
                count++;
                if (i == str.length() - 1) {
                    arr[i][0] = temp;
                    arr[i][1] = count + "";
                }
            } else {
                arr[i - 1][0] = temp;
                arr[i - 1][1] = count + "";
                count = 1;
                temp = str.charAt(i) + "";
                if (i == str.length() - 1) {
                    arr[i][0] = temp;
                    arr[i][1] = count + "";
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + ", " + arr[i][1]);
        }
    }

    public static void main(String[] args) {
        //getNoOfCount("aaaabbbcca").entrySet().forEach(System.out::println);
        getConsecutiveNoOfCount("aaaabbbcc");
    }
}
