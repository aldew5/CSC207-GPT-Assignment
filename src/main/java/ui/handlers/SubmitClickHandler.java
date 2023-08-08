package main.java.ui.handlers;

import main.java.ui.PromptView;
import main.java.util.AudioPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;
public class SubmitClickHandler implements ActionListener {

    private JTextField textField;
    private PromptView promptView;

    public SubmitClickHandler(JTextField textField, PromptView promptView) {
        this.textField = textField;
        this.promptView = promptView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = textField.getText();
        if (inputText.equalsIgnoreCase("done")) {
            promptView.disableElements();
        } else {
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
