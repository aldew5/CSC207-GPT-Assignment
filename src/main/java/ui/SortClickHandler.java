package main.java.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.ui.PromptView;
import main.java.use_case.SortInputUseCase;

public class SortClickHandler implements ActionListener {

    private PromptView promptView;

    public SortClickHandler(PromptView promptView) {
        this.promptView = promptView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SortInputUseCase sortUseCase = new SortInputUseCase();
        int[] inputArray = promptView.convertListToArray(promptView.getInputList());
        inputArray = sortUseCase.sortInput(inputArray);
        promptView.showResults("Sorted Array:", inputArray);
    }
}

