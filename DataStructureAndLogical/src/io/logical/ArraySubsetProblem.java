package io.logical;

import java.util.ArrayList;

public class ArraySubsetProblem {

    public static boolean findSubset(int[] arr, int sum, int start) {
        boolean res = Boolean.FALSE;
        ArrayList<Integer> datas = new ArrayList<>();
        for (int a : arr) {
            datas.add(a);
        }
        if (arr[start] > sum) {
            findSubset(arr, sum, start + 1);
        }
        int d = sum - arr[start];
        if (datas.contains(d)) {
            System.out.println("index is - " + start + ", " + datas.indexOf(d));
            res = Boolean.TRUE;
            return res;
        } else {
            findSubset(arr, d, start + 1);
        }
        return res;
    }

    // Returns true if there is a subset
    // of set[] with sum equal to given sum
    static boolean isSubsetSum(int set[],
                               int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 34, 4, 12, 5, 2};//(4, 5)
        int[] arr2 = {3, 34, 4, 12, 2};//(3,4, 2) 6 4 2
        int[] arr3 = {34, 3, 1, 4, 12, 2};//(3,4, 2) -  6 5 1
        int sum = 9;
        //System.out.println(findSubset(arr1, sum, 0));
        System.out.println(isSubsetSum(arr1, arr1.length, sum));
    }
}
