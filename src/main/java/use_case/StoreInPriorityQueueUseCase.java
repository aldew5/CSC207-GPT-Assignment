package main.java.use_case;

import main.java.datastructure.PriorityQueue;

public class StoreInPriorityQueueUseCase {

    private final PriorityQueue priorityQueue;

    public StoreInPriorityQueueUseCase(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public PriorityQueue storeInPriorityQueue(int[] inputArray) {
        for (int value : inputArray) {
            priorityQueue.enqueue(value);
        }
        return priorityQueue;
    }
}