package main.java.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.ui.PromptView;
import main.java.use_case.IncreaseKeyUseCase;

public class IncreaseKeyClickHandler implements ActionListener {

    private PromptView promptView;

    public IncreaseKeyClickHandler(PromptView promptView) {
        this.promptView = promptView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = promptView.promptIndex(); // Prompt the user for the index
        int newValue = promptView.promptNewValue(); // Prompt the user for the new value

        try {
            IncreaseKeyUseCase increaseKeyUseCase = new IncreaseKeyUseCase(promptView.getMaxBinaryHeap());
            increaseKeyUseCase.increaseKey(index, newValue);

            promptView.getInputList().set(index, newValue);
            promptView.showResults("Key increased at index " + index + " to " + newValue,
                    promptView.convertListToArray(promptView.getInputList()));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            promptView.showAlert("Invalid input", "Invalid index or new value.");
        }
    }
}

