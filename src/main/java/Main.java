package main.java;

import ui.PromptView;
import javax.swing.*;

/**
 * The Main class is the entry point of the application. It initializes
 * and displays the user interface for input and interaction.
 */
public class Main {

    /**
     * The main method of the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create and display the user interface using SwingUtilities
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of the PromptView to show the user interface
                PromptView promptView = new PromptView();
                promptView.setVisible(true);
            }
        });
    }
}
