package com.shortthirdman.quickstart.codesignal;

import java.util.Arrays;

/**
 * An integer M and a non-empty array A consisting of N non-negative integers are given.
 * All integers in array A are less than or equal to <code>M</code>.
 * A pair of integers <code>(P, Q)</code>, such that <code>0 ≤ P ≤ Q < N</code>, is called a slice of array <code>A</code>.
 * <br></br>
 * The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.
 * <br></br>
 * For example, consider integer M = 6 and array A such that:
 * <pre>
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 5
 *     A[3] = 5
 *     A[4] = 2
 * </pre>
 * There are exactly nine distinct slices:
 * <pre>(0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).</pre>
 *
 * The goal is to calculate the number of distinct slices.
 *
 * @author ShortThirdMan
 */
public class CountDistinctSlices {

    /**
     * Given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.
     * <br>
     * If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
     * @param M integer
     * @param A non-empty array
     * @return number of distinct slices
     */
    public int calculateDistinctSlices(int M, int[] A) {
        int N = A.length;
        if (N < 1 || N > 100000) {
            throw new IllegalArgumentException("Array length should be between 1 and 100000");
        }

        if (M < 0 || M > 100000) {
            throw new IllegalArgumentException("Integer M should be between 0 and 100000");
        }

        boolean isNotInRange = Arrays.stream(A).boxed().anyMatch(n -> n < 0 || n > M);
        if (isNotInRange) {
            throw new IllegalArgumentException("Each element in array should be between 0 and " + M);
        }

        int distinctSlices = 0;

        if (distinctSlices > 1_000_000_000) {
            return 1_000_000_000;
        }

        return distinctSlices;
    }
}
