package test.java;


import main.java.datastructure.PriorityQueue;
import main.java.use_case.StoreInPriorityQueueUseCase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StoreInPriorityQueueUseCaseTest {

    @Test
    public void testStoreInPriorityQueue() {
        // Create an instance of PriorityQueue
        PriorityQueue priorityQueue = new PriorityQueue(10); // Adjust the capacity as needed

        // Create an instance of StoreInPriorityQueueUseCase
        StoreInPriorityQueueUseCase queueUseCase = new StoreInPriorityQueueUseCase(priorityQueue);

        // Input array
        int[] inputArray = {8, 5, 10, 3, 7};

        // Store inputArray in the priority queue
        queueUseCase.storeInPriorityQueue(inputArray);

        // Check if the elements are correctly enqueued
        assertEquals(10, priorityQueue.peek());
        assertEquals(5, priorityQueue.size());
    }

    @Test
    public void testStoreEmptyArray() {
        // Create an instance of PriorityQueue
        PriorityQueue priorityQueue = new PriorityQueue(10); // Adjust the capacity as needed

        // Create an instance of StoreInPriorityQueueUseCase
        StoreInPriorityQueueUseCase queueUseCase = new StoreInPriorityQueueUseCase(priorityQueue);

        // Input array
        int[] inputArray = {};

        // Store inputArray in the priority queue
        queueUseCase.storeInPriorityQueue(inputArray);

        // Check if the priority queue is empty
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void testStoreSingleElementArray() {
        // Create an instance of PriorityQueue
        PriorityQueue priorityQueue = new PriorityQueue(10); // Adjust the capacity as needed

        // Create an instance of StoreInPriorityQueueUseCase
        StoreInPriorityQueueUseCase queueUseCase = new StoreInPriorityQueueUseCase(priorityQueue);

        // Input array
        int[] inputArray = {5};

        // Store inputArray in the priority queue
        queueUseCase.storeInPriorityQueue(inputArray);

        // Check if the element is correctly enqueued
        assertEquals(5, priorityQueue.peek());
        assertEquals(1, priorityQueue.size());
    }
}