package io.logical;

import java.util.Arrays;

public class PlatformProblem {

    // Returns minimum number of platforms required
    static int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }
            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }
        return result;
    }

    public static int getMinNoOfPlatform(int[] a, int[] b) {
        Arrays.sort(b);
        int minPlatform = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= b[index]) {
                minPlatform++;
            } else {
                index++;
            }
        }
        return minPlatform;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        //int depsor[] = { 910, 1120, 1130, 1200, 1900, 2000 };
        int n = arr.length;
        //System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
        System.out.println("Minimum Number of Platforms Required = " + getMinNoOfPlatform(arr, dep));

        double[] arrival = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 };
        double[] departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 };
        System.out.print("The minimum platforms needed is " + getMinNoOfPlatform(arrival, departure));
    }

    public static int getMinNoOfPlatform(double[] a, double[] b) {
        Arrays.sort(b);
        int minPlatform = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= b[index]) {
                minPlatform++;
            } else {
                index++;
            }
        }
        return minPlatform;
    }
}
