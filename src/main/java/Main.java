package main.java;

import main.java.ui.PromptView;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PromptView promptView = new PromptView();
                promptView.setVisible(true);
            }
        });
    }
}