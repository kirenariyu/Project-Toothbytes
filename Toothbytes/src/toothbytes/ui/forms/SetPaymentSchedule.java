/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothbytes.ui.forms;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.border.*;

/**
 *
 * @author Kimwell Tandoc
 */
public class SetPaymentSchedule extends javax.swing.JPanel {

    /**
     * Creates new form SetPaymentSchedule
     */
    public SetPaymentSchedule() {
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
        cancelBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        specificDatesMonthCB = new javax.swing.JComboBox();
        specificDatesDayCB = new javax.swing.JComboBox();
        specificDatesYearCB = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        specificDatesAmountTF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        specificDatesTable = new javax.swing.JTable();
        specificDatesAddBtn = new javax.swing.JButton();
        specificDatesRemoveBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        timedFrequencyCB = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        timedAmountTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        timedSetBtn = new javax.swing.JButton();
        timedEditBtn = new javax.swing.JButton();
        timedRemoveBtn = new javax.swing.JButton();
        timedFromMonthCB = new javax.swing.JComboBox();
        timedFromDayCB = new javax.swing.JComboBox();
        timedFromYearCB = new javax.swing.JComboBox();
        timedToMonthCB = new javax.swing.JComboBox();
        timedToDayCB = new javax.swing.JComboBox();
        timedToYearCB = new javax.swing.JComboBox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Specific dates"));

        jLabel1.setText("Month:");

        jLabel2.setText("Day:");

        jLabel3.setText("Year:");

        specificDatesMonthCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month...", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        specificDatesMonthCB.setToolTipText("");

        specificDatesDayCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        specificDatesYearCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year...", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        jLabel4.setText("Amount:");

        specificDatesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Amount"
            }
        ));
        specificDatesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        specificDatesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                specificDatesTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(specificDatesTable);

        specificDatesAddBtn.setText("Add");
        specificDatesAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                specificDatesAddBtnMouseClicked(evt);
            }
        });

        specificDatesRemoveBtn.setText("Remove schedule");
        specificDatesRemoveBtn.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(specificDatesMonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specificDatesDayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(specificDatesYearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(specificDatesAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(specificDatesAddBtn))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(specificDatesRemoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specificDatesMonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specificDatesDayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specificDatesYearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specificDatesAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specificDatesAddBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specificDatesRemoveBtn))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Timed"));

        jLabel5.setText("Frequency:");

        timedFrequencyCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Frequency...", "Weekly", "Monthly", "Quarterly", "Semiannual", "Annualy" }));

        jLabel6.setText("Amount:");

        jLabel7.setText("From:");

        jLabel8.setText("To:");

        timedSetBtn.setText("Set");
        timedSetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timedSetBtnMouseClicked(evt);
            }
        });

        timedEditBtn.setText("Edit");
        timedEditBtn.setEnabled(false);
        timedEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timedEditBtnActionPerformed(evt);
            }
        });

        timedRemoveBtn.setText("Remove");

        timedFromMonthCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month...", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        timedFromMonthCB.setToolTipText("");

        timedFromDayCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        timedFromYearCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year...", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        timedToMonthCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month...", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        timedToMonthCB.setToolTipText("");

        timedToDayCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        timedToYearCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year...", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timedFrequencyCB, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(timedAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(timedFromMonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timedFromDayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timedFromYearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(timedEditBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timedRemoveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timedSetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(timedToMonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timedToDayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timedToYearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(timedSetBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timedEditBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timedRemoveBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timedFrequencyCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timedAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timedFromMonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timedFromDayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timedFromYearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timedToMonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timedToDayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timedToYearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okBtn))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(okBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_okBtnActionPerformed

    private void specificDatesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_specificDatesTableMouseClicked
        specificDatesRemoveBtn.setEnabled(true);
    }//GEN-LAST:event_specificDatesTableMouseClicked

    private void specificDatesAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_specificDatesAddBtnMouseClicked
        grayFieldBordersSD();
        String specificMonth = specificDatesMonthCB.getSelectedItem().toString();
        String specificDay = specificDatesDayCB.getSelectedItem().toString();
        String specificYear = specificDatesYearCB.getSelectedItem().toString();
        double specificAmount;
        try {
            specificAmount = Double.parseDouble(specificDatesAmountTF.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("nfe: " + nfe);
            if (specificDatesAmountTF.getText().isEmpty()) {
                specificAmount = 0.0;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount \n Please recheck.");
                specificDatesAmountTF.setText("");
                specificAmount = 0.0;
            }
        }

        if (!specificMonth.equals("Month...")
            && !specificDay.equals("Day...")
            && !specificYear.equals("Year...")
            && !Double.toString(specificAmount).isEmpty()
            && specificAmount > 0
            && !hasLetters(Double.toString(specificAmount))
            && !hasSpecialCharacters(Double.toString(specificAmount).replace(".", ""))) {
            //do the codes here, the inputs are valid
        } else {
            if (specificMonth.equals("Month...")) {specificDatesMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if (specificDay.equals("Day...")) {specificDatesDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if (specificYear.equals("Year...")) {specificDatesYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if (specificAmount <= 0 || specificDatesAmountTF.getText().isEmpty()) {specificDatesAmountTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            JOptionPane.showMessageDialog(null, "Some inputs are invalid. \n Please recheck.");
            System.out.println("some inputs are invalid \n" + specificMonth + "\n" + specificDay + "\n" + specificYear + "\n" + specificAmount);
        }
    }//GEN-LAST:event_specificDatesAddBtnMouseClicked

    private void timedSetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timedSetBtnMouseClicked
        grayFieldBordersT();
        String timedFrequency = timedFrequencyCB.getSelectedItem().toString();
        String timedFMonth = timedFromMonthCB.getSelectedItem().toString();
        String timedFDay = timedFromDayCB.getSelectedItem().toString();
        String timedFYear = timedFromYearCB.getSelectedItem().toString();
        String timedTMonth = timedToMonthCB.getSelectedItem().toString();
        String timedTDay = timedToDayCB.getSelectedItem().toString();
        String timedTYear = timedToYearCB.getSelectedItem().toString();
        double timedAmount;
        try {
            timedAmount = Double.parseDouble(timedAmountTF.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("nfe: " + nfe);
            if (timedAmountTF.getText().isEmpty()) {
                timedAmount = 0.0;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount \n Please recheck.");
                timedAmountTF.setText("");
                timedAmount = 0.0;
            }
        }
        if(!timedFMonth.equals("Month...") && !timedTMonth.equals("Month...") &&
            !timedFDay.equals("Day...") && !timedTDay.equals("Day...") &&
            !timedFYear.equals("Year...")&& !timedTYear.equals("Year...")&&
            !Double.toString(timedAmount).isEmpty() &&
            timedAmount > 0 &&
            !hasLetters(Double.toString(timedAmount)) &&
            !hasSpecialCharacters(Double.toString(timedAmount).replace(".", ""))){
            lockFields();
        }else{
            if(timedFrequency.equals("Frequency...")){timedFrequencyCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedFMonth.equals("Month...")){timedFromMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedTMonth.equals("Month...")){timedToMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedFDay.equals("Day...")){timedFromDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedTDay.equals("Day...")){timedToDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedFYear.equals("Year...")){timedFromYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedTYear.equals("Year...")){timedToYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(timedAmount == 0.0 || timedAmountTF.getText().isEmpty()){timedAmountTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            JOptionPane.showMessageDialog(null, " Some of the fields are invalid. \n Please recheck inputs.");
        }
    }//GEN-LAST:event_timedSetBtnMouseClicked

    private void timedEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timedEditBtnActionPerformed
        timedFrequencyCB.setEnabled(true);
        timedAmountTF.setEnabled(true);
        timedFromMonthCB.setEnabled(true);
        timedFromDayCB.setEnabled(true);
        timedFromYearCB.setEnabled(true);
        timedToMonthCB.setEnabled(true);
        timedToDayCB.setEnabled(true);
        timedToYearCB.setEnabled(true);
        timedSetBtn.setEnabled(true);
        timedEditBtn.setEnabled(false);
        grayFieldBordersT();
        timedSetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
    }//GEN-LAST:event_timedEditBtnActionPerformed

        public boolean hasNumbers(String numberlessString) {
        String pattern = "[0-9]";
        if (Pattern.compile(pattern).matcher(numberlessString).find()) {
            return true;//there is a number in the string
        } else {
            return false;//the string has no numbers
        }
    }

    public boolean hasSpecialCharacters(String specialCharacterlessString) {
        String pattern = "[^A-Za-z0-9]+";
        if (Pattern.compile(pattern).matcher(specialCharacterlessString).find()) {
            return true;//there is a special character in the string
        } else {
            return false;
        }
    }

    public boolean hasLetters(String letterlessString) {
        String pattern = "[A-Za-z]";
        if (Pattern.compile(pattern).matcher(letterlessString).find()) {
            return true;//there is a letter on the string
        } else {
            return false;
        }
    }

    public void grayFieldBordersSD() {
        specificDatesMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        specificDatesDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        specificDatesYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        specificDatesAmountTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
    }

    public void grayFieldBordersT() {
        timedFrequencyCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedAmountTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedFromMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedFromDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedFromYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedToMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedToDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        timedToYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
    }

    public void lockFields(){
        timedFrequencyCB.setEnabled(false);
        timedAmountTF.setEnabled(false);
        timedFromMonthCB.setEnabled(false);
        timedFromDayCB.setEnabled(false);
        timedFromYearCB.setEnabled(false);
        timedToMonthCB.setEnabled(false);
        timedToDayCB.setEnabled(false);
        timedToYearCB.setEnabled(false);
        timedSetBtn.setEnabled(false);
        timedEditBtn.setEnabled(true);
        timedFrequencyCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedAmountTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedFromMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedFromDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedFromYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedToMonthCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedToDayCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedToYearCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
        timedSetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,205,170)));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton okBtn;
    private javax.swing.JButton specificDatesAddBtn;
    private javax.swing.JTextField specificDatesAmountTF;
    private javax.swing.JComboBox specificDatesDayCB;
    private javax.swing.JComboBox specificDatesMonthCB;
    private javax.swing.JButton specificDatesRemoveBtn;
    private javax.swing.JTable specificDatesTable;
    private javax.swing.JComboBox specificDatesYearCB;
    private javax.swing.JTextField timedAmountTF;
    private javax.swing.JButton timedEditBtn;
    private javax.swing.JComboBox timedFrequencyCB;
    private javax.swing.JComboBox timedFromDayCB;
    private javax.swing.JComboBox timedFromMonthCB;
    private javax.swing.JComboBox timedFromYearCB;
    private javax.swing.JButton timedRemoveBtn;
    private javax.swing.JButton timedSetBtn;
    private javax.swing.JComboBox timedToDayCB;
    private javax.swing.JComboBox timedToMonthCB;
    private javax.swing.JComboBox timedToYearCB;
    // End of variables declaration//GEN-END:variables
}