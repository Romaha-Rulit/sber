package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация сортировок ===\n");

        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Исходный массив:");
        SortingAlgorithms.printArray(array);

        // Тестируем пузырьковую сортировку
        int[] bubbleArray = array.clone();
        SortingAlgorithms.bubbleSort(bubbleArray);
        System.out.println("\nПосле пузырьковой сортировки:");
        SortingAlgorithms.printArray(bubbleArray);

        // Тестируем быструю сортировку
        int[] quickArray = array.clone();
        SortingAlgorithms.quickSort(quickArray);
        System.out.println("\nПосле быстрой сортировки:");
        SortingAlgorithms.printArray(quickArray);

        System.out.println("\n=== Запуск тестов через Maven ===");
        System.out.println("Выполните команду: mvn test");
    }
}