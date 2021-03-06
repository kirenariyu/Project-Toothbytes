/*
 * Copyright (c) 2014, 2015, Project Toothbytes. All rights reserved.
 *
 *
*/
package window.forms;

import java.awt.Window;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import utilities.PersonalInfo;

public class PersonalInformation extends javax.swing.JPanel {
    private PersonalInfo pi;
    private String patientID;
    private boolean newPatient = true;
    private final String BUTTON_DIR = "res/buttons/";
    
    public PersonalInformation() {
        initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }
    
    public PersonalInformation(PersonalInfo pi){
        initComponents();
        this.pi = pi;
        patientID = pi.getPatientID();
        insertData();
        newPatient = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        surnameTF = new javax.swing.JTextField();
        givenNameTF = new javax.swing.JTextField();
        miTF = new javax.swing.JTextField();
        genderCB = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        monthCB = new javax.swing.JComboBox();
        dayCB = new javax.swing.JComboBox();
        yearTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nicknameTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        homeAddressTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        telephoneNumberTF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cellphoneNumberTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        officeNumberTF = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        faxNumberTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        emailAddressTF = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        occupationTF = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        civilStatusCB = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(250, 255, 250));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Personal Information");

        jLabel2.setText("Surname:");

        jLabel3.setText("Given Name:");

        jLabel4.setText("MI:");

        genderCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gender", "Male", "Female" }));

        jLabel6.setText("Birthdate:");

        monthCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearTF.setText("Year");

        jLabel11.setText("Nickname:");

        jLabel12.setText("Civil Status:");

        jLabel13.setText("Home Address:");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact Information"));

        jLabel14.setText("Telephone Number:");

        jLabel15.setText("Cellphone Number:");

        jLabel16.setText("Office Number:");

        jLabel17.setText("Fax Number:");

        jLabel18.setText("Email Address:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cellphoneNumberTF))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(faxNumberTF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(officeNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(officeNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cellphoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(faxNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel19.setText("Occupation:");

        nextButton.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Save.png"));
        nextButton.setText("Save");
        nextButton.setToolTipText("");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Cancel.png"));
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");

        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("*");

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("*");

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("*");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("*");

        jLabel7.setText("Gender:");

        civilStatusCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Civil Status", "Single", "Married", "Divorced", "Separated", "Widowed" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(homeAddressTF))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel20)
                                                .addComponent(jLabel21)
                                                .addComponent(jLabel23))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(occupationTF)
                                                .addComponent(genderCB, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(civilStatusCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(nicknameTF, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(miTF, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(givenNameTF, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(surnameTF)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel8))))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(36, 36, 36))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(givenNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(miTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nicknameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel26)
                            .addComponent(civilStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(occupationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel28)))
                        .addGap(29, 29, 29)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        grayTFBorders();
        
