package main.java.ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface UIComponentFactory {
    JTextField createTextField(int columns);
    JButton createButton(String text, ActionListener actionListener);
    JLabel createLabel(String text);
}
