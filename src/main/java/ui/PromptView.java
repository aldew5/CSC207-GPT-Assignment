package main.java.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.datastructure.MaxBinaryHeap;
import main.java.datastructure.PriorityQueue;
import main.java.use_case.SortInputUseCase;
import main.java.use_case.StoreInPriorityQueueUseCase;
import main.java.util.BuildView;

public class PromptView extends JFrame{

    private JTextField textField;
    private JButton submitButton;
    private JButton sortButton;
    private JButton queueButton;
    private JButton increaseKeyButton;

    private List<Integer> inputList;
    private PriorityQueue priorityQueue;
    private MaxBinaryHeap maxBinaryHeap;

    public PromptView() {
        setTitle("User Input Prompt");
        setSize(600, 400);
        setLocationRelativeTo(null);

        inputList = new ArrayList<>();
        priorityQueue = new PriorityQueue(10);
        maxBinaryHeap = new MaxBinaryHeap(10);

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter numbers separated by commas or 'done' to submit:");
        add(label, BorderLayout.NORTH);

        textField = new JTextField(20);
        add(textField, BorderLayout.CENTER);

        submitButton = new JButton("Submit List");
        sortButton = new JButton("Sort List");
        queueButton = new JButton("Priority Queue");
        increaseKeyButton = new JButton("Increase Key");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(queueButton);
        buttonPanel.add(increaseKeyButton);

        add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(this::onSubmitClicked);
        sortButton.addActionListener(this::onSortClicked);
        queueButton.addActionListener(this::onQueueClicked);
        increaseKeyButton.addActionListener(this::onIncreaseKeyClicked);
    }
        private void clearInputField() {
            textField.setText("");
        }

    private void onSubmitClicked(ActionEvent e) {
        String inputText = textField.getText();
        if (inputText.equalsIgnoreCase("done")) {
            disableSubmitButton();
            disableInputField();
            enableSortButton();
            enableQueueButton();
        } else {
            List<String> inputTokens = Arrays.asList(inputText.split(","));
            for (String token : inputTokens) {
                try {
                    int number = Integer.parseInt(token.trim());
                    inputList.add(number);
                    priorityQueue.enqueue(number);
                } catch (NumberFormatException ex) {
                    showAlert("Invalid input", "Please enter a valid list of numbers or 'done' to submit.");
                    return;
                }
            }
            clearInputField();
        }
    }

    private void onSortClicked(ActionEvent e) {
        SortInputUseCase sortUseCase = new SortInputUseCase();
        int[] inputArray = convertListToArray(inputList);
        inputArray = sortUseCase.sortInput(inputArray);
        showResults("Sorted Array:", inputArray);
    }

    private void onQueueClicked(ActionEvent e) {
        PriorityQueue priorityQueue = new PriorityQueue(inputList.size());
        StoreInPriorityQueueUseCase queueUseCase = new StoreInPriorityQueueUseCase(priorityQueue);
        int[] inputArray = convertListToArray(inputList);
        queueUseCase.storeInPriorityQueue(inputArray);
        showResults("Priority Queue (max heap) contents:", priorityQueue);
    }

    private int[] convertListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void disableSubmitButton() {
        submitButton.setEnabled(false);
    }

    private void disableInputField() {
        textField.setEnabled(false);
    }

    private void enableSortButton() {
        sortButton.setEnabled(true);
    }

    private void enableQueueButton() {
        queueButton.setEnabled(true);
    }

    private void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    private void showResults(String title, int[] array) {
        StringBuilder result = new StringBuilder(title + "\n");
        for (int num : array) {
            result.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    private void showResults(String title, PriorityQueue priorityQueue) {
        StringBuilder result = new StringBuilder(title + "\n");
        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.dequeue()).append(" ");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    private void onIncreaseKeyClicked(ActionEvent e) {
        int index = promptIndex(); // Prompt the user for the index
        int newValue = promptNewValue(); // Prompt the user for the new value

        try {
            maxBinaryHeap.increaseKey(index, newValue);
            inputList.set(index, newValue);
            showResults("Key increased at index " + index + " to " + newValue, convertListToArray(inputList));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            showAlert("Invalid input", "Invalid index or new value.");
        }
    }

    private int promptIndex() {
        String indexText = JOptionPane.showInputDialog(this, "Enter index to increase key:");
        return Integer.parseInt(indexText);
    }

    private int promptNewValue() {
        String newValueText = JOptionPane.showInputDialog(this, "Enter new value:");
        return Integer.parseInt(newValueText);
    }


    public void showPrompt() {
        sortButton.setEnabled(false);
        queueButton.setEnabled(false);
        setVisible(true);
    }

}