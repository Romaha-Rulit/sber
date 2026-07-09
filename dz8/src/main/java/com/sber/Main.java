package com.sber;

import com.sber.model.Order;
import com.sber.model.Student;
import com.sber.service.StreamTasks;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "JavaScript is great",
                "Python is simple",
                "Java rocks",
                "C++ is powerful",
                "I love Java programming",
                "Rust is safe",
                "javascript everywhere"
        );
        StreamTasks.filterStrings(strings, "java");

        List<Student> students = Arrays.asList(
                new Student("Анна", 20, 1),
                new Student("Борис", 22, 3),
                new Student("Виктор", 19, 1),
                new Student("Галина", 21, 2),
                new Student("Дмитрий", 23, 3),
                new Student("Елена", 20, 2),
                new Student("Жанна", 24, 3),
                new Student("Иван", 18, 1)
        );
        StreamTasks.groupStudentsByCourse(students);

        List<Order> orders = Arrays.asList(
                new Order(1, 15000.50, LocalDate.of(2024, Month.JANUARY, 10)),
                new Order(2, 8500.00, LocalDate.of(2024, Month.JANUARY, 15)),
                new Order(3, 23000.75, LocalDate.of(2024, Month.FEBRUARY, 5)),
                new Order(4, 5000.00, LocalDate.of(2024, Month.MARCH, 20)),
                new Order(5, 42000.00, LocalDate.of(2024, Month.JANUARY, 25)),
                new Order(6, 12000.30, LocalDate.of(2024, Month.FEBRUARY, 14))
        );
        StreamTasks.analyzeOrders(orders);
    }
}
