import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 12/07/24
 * Description: This program is a two player WordPuzzle game where points are appointed with the number of guesses. 
 * The first player to reach 40 points is the winner.
 */


public class Section2 {
    private static final List<String> WORD_LIST = Arrays.asList(
            "Apple", "Ball", "Cat", "Dog", "Elephant", "Fish", "Grape", "Hat", "Ice", "Jump",
            "Key", "Lamp", "Moon", "Nest", "Orange", "Pen", "Queen", "Rainbow", "Sun", "Tree",
            "Umbrella", "Violin", "Water", "Xylophone", "Yellow", "Zebra", "Book", "Chair", "Door", "Egg",
            "Fork", "Guitar", "House", "Ink", "Jacket", "Kite", "Lemon", "Mountain", "Notebook", "Owl",
            "Pencil", "Quilt", "Robot", "Sock", "Table", "Unicorn", "Volcano", "Window", "Yogurt", "Zipper"
    );

    private static final int WIN_SCORE = 40;
    private static final int MAX_GUESSES = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1Score = 0;
        int player2Score = 0;
        int currentPlayer = 1;

        while (player1Score < WIN_SCORE && player2Score < WIN_SCORE) {
            System.out.println("Player " + currentPlayer + "'s turn");
            String word = WORD_LIST.get(random.nextInt(WORD_LIST.size())).toLowerCase();
            String shuffledWord = shuffleWord(word);
            
            System.out.println("Shuffled word: " + shuffledWord.toLowerCase());
            
            int points = playTurn(scanner, word);
            
            if (currentPlayer == 1) {
                player1Score += points;
                System.out.println("Player 1 score: " + player1Score);
            } else {
                player2Score += points;
                System.out.println("Player 2 score: " + player2Score);
            }
            
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        int winner = (player1Score >= WIN_SCORE) ? 1 : 2;
        System.out.println("Player " + winner + " wins!");

        scanner.close();
    }

    private static String shuffleWord(String word) {
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder shuffled = new StringBuilder();
        for (char c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }

    private static int playTurn(Scanner scanner, String word) {
        for (int i = 0; i < MAX_GUESSES; i++) {
            System.out.print("Enter your guess (or 'reveal' to see the word): ");
            String guess = scanner.nextLine().trim();
            
            if (guess.equalsIgnoreCase("reveal")) {
                System.out.println("The word was: " + word);
                return 0;
            }
            
            if (guess.equalsIgnoreCase(word)) {
                System.out.println("Correct! You guessed it in " + (i + 1) + " tries.");
                return MAX_GUESSES - i;
            } else {
                System.out.println("Incorrect. Try again.");
            }
        }
        
        System.out.println("Out of guesses. The word was: " + word);
        return 0;
    }
}