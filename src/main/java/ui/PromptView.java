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
import main.java.util.ButtonPanelBuilder;

/**
 * The main user interface for the application.
 * Allows users to input, sort, and manipulate values using various operations.
 */
public class PromptView extends JFrame {

    private JTextField textField;

    private List<Integer> inputList;
    private PriorityQueue priorityQueue;
    private MaxBinaryHeap maxBinaryHeap;

    /**
     * Constructs the main user interface.
     * Initializes necessary components and UI elements.
     */
    public PromptView() {
        setTitle("User Input Prompt");
        setSize(600, 400);
        setLocationRelativeTo(null);

        inputList = new ArrayList<>();
        priorityQueue = new PriorityQueue(10);
        maxBinaryHeap = new MaxBinaryHeap(10);

        initComponents();
    }

    /**
     * Initializes and constructs the UI components.
     */
    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter numbers separated by commas or 'done' to submit:");
        add(label, BorderLayout.NORTH);

        textField = new JTextField(20);
        add(textField, BorderLayout.CENTER);

        // Construct the button panel using a builder
        JPanel buttonPanel = new ButtonPanelBuilder()
                .addButton("Submit List", new SubmitClickHandler(textField, this))
                .addButton("Sort List", new SortClickHandler(this))
                .addButton("Priority Order List", new QueueClickHandler(this))
                .addButton("Adjust List Value", new IncreaseKeyClickHandler(this))
                .build();

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Clears the input field.
     */
    public void clearInputField() {
        textField.setText("");
    }

    /**
     * Converts a list of integers to an array of integers.
     *
     * @param list The list to be converted.
     * @return An array containing the elements of the list.
     */
    public int[] convertListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * Disables certain UI elements.
     */
    public void disableElements() {
        textField.setEnabled(false);
    }

    /**
     * Displays an alert dialog with a specified title and message.
     *
     * @param title   The title of the alert.
     * @param message The message to be displayed in the alert.
     */
    public void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a dialog showing the results of an operation on an array.
     *
     * @param title The title of the dialog.
     * @param array The array to be displayed.
     */
    public void showResults(String title, int[] array) {
        StringBuilder result = new StringBuilder(title + "\n");
        for (int num : array) {
            result.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    /**
     * Displays a dialog showing the contents of a priority queue.
     *
     * @param title         The title of the dialog.
     * @param priorityQueue The priority queue to be displayed.
     */
    public void showResults(String title, PriorityQueue priorityQueue) {
        StringBuilder result = new StringBuilder(title + "\n");
        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.dequeue()).append(" ");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    /**
     * Prompts the user to enter an index.
     *
     * @return The index entered by the user.
     */
    public int promptIndex() {
        String indexText = JOptionPane.showInputDialog(this, "Enter index to increase key:");
        return Integer.parseInt(indexText);
    }

    /**
     * Prompts the user to enter a new value.
     *
     * @return The new value entered by the user.
     */
    public int promptNewValue() {
        String newValueText = JOptionPane.showInputDialog(this, "Enter new value:");
        return Integer.parseInt(newValueText);
    }

    /**
     * Returns the input list.
     *
     * @return The input list.
     */
    public List<Integer> getInputList() {
        return inputList;
    }

    /**
     * Returns the priority queue.
     *
     * @return The priority queue.
     */
    public PriorityQueue getPriorityQueue() {
        return priorityQueue;
    }

    /**
     * Returns the max binary heap.
     *
     * @return The max binary heap.
     */
    public MaxBinaryHeap getMaxBinaryHeap() {
        return maxBinaryHeap;
    }
}
