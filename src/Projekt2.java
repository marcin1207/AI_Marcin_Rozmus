
import java.awt.Button;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Projekt2 extends javax.swing.JFrame {

    int rozmiar1 = 800;
    int rozmiar2 = 600;
    int x=50;
    public ImageIcon kolo;
    public Image bg;
    public double theta=0;
    public BufferedImage image;
    public  static Button btn1, btn2;
    public File file;

    public Projekt2() {
        btn1 = new Button();
       
        btn1.setBounds(100, 400, 90, 35);
        btn1.setVisible(true);
        btn1.setFocusable(true);
        btn1.setLabel("Logowanie");
        btn1.setForeground(Color.cyan);
        btn1.setBackground(Color.DARK_GRAY);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        dispose();
                        Logowanie logowanie = new Logowanie();
                        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                        logowanie.setLocation(d.width / 2 - 400, d.height / 2 - 300);
                        logowanie.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        logowanie.setVisible(true);

                    }
                });
            }
        });
        btn2 = new Button();
        btn2.setBounds(600, 400, 90, 35);
        btn2.setVisible(true);
        btn2.setFocusable(true);
        btn2.setLabel("Rejestracja");
        btn2.setForeground(Color.cyan);
        btn2.setBackground(Color.DARK_GRAY);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rejestracja okno = new Rejestracja();
                Dimension d3 = Toolkit.getDefaultToolkit().getScreenSize();
                okno.setLocation(d3.width / 2 - 400, d3.height / 2 - 300);
                okno.setSize(800, 600);
                okno.setVisible(true);
                okno.setDefaultCloseOperation(EXIT_ON_CLOSE);
                okno.setFocusable(true);
                dispose();
            }
        });

        initComponents();
        file = new File("C:\\Users\\Marcin\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\tlo.jpg");
        kolo = new ImageIcon("C:\\Users\\Marcin\\Documents\\NetBeansProjects\\Java_lato_2015-2016_Marcin_Rozmus\\src\\gfx\\wheel2.png");
        bg = kolo.getImage();
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Projekt2.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread animacja = new Thread(){
         
            @Override
            public void run(){
                while(true){
                RuchKoła();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Projekt2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        };
        animacja.start(); 
    }
    private void RuchKoła(){
       theta+=5;
       x+=3;
       repaint();
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(image, 0, 0, 800, 600, null);
        
        AffineTransform transform = new AffineTransform();
        //g2d.translate(50, 50);
        transform.translate(x, 370);
       
        transform.rotate(Math.toRadians(theta),50,50);
        
        g2d.drawImage(bg, transform, null);
        //g2d.translate(-50, -50);
        //g2d.drawImage(bg, 300, 400, null);
        
        
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Projekt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projekt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projekt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projekt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Projekt2 głowne = new Projekt2();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                głowne.setLocation(d.width / 2 - 400, d.height / 2 - 300);
                głowne.setDefaultCloseOperation(EXIT_ON_CLOSE);
                głowne.setVisible(true);
                głowne.add(btn1);
                głowne.add(btn2);
                /*
                PLansza_frame frame = new PLansza_frame();
                Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(d2.width/2-600, d2.height/2-325);
                frame.setSize(1200, 650);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                Konfiguracja konf = new Konfiguracja();
                Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
                konf.setLocation(d2.width/2-300, d2.height/2-200);
                konf.setSize(700, 450);
                konf.setVisible(true);
                konf.setDefaultCloseOperation(EXIT_ON_CLOSE);
                 */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
