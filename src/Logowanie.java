
import com.mysql.jdbc.MySQLConnection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Logowanie extends javax.swing.JFrame {

    /**
     * Creates new form Logowanie
     */
    Connection myConn = null;
    PreparedStatement myPSt = null;
    

    public Logowanie() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JLabel5_Message = new javax.swing.JLabel();
        jButton2_Message = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_box = new javax.swing.JTextField();
        pass_box = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setLayout(null);

        JLabel5_Message.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLabel5_Message.setForeground(new java.awt.Color(0, 0, 255));
        jPanel3.add(JLabel5_Message);
        JLabel5_Message.setBounds(60, 10, 380, 80);

        jButton2_Message.setBackground(new java.awt.Color(102, 102, 102));
        jButton2_Message.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2_Message.setForeground(new java.awt.Color(0, 102, 204));
        jButton2_Message.setText("OK");
        jButton2_Message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_MessageActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2_Message);
        jButton2_Message.setBounds(650, 20, 55, 29);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/tlo_01.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setAlignmentY(0.0F);
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 100);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 800, 0);

        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Login: ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(80, 180, 70, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Password:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(80, 220, 100, 30);

        login_box.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        login_box.setForeground(new java.awt.Color(0, 102, 204));
        login_box.setName("login_box"); // NOI18N
        jPanel2.add(login_box);
        login_box.setBounds(200, 180, 200, 30);
        login_box.getAccessibleContext().setAccessibleName("login_box");

        pass_box.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pass_box.setForeground(new java.awt.Color(0, 102, 204));
        pass_box.setName("pass_box"); // NOI18N
        jPanel2.add(pass_box);
        pass_box.setBounds(200, 220, 200, 30);
        pass_box.getAccessibleContext().setAccessibleName("pass_box");
        pass_box.getAccessibleContext().setAccessibleDescription("");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setText("Zaloguj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(430, 280, 110, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/tlo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setIconTextGap(0);
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 600);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Timer timer1 = new Timer(30, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jPanel3.getHeight() != 100) {
                jPanel3.setBounds(0, 0, 800, 100);
                if (jPanel3.getHeight() == 100) {
                    timer1.stop();
                }
            }

        }

    });
    Timer timer2 = new Timer(30, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jPanel3.getHeight() != 0) {
                jPanel3.setBounds(0, 0, 800, 0);
                if (jPanel3.getHeight() == 0) {
                    timer2.stop();
                }
            }

        }

    });

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gra", "root", "student");
            myPSt = myConn.prepareStatement("SELECT `Name`, `Login`, `Password` FROM `players` WHERE `Login` = ? AND `Password` = ?");
            myPSt.setString(1, login_box.getText());
            myPSt.setString(2, String.valueOf(pass_box.getPassword()));
            ResultSet result = myPSt.executeQuery();
            if (result.next()) {
                JLabel5_Message.setText("Login Successesfully");
                JLabel5_Message.setForeground(Color.GREEN);
                timer1.start();
            } else {
                JLabel5_Message.setText("Invalide Username Or Password");
                JLabel5_Message.setForeground(Color.RED);
                timer1.start();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Logowanie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2_MessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_MessageActionPerformed
        timer2.start();
        
        PLansza_frame frame = new PLansza_frame();
                Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(d2.width/2-600, d2.height/2-300);
                frame.setSize(1200, 600);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.dispose();
        
        
    }//GEN-LAST:event_jButton2_MessageActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel5_Message;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2_Message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField login_box;
    private javax.swing.JPasswordField pass_box;
    // End of variables declaration//GEN-END:variables
}
