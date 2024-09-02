package com.shortthirdman.quickstart.codesignal;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DriversLapElimination {

    public String[] driversInEliminationOrder(String[][] laps) {
        // Step 1: Parse input into a Map of driver name to their lap times
        Map<String, PriorityQueue<Integer>> lapTimes = new HashMap<>();
        int numLaps = laps.length;

        for (String[] strings : laps) {
            for (String lapInfo : strings) {
                String[] parts = lapInfo.split(" ");
                String name = parts[0];
                int time = Integer.parseInt(parts[1]);

                lapTimes.putIfAbsent(name, new PriorityQueue<>((t1, t2) -> Integer.compare(t2, t1)));
                lapTimes.get(name).add(time);
            }
        }

        // Step 2: Use a min-heap to track the current slowest lap times
        PriorityQueue<String> eliminationOrder = new PriorityQueue<>();

        // Step 3: Process each lap
        for (int lap = 0; lap < numLaps; lap++) {
            // Collect all drivers with the slowest lap time in this round
            PriorityQueue<String> currentEliminations = new PriorityQueue<>();
            int currentMinTime = Integer.MAX_VALUE;

            for (String name : lapTimes.keySet()) {
                PriorityQueue<Integer> times = lapTimes.get(name);
                if (!times.isEmpty() && times.peek() == currentMinTime) {
                    currentEliminations.add(name);
                }
            }

            // Remove all drivers with the slowest time in this round from the lapTimes
            while (!currentEliminations.isEmpty()) {
                String eliminated = currentEliminations.poll();
                eliminationOrder.add(eliminated);
                lapTimes.get(eliminated).poll(); // Remove the slowest lap time
            }

            // Update the currentMinTime to the next slowest time available
            for (String name : lapTimes.keySet()) {
                PriorityQueue<Integer> times = lapTimes.get(name);
                if (!times.isEmpty()) {
                    currentMinTime = Math.min(currentMinTime, times.peek());
                }
            }
        }

        // Step 4: Collect and return the final elimination order
        String[] result = new String[eliminationOrder.size()];
        int index = 0;
        while (!eliminationOrder.isEmpty()) {
            result[index++] = eliminationOrder.poll();
        }
        return result;
    }
}
