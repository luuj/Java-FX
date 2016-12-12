package Controller;
import java.io.File;
import javafx.scene.media.AudioClip;

/********************************************
 * Singleton class to play audio
 ********************************************/

public class Music_Singleton {
    private static Music_Singleton sBlock;
    AudioClip fx, bgm;
	
    private Music_Singleton(){
    	bgm = new AudioClip(new File("bin/audio/perion.mp3").toURI().toString());
    	bgm.setCycleCount(AudioClip.INDEFINITE);
        fx = new AudioClip(new File("bin/audio/crackle.mp3").toURI().toString());
    }
    
    public static Music_Singleton get() {
        if (sBlock == null)
            sBlock = new Music_Singleton();

        return sBlock;
    }
    
    public void playBackground(){
    	bgm.play();
    }
    
    public void playCrackle(){
    	fx.play();
    }
    
    
}
