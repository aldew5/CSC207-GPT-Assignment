package main.java.datastructure;

/**
 * A simple Java implementation of a max binary heap.
 */
public class MaxBinaryHeap {

    /**
     * Internal array to store the elements of the max binary heap.
     */
    private int[] heap;

    /**
     * The number of elements currently in the max binary heap.
     */
    private int size;

    /**
     * The maximum capacity of the max binary heap.
     */
    private int capacity;

    /**
     * Creates a new instance of main.java.datastructure.MaxBinaryHeap with the given capacity.
     *
     * @param capacity The maximum number of elements the heap can hold.
     */
    public MaxBinaryHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    /**
     * Get the index of the parent node of a given node in the heap.
     *
     * @param index The index of the node for which to find the parent.
     * @return The index of the parent node.
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }
    /**
     * Get the internal heap array of the max binary heap.
     *
     * @return The internal heap array.
     */
    public int[] getHeap() {
        return heap;
    }

    /**
     * Get the index of the left child node of a given node in the heap.
     *
     * @param index The index of the node for which to find the left child.
     * @return The index of the left child node.
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * Get the index of the right child node of a given node in the heap.
     *
     * @param index The index of the node for which to find the right child.
     * @return The index of the right child node.
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Swap the elements at two given indices in the heap.
     *
     * @param i The index of the first element to swap.
     * @param j The index of the second element to swap.
     */
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Move the element at the given index down the heap to maintain the max heap property.
     *
     * @param index The index of the element to be moved down.
     */
    public void heapifyDown(int index) {
        int maxIndex = index;
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);

        if (leftChildIndex < size && heap[leftChildIndex] > heap[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] > heap[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    /**
     * Insert a new element into the max binary heap.
     *
     * @param value The value to be inserted into the heap.
     * @throws IllegalStateException If the heap is already full and cannot accommodate more elements.
     */
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full. Cannot insert.");
        }

        heap[size] = value;
        int currentIndex = size;
        size++;

        // Perform swap with parent repeatedly until the element reaches its correct position
        while (currentIndex > 0 && heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    /**
     * Extract the maximum element from the max binary heap (root node).
     *
     * @return The maximum element in the heap.
     * @throws IllegalStateException If the heap is empty and there are no elements to extract.
     */
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty. Cannot extract.");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return max;
    }

    /**
     * Get the maximum element in the max binary heap without removing it.
     *
     * @return The maximum element in the heap.
     * @throws IllegalStateException If the heap is empty and there are no elements to peek.
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }

        return heap[0];
    }

    /**
     * Get the current number of elements in the max binary heap.
     *
     * @return The size of the heap.
     */
    public int getSize() {
        return size;
    }

    /**
     * Increase the value of a key at the given index in the max heap.
     *
     * @param index The index of the key to increase.
     * @param newValue The new value to set for the key.
     * @throws IllegalArgumentException If the new value is less than the current value.
     */
    public void increaseKey(int index, int newValue) {
        if (newValue < heap[index]) {
            throw new IllegalArgumentException("New value must be greater than or equal to the current value.");
        }

        while (index > 0 && newValue > heap[parent(index)]) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }

        heap[index] = newValue;
    }
}