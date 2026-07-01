package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    private int[] testArray;
    private int[] expectedSorted;

    @BeforeEach
    void setUp() {
        testArray = new int[]{64, 34, 25, 12, 22, 11, 90};
        expectedSorted = new int[]{11, 12, 22, 25, 34, 64, 90};
    }

    @Test
    void bubbleSortShouldSortArrayCorrectly() {
        int[] array = testArray.clone();
        SortingAlgorithms.bubbleSort(array);
        assertArrayEquals(expectedSorted, array);
    }

    @Test
    void quickSortShouldSortArrayCorrectly() {
        int[] array = testArray.clone();
        SortingAlgorithms.quickSort(array);
        assertArrayEquals(expectedSorted, array);
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] empty = new int[0];
        SortingAlgorithms.bubbleSort(empty);
        assertEquals(0, empty.length);

        int[] empty2 = new int[0];
        SortingAlgorithms.quickSort(empty2);
        assertEquals(0, empty2.length);
    }

    @Test
    void shouldHandleSingleElement() {
        int[] single = new int[]{42};
        SortingAlgorithms.bubbleSort(single);
        assertEquals(42, single[0]);

        int[] single2 = new int[]{42};
        SortingAlgorithms.quickSort(single2);
        assertEquals(42, single2[0]);
    }

    @Test
    void shouldHandleAlreadySorted() {
        int[] sorted = new int[]{1, 2, 3, 4, 5};
        int[] expected = sorted.clone();
        SortingAlgorithms.bubbleSort(sorted);
        assertArrayEquals(expected, sorted);
    }

    @Test
    void bothSortsShouldProduceSameResult() {
        int[] array1 = testArray.clone();
        int[] array2 = testArray.clone();
        SortingAlgorithms.bubbleSort(array1);
        SortingAlgorithms.quickSort(array2);
        assertArrayEquals(array1, array2);
    }
}