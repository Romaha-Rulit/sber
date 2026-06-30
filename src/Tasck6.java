import java.util.Scanner;
class Tasck6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println(n + " не является простым числом");
            return;
        }

        boolean isPrime = true;

        // Оптимизация: проверяем только до √n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break; // Ранний выход при нахождении делителя
            }
        }

        if (isPrime) {
            System.out.println(n + " является простым числом");
        } else {
            System.out.println(n + " является составным числом");
        }

        scanner.close();
    }
}