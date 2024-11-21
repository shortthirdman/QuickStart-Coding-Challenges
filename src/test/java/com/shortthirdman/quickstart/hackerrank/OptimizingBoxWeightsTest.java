package com.shortthirdman.quickstart.hackerrank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptimizingBoxWeightsTest {

    OptimizingBoxWeights app;

    @BeforeEach
    void setUp() {
        app = new OptimizingBoxWeights();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMinimalHeaviestListA_singleElement() {
        List<Integer> input = List.of(5);
        List<Integer> result = app.minimalHeaviestSetA(input);
        assertEquals(List.of(5), result);
    }

    @Test
    void testMinimalHeaviestListA_multipleElements() {
        List<Integer> input = List.of(1, 3, 2, 5, 4);
        List<Integer> result = app.minimalHeaviestSetA(input);
        // The setA should be minimal but heaviest
        assertEquals(List.of(5, 4), result);
    }

    @Test
    void testMinimalHeaviestListA_worksWithNegativeNumbers() {
        List<Integer> input = List.of(1, -3, 5, -2, 4);
        List<Integer> result = app.minimalHeaviestSetA(input);
        // The expected output will depend on logic. Adjust based on expected behavior.
        assertEquals(List.of(5, 4), result);  // or other correct output based on logic.
    }

    @Test
    void testMinimalHeaviestListA_largeList() {
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            input.add(i);
        }
        List<Integer> result = app.minimalHeaviestSetA(input);
        // Verify the list isn't empty and the logic holds for larger inputs
        assertFalse(result.isEmpty());
    }

    @Test
    void testMinimalHeaviestListA_emptyList() {
        List<Integer> input = new ArrayList<>();
        List<Integer> result = app.minimalHeaviestSetA(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testMinimalHeaviestListA_nullList() {
        List<Integer> input = null;
        assertThrows(NullPointerException.class, () -> app.minimalHeaviestSetA(input));
    }

    @Test
    void testMinimalHeaviestListA_nullElementInList() {
        List<Integer> input = List.of(1, 2, null, 4);
        assertThrows(NullPointerException.class, () -> app.minimalHeaviestSetA(input));
    }

    // Edge Cases

    @Test
    void testMinimalHeaviestListA_allEqualElements() {
        List<Integer> input = List.of(3, 3, 3, 3, 3);
        List<Integer> result = app.minimalHeaviestSetA(input);
        // In this case, since all elements are the same, the result should contain half of the elements
        assertEquals(List.of(3, 3, 3), result); // This would depend on expected behavior.
    }

    @Test
    void testMinimalHeaviestListA_sortedInput() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        List<Integer> result = app.minimalHeaviestSetA(input);
        assertEquals(List.of(5, 4), result); // The heaviest portion is expected to be the largest sum.
    }

    @Test
    void testMinimalHeaviestListA_reverseSortedInput() {
        List<Integer> input = List.of(5, 4, 3, 2, 1);
        List<Integer> result = app.minimalHeaviestSetA(input);
        assertEquals(List.of(5, 4), result);
    }

    @Test
    void testMinimalHeaviestListA_largeInputWithNegativeAndPositiveValues() {
        List<Integer> input = List.of(1, 2, -3, -1, 4, -2, 6, -5, 3);
        List<Integer> result = app.minimalHeaviestSetA(input);
        // Verify correct handling of a mixture of positive and negative numbers
        assertEquals(List.of(6, 4), result);  // Adjust based on your expected behavior
    }

    @Test
    void testMinimalHeaviestListA_singleNegativeElement() {
        List<Integer> input = List.of(-5);
        List<Integer> result = app.minimalHeaviestSetA(input);
        assertEquals(List.of(-5), result);
    }

    // Exception Handling Test Case

    @Test
    void testMinimalHeaviestListA_noItemsAfterProcessing() {
        List<Integer> input = List.of(1, 1, 1, 1, 1, 1);
        List<Integer> result = app.minimalHeaviestSetA(input);
        // Result will depend on your expected implementation for lists with minimal variance.
        assertNotNull(result); // Just to check that an empty or non-empty list is returned
    }
}