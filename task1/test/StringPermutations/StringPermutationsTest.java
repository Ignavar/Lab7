package StringPermutations;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StringPermutationsTest {

    @Test
    void testGeneratePermutationsWithDuplicatesExcluded() {
        // Test case with duplicates excluded
        List<String> permutations = StringPermutations.generatePermutations("aab", true);
        assertEquals(3, permutations.size(), "Should have 3 unique permutations when duplicates are excluded");
        assertTrue(permutations.contains("aab"));
        assertTrue(permutations.contains("aba"));
        assertTrue(permutations.contains("baa"));
    }

    @Test
    void testGeneratePermutationsWithDuplicatesIncluded() {
        // Test case with duplicates included
        List<String> permutations = StringPermutations.generatePermutations("aab", false);
        assertEquals(6, permutations.size(), "Should have 6 permutations when duplicates are included");
        assertTrue(permutations.contains("aab"));
        assertTrue(permutations.contains("aab"));
        assertTrue(permutations.contains("aba"));
        assertTrue(permutations.contains("aba"));
        assertTrue(permutations.contains("baa"));
        assertTrue(permutations.contains("baa"));
    }

    @Test
    void testGeneratePermutationsSingleCharacter() {
        // Test case for a single character
        List<String> permutations = StringPermutations.generatePermutations("a", false);
        assertEquals(1, permutations.size(), "Single character should return only one permutation");
        assertTrue(permutations.contains("a"));
    }

    @Test
    void testGeneratePermutationsEmptyString() {
        // Test case for an empty string
        List<String> permutations = StringPermutations.generatePermutations("", false);
        assertTrue(permutations.isEmpty(), "Empty input should return an empty list");
    }

    @Test
    void testGeneratePermutationsUniqueCharacters() {
        // Test case with unique characters
        List<String> permutations = StringPermutations.generatePermutations("abc", false);
        assertEquals(6, permutations.size(), "Should generate 6 unique permutations for 'abc'");
        assertTrue(permutations.contains("abc"));
        assertTrue(permutations.contains("acb"));
        assertTrue(permutations.contains("bac"));
        assertTrue(permutations.contains("bca"));
        assertTrue(permutations.contains("cab"));
        assertTrue(permutations.contains("cba"));
    }

    @Test
    void testGeneratePermutationsNullInput() {
        // Test case for null input
        List<String> permutations = StringPermutations.generatePermutations(null, false);
        assertTrue(permutations.isEmpty(), "Null input should return an empty list");
    }
}
