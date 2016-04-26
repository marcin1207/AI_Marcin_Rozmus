
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ThreadPosition extends Thread {

    public BufferedImage image;
    private Samochod car;
    public int kolor;
    private double xx=0;
    private double yy=0;

    public ThreadPosition(Samochod car) {
        this.car = car;

    }

    @Override
    public void run() {
        while (true) {
            mapa();
            try {
                krawiedzie(car);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mapa() {
        File file = new File("C:\\Users\\Marcin\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\mapa.bmp");
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
        }
        int clr = image.getRGB((int) car.getX(), (int) car.getY());
        kolor = (clr & 0x00ffffff) >> 16;
        if (kolor == 0) {
            System.out.println("white");
            car.setAcceleration();
        }
        if (kolor == 255) {
            System.out.println("black");
            car.returnAcceleration();
        }
        // System.out.println(System.currentTimeMillis());
    }

    private void krawiedzie(Samochod car) {
        xx = car.getX() + Math.cos(car.getA());
        yy =car.getY() + Math.sin(car.getA());
        System.out.println(xx);
        System.out.println(car.getA());
        System.out.println(yy);
        //System.out.println(car.getX());
        //System.out.println(car.getY());
        if (xx < 1100) {
            if (yy < 550) {
                car.set_move_true(true);
                System.out.println("ruch");
            } else {
                car.set_move_true(false);
            }
        } else {
            car.set_move_true(false);
        }
        xx=0;
        yy=0;
    }
}
