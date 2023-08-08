package main.java.ui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.ui.PromptView;
import main.java.use_case.SortInputUseCase;
import main.java.util.AudioPlayer;

/**
 * ActionListener implementation for the "Sort List" button.
 * This class handles the logic for sorting the input array and displaying results.
 */
public class SortClickHandler implements ActionListener {

    private PromptView promptView;

    /**
     * Constructor to initialize the handler with the PromptView instance.
     *
     * @param promptView The PromptView instance associated with the handler.
     */
    public SortClickHandler(PromptView promptView) {
        this.promptView = promptView;
    }

    /**
     * Handles the action event triggered by clicking the "Sort List" button.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Create a sort use case
        SortInputUseCase sortUseCase = new SortInputUseCase();

        // Convert input list to array, sort it, and play audio feedback
        int[] inputArray = promptView.convertListToArray(promptView.getInputList());
        inputArray = sortUseCase.sortInput(inputArray);
        AudioPlayer.playAudio("src/main/assets/sort.wav");

        // Show the sorted array
        promptView.showResults("Sorted Array:", inputArray);
    }
}


