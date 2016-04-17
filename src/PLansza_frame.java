

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
 

public class PLansza_frame  extends JFrame{

    public PLansza_frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Plansza plansza = new Plansza();
        Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
        //plansza.setLocation(d2.width/2-500, d2.height/2-400);
        //plansza.setSize(1000, 800);
        plansza.setFocusable(true);
        plansza.setVisible(true);
        plansza.setDoubleBuffered(true);
        this.add(plansza);
        this.pack();
    
    
    }
    
    
    
}
