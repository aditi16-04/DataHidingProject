/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import steganography.Steganography;

public class MainScreen extends javax.swing.JFrame {

    Steganography steganography = null;
    BufferedImage bufferedImage = null;
    int key;

    public MainScreen() {
        initComponents();
        key = 1;
        secretMessageTextField.setVisible(false);
        secretMessageLabel.setVisible(false);
        keyLabel.setVisible(false);
        keyTextField.setVisible(false);
        steganography = new Steganography();
        firstSectionImage.setSize(200, 200);
        secondImageSection.setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstSectionImage = new javax.swing.JLabel();
        firstSectionImage.setSize(300, 300);
        secondImageSection = new javax.swing.JLabel();
        secondImageSection.setSize(300, 300);
        jLabel1 = new javax.swing.JLabel();
        keyTextField = new javax.swing.JTextField();
        keyLabel = new javax.swing.JLabel();
        secretMessageLabel = new javax.swing.JLabel();
        secretMessageTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openImage = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        grayScale = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        binaryConversion = new javax.swing.JMenuItem();
        encryptData = new javax.swing.JMenuItem();
        embedData = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("A Novel Approach to Data Hiding to Maintain Visual Artifacts of Binary Cover Image");

        keyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyTextFieldActionPerformed(evt);
            }
        });

        keyLabel.setText("Enter Key");
        secretMessageLabel.setText("Secret Message");

        secretMessageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secretMessageTextFieldActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        openImage.setText("Open Image");
        openImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openImageActionPerformed(evt);
            }
        });

        jMenu1.add(openImage);
        exit.setText("Exit");
        jMenu1.add(exit);
        jMenuBar1.add(jMenu1);

        grayScale.setText("Edit");

        jMenuItem3.setText("Gray Scale conversion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        grayScale.add(jMenuItem3);

        binaryConversion.setText("Binary COnversion");
        binaryConversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryConversionActionPerformed(evt);
            }
        });
        grayScale.add(binaryConversion);

        encryptData.setText("Encrypt Data");
        encryptData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptDataActionPerformed(evt);
            }
        });
        grayScale.add(encryptData);

        embedData.setText("Embed Data");
        embedData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embedDataActionPerformed(evt);
            }
        });
        grayScale.add(embedData);

        jMenuItem7.setText("Decrypt and Extract");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        grayScale.add(jMenuItem7);

        jMenuBar1.add(grayScale);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(firstSectionImage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(keyTextField)
                                                .addComponent(keyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(secretMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(secretMessageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(secondImageSection, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(firstSectionImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(secondImageSection, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(119, 119, 119))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(keyLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(keyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(secretMessageLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(secretMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ImageIcon icon = new ImageIcon();
    String filepath = "";

    private void openImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openImageActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        int i = chooser.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            filepath = f.getPath();
            try {
                firstSectionImage.setIcon(new ImageIcon(ImageIO.read(new File(filepath))));
                steganography.loadImage(filepath);
                key = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_openImageActionPerformed

    private void keyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyTextFieldActionPerformed

    private void secretMessageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secretMessageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secretMessageTextFieldActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (key == 1) {
            key = 2;
            bufferedImage = steganography.convertTogray();
            if (bufferedImage == null) {
                JOptionPane.showMessageDialog(this, "Error");
            } else {
                JOptionPane.showMessageDialog(this, "Gray conversion successful");
                try {
                    secondImageSection.setIcon(new ImageIcon(ImageIO.read(new File(filepath))));
                } catch (IOException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void binaryConversionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryConversionActionPerformed
        // TODO add your handling code here:
        if (key == 2) {
            key = 3;
            keyLabel.setVisible(true);
            keyTextField.setVisible(true);
            secretMessageLabel.setVisible(true);
            secretMessageTextField.setVisible(true);
            int status = steganography.convertToBinary();
            if (status == 1) {
                JOptionPane.showMessageDialog(this, "Binary conversion done");
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_binaryConversionActionPerformed
    String encrypted;

    private void encryptDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptDataActionPerformed
        // TODO add your handling code here:
        if (key == 3) {
            String keyData = keyTextField.getText().toString();
            String msg = secretMessageTextField.getText().toString();
            if (keyData.equals("") || keyData == null || msg.equals("") || msg == null) {
                JOptionPane.showMessageDialog(this, "Please fill data first");
            } else {
                key = 4;
                keyTextField.setText("");
                secretMessageTextField.setText("");
                encrypted = steganography.encrypt(msg, keyData);
                keyLabel.setVisible(false);
                keyTextField.setVisible(false);
                secretMessageLabel.setVisible(false);
                secretMessageTextField.setVisible(false);
                if (encrypted.equals("") || encrypted == null) {
                    JOptionPane.showMessageDialog(this, "Error in encrypting");
                } else {
                    JOptionPane.showMessageDialog(this, "Encrypted");
                }
            }
        }
    }//GEN-LAST:event_encryptDataActionPerformed

    private void embedDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embedDataActionPerformed
        // TODO add your handling code here:
        if (key == 4) {
            key = 5;
            bufferedImage = steganography.encode(encrypted, steganography.H1, steganography.H2);
            keyLabel.setVisible(true);
            keyTextField.setVisible(true);
            if (bufferedImage == null) {
                JOptionPane.showMessageDialog(this, "Error");
            } else {
                secondImageSection.setIcon(new ImageIcon(bufferedImage));
                JOptionPane.showMessageDialog(this, "Data Embedded");
            }
        }
    }//GEN-LAST:event_embedDataActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if (key == 5) {
            key = 6;
            String keyData = keyTextField.getText().toString();
            if (keyData.equals("") || keyData == null) {
                JOptionPane.showMessageDialog(this, "Please fill data first");
            } else {
                String decryptedData = steganography.decode(keyData);
                if (decryptedData.equals("") || decryptedData == null) {
                    JOptionPane.showMessageDialog(this, "Error in encrypting");
                } else {
                    JOptionPane.showMessageDialog(this, decryptedData);
                }
            }
        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem binaryConversion;
    private javax.swing.JMenuItem embedData;
    private javax.swing.JMenuItem encryptData;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel firstSectionImage;
    private javax.swing.JMenu grayScale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JLabel keyLabel;
    private javax.swing.JTextField keyTextField;
    private javax.swing.JMenuItem openImage;
    private javax.swing.JLabel secondImageSection;
    private javax.swing.JLabel secretMessageLabel;
    private javax.swing.JTextField secretMessageTextField;
    // End of variables declaration//GEN-END:variables
}
