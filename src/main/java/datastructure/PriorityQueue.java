package main.java.datastructure;

/**
 * A simple priority queue data structure implemented using a max binary heap.
 * The element with the highest priority (i.e., the maximum value) is always at the front of the queue.
 */
public class PriorityQueue {
    private MaxBinaryHeap maxHeap;

    /**
     * Creates a new instance of the main.java.datastructure.PriorityQueue with the specified capacity.
     *
     * @param capacity The maximum number of elements the priority queue can hold.
     */
    public PriorityQueue(int capacity) {
        maxHeap = new MaxBinaryHeap(capacity);
    }

    /**
     * Inserts an element with the given priority into the priority queue.
     *
     * @param value The value to be enqueued (inserted) into the priority queue.
     */
    public void enqueue(int value) {
        maxHeap.insert(value);
    }

    /**
     * Removes and retrieves the element with the highest priority (maximum value) from the priority queue.
     *
     * @return The element with the highest priority in the priority queue.
     * @throws IllegalStateException If the priority queue is empty and there are no elements to dequeue.
     */
    public int dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * Retrieves the element with the highest priority (maximum value) from the priority queue without removing it.
     *
     * @return The element with the highest priority in the priority queue.
     * @throws IllegalStateException If the priority queue is empty and there are no elements to peek.
     */
    public int peek() {
        return maxHeap.peek();
    }

    /**
     * Gets the current number of elements in the priority queue.
     *
     * @return The size of the priority queue.
     */
    public int size() {
        return maxHeap.getSize();
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return maxHeap.getSize() == 0;
    }
}