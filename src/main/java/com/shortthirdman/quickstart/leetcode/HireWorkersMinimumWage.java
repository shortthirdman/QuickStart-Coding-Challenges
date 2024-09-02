package com.shortthirdman.quickstart.leetcode;

import com.shortthirdman.quickstart.common.Worker;

import java.util.*;

/**
 * <b>Minimum Cost to Hire K Workers</b><br/>
 * There are N workers. The i-th worker has a quality[i] and a minimum wage expectation wage[i].<br/>
 *
 * Now we want to hire exactly K workers to form a paid group. When hiring a group of K workers, we must pay them according to the following rules:<br/>
 * 1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.<br/>
 * 2. Every worker in the paid group must be paid at least their minimum wage expectation.<br/>
 *
 * Return the least amount of money needed to form a paid group satisfying the above conditions.<br/>
 *
 * @author shortthirdman
 */
public class HireWorkersMinimumWage {


	public double minCostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Worker> list = new ArrayList<>();
        for (int i = 0; i < wage.length; i++) {
            list.add(new Worker(quality[i], wage[i]));
        }
        list.sort(Comparator.comparing(Worker::getRatio));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        double result = Integer.MAX_VALUE;

        try {
            for (Worker w : list) {
                sum += w.getQuality();
                q.offer(-w.getQuality());

                if (q.size() > K) {
                    int extra = q.poll();
                    sum += extra;
                } else {
					throw new IllegalStateException("Queue is empty or no elements to poll");
				}

                if (q.size() == K) {
                    result = Math.min(result, sum * w.getRatio());
                }
            }
        } catch (NullPointerException npe) {
            System.err.println("Error while in polling in priority queue");
            npe.printStackTrace();
        }

        return result;
    }
}
