
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    public int auto,mapa,c,b,d,e;
    
    public ImageIcon j;
    public ImageIcon bonus;
    public JLabel lb1,lb2;
    public int czas=0; 
    boolean siec= true;
     Random r ;
    public Samochod car = new Samochod(20, 20, 20, 60, 27);
    public BufferedImage image;
    public File file;
    Image bg;
    Image piorun;
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    public Font font;

    public Plansza(int auto1, int mapa1) {
        
        
        this.mapa = mapa1;
        this.auto = auto1;
        int style = Font.BOLD;

        font = new Font ("Arial", style , 14);
          r = new Random();
         b=r.nextInt(1200);//X
         c=r.nextInt(650);//y
         d=r.nextInt(1200);//X
         e=r.nextInt(650);//y
        switch (auto) {
            case 1:
                j = new ImageIcon("src\\gfx\\AUTA\\ambulance.png");
                break;
            case 2:
                j= new ImageIcon("src\\gfx\\AUTA\\bugati.png");
                break;
            case 3:
                j = new ImageIcon("src\\gfx\\AUTA\\car.png");
                break;
            case 4:
                j = new ImageIcon("src\\gfx\\AUTA\\police.png");
                break;
            default:
                break;
        }
        bg = j.getImage();
        
        switch (mapa) {
            case 1:
                file = new File("src\\gfx\\MAPY\\mapa-kolor.jpg");
                break;
            case 2:
                file = new File("src\\gfx\\MAPY\\mapa2-kolor.jpg");
                break;
            case 3:
                file = new File("src\\gfx\\MAPY\\mapa3-kolor.jpg");
                break;
            default:
                break;
        }
       try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
           Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
        }
        bonus = new ImageIcon("src\\gfx\\piorun.png");
        piorun= bonus.getImage();
        car.setX(100);
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
        Thread czas2 = new Thread(){
        @Override
        public void run(){
            while(true){
                czas=czas+1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
                }
        };
        czas2.start();
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                
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
                        Thread.sleep(10);
                        repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
            
        };
        thread.start();
        Thread pozycja = new ThreadPosition(car,auto,mapa);      
        pozycja.start();       
        Thread task1 = new Thread() {
            @Override
            public synchronized void run() {
                
                while(true){
                     Odtwarzacz muzyka = new Odtwarzacz();
                    muzyka.play();
                    try {
                        Thread.sleep(118000 );
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                
            };
        };
        task1.start();
        Thread watek_siec = new Thread("Sieć"){
            public  synchronized void run(){
            System.out.println("Connecting");  
                try {
                    socket = new Socket("localhost", 8192);
                    System.out.println("Connection successful.");
                    siec=true;
                    
                } catch (Exception ex) {
                     System.out.println("Bład przy połączeniu");
                     Thread.interrupted();
                     siec =false;
                  System.out.println("Zamknięto wątek");
                }
                finally{
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
           
            while(siec){
                
                double  x = car.getX();
                double  y = car.getY();
                
                try {
                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeDouble(x);
                    out.writeDouble(y);
                    System.out.println("Wysłano");
                } catch (IOException ex) {
                    Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }

        };
        //watek_siec.start();
        Thread bonus = new Thread("Bonus"){
        public void run(){
            while(true){
                 b=r.nextInt(1200);
                 c=r.nextInt(650);
                 d=r.nextInt(1200);//X
                 e=r.nextInt(650);//y
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        };
       bonus.start();
    }

    @Override
    public void paint(Graphics g) {
 
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(image,0,0,1200,650,null);
        g2d.setFont(font);
        
        g2d.drawString("Czas: "+String.valueOf(czas)+ "s", 50, 100);
        
        g2d.drawImage(piorun,b,c,40, 40, null); 
        g2d.drawImage(piorun,d,e,40, 40, null); 
        
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform old = g2d.getTransform();
      
        
        g2d.setColor(Color.white);

        // rotating the hero, rotation point is the middle of the square
        g2d.rotate( car.getA(), car.getX() + car.getW() / 2, car.getY()+ car.getH() / 2);
     
        //g2d.setPaint(Color.red);
       
        //g2d.fill(car);
       
        
       g2d.drawImage(bg, (int) car.getX(), (int) car.getY(), (int) car.getW(), (int) car.getH(), null); 
       

        g2d.setTransform(old);
    }
    public void update(Graphics g){
        paint(g);
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
