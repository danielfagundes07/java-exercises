/*Text Analyzer
Read any .txt file
//1) Classes: FileReader, BufferedReader

Count words, sentences, paragraphs
2) Show menu to user, accept user imput(1-Count words/2-Count sentences/3-Count paragraphs), accept filePath given by user

Most frequent words (frequency array)

Average word length
4) sum of number of characters by the number of words

Reading time estimate

Output summary report
6) Show a simple, yet intuitive Summary of all data listed.
*/


// Main.java
package exercises.Text_Analyzer_Exercise;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please type your current file path (or Q to quit): ");
            String filePath = scanner.nextLine();
            if (filePath.equalsIgnoreCase("Q")) return;

            String fileContent = FileLoader.readFile(filePath);
            TextAnalyzer analyzer = new TextAnalyzer(fileContent);

            boolean quit = false;
            while (!quit) {
                System.out.println("""
                        1 - Count Words
                        2 - Count Sentences
                        3 - Count Paragraphs
                        4 - Summary
                        5 - Quit
                        """);
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> analyzer.wordCounter();
                    case 2 -> analyzer.sentenceCounter();
                    case 3 -> analyzer.paragraphCounter();
                    case 4 -> analyzer.summaryReport();
                    case 5 -> quit = true;
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
