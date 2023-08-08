package use_case;

import datastructure.HeapSort;


public class SortInputUseCase {

    /**
     * Sorts the given array of integers in ascending order using the HeapSort algorithm.
     *
     * @param inputArray The array of integers to be sorted.
     * @return The sorted array in ascending order.
     */
    public int[] sortInput(int[] inputArray) {
        HeapSort heap_sort = new HeapSort();
        inputArray = heap_sort.sort(inputArray);
        return inputArray;
    }
}

