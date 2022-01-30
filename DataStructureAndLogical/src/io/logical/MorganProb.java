package io.logical;

/**
 * int[]{-2, -3, 4, -1, -2, 1, 5, -3}
 */
public class MorganProb {

    public static int maxSumSubArray(int[] arr) {
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                if(min < sum) {
                    min = sum;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}
