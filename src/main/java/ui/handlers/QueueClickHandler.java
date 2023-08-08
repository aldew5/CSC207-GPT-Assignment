package main.java.ui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.datastructure.PriorityQueue;
import main.java.ui.PromptView;
import main.java.use_case.StoreInPriorityQueueUseCase;
import main.java.util.AudioPlayer;

public class QueueClickHandler implements ActionListener {

    private PromptView promptView;

    public QueueClickHandler(PromptView promptView) {
        this.promptView = promptView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PriorityQueue priorityQueue = new PriorityQueue(promptView.getInputList().size());
        StoreInPriorityQueueUseCase queueUseCase = new StoreInPriorityQueueUseCase(priorityQueue);
        int[] inputArray = promptView.convertListToArray(promptView.getInputList());
        queueUseCase.storeInPriorityQueue(inputArray);
        AudioPlayer.playAudio("src/main/assets/priority_sort.wav");
        promptView.showResults("Priority Queue (max heap) contents:", priorityQueue);
    }
}

