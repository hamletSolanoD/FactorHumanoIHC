package ElementosPersonalizados;
import javax.sound.sampled.*;
import javax.sound.sampled.Line.Info;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SonidoClip {

    private Clip audioClip;
    private AudioInputStream audioStream;

    //clip method
    public SonidoClip(String path) {
        //create an AudioInputStream from a given sound file
    	//File audioFile = new File(path);
    	//File audioFile = new File(getClass().getSystemResource("/Resources/high.txt").toURI());

    	//File audioFile = new File(ClassLoader.getSystemResource("path").getFile());
    	//InputStream audioFile = getClass().getResourceAsStream(path);
    	
    	
        try {
           // audioStream = AudioSystem.getAudioInputStream(audioFile);
        	
        	//File file = new File(path);
        	audioStream = AudioSystem.getAudioInputStream(getClass().getResource(path));
        	
        }
        catch (UnsupportedAudioFileException | IOException e) {
        	JFrame	j = 		new JFrame();
			j.setBounds(400,400,400,400);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j.setVisible(true);
        }

        //acquire audio format and create a DataLine.Info object
        AudioFormat format = audioStream.getFormat();
        Info info = new DataLine.Info(Clip.class, format);

        //obtain the Clip
        try {
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        }
        catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        new Thread( () -> {
            audioClip.setFramePosition(0);
            audioClip.start();
        }){}.start();
    }

    public void loop() {
        new Thread( () -> {
            audioClip.setFramePosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }){}.start();
    }

    public void stop() {
        audioClip.stop();
    }

}