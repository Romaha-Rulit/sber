package com.sber.dz7;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DZ7: Сериализация и работа с файлами ===\n");

        // 1. Удаление лишних пробелов
        System.out.println("1. Очистка файла Borodino.txt");
        String cleaned = removeExtraSpaces(
                "src/main/resources/Borodino.txt",
                "src/main/resources/Borodino_cleaned.txt"
        );
        System.out.println("Результат:\n" + cleaned);

        // 2. Сортировка имен
        System.out.println("\n2. Сортировка имен");
        List<String> sortedNames = sortNames(
                "src/main/resources/listNames.txt",
                "src/main/resources/listNames_sorted.txt"
        );
        System.out.println("Отсортированные имена: " + sortedNames);

        // 3. Сериализация героя
        System.out.println("\n3. Сериализация героя");
        Hero hero = new Hero("Артур", 5,
                new Weapon("Рапира", 50),
                new Armor("Латы", 30)
        );
        System.out.println("Герой до сериализации: " + hero);

        saveHero(hero, "hero.ser");
        Hero loaded = loadHero("hero.ser");
        System.out.println("Герой после десериализации: " + loaded);
        System.out.println("Объекты равны: " + hero.equals(loaded));
    }

    public static String removeExtraSpaces(String inputFile, String outputFile) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line.trim().replaceAll("\\s+", " "));
                result.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения: " + inputFile, e);
        }

        String content = result.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи: " + outputFile, e);
        }
        return content;
    }

    public static List<String> sortNames(String inputFile, String outputFile) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    names.add(trimmed);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения: " + inputFile, e);
        }

        Collections.sort(names);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи: " + outputFile, e);
        }
        return names;
    }

    public static void saveHero(Hero hero, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(hero);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка сериализации: " + filename, e);
        }
    }

    public static Hero loadHero(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Hero) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка десериализации: " + filename, e);
        }
    }
}
