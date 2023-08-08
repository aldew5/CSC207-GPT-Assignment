package main.java.ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SwingUIComponentFactory implements UIComponentFactory {

    @Override
    public JTextField createTextField(int columns) {
        return new JTextField(columns);
    }

    @Override
    public JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }

    @Override
    public JLabel createLabel(String text) {
        return new JLabel(text);
    }
}
