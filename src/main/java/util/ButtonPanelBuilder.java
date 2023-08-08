package main.java.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A builder class for creating a panel of buttons with associated action listeners.
 */
public class ButtonPanelBuilder {

    private JPanel buttonPanel;

    /**
     * Constructs a new instance of the ButtonPanelBuilder.
     */
    public ButtonPanelBuilder() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
    }

    /**
     * Adds a button with the specified text and action listener to the panel.
     *
     * @param text           The text to display on the button.
     * @param actionListener The action listener to be associated with the button.
     * @return The ButtonPanelBuilder instance for method chaining.
     */
    public ButtonPanelBuilder addButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        buttonPanel.add(button);
        return this;
    }

    /**
     * Builds and returns the panel containing the added buttons.
     *
     * @return The built JPanel containing the buttons.
     */
    public JPanel build() {
        return buttonPanel;
    }
}
