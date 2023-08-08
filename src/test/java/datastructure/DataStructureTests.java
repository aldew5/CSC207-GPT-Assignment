package datastructure;


import main.java.datastructure.HeapSort;
import main.java.datastructure.PriorityQueue;
import main.java.datastructure.MaxBinaryHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DataStructureTests {


    @Test
    public void testMaxBinaryHeap() {
        MaxBinaryHeap maxBinaryHeap = new MaxBinaryHeap(5);
        maxBinaryHeap.insert(5);
        maxBinaryHeap.insert(10);
        maxBinaryHeap.insert(7);
        maxBinaryHeap.insert(15);
        maxBinaryHeap.insert(20);

        int[] expectedArray = {20, 15, 7, 5, 10};
        assertArrayEquals(expectedArray, maxBinaryHeap.getHeap());
    }

    @Test
    public void testPriorityQueue() {
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(15);
        priorityQueue.enqueue(20);

        int[] expectedArray = {20, 15, 10, 7, 5};
        int[] actualArray = new int[expectedArray.length];

        for (int i = 0; i < actualArray.length; i++) {
            actualArray[i] = priorityQueue.dequeue();
        }

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testHeapSort() {
        int[] inputArray = {5, 10, 7, 15, 20};
        HeapSort heapSort = new HeapSort();
        int[] sortedArray = heapSort.sort(inputArray);

        int[] expectedArray = {5, 7, 10, 15, 20};
        assertArrayEquals(expectedArray, sortedArray);
    }
}

