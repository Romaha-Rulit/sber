import java.util.Scanner;
import java.util.Random;
class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char secretLetter = (char) ('A' + random.nextInt(26));

        System.out.println("=== ИГРА \"УГАДАЙ БУКВУ\" ===");
        System.out.println("Загадана буква от A до Z. Попробуйте угадать!");

        int attempts = 0;
        boolean guessed = false;

        while (!guessed) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Ошибка: введите одну букву от A до Z");
                continue;
            }

            char userGuess = input.charAt(0);
            attempts++;

            if (userGuess == secretLetter) {
                System.out.println("Right!");
                System.out.println("Вы угадали с " + attempts + " попытки!");
                guessed = true;
            } else if (userGuess < secretLetter) {
                System.out.println("You're too low");
            } else {
                System.out.println("You're too high");
            }
        }

        scanner.close();
    }
}