import java.util.Scanner;

class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Решение квадратного уравнения ax² + bx + c = 0");
        System.out.print("Введите a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите c: ");
        double c = scanner.nextDouble();

        // Проверка на вырожденный случай
        if (Math.abs(a) < 1e-10) {
            if (Math.abs(b) < 1e-10) {
                if (Math.abs(c) < 1e-10) {
                    System.out.println("Бесконечное множество корней");
                } else {
                    System.out.println("Корней нет");
                }
            } else {
                double root = -c / b;
                System.out.println("Уравнение линейное, корень: x = " + root);
            }
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("Дискриминант < 0, вещественных корней нет");
        } else if (Math.abs(discriminant) < 1e-10) {
            double root = -b / (2 * a);
            System.out.println("Один корень (D = 0): x = " + root);
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double root1 = (-b + sqrtD) / (2 * a);
            double root2 = (-b - sqrtD) / (2 * a);
            System.out.println("Два корня:");
            System.out.println("x₁ = " + root1);
            System.out.println("x₂ = " + root2);
        }

        scanner.close();
    }
}