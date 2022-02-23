package io.logical;

import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List list = Arrays.asList(arr);
        int sum = 6;
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if(list.contains(diff)) {
                System.out.println("Pair is - " + arr[i] + ", " + diff);
            }
        }
    }
}
