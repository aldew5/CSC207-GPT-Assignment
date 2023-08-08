import main.java.ui.PromptView;
import main.java.ui.SwingUIComponentFactory;
import main.java.ui.UIComponentFactory;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PromptView promptView = new PromptView();
                promptView.showPrompt();
            }
        });
    }
}