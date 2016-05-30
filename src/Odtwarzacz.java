
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;



public class Odtwarzacz {
        public InputStream in;
        public AudioStream as;
        public File audio = new File("C:\\Users\\MR\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\audio\\sound.wav");
      
    public Odtwarzacz(){
        try {
                in = new FileInputStream(audio); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Odtwarzacz.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                
                    as = new AudioStream(in);
                } catch (IOException ex) {
                    Logger.getLogger(Odtwarzacz.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        
    }    
   public void play(){
            
    AudioPlayer.player.start(as);
}
}