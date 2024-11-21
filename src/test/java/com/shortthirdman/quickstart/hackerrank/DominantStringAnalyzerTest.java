package com.shortthirdman.quickstart.hackerrank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominantStringAnalyzerTest {

    DominantStringAnalyzer app;

    @BeforeEach
    void setUp() {
        app = new DominantStringAnalyzer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testDominantStringCount_withDominantSubstrings() {
        String input = "aabb";
        long result = app.getDominantStringCount(input);
        assertEquals(1, result, "There should be one dominant substring.");
    }

    // Positive Test Case 2: String with multiple dominant substrings
    @Test
    void testDominantStringCount_multipleDominantSubstrings() {
        String input = "abccba";
        long result = app.getDominantStringCount(input);
        assertEquals(2, result, "There should be two dominant substrings.");
    }

    // Positive Test Case 3: String that contains only dominant substrings
    @Test
    void testDominantStringCount_allDominant() {
        String input = "aabbcc";
        long result = app.getDominantStringCount(input);
        assertEquals(6, result, "There should be 6 dominant substrings.");
    }

    // Negative Test Case 1: No dominant substrings
    @Test
    void testDominantStringCount_noDominantSubstrings() {
        String input = "abcd";
        long result = app.getDominantStringCount(input);
        assertEquals(0, result, "There should be no dominant substrings.");
    }

    // Edge Case 1: Empty string
    @Test
    void testDominantStringCount_emptyString() {
        String input = "";
        long result = app.getDominantStringCount(input);
        assertEquals(0, result, "An empty string should have 0 dominant substrings.");
    }

    // Edge Case 2: Single character string
    @Test
    void testDominantStringCount_singleCharacterString() {
        String input = "a";
        long result = app.getDominantStringCount(input);
        assertEquals(0, result, "A single character string should have 0 dominant substrings.");
    }

    // Edge Case 3: String of length 1 (no even length substrings)
    @Test
    void testDominantStringCount_stringOfLength1() {
        String input = "a";
        long result = app.getDominantStringCount(input);
        assertEquals(0, result, "A string of length 1 should have no even-length dominant substrings.");
    }

    // Edge Case 4: String with no even-length substrings that are dominant
    @Test
    void testDominantStringCount_noDominantEvenLengthSubstrings() {
        String input = "xyz";
        long result = app.getDominantStringCount(input);
        assertEquals(0, result, "There should be no dominant substrings in a string of length 3.");
    }

    // Edge Case 5: Long string with no dominant substrings
    @Test
    void testDominantStringCount_longStringNoDominantSubstrings() {
        String input = "abcdefgh";
        long result = app.getDominantStringCount(input);
        assertEquals(0, result, "There should be no dominant substrings in this string.");
    }

    // Exception Handling Test: Null string should throw NullPointerException
    @Test
    void testDominantStringCount_nullString() {
        String input = null;
        assertThrows(NullPointerException.class, () -> app.getDominantStringCount(input), "Null input should throw NullPointerException.");
    }

    // Exception Handling Test: String with invalid characters (optional based on assumptions)
    @Test
    void testDominantStringCount_invalidCharacters() {
        String input = "abc123"; // Assuming we only deal with lowercase letters
        assertThrows(IllegalArgumentException.class, () -> app.getDominantStringCount(input), "Invalid input with non-lowercase characters should throw IllegalArgumentException.");
    }
}