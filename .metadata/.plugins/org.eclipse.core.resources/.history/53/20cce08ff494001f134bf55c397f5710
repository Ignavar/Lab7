package StringPermutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringPermutations {

    /**
     * Generates all permutations of a given string using recursion.
     * Handles duplicate characters if excludeDuplicates is true.
     *
     * @param str             The input string
     * @param excludeDuplicates If true, removes duplicate permutations from the results
     * @return List of all unique or all permutations depending on excludeDuplicates
     */
    public static List<String> generatePermutations(String str, boolean excludeDuplicates) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return permutations; // Return an empty list for empty input
        }
        Set<String> uniquePermutations = new HashSet<>();
        permute(str.toCharArray(), 0, permutations, uniquePermutations, excludeDuplicates);
        return permutations;
    }

    /**
     * Helper method to generate permutations by recursively swapping characters.
     *
     * @param chars         Character array of the string
     * @param index         Current index for swapping
     * @param permutations  List to store generated permutations
     * @param uniquePermutations Set to store unique permutations if excludeDuplicates is true
     * @param excludeDuplicates Boolean to decide whether to filter duplicates
     */
    private static void permute(char[] chars, int index, List<String> permutations, Set<String> uniquePermutations, boolean excludeDuplicates) {
        if (index == chars.length - 1) {
            String perm = new String(chars);
            if (excludeDuplicates) {
                if (uniquePermutations.add(perm)) {
                    permutations.add(perm);
                }
            } else {
                permutations.add(perm);
            }
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1, permutations, uniquePermutations, excludeDuplicates);
            swap(chars, index, i); // backtrack
        }
    }

    /**
     * Helper method to swap characters in an array.
     *
     * @param chars Character array
     * @param i     First index
     * @param j     Second index
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the input string
        System.out.print("Enter a string to generate permutations: ");
        String input = scanner.nextLine();

        // Prompt the user for duplicate exclusion choice
        System.out.print("Exclude duplicates (yes/no)? ");
        boolean excludeDuplicates = scanner.nextLine().trim().equalsIgnoreCase("yes");

        // Generate permutations
        List<String> permutations = generatePermutations(input, excludeDuplicates);
        
        System.out.println("Generated Permutations:");
        permutations.forEach(System.out::println);

        scanner.close();
    }
}
