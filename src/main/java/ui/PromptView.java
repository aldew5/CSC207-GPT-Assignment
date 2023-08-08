package main.java.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import main.java.datastructure.MaxBinaryHeap;
import main.java.datastructure.PriorityQueue;
import main.java.ui.handlers.IncreaseKeyClickHandler;
import main.java.ui.handlers.QueueClickHandler;
import main.java.ui.handlers.SortClickHandler;
import main.java.ui.handlers.SubmitClickHandler;
import main.java.util.*;

public class PromptView extends JFrame{

    private JTextField textField;

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



    public void clearInputField() {
            textField.setText("");
        }

    public int[] convertListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void disableElements() {
        textField.setEnabled(false);
    }

    public void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void showResults(String title, int[] array) {
        StringBuilder result = new StringBuilder(title + "\n");
        for (int num : array) {
            result.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    public void showResults(String title, PriorityQueue priorityQueue) {
        StringBuilder result = new StringBuilder(title + "\n");
        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.dequeue()).append(" ");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    public int promptIndex() {
        String indexText = JOptionPane.showInputDialog(this, "Enter index to increase key:");
        return Integer.parseInt(indexText);
    }

    public int promptNewValue() {
        String newValueText = JOptionPane.showInputDialog(this, "Enter new value:");
        return Integer.parseInt(newValueText);
    }


    public List<Integer> getInputList() {
        return inputList;
    }

    public PriorityQueue getPriorityQueue() {
        return priorityQueue;
    }

    public MaxBinaryHeap getMaxBinaryHeap() {
        return maxBinaryHeap;
    }
}