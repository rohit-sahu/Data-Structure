package io.logical;

import java.util.TreeSet;

/**
 * Efficient Java program to sort an
 * array of numbers in range from 1 to n.
 *
 * @author rohit-sahu
 */
public class IntegerArraySort {

    // function for sort array
    static void sortit(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
    }

    static void sortUsingTreeSet(int[] arr, int n) {
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            integers.add(arr[i]);
        }
        integers.forEach(System.out::println);
    }

    // Driver code
    public static void main(String args[]) {
        int[] arr = {10, 7, 9, 2, 8,
                3, 5, 4, 6, 1};
        int n = arr.length;

        // for sort an array
        sortit(arr, n);

        // for print all the
        // element in sorted way
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sortUsingTreeSet(arr, n);
    }
}

