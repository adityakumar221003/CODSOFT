import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();
    private int randomNumber;
    private int usrGuessNumber;
    private int attempts;
    private int maxAttempts = 5; // Set a limit on the number of attempts
    private int score;

    // Method to generate a random number between 1 and 100
    int generateRandomNumber() {
        return random.nextInt(100) + 1; // Generate number between 1 and 100
    }

    // Method to display the result of the game
    void displayResult(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Congratulations! You have guessed the number correctly.");
            score += (maxAttempts - attempts + 1); // Update score based on attempts
        } else {
            System.out.println("Sorry, you've used all your attempts. The number was " + randomNumber + ".");
        }
        System.out.println("Your score: " + score + "\n");
    }

    // Method to get user input
    void usrInput() {
        attempts = 0; // Reset attempts for the new round
        randomNumber = generateRandomNumber(); // Generate a new random number
        boolean guessedCorrectly = false;

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.println(
                    "Guess a number between 1 to 100. You have " + (maxAttempts - attempts) + " attempts left:");
            usrGuessNumber = input.nextInt();
            attempts++;

            if (usrGuessNumber == randomNumber) {
                guessedCorrectly = true;
            } else if (usrGuessNumber < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        displayResult(guessedCorrectly);
    }

    // Method to play multiple rounds
    void playGame() {
        String playAgain;
        do {
            usrInput();
            System.out.println("Do you want to play again? (yes/no): ");
            playAgain = input.next().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing! Your final score: " + score);
    }

    public static void main(String[] args) {
        NumberGuessGame game = new NumberGuessGame();
        game.playGame(); // Start the game
    }
}