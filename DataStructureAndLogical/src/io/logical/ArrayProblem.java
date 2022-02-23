package io.logical;

import java.util.HashMap;
import java.util.*;

public class ArrayProblem {

    public static int maxNoOfOnesInArray(int [][]arr) {
        int count = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
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

    /**
     * Find second highest number
     * arr[]={12, 35, 1, 10, 34, 1};(restrictions-> no-collections,no-sorting)
     *
     * @param arr
     * @return
     */
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

    /**
     * Find non-repeating number (like- 7)
     * arr[]={1,2,2,1,8,8,7,35,35,24,24};(restrictions ->no-collections,no-sorting)
     * @param arr
     * @return
     */
    public static int getNonRepeatingNumber(int[] arr) {
        int maxNumber = Arrays.stream(arr).max().orElse(0);
        int[] countArray = new int[maxNumber + 1];
        int output = 0;
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]] = countArray[arr[i]] + 1;
        }
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 1) {
                output = i;
                break;
            }
        }
        return output;
    }

    /**
     * Find all pairs example If the sum of both the numbers is equal to the sum then print that pair
     * arr[]={1,4,2,5,8,9,7,35,64,24};sum=10;
     *
     * @param arr
     */
    public static void findAllPairTargetSum(Integer []arr, int target) {
        List<Integer> list = Arrays.asList(arr);
        //Collections.addAll(list, arr);// Add the array to list
        for (int i = 0; i < list.size(); i++) {
            int first = list.get(i);
            if (list.contains(target - first)) {
                System.out.println("Pair is - (" + first + ", " + (target - first) + ")");
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 0}, {0, 0, 1, 0}, {1, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(maxNoOfOnesInArray(arr));

        //Target Array test
        int arr1[] = {2,6,5,8,11};
        int target = 14;
        getTargetFromArray(arr1, target);
        getTargetFromArray2(arr1, target);

        System.out.println(getNonRepeatingNumber(new int[]{1,2,2,1,8,8,7,35,35,24,24}));

        findAllPairTargetSum(new Integer[]{1,4,2,5,8,9,7,35,64,24}, 10);
    }
}
