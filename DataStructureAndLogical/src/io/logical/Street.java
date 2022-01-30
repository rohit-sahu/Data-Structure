package io.logical;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * {1,2,3,4,2,3,4,1,1,3,4,2,1} - 1 4
 * {1,2,3,3,3,2,2,4,5,6,7} - 2 3
 *
 * String 1: FFABABABACCDDEFG -> DFBCA
 * Output:ABCDF
 */
public class Street {

    public static void findMaxDuplicateData(int []arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int frequency = 0;
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            if (frequency == map.get(arr[i]) && number > arr[i]) {

            } else if (map.get(arr[i]) >= frequency) {
                frequency = map.get(arr[i]);
                number = arr[i];
            }
        }
        /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= frequency) {
                frequency = entry.getValue();
                number = entry.getKey();
            }
        }*/
        System.out.println(number + " " + frequency);
    }

    public static void getRepeatingCharInAsc(String str) {
        StringBuilder builder = new StringBuilder("");
        HashMap<Character, Integer> map = new HashMap<>();
        TreeSet<String> sortedSet = new TreeSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
            if (map.get(str.charAt(i)) > 1) {
                sortedSet.add(Character.toString(str.charAt(i)));
            }
        }
        sortedSet.forEach(builder::append);
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        findMaxDuplicateData(new int[]{1,2,3,4,2,3,4,1,1,3,4,2,1});
        findMaxDuplicateData(new int[]{1,2,3,3,3,2,2,4,5,6,7});
        findMaxDuplicateData(new int[]{3,3,3,2,2,2,1,1,1});

        getRepeatingCharInAsc("FFABABABACCDDEFG");
    }
}
