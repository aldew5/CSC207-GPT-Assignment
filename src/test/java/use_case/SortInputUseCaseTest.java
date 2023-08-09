package use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortInputUseCaseTest {

    @Test
    public void testSortInput() {
        SortInputUseCase sortInputUseCase = new SortInputUseCase();

        // Test with unsorted input array
        int[] unsortedArray = {8, 5, 10, 3, 7};
        int[] expectedSortedArray = {3, 5, 7, 8, 10};
        int[] sortedArray = sortInputUseCase.sortInput(unsortedArray);
        assertArrayEquals(expectedSortedArray, sortedArray);

        // Test with sorted input array
        int[] sortedInputArray = {1, 2, 3, 4, 5};
        int[] expectedSameArray = {1, 2, 3, 4, 5};
        int[] sameArray = sortInputUseCase.sortInput(sortedInputArray);
        assertArrayEquals(expectedSameArray, sameArray);

        // Test with empty input array
        int[] emptyArray = {};
        int[] expectedEmptyArray = {};
        int[] resultEmptyArray = sortInputUseCase.sortInput(emptyArray);
        assertArrayEquals(expectedEmptyArray, resultEmptyArray);

        // Test with single-element input array
        int[] singleElementArray = {42};
        int[] expectedSingleElementArray = {42};
        int[] resultSingleElementArray = sortInputUseCase.sortInput(singleElementArray);
        assertArrayEquals(expectedSingleElementArray, resultSingleElementArray);
    }
}