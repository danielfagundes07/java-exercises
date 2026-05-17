package exercises.Alarm_Clock_Exercise;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock implements Runnable{
    
    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner){
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
public void run() {
    // Keep looping until the current time reaches the alarm time
    while (LocalTime.now().isBefore(alarmTime)) {
        try {
            Thread.sleep(1000); // wait one second
            LocalTime now = LocalTime.now();
            System.out.printf("\r%02d:%02d:%02d",
                    now.getHour(),
                    now.getMinute(),
                    now.getSecond());
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }

    playSound(filePath);
}

    private void playSound(String filePath) {
    File audioFile = new File(filePath);

    try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        // Loop continuously until user stops
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println("\nPress *Enter* to stop the alarm");
        scanner.nextLine();
        clip.stop();
    } catch (UnsupportedAudioFileException e) {
        System.out.println("Audio file format is not supported.");
    } catch (LineUnavailableException e) {
        System.out.println("Audio is unavailable.");
    } catch (IOException e) {
        System.out.println("Error reading audio file.");
    }
}

}
