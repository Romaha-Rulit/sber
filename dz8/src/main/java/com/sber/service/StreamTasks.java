package com.sber.service;

import com.sber.model.Order;
import com.sber.model.Student;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks {

    // ===== Задача 1: Фильтрация строк =====
    public static void filterStrings(List<String> strings, String substring) {
        System.out.println("=== Задача 1: Фильтрация строк, содержащих \"" + substring + "\" ===");
        System.out.println("Исходный список: " + strings);

        List<String> result = strings.stream()
                .filter(s -> s.contains(substring))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Результат: " + result);
        System.out.println();
    }

    // ===== Задача 2: Группировка студентов по курсу + средний возраст =====
    public static void groupStudentsByCourse(List<Student> students) {
        System.out.println("=== Задача 2: Группировка студентов по курсу ===");
        System.out.println("Исходный список:");
        students.forEach(System.out::println);

        Map<Integer, Double> averageAgeByCourse = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourse,
                        Collectors.averagingInt(Student::getAge)
                ));

        System.out.println("\nСредний возраст по курсам:");
        averageAgeByCourse.forEach((course, avgAge) ->
                System.out.printf("  Курс %d: средний возраст = %.1f%n", course, avgAge));
        System.out.println();
    }

    // ===== Задача 3: Анализ заказов =====
    public static void analyzeOrders(List<Order> orders) {
        System.out.println("=== Задача 3: Анализ заказов ===");
        System.out.println("Исходный список:");
        orders.forEach(System.out::println);

        // Заказ с максимальной суммой
        orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount))
                .ifPresent(order -> System.out.println("\nЗаказ с максимальной суммой: " + order));

        // Заказ с минимальной суммой
        orders.stream()
                .min(Comparator.comparingDouble(Order::getAmount))
                .ifPresent(order -> System.out.println("Заказ с минимальной суммой: " + order));

        // Сумма всех заказов за определенный месяц (например, январь 2024)
        Month targetMonth = Month.JANUARY;
        int targetYear = 2024;

        double totalForMonth = orders.stream()
                .filter(o -> o.getDate().getMonth() == targetMonth && o.getDate().getYear() == targetYear)
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.printf("Сумма всех заказов за %s %d: %.2f%n", targetMonth, targetYear, totalForMonth);
    }
}
