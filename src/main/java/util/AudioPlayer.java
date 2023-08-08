package main.java.util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Utility class for playing audio files.
 */
public class AudioPlayer {

    /**
     * Plays an audio file located at the specified file path.
     *
     * @param filePath The path to the audio file to be played.
     */
    public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);

            audioClip.start();

            // Wait until the audio playback is finished
            while (audioClip.isRunning()) {
                Thread.sleep(1000);
            }

            audioClip.close();
            audioStream.close();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
