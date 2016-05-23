
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class Odtwarzacz {
    public FileInputStream fis;
    public   Player playMP3;
   
   public void play(){
       try {
          fis = new FileInputStream("C:\\Users\\Marcin\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\audio\\music1.mp3");
          playMP3 = new Player(fis);
          playMP3.play();
          
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Odtwarzacz.class.getName()).log(Level.SEVERE, null, ex);
      } catch (JavaLayerException ex) {
          Logger.getLogger(Odtwarzacz.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
    
}
