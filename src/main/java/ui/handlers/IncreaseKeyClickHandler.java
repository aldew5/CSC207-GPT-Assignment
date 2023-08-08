package ui.handlers;

import ui.PromptView;
import use_case.IncreaseKeyUseCase;
import util.AudioPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "Increase Key" button.
 * This class handles the logic for increasing a key in the max binary heap.
 */
public class IncreaseKeyClickHandler implements ActionListener {

    private PromptView promptView;

    /**
     * Constructor to initialize the handler with the PromptView instance.
     *
     * @param promptView The PromptView instance associated with the handler.
     */
    public IncreaseKeyClickHandler(PromptView promptView) {
        this.promptView = promptView;
    }

    /**
     * Handles the action event triggered by clicking the "Increase Key" button.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Prompt the user for the index and new value
        int index = promptView.promptIndex();
        int newValue = promptView.promptNewValue();

        try {
            // Use the IncreaseKeyUseCase to increase the key in the max binary heap
            IncreaseKeyUseCase increaseKeyUseCase = new IncreaseKeyUseCase(promptView.getMaxBinaryHeap());
            increaseKeyUseCase.increaseKey(index, newValue);

            // Update the input list and show results
            promptView.getInputList().set(index, newValue);

            // Play audio feedback
            AudioPlayer.playAudio("src/main/assets/adjust.wav");

            promptView.showResults("Key increased at index " + index + " to " + newValue,
                    promptView.convertListToArray(promptView.getInputList()));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            promptView.showAlert("Invalid input", "Invalid index or new value.");
        }
    }
}


