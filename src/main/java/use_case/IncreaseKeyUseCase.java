package main.java.use_case;

import main.java.datastructure.MaxBinaryHeap;

public class IncreaseKeyUseCase {

    private MaxBinaryHeap maxBinaryHeap;

    public IncreaseKeyUseCase(MaxBinaryHeap maxBinaryHeap) {
        this.maxBinaryHeap = maxBinaryHeap;
    }

    /**
     * Increases the value of a key at the specified index in the max binary heap.
     *
     * @param index     The index of the key to increase.
     * @param newValue  The new value to set for the key.
     * @throws IllegalArgumentException If the new value is less than the current value.
     * @throws IndexOutOfBoundsException If the index is invalid for the heap.
     */
    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= maxBinaryHeap.getSize()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }

        if (newValue < maxBinaryHeap.getHeap()[index]) {
            throw new IllegalArgumentException("New value must be greater than or equal to the current value.");
        }

        maxBinaryHeap.getHeap()[index] = newValue;
        maxBinaryHeap.heapifyDown(index);
    }
}