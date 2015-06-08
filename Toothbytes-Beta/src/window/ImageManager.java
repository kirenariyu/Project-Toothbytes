/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import java.awt.Dialog;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import models.Patient;
import utilities.DBAccess;

/**
 *
 * @author Ecchi Powa
 */
public class ImageManager extends javax.swing.JPanel {

    /**
     * Creates new form ImageManager
     */
    
    private Patient p;
    private String fileLocation, tag, date, remark;
    private int picNo, remarkNo;
    
    public ImageManager(Patient p) {
        initComponents();
        this.p = p;
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePane = new javax.swing.JPanel();
        imageLoad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarks = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        remarksNo = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        tagSelect = new javax.swing.JTextField();

        imagePane.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout imagePaneLayout = new javax.swing.GroupLayout(imagePane);
        imagePane.setLayout(imagePaneLayout);
        imagePaneLayout.setHorizontalGroup(
            imagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        imagePaneLayout.setVerticalGroup(
            imagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        imageLoad.setText("Load Image");
        imageLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageLoadActionPerformed(evt);
            }
        });

        remarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                remarksKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(remarks);

        jLabel1.setText("Characters Left:");

        remarksNo.setText("255");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");

        tagSelect.setText("inputTag");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remarksNo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(imageLoad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tagSelect))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageLoad)
                    .addComponent(tagSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(remarksNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageLoadActionPerformed
        fileLocation = promptForFile();
        JLabel image = new JLabel(fileLocation);
        imagePane.add(image);
    }//GEN-LAST:event_imageLoadActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            tag = tagSelect.getText();
            date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            remark = remarks.getText();
            
            picNo = DBAccess.getLastNo("DENTAL_PICTURES WHERE patientID = " + p.getId());
            picNo++;

            String patientPicDatabase = "res/photos/" + p.getId() + "-"+tag+"-"+date+"-" + picNo + ".jpg";
            File source = new File(fileLocation);
            File output = new File(patientPicDatabase);

            Files.copy(source.toPath(), output.toPath(), REPLACE_EXISTING);
            
            String query = "INSERT INTO DENTAL_PICTURES VALUES(DEFAULT, "+p.getId()+", null, NOW(), '"+remark+"', '"+tag+"', '"+patientPicDatabase+"')";
            DBAccess.dbQuery(query);
            
            Window w = SwingUtilities.getWindowAncestor(this);
            w.dispose();
        } catch (Exception ex) {
            System.out.println("ImageManager - imageLoadActionPerformed Error: "+ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void remarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remarksKeyReleased
        remarkNo = remarks.getText().length();
        remarksNo.setText(String.valueOf(remarkNo));
        if(remarkNo > 254){
            evt.consume();
        }
    }//GEN-LAST:event_remarksKeyReleased

    private String promptForFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton imageLoad;
    private javax.swing.JPanel imagePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane remarks;
    private javax.swing.JLabel remarksNo;
    private javax.swing.JButton save;
    private javax.swing.JTextField tagSelect;
    // End of variables declaration//GEN-END:variables
}
