package main.java.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanelBuilder {

    private JPanel buttonPanel;

    public ButtonPanelBuilder() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
    }

    public ButtonPanelBuilder addButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        buttonPanel.add(button);
        return this;
    }

    public JPanel build() {
        return buttonPanel;
    }
}
