
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
    public Samochod car = new Samochod(200, 200, 0, 27, 60);
    public BufferedImage image;
    Image bg;

    public Plansza() {

        //System.out.println("Przed");
        ImageIcon j = new ImageIcon("C:\\Users\\MR\\Documents\\NetBeansProjects\\Projekt2\\src\\gfx\\car.png");
        bg = j.getImage();
        File file = new File("C:\\Users\\MR\\Documents\\NetBeansProjects\\Projekt2\\src\\gfx\\mapa.bmp");
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                        Plansza.this.goLeft();
                    }
                    if (Plansza.this.right) {
                        Plansza.this.goRight();
                    }
                    Plansza.this.repaint();
                    if (tmpAngle > 360) {
                        tmpAngle = 0;
                    } else if (tmpAngle < 0) {
                        tmpAngle = 360;

                    }
                    car.setA(tmpAngle);
                    try {
                      
                    } catch (Exception ex) {
                        Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.err.println("X: "+(int)car.getX());

                    //System.err.println("Y: "+(int)car.getY());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        Thread kolor = new Thread() {
            @Override
            public void run() {

                //int pixel_x = 50;
                //int pixel_y = 50;
                int clr = image.getRGB((int) car.getX(), (int) car.getY());

                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                if (red == 255 && green == 255 && blue == 255) {
                    System.out.println("Black");
                }
                if (red == 0 && green == 0 && blue == 0) {
                    System.out.println("White");
                }

            }

        };
        
        kolor.start();
        thread.start();
        
    }

    @Override
    public void paint(Graphics g) {
        /*
        at=AffineTransform.getTranslateInstance(this.x, this.y);
        //at.translate(70, 120);
        at.rotate(Math.toRadians(this.theta),68,150);
       // at.translate(-70, -120);
        
        //at.rotate(theta);
        Graphics2D g2d =(Graphics2D) g;
        g2d.clearRect(0, 0, 1000, 800);
        //g2d.scale(1, -1);
        g2d.drawImage(bg, at, null);
    
        //g.fillRect( (int) this.x,  (int) this.y, 20, 20);
         */
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform old = g2d.getTransform();

        g2d.setColor(Color.white);

        // rotating the hero, rotation point is the middle of the square
        g2d.rotate(Math.toRadians(90) + car.getA(), car.getX() + car.getW() / 2, car.getY()
                + car.getH() / 2);
        // drawing the square
        //g2d.drawRect((int) car.getX(), (int) car.getY(), car.getW(),car.getH());

        g2d.drawImage(bg, (int) car.getX(), (int) car.getY(), (int) car.getW(), (int) car.getH(), null);

        // to know the "head"
        //sg2d.fillRect((int) car.getX() + car.getW(), (int) car.getY() + 10, 10, 30);
        //in case you have other things to rotate
        g2d.setTransform(old);
    }

    public final void goUp() {
        //System.out.println("Klawisz góra");
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
