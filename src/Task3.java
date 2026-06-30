import java.util.Scanner;

class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String input = scanner.nextLine().trim();

        if (!input.matches("-?\\d+")) {
            System.out.println("Ошибка: введите целое число!");
            return;
        }

        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            System.out.println("Число " + input + " является палиндромом");
        } else {
            System.out.println("Число " + input + " НЕ является палиндромом");
        }

        scanner.close();
    }
}