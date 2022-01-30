package io.logical;

import java.util.HashMap;
import java.util.*;

public class ArrayProblem {

    public static int maxNoOfOnesInArray(int [][]arr) {
        int count = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[j].length; j++) {
                if (counter.containsKey(arr[i][j])) {
                    if (counter.get(arr[i][j]) == 1) {
                        counter.put(arr[i][j], counter.get(arr[i][j]) + 1);
                    }
                } else {
                    counter.put(arr[i][j], 1);
                }
            }
        }
        return count;
    }

    public static void getTargetFromArray(int arr[], int target) {
        boolean isTargetFound = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("index is - " + i + ", " + j);
                    isTargetFound = true;
                    break;
                }
            }
            if (isTargetFound) {
                break;
            }
        }
    }

    public static void getTargetFromArray2(int arr[], int target) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int j : arr) {
            al.add(j);
        }
        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            if (al.contains(val)) {
                int index = al.indexOf(val);
                System.out.println("index is - " + i + ", " + index);
                break;
            }
        }
    }

    public static int secondHighestNumber(int []arr) {
        int firstMin = Integer.MIN_VALUE;
        int secondMin = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(firstMin < arr[i]) {
                firstMin = arr[i];
            } else if(secondMin < arr[i] && arr[i] != firstMin) {
                secondMin = arr[i];
            }
        }
        if (secondMin == Integer.MIN_VALUE) {
            System.out.print("There is no second largest" + " element\n");
        } else {
            System.out.print("The second largest element" + " is " + secondMin);
        }
        return secondMin;
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 0}, {0, 0, 1, 0}, {1, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(maxNoOfOnesInArray(arr));

        //Target Array test
        int arr1[] = {2,6,5,8,11};
        int target = 14;
        getTargetFromArray(arr1, target);
        getTargetFromArray2(arr1, target);
    }
}
