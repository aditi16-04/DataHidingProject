package my_be_project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * embed.java
 *
 * Created on Apr 20, 2014, 1:11:28 PM
 */
/**
 *
 * @author Prativa
 */
import javax.swing.*;
import java.awt.event.*;

import java.io.*;

public class embed extends javax.swing.JFrame {

    public static String path;
    public static String imgpath;
    public static String name;
    public static String s2;
    public static String secret;
    public static String key1;
    public static String key2;

    public embed() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Novel Approach for Data Hiding in Black and White Images");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane3 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));

        jDesktopPane3.setBackground(new java.awt.Color(240, 240, 240));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel2.setText("Enter Secret Data");
        jLabel2.setBounds(50, 150, 140, 18);
        jDesktopPane3.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel3.setText("Enter Key 1");
        jLabel3.setBounds(50, 210, 100, 20);
        jDesktopPane3.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel4.setText("Enter Key 2");
        jLabel4.setBounds(50, 270, 91, 18);
        jDesktopPane3.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField2.setBounds(250, 150, 280, 24);
        jDesktopPane3.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField3.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField3.setBounds(250, 210, 280, 24);
        jDesktopPane3.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField4.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField4.setBounds(250, 270, 280, 24);
        jDesktopPane3.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(250, 340, 90, 40);
        jDesktopPane3.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setText("A Novel Approach for Data Hiding in Black and White Images");
        jLabel1.setBounds(40, 60, 618, 20);
        jDesktopPane3.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(580, 430, 100, 40);
        jDesktopPane3.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField1.setBounds(50, 430, 500, 30);
        jDesktopPane3.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton2.setText("Embed");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(110, 500, 90, 40);
        jDesktopPane3.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(440, 500, 90, 40);
        jDesktopPane3.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String[] arg = new String[1];
        try {
            Img.main(arg);
            if (Img.embeddingPossible == 1) {
                JOptionPane.showMessageDialog(rootPane, "Embedding Possible");
                JOptionPane.showMessageDialog(rootPane, "Embedding Done");
            }
            if (Img.embeddingPossible == 0) {
                JOptionPane.showMessageDialog(rootPane, "Select Another Image");
            }
        } catch (Exception eee) {
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            JFileChooser chooser;
            JLabel label;
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("D:/new folder/."));

            int result = chooser.showOpenDialog(null);
            // if file selected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                name = chooser.getSelectedFile().getPath();
                jTextField1.setText(name);

            }

        } catch (Exception e) {
        }
        path = jTextField1.getText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        secret = jTextField2.getText();
        key1 = jTextField3.getText();
        key2 = jTextField4.getText();

        String[] arg = new String[1];
        try {
            DataPreparation.main(arg);
        } catch (Exception ee) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        new compareimage().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new embed().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
