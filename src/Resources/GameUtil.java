/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author IBM
 */
public class GameUtil {
    
    public static void playShuffle()
    {
        // open the sound file as a Java input stream
//        String gongFile = "./src/audio/cardFan.wav";
//        InputStream in = null;
//        try {
//            in = new FileInputStream(gongFile);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // create an audiostream from the inputstream
//        AudioStream audioStream = null;
//        try {
//            audioStream = new AudioStream(in);
//        } catch (IOException ex) {
//            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // play the audio clip with the audioplayer class
//        AudioPlayer.player.start(audioStream);
        AudioInputStream audioInputStream = null;

        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File("./src/audio/cardFan.wav"));
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        FloatControl gainControl
                = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+ 6.0206f); // Reduce volume by 10 decibels.
        clip.start();
    }
    
    public static void setIcon(JFrame frame)
    {
        String file = "./src/img/card-symbols_b.png";
        ImageIcon img = new ImageIcon(file);
        frame.setIconImage(img.getImage());
    }
}
