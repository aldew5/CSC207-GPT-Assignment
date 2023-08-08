package main.java.ui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.datastructure.PriorityQueue;
import main.java.ui.PromptView;
import main.java.use_case.StoreInPriorityQueueUseCase;
import main.java.util.AudioPlayer;

/**
 * ActionListener implementation for the "Priority Order List" button.
 * This class handles the logic for storing input values in a priority queue and displaying results.
 */
public class QueueClickHandler implements ActionListener {

    private PromptView promptView;

    /**
     * Constructor to initialize the handler with the PromptView instance.
     *
     * @param promptView The PromptView instance associated with the handler.
     */
    public QueueClickHandler(PromptView promptView) {
        this.promptView = promptView;
    }

    /**
     * Handles the action event triggered by clicking the "Priority Order List" button.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Create a priority queue and use case
        PriorityQueue priorityQueue = new PriorityQueue(promptView.getInputList().size());
        StoreInPriorityQueueUseCase queueUseCase = new StoreInPriorityQueueUseCase(priorityQueue);

        // Convert input list to array and store in the priority queue
        int[] inputArray = promptView.convertListToArray(promptView.getInputList());
        queueUseCase.storeInPriorityQueue(inputArray);

        // Play audio feedback
        AudioPlayer.playAudio("src/main/assets/priority_sort.wav");

        // Show the priority queue contents
        promptView.showResults("Priority Queue (max heap) contents:", priorityQueue);
    }
}


