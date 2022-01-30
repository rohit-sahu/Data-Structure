package io.logical;

import java.util.Map;
import java.util.TreeMap;

public class CarPolling {

    public static boolean carPooling(int[][] trips, int capacity) {
        int currentPassengers = 0;
        Map<Integer, Integer> timeline = new TreeMap<>();
        for (int[] trip : trips) {
            final int nPassengers = trip[0];
            final int start = trip[1];
            final int end = trip[2];
            timeline.put(start, timeline.getOrDefault(start, 0) + nPassengers);
            timeline.put(end, timeline.getOrDefault(end, 0) - nPassengers);
        }
        for (final int passengerChange : timeline.values()) {
            currentPassengers += passengerChange;
            if (currentPassengers > capacity)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{3, 1, 10},{3, 2, 4},{4, 3, 7}, {3, 5, 7}, {10, 10, 12}}, 10));
    }
}
