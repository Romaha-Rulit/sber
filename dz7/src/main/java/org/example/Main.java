package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        removeExtraSpaces("Borodino.txt", "Borodino_cleaned.txt");
        sortNames("listNames.txt", "listNames_sorted.txt");
        Hero hero = new Hero("артур ", 5, new Weapon(" рапира ", 50), new Armor("латы", 30));
        System.out.println(hero);
        saveHero(hero, "hero.ser");
        Hero loaded = loadHero("hero.ser");
        System.out.println(loaded);
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
            throw new RuntimeException("ошибка: " + inputFile, e);
        }
        String content = result.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("ошибка: " + outputFile, e);
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
            throw new RuntimeException("ошибка: " + inputFile, e);
        }
        Collections.sort(names);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("ошибка: " + outputFile, e);
        }
        return names;
    }

    public static void saveHero(Hero hero, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(hero);
        } catch (IOException e) {
            throw new RuntimeException("ошибка: " + filename, e);
        }
    }

    public static Hero loadHero(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Hero) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("ошибка: " + filename, e);
        }
    }
}
