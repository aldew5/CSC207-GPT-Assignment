package main.java.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BuildView {

    public static final String PANEL_BOTTOM = java.awt.BorderLayout.SOUTH;

    private JFrame frame;
    private JPanel mainPanel;

    private BuildView(JFrame frame) {
        this.frame = frame;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
    }

    public static BuildView init(JFrame frame) {
        return new BuildView(frame);
    }

    public BuildView addLabel(String text, String panelPosition) {
        JLabel label = new JLabel(text);
        addComponent(label, panelPosition);
        return this;
    }

    public BuildView addTextField(String panelPosition) {
        JTextField textField = new JTextField(20);
        addComponent(textField, panelPosition);
        return this;
    }

    public BuildView addButton(String text, ActionListener actionListener, String panelPosition) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        addComponent(button, panelPosition);
        return this;
    }

    public BuildView addComponent(JComponent component, String panelPosition) {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(component);
        mainPanel.add(panel, panelPosition);
        return this;
    }

    public void build() {
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}