
import java.awt.Dimension;
import java.awt.Toolkit;


public class Konfiguracja extends javax.swing.JFrame {
    public int auto;
    public int mapa;
    public Konfiguracja() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        mapa1 = new javax.swing.JRadioButton();
        mapa2 = new javax.swing.JRadioButton();
        mapa3 = new javax.swing.JRadioButton();
        auto1 = new javax.swing.JRadioButton();
        auto2 = new javax.swing.JRadioButton();
        auto3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        auto4 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        buttonGroup1.add(mapa1);
        mapa1.setText("1");
        jPanel1.add(mapa1);
        mapa1.setBounds(78, 318, 31, 23);

        buttonGroup1.add(mapa2);
        mapa2.setText("2");
        jPanel1.add(mapa2);
        mapa2.setBounds(240, 320, 31, 23);

        buttonGroup1.add(mapa3);
        mapa3.setText("3");
        jPanel1.add(mapa3);
        mapa3.setBounds(430, 320, 31, 23);

        buttonGroup2.add(auto1);
        auto1.setText("1");
        jPanel1.add(auto1);
        auto1.setBounds(71, 133, 31, 23);

        buttonGroup2.add(auto2);
        auto2.setText("2");
        jPanel1.add(auto2);
        auto2.setBounds(193, 133, 31, 23);

        buttonGroup2.add(auto3);
        auto3.setText("3");
        jPanel1.add(auto3);
        auto3.setBounds(330, 140, 31, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/AUTA/bugati.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(181, 86, 79, 45);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/AUTA/car.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 90, 95, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/MAPY_MINI/mapa-kolor-mini.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(47, 218, 127, 69);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/MAPY_MINI/mapa2-kolor-mini.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(220, 220, 127, 69);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/MAPY_MINI/mapa3-kolor-mini.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(400, 220, 127, 69);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/AUTA/ambulance.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(59, 89, 116, 42);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("Wybierz samochód");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(47, 38, 289, 42);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/AUTA/police.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(470, 100, 60, 27);

        buttonGroup2.add(auto4);
        auto4.setText("4");
        jPanel1.add(auto4);
        auto4.setBounds(480, 140, 31, 23);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 153));
        jLabel9.setText("Wybierz mapę");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(47, 187, 97, 19);

        jButton1.setText("Graj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(510, 350, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 656, 415);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(auto1.isSelected()){
            auto=1;
        }else if(auto2.isSelected()){
            auto=2;
        }else if(auto3.isSelected()){
            auto=3;
        }
        else if(auto4.isSelected()){
            auto=4;
        }
        if(mapa1.isSelected()) mapa=1;
        else if(mapa2.isSelected()) mapa=2;
        else if(mapa3.isSelected()) mapa=3;
                PLansza_frame frame = new PLansza_frame(auto,mapa);
                Dimension  d2 = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(d2.width/2-600, d2.height/2-325);
                frame.setSize(1215, 685);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                   this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Konfiguracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Konfiguracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Konfiguracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Konfiguracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Konfiguracja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton auto1;
    private javax.swing.JRadioButton auto2;
    private javax.swing.JRadioButton auto3;
    private javax.swing.JRadioButton auto4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mapa1;
    private javax.swing.JRadioButton mapa2;
    private javax.swing.JRadioButton mapa3;
    // End of variables declaration//GEN-END:variables
}
