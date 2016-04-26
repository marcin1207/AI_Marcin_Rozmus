
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


public class ThreadPosition extends Thread{
    public BufferedImage image;
    private Samochod car;
    public int kolor;
      
    public ThreadPosition(Samochod car){
        this.car = car;
   
    }
    @Override
    public void run(){
        while(true){
        mapa();
            try {
                //krawiedzie(car);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    private void mapa() {
       
        File file = new File("C:\\Users\\MR\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\mapa.bmp");
        try {
            image = ImageIO.read(file);
           
        } catch (IOException ex) {
            Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("Załadowano bitmape");
        //System.out.println((int)car.getX());
       // System.out.println((int)car.getY());
        
        int clr = image.getRGB((int) car.getX(),(int) car.getY());

       kolor = (clr & 0x00ffffff) >> 16;
        //System.out.println("------------");
       // System.out.println(kolor);
      //  System.out.println(car.getX());
       // System.out.println(car.getY());
       // System.out.println("------------");

       
      if (kolor==0) {
          System.out.println("white");
          car.setAcceleration();
        }
        if (kolor ==255) {
            System.out.println("black");
         car.returnAcceleration();
       }
        
       // System.out.println(System.currentTimeMillis());
        
               
          
    }
    

    private void krawiedzie() {
        
        
        
        
    }
}
    
