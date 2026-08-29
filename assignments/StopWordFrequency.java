package week3.assignments;

import java.util.*;

public class StopWordFrequency {

    public static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // Convert to lowercase and remove punctuation
        feedback = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        // Convert HashMap entries to a list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback = "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
