package ui.handlers;

import datastructure.PriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.PromptView;
import use_case.StoreInPriorityQueueUseCase;
import util.AudioPlayer;

import java.awt.event.ActionEvent;
import java.util.List;

import static org.mockito.Mockito.*;

public class QueueClickHandlerTest {

    @Mock
    private PromptView mockPromptView;

    @Mock
    private StoreInPriorityQueueUseCase mockQueueUseCase;

    @Mock
    private PriorityQueue mockPriorityQueue;

    @Mock
    private AudioPlayer mockAudioPlayer;

    private QueueClickHandler queueClickHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockPromptView.getInputList()).thenReturn(List.of(3, 1, 5));
        when(mockPromptView.convertListToArray(List.of(3, 1, 5))).thenReturn(new int[]{3, 1, 5});
        doReturn(mockPriorityQueue).when(mockQueueUseCase).storeInPriorityQueue(any(int[].class));

        queueClickHandler = new QueueClickHandler(mockPromptView);
    }

    @Test
    public void testActionPerformed() {
        // Mock the storeInPriorityQueue method to return a priority queue
        when(mockQueueUseCase.storeInPriorityQueue(any(int[].class))).thenReturn(mockPriorityQueue);

        ActionEvent mockEvent = mock(ActionEvent.class);
        queueClickHandler.actionPerformed(mockEvent);

        // Verify that the methods were called correctly
        verify(mockPromptView).showResults(eq("Priority Queue (max heap) contents:"), any(PriorityQueue.class));
    }
}
