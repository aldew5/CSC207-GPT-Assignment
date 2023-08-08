package main.java.use_case;

import main.java.datastructure.HeapSort;


public class SortInputUseCase {

    /**
     * Sorts the given array of integers in ascending order using the HeapSort algorithm.
     *
     * @param inputArray The array of integers to be sorted.
     * @return The sorted array in ascending order.
     */
    public int[] sortInput(int[] inputArray) {
        HeapSort.sort(inputArray);
        return inputArray;
    }
}

