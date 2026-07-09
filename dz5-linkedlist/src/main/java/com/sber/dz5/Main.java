package com.sber.dz5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация DZ5 ===\n");

        // Работа с файлом (используем ресурс из classpath)
        try {
            String content = Files.readString(Path.of("src/main/resources/input.txt"));
            String[] words = content.split("\\s+");

            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            System.out.println("Частота слов:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        System.out.println("\n=== LinkedList ===\n");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Список: " + list);
        System.out.println("Элемент по индексу 0: " + list.get(0));
        System.out.println("Элемент по индексу 1: " + list.get(1));
        list.remove(1);
        System.out.println("После удаления индекса 1: " + list);
    }
}
