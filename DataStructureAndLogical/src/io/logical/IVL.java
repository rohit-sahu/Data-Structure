package io.logical;

import java.util.Arrays;

/**
 * array[]={1, 60, -10, 70, -80, 85}
 */
public class IVL {

    public static void closetSumToZero(int[] arr) {
        int minSum = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        Arrays.sort(arr);//{-80, -10, 1, 60, 70, 85}
        for(int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] <= minSum && arr[i] + arr[j] > 0) {
                    minSum = arr[i] + arr[j];
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }
        }
        System.out.println("First Number is - " + num1 + " Second Number is - " + num2 + " and sum - " + minSum);
    }

    public static void main(String[] args) {
        closetSumToZero(new int[]{1, 60, -10, 70, -80, 85});
    }
}
