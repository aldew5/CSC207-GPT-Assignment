package ui;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PromptViewTest {

    @Test
    public void testClearInputField() {
        PromptView promptView = new PromptView();
        promptView.clearInputField();

        assertEquals("", promptView.getTextField().getText());
    }

    @Test
    public void testConvertListToArray() {
        PromptView promptView = new PromptView();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        int[] resultArray = promptView.convertListToArray(inputList);
        int[] expectedArray = {1, 2, 3};

        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    public void testDisableElements() {
        PromptView promptView = new PromptView();
        promptView.disableElements();
        assertFalse(promptView.getTextField().isEnabled());
    }

}

