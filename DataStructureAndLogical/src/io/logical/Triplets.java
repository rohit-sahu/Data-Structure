package io.logical;

import java.util.Arrays;

public class Triplets {

    public static void findTriplets(int[] arr) {
        Arrays.sort(arr);//{-2, -1, 0, 1, 2, 3}
        for (int i = 0; i < arr.length; i++) {
            int leftData = i + 1;
            int rightData = arr.length - 1;
            while (leftData < rightData) {
                int add = arr[i] + arr[leftData] + arr[rightData];
                if (add == 0) {
                    leftData++;
                    rightData--;
                    System.out.println("Triplets id : " + arr[i] + ", " + arr[leftData] + ", " + arr[rightData]);
                } else if (add > 0) {
                    rightData--;
                } else {
                    leftData++;
                }
            }
        }
    }

    public static void main(String[] args) {
        findTriplets(new int[] {-2, 1, 3, 0, 2, -1});
    }
}
