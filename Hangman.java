//Create a hangman game using words in a given file
//Use BufferedFile & FileReader
//Randomly select a word, given a number of columns that the file contains
//Program must keep the selected word
//Program must show the hangman, keep adding features if answer is wrong
//Program must be interactive
//Program must quit if user imput = 'Q'

package exercises;

import java.io.*;
import java.util.*;

public class Hangman {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Luiz Reis\\Desktop\\wordbox.txt";
        List<String> listOfWords = loadWords(filePath);

        if (listOfWords.isEmpty()) {
            System.out.println("No words found in file.");
            return;
        }

        System.out.println("Total words: " + listOfWords.size());

        Random random = new Random();
        String chosenWord = listOfWords.get(random.nextInt(listOfWords.size()));

        System.out.println("Welcome to the Hangman game!\n");
        pause(1500);
        System.out.println("Your word has been chosen!");

        Scanner scanner = new Scanner(System.in);
        char[] mask = new char[chosenWord.length()];
        Arrays.fill(mask, '_');

        int wrongGuess = 0;
        boolean continueGame = true;

        while (continueGame) {
            System.out.print("Continue playing? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.isEmpty()) {
                System.out.println("Please type Y or N.");
                continue;
            }
            if (choice.charAt(0) == 'N') {
                System.out.println("Thanks for playing!");
                break;
            }
            if (choice.charAt(0) != 'Y' && choice.charAt(0) != 'N'){
                System.out.println("Please type a valid choice.");
                continue;
            }

            pause(1000);
            hangmanDrawing(wrongGuess);

            // Print current mask
            for (char c : mask) {
                System.out.printf("%c ", c);
            }
            System.out.println();

            System.out.print("\nYour Guess (or type 'quit' to quit): ");
            String userGuess = scanner.nextLine().trim().toLowerCase();

            if (userGuess.isEmpty()) {
                System.out.println("Please type a letter.");
                continue;
            }
            if (userGuess.equals("quit")) {
                System.out.println("Quitting game...");
                break;
            }

            boolean correct = false;
            char guessChar = userGuess.charAt(0);

            for (int i = 0; i < chosenWord.length(); i++) {
                if (Character.toLowerCase(chosenWord.charAt(i)) == guessChar) {
                    mask[i] = chosenWord.charAt(i);
                    correct = true;
                }
            }

            if (correct) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Wrong letter!");
                wrongGuess++;
            }

            if (new String(mask).equals(chosenWord)) {
                System.out.println("🎉 You guessed the word: " + chosenWord);
                break;
            }

            if (wrongGuess >= 6) {
                hangmanDrawing(wrongGuess);
                System.out.println("Game Over! The word was: " + chosenWord);
                break;
            }
        }

        scanner.close();
    }

    // Load words from file
    private static List<String> loadWords(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return words;
    }

    // Pause helper
    private static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    // Hangman drawing
    static void hangmanDrawing(int wrongGuess) {
        switch (wrongGuess) {
            case 0 -> System.out.println("|");
            case 1 -> System.out.println("|\nO");
            case 2 -> System.out.println("|\nO\n|");
            case 3 -> System.out.println("|\nO\n|\\");
            case 4 -> System.out.println("|\nO\n/|\\");
            case 5 -> System.out.println("|\nO\n/|\\\n \\");
            case 6 -> System.out.println("|\nO\n/|\\\n/ \\\nYOU LOST!");
        }
        System.out.println();
    }
}
