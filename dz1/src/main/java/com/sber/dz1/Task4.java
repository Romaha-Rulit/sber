package com.sber.dz1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите трёхзначное число: ");
        int n = scanner.nextInt();

        if (n < 100 || n > 999) {
            System.out.println("Ошибка: число должно быть трёхзначным (100-999)");
            return;
        }

        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int units = n % 10;
        int sum = hundreds + tens + units;

        System.out.println("Сумма цифр числа " + n + " = " + sum);

        scanner.close();
    }
}
