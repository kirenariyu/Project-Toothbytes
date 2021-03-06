/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Patient;
import utilities.DBAccess;

/**
 *
 * @author Ecchi Powa
 */
public class ImageManager extends javax.swing.JPanel {

    private final String BUTTON_DIR = "res/buttons/";
    private final String GALLERY_DIR = "res/gallery/";
   
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

        imageLoad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarks = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        remarksNo = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        tagSelect = new javax.swing.JTextField();
        imagePane = new javax.swing.JLabel();

        imageLoad.setText("Load Image");
        imageLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageLoadActionPerformed(evt);
            }
        });

        remarks.setToolTipText("Remarks");
        remarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                remarksKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(remarks);

        jLabel1.setText("Characters Left:");

        remarksNo.setText("255");

        save.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Save.png"));
        save.setText("Save");
        save.setToolTipText("");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Cancel.png"));
        cancel.setText("Cancel");
        cancel.setToolTipText("");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        tagSelect.setText("inputTag");
        tagSelect.setToolTipText("Tag");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tagSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remarksNo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(save)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(save)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageLoadActionPerformed
         tag = String.valueOf(p.getId());
            date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            remark = remarks.getText();
            
            picNo = DBAccess.getLastNo("DENTAL_PICTURES WHERE patientID = " + p.getId());
            picNo++;
            
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMG", "jpg","png");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fc.getSelectedFile();
            String fileName = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            System.out.println("You chose to open this file: " + selectedFile.getName());            
            imagePane.setIcon(ResizeGalImage(path));
            fileName = p.getId() + "-"  +tag+"-"+date+"-" + picNo + ".jpg";
            BufferedImage image, resizedImg;   
            String patientPicDatabase = GALLERY_DIR + fileName;
            System.out.println(patientPicDatabase);
            System.out.println(path);
            try{
                image = ImageIO.read(selectedFile);
                int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
                resizedImg = resizeImage(image, type, 570, 400);
                ImageIO.write(resizedImg, "jpg", new File(patientPicDatabase));
            }catch(IOException error){
                                            
            } 
            String query = "INSERT INTO DENTAL_PICTURES VALUES(DEFAULT, "+p.getId()+", '"+patientPicDatabase+"', NOW(), '"+remark+"', '"+tag+"')";
            DBAccess.dbQuery(query);
            System.out.println(query);
        }else if (result == JFileChooser.CANCEL_OPTION){ 
            
        }
    }//GEN-LAST:event_imageLoadActionPerformed
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
    
    public ImageIcon ResizeGalImage(String imagePath){
        ImageIcon MyImage = new ImageIcon(imagePath);
        Image img = MyImage.getImage();        
        Image newImage = img.getScaledInstance(255, 245, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            JOptionPane.showMessageDialog(null,"Update Success");
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

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        Window w = SwingUtilities.getWindowAncestor(this);
        w.dispose();
    }//GEN-LAST:event_cancelActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton imageLoad;
    private javax.swing.JLabel imagePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane remarks;
    private javax.swing.JLabel remarksNo;
    private javax.swing.JButton save;
    private javax.swing.JTextField tagSelect;
    // End of variables declaration//GEN-END:variables
}
