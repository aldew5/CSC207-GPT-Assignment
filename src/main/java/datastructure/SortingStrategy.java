package main.java.datastructure;

/**
 * The SortingStrategy interface defines a contract for sorting algorithms.
 * Classes that implement this interface provide various sorting methods
 * for sorting arrays of integers.
 */
public interface SortingStrategy {

    /**
     * Sorts an array of integers using a specific sorting algorithm.
     *
     * @param array The array of integers to be sorted.
     * @return A new array containing the sorted integers.
     */
    int[] sort(int[] array);
}
