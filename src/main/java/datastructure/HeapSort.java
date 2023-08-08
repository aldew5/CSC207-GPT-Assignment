package main.java.datastructure;

public class HeapSort implements SortingStrategy {

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;

        // Build a max heap (heapify) from the array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the max heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

        return arr;
    }

    /**
     * Max heapify the subtree rooted at the given index.
     *
     * @param arr   The array representing the heap.
     * @param n     The size of the heap.
     * @param index The index of the root of the subtree to be heapified.
     */
    private void heapify(int[] arr, int n, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}
