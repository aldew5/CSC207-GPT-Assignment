package main.java.use_case;

import main.java.datastructure.MaxBinaryHeap;

/**
 * Represents the use case for increasing a key in a max binary heap.
 */
public class IncreaseKeyUseCase {

    private MaxBinaryHeap maxBinaryHeap;

    /**
     * Creates an instance of the IncreaseKeyUseCase.
     *
     * @param maxBinaryHeap The max binary heap to be used for the increase operation.
     */
    public IncreaseKeyUseCase(MaxBinaryHeap maxBinaryHeap) {
        this.maxBinaryHeap = maxBinaryHeap;
    }

    /**
     * Increases the value of a key at the specified index in the max binary heap.
     *
     * @param index    The index of the key to be increased.
     * @param newValue The new value to be assigned to the key.
     * @throws IllegalArgumentException If the index is invalid.
     */
    public void increaseKey(int index, int newValue) throws IllegalArgumentException {
        maxBinaryHeap.increaseKey(index, newValue);
    }
}
