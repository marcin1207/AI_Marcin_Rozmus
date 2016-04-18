
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Rejestracja extends javax.swing.JFrame {

    /**
     * Creates new form Rejestracja
     */
    public Rejestracja() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        login_box = new javax.swing.JTextField();
        imie_box = new javax.swing.JTextField();
        password_box = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5_message = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nick:");
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 180, 100, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Imię:");
        jLabel2.setAlignmentY(0.0F);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 130, 100, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hasło:");
        jLabel3.setAlignmentY(0.0F);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 230, 100, 30);

        login_box.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        login_box.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(login_box);
        login_box.setBounds(240, 180, 120, 30);

        imie_box.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        imie_box.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(imie_box);
        imie_box.setBounds(240, 130, 120, 30);

        password_box.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        password_box.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(password_box);
        password_box.setBounds(240, 230, 120, 30);

        jButton1.setBackground(new java.awt.Color(51, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Zarejestruj");
        jButton1.setAlignmentY(0.0F);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(430, 280, 170, 40);

        jLabel5_message.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5_message.setAlignmentY(0.0F);
        jPanel1.add(jLabel5_message);
        jLabel5_message.setBounds(110, 330, 290, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/tlo3.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-10, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection Conn = null;
        PreparedStatement PSt = null;
        Connection myConn = null;
        PreparedStatement myPSt = null;
        try {
            Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gra", "root", "student");
            PSt = Conn.prepareStatement("INSERT INTO `players`(`Name`, `Login`, `Password`) VALUES ( ?, ?, ?);");
            PSt.setString(1, imie_box.getText());
            PSt.setString(2, login_box.getText());
            PSt.setString(3, String.valueOf(password_box.getPassword()));
            PSt.execute();
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gra", "root", "student");
            myPSt = myConn.prepareStatement("SELECT `Name`, `Login`, `Password` FROM `players` WHERE `Login` = ? AND `Password` = ?");
            myPSt.setString(1, login_box.getText());
            myPSt.setString(2, String.valueOf(password_box.getPassword()));
            ResultSet result = myPSt.executeQuery();  
            //int intinsertedRows=PSt.executeUpdate("SELECT `Name`, `Login`, `Password` FROM `players` WHERE `Login` = ? AND `Password` = ?");
            if (result.next()) {
                jLabel5_message.setText("Registered user !");
                jLabel5_message.setForeground(Color.GREEN);
               
            } else {
                jLabel5_message.setText("Registration error");
                jLabel5_message.setForeground(Color.RED);
               
            }
            
            

        }
    
   catch ( SQLException sqlex )
   {
      System.out.println(sqlex.getMessage());
      jLabel5_message.setText(sqlex.getMessage());
      jLabel5_message.setForeground(Color.RED);
     
   }
   catch(Exception e)
   {
      System.out.println(e.getMessage());
     
   }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField imie_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5_message;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField login_box;
    private javax.swing.JPasswordField password_box;
    // End of variables declaration//GEN-END:variables
}