package com.sber.dz8;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = scanner.nextInt();
        System.out.print("Введите b: ");
        int b = scanner.nextInt();

        if (b == 0) {
            System.out.println("Ошибка: деление на ноль невозможно!");
            return;
        }

        int quotient = a / b;
        int remainder = a % b;
        System.out.println(a + " / " + b + " = " + quotient + " и " + remainder + " в остатке");

        scanner.close();
    }
}