        if(entriesValid()){
           //move to next page of registration 
            String surname = surnameTF.getText();               //no numbers, special characters
            String givenName = givenNameTF.getText();           //no numbers, special characters
            String mi =  miTF.getText();                        //no numbers
            String gender = genderCB.getSelectedItem().toString();
            
            //birthdate
            Calendar birthdate = Calendar.getInstance();
            int month = monthCB.getSelectedIndex();
            int day = dayCB.getSelectedIndex();
            int year = Integer.parseInt(yearTF.getText());
            birthdate.set(year, month, day);
            
            String nickname = nicknameTF.getText();       //no numbers, special characters
            String civilStatus = civilStatusCB.getSelectedItem().toString();             //no numbers
            String occupation = occupationTF.getText();         //no numbers
            String homeAddress = homeAddressTF.getText();
            String telephoneNo = telephoneNumberTF.getText();
            String officeNo = officeNumberTF.getText();
            String emailAdd = emailAddressTF.getText();
            String cellphoneNo = cellphoneNumberTF.getText();
            String faxNo = faxNumberTF.getText();
            
                        
            pi = new PersonalInfo(surname, givenName, mi, gender, birthdate, civilStatus, nickname, occupation, homeAddress,
            telephoneNo, officeNo, emailAdd, cellphoneNo, faxNo, null);
            
            updatePersonalInfo();  
            
        }else{
            int year = Integer.parseInt(yearTF.getText());
            
            if(miTF.getText().isEmpty() || hasNumbers(miTF.getText()) || miTF.getText().length() < -1 || miTF.getText().length() > 2){miTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(year < 1960 || yearTF.getText().isEmpty() || hasLetters(yearTF.getText()) || hasSpecialCharacters(yearTF.getText())){yearTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(civilStatusCB.getSelectedIndex() == 0){civilStatusCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(hasNumbers(occupationTF.getText())){occupationTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(surnameTF.getText().isEmpty()){surnameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(givenNameTF.getText().isEmpty()){givenNameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(homeAddressTF.getText().isEmpty()){homeAddressTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(genderCB.getSelectedIndex() == 0){genderCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));}
            if(hasLetters(telephoneNumberTF.getText())){telephoneNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(hasLetters(cellphoneNumberTF.getText())){cellphoneNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(hasLetters(officeNumberTF.getText())){officeNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            if(hasLetters(faxNumberTF.getText())){faxNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));}
            JOptionPane.showMessageDialog(null,"One or more fields are invalid. Please recheck inputs.");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        Window w = SwingUtilities.getWindowAncestor(this);
        w.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void updatePersonalInfo(){
        pi.NewPersonalInfo();
        JOptionPane.showMessageDialog(this,"Registration Successful");
        Window w = SwingUtilities.getWindowAncestor(this);
        w.dispose();
    }
    
    public void grayTFBorders(){
        miTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        yearTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        nicknameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        civilStatusCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        occupationTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        surnameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        givenNameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        homeAddressTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        telephoneNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        cellphoneNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        officeNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
        faxNumberTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201,201,201)));
    }
    
    public boolean entriesValid(){
        String surname = surnameTF.getText();               //no filter *
        String givenName = givenNameTF.getText();           //no filter *
        String mi =  miTF.getText();
        String birthYear = yearTF.getText();                //no letters 
        String nationality = nicknameTF.getText();       //no numbers, special characters 
        String occupation = occupationTF.getText();         //no numbers 
        String homeAddress = homeAddressTF.getText();       //no filter *
        
        if(!entriesNull(surname, givenName, mi, birthYear, homeAddress) &&
           !hasNumbers(mi) && mi.length() > -1 && mi.length() <= 2 &&
           !hasLetters(birthYear) &&
           !hasNumbers(nationality) && !hasSpecialCharacters(nationality) && 
           genderCB.getSelectedIndex() != 0 &&
           civilStatusCB.getSelectedIndex() !=0 &&
           !hasNumbers(occupation)){
            return true;
        }else{
            // One of the entries has invalid inputs
            return false;
        }
        
    }
    
    public boolean entriesNull(String surname, String givenName, String mi, String birthYear, String homeAddress){
        if(surname.isEmpty() || givenName.isEmpty() || mi.isEmpty() || birthYear.isEmpty() || homeAddress.isEmpty()){
            // One or more strings are null
            return true;
        }else{
            return false;
        }
    }
    
    public boolean hasNumbers(String numberlessString){
        String pattern = "[0-9]";
        if(Pattern.compile(pattern).matcher(numberlessString).find()){
            // There is a number in the string
            return true;
        }else{
            // The string has no numbers
            return false;
        }
    }
    
    public boolean hasSpecialCharacters(String specialCharacterlessString){
        String pattern = "[^A-Za-z0-9]+";
        if(Pattern.compile(pattern).matcher(specialCharacterlessString).find()){
            // There is a special character in the string
            return true;
        }else{
            return false;
        }
    }
    
    public boolean hasLetters(String letterlessString){
        String pattern = "[A-Za-z]";
        if(Pattern.compile(pattern).matcher(letterlessString).find()){
            // There is a letter on the string
            return true;
        }else{
            return false;
        }   
    }

    private void insertData(){
        surnameTF.setText(pi.getSurname());
        givenNameTF.setText(pi.getGivenName());
        miTF.setText(pi.getMI());
        
        if(pi.getGender().compareTo("M") == 1){
            genderCB.setSelectedIndex(1);
        } else {
            genderCB.setSelectedIndex(2);
        }
        
        nicknameTF.setText(pi.getNickname());
        civilStatusCB.setSelectedItem(pi.getCivilStatus());
        
        //Birthdate
        Calendar birthdate = pi.getBirthDate();
        int month = birthdate.get(Calendar.MONTH)+1;
        int day = birthdate.get(Calendar.DAY_OF_MONTH);
        int year = birthdate.get(Calendar.YEAR);
        
        monthCB.setSelectedIndex(month);
        dayCB.setSelectedIndex(day);
        yearTF.setText(String.valueOf(year));
        
        occupationTF.setText(pi.getOccupation());
        homeAddressTF.setText(pi.getHomeAddress());
        telephoneNumberTF.setText(pi.getTelephoneNo());
        officeNumberTF.setText(pi.getOfficeNo());
        emailAddressTF.setText(pi.getEmailAdd());
        faxNumberTF.setText(pi.getFaxNo());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cellphoneNumberTF;
    private javax.swing.JComboBox civilStatusCB;
    private javax.swing.JComboBox dayCB;
    private javax.swing.JTextField emailAddressTF;
    private javax.swing.JTextField faxNumberTF;
    private javax.swing.JComboBox genderCB;
    private javax.swing.JTextField givenNameTF;
    private javax.swing.JTextField homeAddressTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField miTF;
    private javax.swing.JComboBox monthCB;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField nicknameTF;
    private javax.swing.JTextField occupationTF;
    private javax.swing.JTextField officeNumberTF;
    private javax.swing.JTextField surnameTF;
    private javax.swing.JTextField telephoneNumberTF;
    private javax.swing.JTextField yearTF;
    // End of variables declaration//GEN-END:variables
}
