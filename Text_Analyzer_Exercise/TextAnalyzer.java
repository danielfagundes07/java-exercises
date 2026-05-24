// TextAnalyzer.java
package exercises.Text_Analyzer_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TextAnalyzer {
    private final String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public void wordCounter() {
        String[] tokens = text.split("[\\s,\\.]+");
        long words = java.util.Arrays.stream(tokens).filter(t -> !t.isEmpty()).count();
        System.out.println("Total words: " + words);
    }

    public void sentenceCounter() {
        String[] sentences = text.split("[,\\.]+");
        System.out.println("Total sentences: " + sentences.length);
    }

    public void paragraphCounter() {
        String[] paragraphs = text.split("\\.");
        System.out.println("Total paragraphs: " + paragraphs.length);
    }

    public void averageWordLength() {
        String[] tokens = text.split("[\\s,\\.]+");
        int sumCharacters = 0, words = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                sumCharacters += token.length();
                words++;
            }
        }
        if (words > 0) {
            double avg = (double) sumCharacters / words;
            System.out.printf("Average Word Length: %.2f%n", avg);
        }
    }

    public void mostFrequentWords() {
        String[] tokens = text.split("[\\s,\\.]+");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                token = token.toLowerCase();
                frequencyMap.put(token, frequencyMap.getOrDefault(token, 0) + 1);
            }
        }
        var topWords = frequencyMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Most frequent words:");
        topWords.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    public void readingTimeEstimate() {
        String[] tokens = text.split("[\\s,\\.]+");
        long words = java.util.Arrays.stream(tokens).filter(t -> !t.isEmpty()).count();
        if (words > 0) {
            double minutes = (double) words / 200;
            System.out.printf("Estimated reading time: %.2f minutes%n", minutes);
        }
    }

    public void summaryReport() {
        System.out.println("----- Summary Report -----");
        wordCounter();
        sentenceCounter();
        paragraphCounter();
        averageWordLength();
        mostFrequentWords();
        readingTimeEstimate();
        System.out.println("--------------------------");
    }
}
