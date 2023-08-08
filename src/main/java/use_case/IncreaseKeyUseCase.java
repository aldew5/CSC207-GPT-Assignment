package main.java.use_case;

import main.java.datastructure.MaxBinaryHeap;

public class IncreaseKeyUseCase {

    private MaxBinaryHeap maxBinaryHeap;

    public IncreaseKeyUseCase(MaxBinaryHeap maxBinaryHeap) {
        this.maxBinaryHeap = maxBinaryHeap;
    }

    public void increaseKey(int index, int newValue) {
        maxBinaryHeap.increaseKey(index, newValue);
    }
}
