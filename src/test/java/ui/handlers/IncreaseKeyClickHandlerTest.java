package ui.handlers;

import datastructure.MaxBinaryHeap;
import org.junit.jupiter.api.Test;
import ui.PromptView;

import static org.mockito.Mockito.*;

public class IncreaseKeyClickHandlerTest {

    @Test
    public void testActionPerformed() {
        PromptView promptView = mock(PromptView.class);
        MaxBinaryHeap maxBinaryHeap = mock(MaxBinaryHeap.class);
        IncreaseKeyClickHandler handler = new IncreaseKeyClickHandler(promptView);

        when(promptView.getMaxBinaryHeap()).thenReturn(maxBinaryHeap);
        when(promptView.promptIndex()).thenReturn(0);
        when(promptView.promptNewValue()).thenReturn(10);

        handler.actionPerformed(null);

        // Verify that the increaseKey method is called with the correct arguments
        verify(maxBinaryHeap).increaseKey(0, 10);

        // Verify that the appropriate methods in promptView are called
        verify(promptView).getInputList();
    }
}

