/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.forms;

import java.awt.Dialog;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import utilities.AdditionalInfo;
import utilities.DBAccess;
import utilities.MedicalCond;

/**
 *
 * @author Ecchi Powa
 */
public class InfoEditor extends javax.swing.JPanel {

    /**
     * Creates new form InfoEditor
     */
        
    private ArrayList<AdditionalInfo> additionalInfoList = new ArrayList<>();
    private ArrayList<MedicalCond> medicalConditionList = new ArrayList<>();
    private int patientID = 0;
    private int selection = 0;
    
    public InfoEditor(int patientID) {
        initComponents();
        this.patientID = patientID;
        start();
    }
    
    private void start(){
        additionalInfoList = DBAccess.getAdditionalInfoData(patientID);
        medicalConditionList = DBAccess.getMedicalConditionData(patientID);
        addNew.setEnabled(false);
        edit.setEnabled(false);
        delete.setEnabled(false);
    }
    
    private void resetTable(){
        editTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        editTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        editTable.setCellSelectionEnabled(true);
        editTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(editTable);
        editTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editTable = new javax.swing.JTable();
        select = new javax.swing.JComboBox();
        addNew = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        close = new javax.swing.JButton();

        editTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        editTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        editTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editTable.setRowSelectionAllowed(true);
        editTable.getTableHeader().setReorderingAllowed(false);
        editTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(editTable);
        editTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        select.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Info", "Additional Info", "Medical Info" }));
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        addNew.setText("Add New");
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });

        edit.setText("Edit Existing");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(select, javax.swing.GroupLayout.Alignment.LEADING, 0, 164, Short.MAX_VALUE)
                    .addComponent(addNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                        .addComponent(close)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed
        if(select.getSelectedIndex() == 1){
            launchAdditionalInformation();
        }  else if(select.getSelectedIndex() == 2){
            launchMedicalInformation();
        }
    }//GEN-LAST:event_addNewActionPerformed
    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        resetTable();
        edit.setEnabled(false);
        delete.setEnabled(false);
        if(select.getSelectedIndex() == 1 && select.getSelectedIndex() != selection){
            selection = select.getSelectedIndex();
            changeEditTableAddInfo();
            addNew.setEnabled(true);
        } else if(select.getSelectedIndex() == 2 && select.getSelectedIndex() != selection){
            selection = 2;
            changeEditTableMedInfo();
            addNew.setEnabled(true);
            
        } else {
            selection = 0;
            addNew.setEnabled(false);
        }
    }//GEN-LAST:event_selectActionPerformed
    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        Window w = SwingUtilities.getWindowAncestor(this);
        w.dispose();
    }//GEN-LAST:event_closeActionPerformed
    private void editTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTableMouseReleased
        if(select.getSelectedIndex() == 1){
            edit.setEnabled(true);
            delete.setEnabled(true);
        }
    }//GEN-LAST:event_editTableMouseReleased
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if(selection == 1){
            int row = editTable.getSelectedRow();
            int selectedID = Integer.parseInt(String.valueOf(editTable.getModel().getValueAt(row, 0)));
            AdditionalInfo ai = null;
            
            for(int i = 0; i < additionalInfoList.size(); i++){
                if(additionalInfoList.get(i).getAdditionalInfoID() == selectedID){
                    ai = additionalInfoList.get(i);
                }
            }
            
            AdditionalInfo selectedAI = ai;
            
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    JDialog aie = new JDialog();
                    aie.add(new AdditionalInformation(selectedAI, selectedID));
                    aie.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    aie.pack();
                    aie.setVisible(true);
                    aie.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                }
            });
        }        
        
    }//GEN-LAST:event_editActionPerformed
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(selection == 1){
            int row = editTable.getSelectedRow();
            int selectedID = Integer.parseInt(String.valueOf(editTable.getModel().getValueAt(row, 0)));
            
            String query = "DELETE FROM ADDITIONAL_INFO WHERE ADDITIONALINFOID = "+selectedID;
            DBAccess.dbQuery(query);
        }
    }//GEN-LAST:event_deleteActionPerformed
    
    private void changeEditTableAddInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        DefaultTableModel editModel = new DefaultTableModel();
        editModel = (DefaultTableModel) editTable.getModel();
        
        editModel.addColumn("Additional Info ID");
        editModel.addColumn("Dental Insurance");
        editModel.addColumn("Effective Date");
        editModel.addColumn("Guardian Name");
        editModel.addColumn("Guardian Occupation");
        editModel.addColumn("Referral");
        editModel.addColumn("Reason");
        editModel.addColumn("Previous Dentist");
        editModel.addColumn("Last Dental Visit");
        editModel.addColumn("Physician Name");
        editModel.addColumn("Physician Office");
        editModel.addColumn("Physician Specialty");
        editModel.addColumn("Physician Contact No");
        
        editTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        for(int i = 0; i < additionalInfoList.size(); i++){
            String effectiveDate = "";
            String lastDentalVisit = "";
            try{
                effectiveDate = sdf.format(additionalInfoList.get(i).getEffectiveDate().getTime());
            }catch(Exception e){}
            try{
                lastDentalVisit = sdf.format(additionalInfoList.get(i).getLastDentalVisit().getTime());
            }catch(Exception e){}
            
            editModel.addRow(new Object[]{additionalInfoList.get(i).getAdditionalInfoID(), additionalInfoList.get(i).getDentalInsurance(),
            effectiveDate, additionalInfoList.get(i).getGuardianName(), additionalInfoList.get(i).getOccupation(),
            additionalInfoList.get(i).getReferrer(), additionalInfoList.get(i).getReason(), additionalInfoList.get(i).getPreviousDentist(),
            lastDentalVisit, additionalInfoList.get(i).getPhysicianName(), additionalInfoList.get(i).getOfficeAddress(),
            additionalInfoList.get(i).getSpecialization(), additionalInfoList.get(i).getOfficeNumber()});
        }
        
        editTable.removeColumn(editTable.getColumnModel().getColumn(0));
    }
    private void changeEditTableMedInfo(){
        DefaultTableModel editModel = new DefaultTableModel();
        editModel = (DefaultTableModel) editTable.getModel();
        
        editModel.addColumn("Medical History ID");
        editModel.addColumn("Good Health");
        editModel.addColumn("Condition");
        editModel.addColumn("Serious Illness");
        editModel.addColumn("Hospitalized");
        editModel.addColumn("Prescription");
        editModel.addColumn("Tobacco");
        editModel.addColumn("Drugs");
        editModel.addColumn("Pregnant");
        editModel.addColumn("Nursing");
        editModel.addColumn("Birth Control");
        editModel.addColumn("Allergy");
        editModel.addColumn("Other Allergy");
        editModel.addColumn("Blood Type");
        editModel.addColumn("Blood Pressure");
        editModel.addColumn("Illness");
        editModel.addColumn("Date");
        
        editTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        editTable.removeColumn(editTable.getColumnModel().getColumn(0));
            
        for(int i = 0; i < medicalConditionList.size(); i++){
            editModel.addRow(medicalConditionList.get(i).returnData());
        }
        
        editTable.removeColumn(editTable.getColumnModel().getColumn(0));
    }
    
    private void launchAdditionalInformation(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                JDialog ai = new JDialog();
                ai.add(new AdditionalInformation(patientID));
                ai.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                ai.pack();
                ai.setVisible(true);
                ai.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                Window w = SwingUtilities.getWindowAncestor(ai);
                w.dispose();
            }
        });
    }
    private void launchMedicalInformation(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                JDialog ai = new JDialog();
                ai.add(new MedicalCondition(patientID));
                ai.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                ai.pack();
                ai.setVisible(true);
                ai.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                Window w = SwingUtilities.getWindowAncestor(ai);
                w.dispose();
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNew;
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTable editTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox select;
    // End of variables declaration//GEN-END:variables
}
