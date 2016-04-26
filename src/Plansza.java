
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

public class Plansza extends JPanel {

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    private double x = 100;
    private double y = 100;
    private int akt_x = 0;
    private int akt_y = 0;
    private double a = 0;
    public double theta = 0;
    private double speed = 1.0;
    private int tmpAngle = 0;
    public AffineTransform at;
    public Samochod car = new Samochod(0, 0, 0, 27, 60);
    public BufferedImage image;
    Image bg;

    public Plansza() {

        //System.out.println("Przed");
        ImageIcon j = new ImageIcon("C:\\Users\\Marcin\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\car.png");
        bg = j.getImage();
//        File file = new File("C:\\Users\\Marcin\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\mapa.bmp");
//        try {
//            image = ImageIO.read(file);
//        } catch (IOException ex) {
//            Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
//        }
        car.setX(150);
        car.setY(150);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //s System.out.println(e.getKeyCode());
                switch (e.getKeyCode()) {
                    case 38:

                        Plansza.this.up = true;

                        // System.out.println("Klawisz góra");
                        break;

                    case 40:
                        Plansza.this.down = true;
                        break;

                    case 37:
                        Plansza.this.left = true;
                        break;

                    case 39:
                        Plansza.this.right = true;
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                switch (e.getKeyCode()) {
                    case 38:

                        Plansza.this.up = false;

                        break;

                    case 40:
                        Plansza.this.down = false;
                        break;

                    case 37:
                        Plansza.this.left = false;
                        break;

                    case 39:
                        Plansza.this.right = false;
                        break;

                    default:
                        break;
                }
            }
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                // TODO: wstawic zmienną podtrzymującą
                while (true) {
                    if (Plansza.this.up) {

                        Plansza.this.goUp();

                    }
                    if (Plansza.this.down) {
                        Plansza.this.goDown();
                    }
                    if (Plansza.this.left) {
                        if (Plansza.this.up) {
                            Plansza.this.goLeft();
                        } else if(Plansza.this.down) {
                            Plansza.this.goLeft();
                        } else {
                        }
                    }
                    if (Plansza.this.right) {
                        if (Plansza.this.up) {
                            Plansza.this.goRight();
                        } else if(Plansza.this.down) {
                            Plansza.this.goRight();
                        } else {
                        }
                    }
                    Plansza.this.repaint();
                    if (tmpAngle > 360) {
                        tmpAngle = 0;
                    } else if (tmpAngle < 0) {
                        tmpAngle = 360;

                    }
                    car.setA(tmpAngle);

                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        thread.start();

        Thread pozycja = new ThreadPosition(car);
        
        pozycja.start();
        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(image,0,0,1200,650,null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform old = g2d.getTransform();
        g2d.setColor(Color.white);

        // rotating the hero, rotation point is the middle of the square
        g2d.rotate(Math.toRadians(90) + car.getA(), car.getX() + car.getW() / 2, car.getY()
                + car.getH() / 2);
        
       
        g2d.drawImage(bg, (int) car.getX(), (int) car.getY(), (int) car.getW(), (int) car.getH(), null);

        g2d.setTransform(old);
    }

    public final void goUp() {
      car.moveForward();
    }
    public final void goDown() {
        car.moveBackword();     
    }  
    public final void goLeft() {
        tmpAngle -= 1;     
    }
    public final void goRight() {
        tmpAngle += 1;    
    }

}
