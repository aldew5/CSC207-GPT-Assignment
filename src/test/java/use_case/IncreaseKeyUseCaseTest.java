package use_case;

import datastructure.MaxBinaryHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IncreaseKeyUseCaseTest {

    private MaxBinaryHeap maxBinaryHeap;
    private IncreaseKeyUseCase increaseKeyUseCase;

    @BeforeEach
    public void setUp() {
        maxBinaryHeap = new MaxBinaryHeap(3);
        increaseKeyUseCase = new IncreaseKeyUseCase(maxBinaryHeap);
    }

    @Test
    public void testIncreaseKey() {
        maxBinaryHeap.insert(10);
        maxBinaryHeap.insert(20);
        maxBinaryHeap.insert(30);

        increaseKeyUseCase.increaseKey(1, 25);

        int[] expectedArray = {30, 25, 20};
        int[] actualArray = maxBinaryHeap.getHeap();
        assertArrayEquals(expectedArray, actualArray);
    }
}
