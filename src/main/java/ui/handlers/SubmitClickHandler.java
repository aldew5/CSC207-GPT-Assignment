package ui.handlers;

import ui.PromptView;
import util.AudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
/**
 * ActionListener implementation for the "Submit List" button.
 * This class handles the logic for processing the user input and updating the UI.
 */
public class SubmitClickHandler implements ActionListener {

    private JTextField textField;
    private PromptView promptView;

    /**
     * Constructor to initialize the handler with the text field and PromptView instance.
     *
     * @param textField The text field where user input is entered.
     * @param promptView The PromptView instance associated with the handler.
     */
    public SubmitClickHandler(JTextField textField, PromptView promptView) {
        this.textField = textField;
        this.promptView = promptView;
    }

    /**
     * Handles the action event triggered by clicking the "Submit List" button.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = textField.getText();
        if (inputText.equalsIgnoreCase("done")) {
            // If input is "done", disable UI elements
            promptView.disableElements();
        } else {
            // Process input tokens and add them to the input list and priority queue
            List<String> inputTokens = Arrays.asList(inputText.split(","));
            for (String token : inputTokens) {
                try {
                    int number = Integer.parseInt(token.trim());
                    promptView.getInputList().add(number);
                    promptView.getPriorityQueue().enqueue(number);
                    AudioPlayer.playAudio("src/main/assets/submit.wav");
                } catch (NumberFormatException ex) {
                    promptView.showAlert("Invalid input", "Please enter a valid list of numbers or 'done' to submit.");
                    return;
                }
            }
            promptView.clearInputField();
        }
    }
}

