package com.sber.dz8;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш вес на Земле (кг): ");
        double earthWeight = scanner.nextDouble();

        if (earthWeight <= 0) {
            System.out.println("Ошибка: вес должен быть положительным числом");
            return;
        }

        double moonWeight = earthWeight * 0.17;
        System.out.printf("Вес на Луне: %.2f кг (17%% от земного)%n", moonWeight);

        scanner.close();
    }
}
