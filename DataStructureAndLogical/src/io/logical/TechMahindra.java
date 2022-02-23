package io.logical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TechMahindra {

    public static void findCharCount(String str) {
//        HashMap<String, Integer> countMap = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (countMap.containsKey(str.charAt(i) + "")) {
//                countMap.put(str.charAt(i) + "", countMap.get(str.charAt(i) + "") + 1);
//            } else {
//                countMap.put(str.charAt(i) + "", 1);
//            }
//        }
//        HashMap<Character, Integer> countMap = new HashMap<>();
//        Stream.of(str.toCharArray())..forEach(chars -> {
//            if (countMap.containsKey(chars)) {
//                countMap.put(chars, countMap.get(chars) + 1);
//            } else {
//                countMap.put(chars, 1);
//            }
//        });

//        countMap.entrySet().forEach(stringIntegerEntry -> System.out.println("Count of " + stringIntegerEntry.getKey() + " is " + stringIntegerEntry.getValue()));
//        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
//            System.out.println("Count of " + entry.getKey() + " is " + entry.getValue());
//        }
    }

    public static void main(String[] args) {
        findCharCount("tyuihgfjkaajhhhhiii");
    }
}
