package com.sber.dz8;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число (не более 100): ");
        int number = scanner.nextInt();

        if (number < 1 || number > 100) {
            System.out.println("Ошибка: число должно быть от 1 до 100");
            return;
        }

        String roman = convertToRoman(number);
        System.out.println(number + " в римской записи: " + roman);

        scanner.close();
    }

    private static String convertToRoman(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }
}
