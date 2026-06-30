import java.util.Scanner;

 class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество членов (2 < n < 100): ");
        int n = scanner.nextInt();

        if (n <= 2 || n >= 100) {
            System.out.println("Ошибка: n должно быть в диапазоне (2, 100)");
            return;
        }

        System.out.println("Первые " + n + " членов последовательности Фибоначчи:");

        long first = 0;
        long second = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(first);
            } else if (i == 2) {
                System.out.print(", " + second);
            } else {
                long next = first + second;
                System.out.print(", " + next);
                first = second;
                second = next;
            }
        }
        System.out.println();

        scanner.close();
    }
}