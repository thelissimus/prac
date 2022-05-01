import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.printf("Guess the number! (between %d and %d)\n", GUESS_RANGE_MIN, GUESS_RANGE_MAX);

        final int secretNumber = getRandomInt(GUESS_RANGE_MIN, GUESS_RANGE_MAX);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input your guess");
            String input = scanner.nextLine();
            int guess;

            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println("Please enter a number!");
                continue;
            }

            if (guess == secretNumber) {
                System.out.println("You win!");
                break;
            } else if (guess > secretNumber) {
                System.out.println("Too big!");
            } else {
                System.out.println("Too small!");
            }
        }
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static final int GUESS_RANGE_MIN = 1;
    public static final int GUESS_RANGE_MAX = 100;
}
