import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 3; // Number of rounds
        int maxAttempts = 5; // Maximum attempts per round
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess the number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1) * 10; // Points based on remaining attempts
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was: " + randomNumber);
            }
        }

        System.out.println("\nGame over! Your total score is: " + score);
        scanner.close();
    }
}
