/**
 * Module 5 Critical Thinking
 * Megan M. Wright
 * Colorado State University Global
 * CSC400-1: Data Structures and Algorithms
 * Professor Pensado, Herbert
 * DJanuary 19th, 2024
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CT5Option2StringObjects {

    // This method is looking for the maximum string length present in the array
    public static int findMaxStringLength(String[] wordList) {
        int longestLength = 0;
        for (String word : wordList) {
            if (word.length() > longestLength) {
                longestLength = word.length();
            }
        }
        return longestLength;
    }

    // This is the 'Radix Sort' method for string sorting
    public static void radixSortStrings(String[] wordList) {
        int maxWordLength = findMaxStringLength(wordList);

        // This is sorting the each string from right to left characters 
        for (int position = maxWordLength - 1; position >= 0; position--) {
            sortBasedOnCharacter(wordList, position);
        }
    }

    // This is a helper method to sort strings based on a specific character position
    private static void sortBasedOnCharacter(String[] wordList, int charPosition) {
        // Create 27 buckets (26 letters + 1 for shorter strings)
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            buckets.add(new ArrayList<>());
        }

        // THis is placing words into the right buckets based on the character at the current position
        for (String word : wordList) {
            int bucketIndex;
            if (charPosition < word.length()) {
                bucketIndex = word.charAt(charPosition) - 'a' + 1;
            } else {
                bucketIndex = 0; // smaller words are going into the first bucket
            }
            buckets.get(bucketIndex).add(word);
        }

        // THis is rebuilding the array from the buckets
        int index = 0;
        for (List<String> bucket : buckets) {
            for (String word : bucket) {
                wordList[index++] = word;
            }
        }
    }

    // This is the main method that will provide the testing array and call methods for result.
    public static void main(String[] args) {
        String[] wordList = {"joke", "book", "back", "dig", "desk", "word", "fish", "ward", "dish", "wit", "deed", "fast", "dog", "bend"};

        System.out.println("The Original Array: " + Arrays.toString(wordList));
        radixSortStrings(wordList);
        System.out.println("The Sorted Array: " + Arrays.toString(wordList));
    }
}
