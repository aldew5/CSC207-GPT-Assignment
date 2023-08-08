package main.java.use_case;

import main.java.datastructure.PriorityQueue;

/**
 * Use case class for storing an array of integers in a priority queue.
 * This class encapsulates the logic of adding values from an array to a priority queue.
 */
public class StoreInPriorityQueueUseCase {

    private final PriorityQueue priorityQueue;

    /**
     * Constructor to initialize the use case with a priority queue.
     *
     * @param priorityQueue The priority queue instance to be used.
     */
    public StoreInPriorityQueueUseCase(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    /**
     * Stores an array of integers in the priority queue.
     *
     * @param inputArray The input array of integers to be stored in the priority queue.
     * @return The priority queue after storing all the values from the input array.
     */
    public PriorityQueue storeInPriorityQueue(int[] inputArray) {
        for (int value : inputArray) {
            priorityQueue.enqueue(value);
        }
        return priorityQueue;
    }
}
