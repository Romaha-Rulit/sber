package com.sber.dz4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация DZ4 ===\n");

        // Pair
        Pair<Integer, String> car = new Pair<>(340, "BMW");
        System.out.println("Pair: " + car);
        car.setValue("Mercedes AMG");
        car.setKey(63);
        System.out.println("Обновленный Pair: " + car);

        System.out.println("\n=== Сравнение TreeSet и HashSet ===\n");

        // TreeSet vs HashSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(i);
        }
        long treeTime = System.nanoTime() - start;
        System.out.println("TreeSet добавление: " + treeTime + " ns");

        HashSet<Integer> hashSet = new HashSet<>();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(i);
        }
        long hashTime = System.nanoTime() - start;
        System.out.println("HashSet добавление: " + hashTime + " ns");

        start = System.nanoTime();
        treeSet.contains(5000);
        long treeGet = System.nanoTime() - start;
        System.out.println("TreeSet поиск: " + treeGet + " ns");

        start = System.nanoTime();
        hashSet.contains(5000);
        long hashGet = System.nanoTime() - start;
        System.out.println("HashSet поиск: " + hashGet + " ns");
    }
}
