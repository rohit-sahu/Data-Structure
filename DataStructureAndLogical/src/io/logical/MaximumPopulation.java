package io.logical;

public class MaximumPopulation {

    public int maximumPopulation(int[][] logs) {
        // years are between 1950 to 2050
        // we can counts all the alive persons in array of size 101
        int[] persons = new int[101];
        // take start and end year from logs
        for (int i = 0; i < logs.length; i++) {
            int start = logs[i][0];
            int end = logs[i][1];
            // increase count of persons array in this range
            for (int j = start - 1950; j < end - 1950; j++) {
                persons[j]++;
            }
        }
        // find maximum population
        int result = -1;
        int year = -1;
        System.out.println(persons[58]);
        for (int i = 0; i < 101; i++) {
            if (persons[i] > result) {
                result = persons[i];
                year = i;
            }
        }
        return year + 1950;
    }

    /**
     * Line sweep algorithm
     * @param logs
     * @return
     */
    public int maximumPopulation1(int[][] logs) {
        int[] arr = new int[101];

        for(int i = 0; i < logs.length; i++) {
            int start = logs[i][0] - 1950;
            int end = logs[i][1] - 1950;
            arr[start]++;
            arr[end]--;
        }

        int res = 0;
        int max = arr[0];
        for(int i = 1; i < 101; i++) {
            arr[i] += arr[i-1];
            if(arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }
        return res+1950;
    }
}
