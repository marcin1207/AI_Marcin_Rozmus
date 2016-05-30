
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ThreadPosition extends Thread {

    public BufferedImage image;
    private Samochod car;
    public int kolor,auto,mapa;
    private double xx=0;
    private double yy=0;
    public File file;
    

    public ThreadPosition(Samochod car,int auto, int mapa) {
        this.car = car;
        this.auto =auto;
        this.mapa=mapa;
        

    }

    @Override
    public void run() {
        while (true) {
            mapa();
            try {
                krawiedzie(car);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mapa() {
           switch (mapa) {
            case 1:
                file = new File("C:\\Users\\MR\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\MAPY\\mapa.bmp");
                break;
            case 2:
                file = new File("C:\\Users\\MR\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\MAPY\\mapa2.bmp");
                break;
            case 3:
                file = new File("C:\\Users\\MR\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\MAPY\\mapa3.bmp");
                break;
            default:
                break;
        }
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
        }
       // car.setAcceleration();
        int clr = image.getRGB((int) car.getX(), (int) car.getY());
        kolor = (clr & 0x00ffffff) >> 16;
        if (kolor == 255) {
            //System.out.println("white");
            if(car.returnAcceleration()==(1.5));
            else if(car.returnAcceleration()>=1.5) car.ac -=0.2;
        }
        if (kolor == 0) {
            //System.out.println("black");
            if(car.returnAcceleration()==(3));
            else if(car.returnAcceleration()<=3) car.ac +=0.2;
        }
        //System.out.println(car.ac);
        // System.out.println(System.currentTimeMillis());
    }

    private void krawiedzie(Samochod car) {
        xx = car.getX() + 10*Math.cos(car.getA());
        System.out.println("X: "+car.getX());
        yy =car.getY() + 10*Math.sin(car.getA());
         System.out.println("Y: "+car.getY());
         System.out.println("XX: "+xx);
         System.out.println("YY: "+yy);
         System.out.println("Sin X: "+10*Math.cos(car.getA()));
         System.out.println("Sin Y: "+10*Math.sin(car.getA()));
          System.out.println("-----------------------------------");
        //prawo
      
        if(xx>0){
            if(yy>0){
                if(xx<1150) {
                    if(yy<615) car.move_true = true;                     
                } else car.move_true = false;      
            } else car.move_true = false;      
        } else car.move_true = false;      
        
       if(xx<0){
           if(yy<0)  car.move_true = false;      
       }
        if(yy>0){   
            if(yy>615) car.move_true = false;      
        }
        
        
        
        
        xx=0;
        yy=0;
    }
}
