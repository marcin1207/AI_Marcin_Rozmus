package server;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JTextArea;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

public class DataServer extends javax.swing.JFrame {

    public JTextArea txt_box;
    public JButton btn1;
    public JPanel panel;
    public JScrollPane scrol;
    
    static int port = 8192;
    static Users[] user = new Users[2];
    public static ServerSocket listener;
    public static Socket socket;
    public static DataOutputStream out;
    public static DataInputStream in;
    Double x, y;
    Double tmpx,tmpy;
    public DataServer() {

        initComponents();
        panel = new JPanel();
        panel.setBounds(0, 0, 400, 400);
        panel.setVisible(true);
        
        txt_box = new JTextArea();
        txt_box.setSize(400, 300);
        txt_box.setVisible(true);
        txt_box.setRows(15);
        txt_box.setColumns(30);
        
        scrol = new JScrollPane();
        scrol.setSize(400, 300);
        JScrollPane scroll = new JScrollPane (txt_box, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrol.setVisible(true);
        btn1 = new JButton();
        btn1.setBounds(30, 280, 120, 50);
        btn1.setText("Uruchom");
        btn1.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread watek;
                watek = new Thread("Serwer") {
                    public void run() {
                        try {
                            listener = new ServerSocket(8192);
                            txt_box.append("Sewer uruchomiony na porcie 8192\n");
                            socket = listener.accept();
                            txt_box.append("Connection from: " + socket.getInetAddress()+"\n");     
                            while (true) {
                                in = new DataInputStream(socket.getInputStream());
                                tmpx = in.readDouble();
                                tmpy = in.readDouble();
                                if(!Objects.equals(tmpx, x)){
                                    if(!Objects.equals(tmpy, y))
                                    {
                                        x=tmpx;
                                        y=tmpy;
                                        txt_box.append("klient 1: X: "+Math.round(x)+"  Y: "+Math.round(y)+"\n");
                                    }
                                }else{
                                    if(!Objects.equals(tmpy, y))
                                    {
                                        x=tmpx;
                                        y=tmpy;
                                        txt_box.append("klient 1: X: "+Math.round(x)+"  Y: "+Math.round(y)+"\n");
                                    }
                                }
                                
                               
                                
                                Thread.sleep(20);
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        catch (InterruptedException ex) {
                            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                watek.start();
            }
        });

        //panel.add(txt_box);
        
       
        panel.add(scroll);
         panel.add(btn1);
        this.add(panel);
        this.pack();

    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(DataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DataServer serw = new DataServer();
                serw.setSize(400, 400);
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                serw.setLocation(d.width / 2 - 200, d.height / 2 - 200);

                serw.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
