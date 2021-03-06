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
import java.util.Calendar;
import java.util.regex.Pattern;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import models.Appointment;
import models.PatientX;
import utilities.DBAccess;

/**
 *
 * @author Ecchi Powa
 */
public class UpdateAppointment extends javax.swing.JPanel {
    
    private final String BUTTON_DIR = "res/buttons/";

    /**
     * Creates new form SetAppointment
     */
    
    private int appointmentID;
    private Appointment appointment;
    private ArrayList<PatientX> patientList = DBAccess.getPatientXData("");
    private Calendar now = Calendar.getInstance();
    private int monthMod = now.get(Calendar.MONTH);
    private int yearMod = now.get(Calendar.YEAR);
    private int initCharNo = 254;
    private int charTyped = 0;
    private boolean toggle = true;
    
    public UpdateAppointment() {
        initComponents();
        setMonthValues();
        setPatientValues();
    }
    
    public UpdateAppointment(Appointment appointment){
        initComponents();
        this.appointment = appointment;
        appointmentID = appointment.getAppointmentID();
        String[] appDate = appointment.getAppointmentDate().split("-");
        monthMod = Integer.parseInt(appDate[1])-1;
        yearMod = Integer.parseInt(appDate[0]);
        
        setMonthValues();
        setPatientValues();
        findPatient(appointment.getPatientID());
        setAppointmentValues();
        now.set(Integer.parseInt(appDate[0]), Integer.parseInt(appDate[1])-1, Integer.parseInt(appDate[2]));
        sptMiniCalendar.changeSelection(now.get(Calendar.DAY_OF_WEEK_IN_MONTH)-1, now.get(Calendar.DAY_OF_WEEK)-1, true, false);
    }
    
    public UpdateAppointment(String date){
initComponents();
        String[] dateArr = date.split("-");
        monthMod = Integer.parseInt(dateArr[1]);
        yearMod = Integer.parseInt(dateArr[0]);
        setMonthValues();
        setPatientValues();
        now.set(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
        sptMiniCalendar.changeSelection(now.get(Calendar.DAY_OF_WEEK_IN_MONTH)-1, now.get(Calendar.DAY_OF_WEEK)-1, true, false);

    }
    
    public UpdateAppointment(int patientID, String reason){
        initComponents();
        setMonthValues();

        setPatientValues();
        findPatient(patientID);
        sptReason.setText(reason);
        sptReason.setEnabled(false);
    }
    
    public void setAppointmentValues(){
        String[] startHour = appointment.getAppointmentTime().split(":");
        sptStartHour.setSelectedItem(String.valueOf(startHour[0]));
        sptStartMin.setSelectedItem(String.valueOf(startHour[1]));
        
        String[] endHour = appointment.getAppointmentEndTime().split(":");
        sptDurHour.setSelectedItem(String.valueOf(endHour[0]));
        sptDurMin.setSelectedItem(String.valueOf(endHour[1]));
        
        //sptID.setText("Appointment Number: " +(String.valueOf(appointmentID)));
        sptReason.setText(appointment.getAppointmentRemarks());
    }
        
    public void setPatientValues(){
        for(int i = 0; i < patientList.size(); i++){
            sptPatient.addItem(patientList.get(i).getFullName());
            System.out.println(patientList.get(i).getFullName());
        }
    }
    
    public void findPatient(int patientID){
        for(int i = 0; i < patientList.size(); i ++){
            if(patientList.get(i).getId() == patientID){
                sptPatient.setSelectedItem(patientList.get(i).getFullName());
            }
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
    public void setMonthValues(){
        if(monthMod > 11){
            yearMod = yearMod + 1;
            now.set(Calendar.YEAR, yearMod);
            now.set(Calendar.MONTH, 0);
            monthMod = 0;
        } else if (monthMod < -1){
            yearMod = yearMod - 1;
            now.set(Calendar.YEAR, yearMod);
            now.set(Calendar.MONTH, 11);
            monthMod = 11;
        } else {
            now.set(Calendar.MONTH, monthMod);
        }
        
        String month = new SimpleDateFormat("MMMM").format(now.getTime());
        sptMonth.setText(month);
        sptYear.setText(String.valueOf(now.get(Calendar.YEAR)));
        
        genCalendar();
        
        now.set(Calendar.DAY_OF_MONTH, 1);
        int currDay = now.get(Calendar.DAY_OF_WEEK);
        int weekNo = 0;
        
        try{
            for(int x = 1; x < Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)+1; x++){
                sptMiniCalendar.getModel().setValueAt(x, weekNo, currDay-1);
                currDay++;
                if((currDay) > 7){
                    currDay = currDay - 7;
                    weekNo++;
                }
            }
        }catch(Exception e){
            System.out.println("UpdateAppointment - setMonthValues Error: "+e);
        }
    }
    
    public void genCalendar(){
        sptMiniCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            
        });
        sptMiniCalendar.setAutoscrolls(false);
        sptMiniCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public Appointment getAppointmentValues(){
        Appointment appointment = new Appointment();
        
        int patientIDx = 0;
        String appointmentDate = "";

        String appointmentRemarks = "";
        
        for(int i = 0; i < patientList.size(); i++){
            if(patientList.get(i).getFullName().equals(sptPatient.getSelectedItem())){
                patientIDx = patientList.get(i).getId();
            }
        }
        
        int calendarX = sptMiniCalendar.getSelectedRow();
        int calendarY = sptMiniCalendar.getSelectedColumn();
        
        String appointmentDay = "";
        
        try{
            appointmentDay = sptMiniCalendar.getModel().getValueAt(calendarX, calendarY).toString();
        }catch(Exception e){
            System.out.println("SetAppointment - getAppointmentValues Error: "+ e);
        }
        
        if(Integer.parseInt(appointmentDay) < 10){
            if(now.get(Calendar.MONTH) < 10){
                appointmentDate = now.get(Calendar.YEAR) + "-0" + (now.get(Calendar.MONTH)+1) + "-0" + appointmentDay;
            } else {
                appointmentDate = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH)+1) + "-0" + appointmentDay;
            }
        } else {
            if(now.get(Calendar.MONTH) < 10){
                appointmentDate = now.get(Calendar.YEAR) + "-0" + (now.get(Calendar.MONTH)+1) + "-" + appointmentDay;
            } else {
                appointmentDate = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH)+1) + "-" + appointmentDay;
            }
        }
        
        String appointmentTime = sptStartHour.getSelectedItem() + ":" + sptStartMin.getSelectedItem() + ":00";
        String appointmentEndTime = sptDurHour.getSelectedItem() + ":" +sptDurMin.getSelectedItem() + ":00";

        appointmentRemarks = sptReason.getText();
        appointment.setAppointmentID(appointmentID);
        appointment.setPatientID(patientIDx);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setAppointmentEndTime(appointmentEndTime);
        appointment.setAppointmentRemarks(appointmentRemarks);
        
        return appointment;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sptPatient = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        sptMiniCalendar = new javax.swing.JTable();
        sptNext = new javax.swing.JButton();
        sptPrevious = new javax.swing.JButton();
        sptMonth = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sptReason = new javax.swing.JTextPane();
        sptCancel = new javax.swing.JButton();
        sptSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sptCharLeft = new javax.swing.JLabel();
        sptYear = new javax.swing.JLabel();
        appointmentNumber = new javax.swing.JLabel();
        sptStartHour = new javax.swing.JComboBox();
        sptStartMin = new javax.swing.JComboBox();
        sptDurHour = new javax.swing.JComboBox();
        sptDurMin = new javax.swing.JComboBox();
        tempPatient = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 255, 250));
        setMaximumSize(new java.awt.Dimension(508, 462));
        setMinimumSize(new java.awt.Dimension(508, 462));
        setPreferredSize(new java.awt.Dimension(508, 462));

        sptPatient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Patient" }));

        sptMiniCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sptMiniCalendar.setAutoscrolls(false);
        sptMiniCalendar.setCellSelectionEnabled(true);
        sptMiniCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sptMiniCalendar.setRowHeight(20);
        jScrollPane1.setViewportView(sptMiniCalendar);

        sptNext.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Next.png"));
        sptNext.setToolTipText("Next");
        sptNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sptNextActionPerformed(evt);
            }
        });

        sptPrevious.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Back.png"));
        sptPrevious.setToolTipText("Previous");
        sptPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sptPreviousActionPerformed(evt);
            }
        });

        sptMonth.setFont(new java.awt.Font("Vijaya", 1, 18)); // NOI18N
        sptMonth.setText("Month");

        sptReason.setText("Reason");
        sptReason.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sptReasonMouseClicked(evt);
            }
        });
        sptReason.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sptReasonKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(sptReason);

        sptCancel.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Cancel.png"));
        sptCancel.setToolTipText("Cancel");
        sptCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sptCancelActionPerformed(evt);
            }
        });

        sptSave.setIcon(new javax.swing.ImageIcon(BUTTON_DIR+"Save.png"));
        sptSave.setToolTipText("Update");
        sptSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sptSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Start Time");

        jLabel2.setText("End Time");

        jLabel3.setText("Characters Left: ");

        sptCharLeft.setText("254");

        sptYear.setFont(new java.awt.Font("Vijaya", 1, 18)); // NOI18N
        sptYear.setText("Year");

        appointmentNumber.setText(" ");

        sptStartHour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hour", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));

        sptStartMin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Minute", "00", "15", "30", "45" }));

        sptDurHour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hour", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));

        sptDurMin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Minute", "00", "15", "30", "45" }));

        tempPatient.setText("Temporary Patient");
        tempPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sptStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sptDurHour, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sptStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sptDurMin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sptCharLeft))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(sptCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sptSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(sptPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sptMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(sptYear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(sptNext, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sptPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appointmentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentNumber)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sptPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tempPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sptMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sptYear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sptNext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sptPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sptStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sptStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sptDurHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sptDurMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sptCharLeft))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sptCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sptSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sptPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sptPreviousActionPerformed
        monthMod --;
        setMonthValues();
    }//GEN-LAST:event_sptPreviousActionPerformed

    private void sptNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sptNextActionPerformed
        monthMod ++;
        setMonthValues();
    }//GEN-LAST:event_sptNextActionPerformed

    private void sptReasonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sptReasonKeyTyped
        charTyped = sptReason.getText().length();
        if(initCharNo > charTyped){            
            sptCharLeft.setText(String.valueOf(initCharNo - charTyped));
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_sptReasonKeyTyped

    private void sptReasonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sptReasonMouseClicked
        if(sptReason.getText().equals("Reason")){
            sptReason.setText("");
        }
    }//GEN-LAST:event_sptReasonMouseClicked

    private void sptCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sptCancelActionPerformed
        Window w = SwingUtilities.getWindowAncestor(this);
        w.dispose();
        
    }//GEN-LAST:event_sptCancelActionPerformed

    private void sptSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sptSaveActionPerformed
        appointment = getAppointmentValues();
        Boolean notApp = false;
        ArrayList<Appointment> appointmentList = DBAccess.getAppointmentData(" WHERE APPOINTMENTDATE LIKE '"+appointment.getAppointmentDate()+"';");
                
        String at = appointment.getAppointmentTime();
        String et = appointment.getAppointmentEndTime();
        
        for(int i = 0; i < appointmentList.size(); i++){        
            String[] iat = appointmentList.get(i).getAppointmentTime().split(":");
            String[] iet = appointmentList.get(i).getAppointmentEndTime().split(":");
            
            int timeStartHour = Integer.parseInt(iat[0]);
            int timeEndHour = Integer.parseInt(iet[0]);
            
            int timeStart = Integer.parseInt(iat[1]);
            int timeEnd = Integer.parseInt(iet[1]);
            
            if(timeStart >= timeEnd){
                timeStart = timeStart - (60 * (timeEndHour - timeStartHour));
            }
            
            if (appointmentList.get(i).getAppointmentID() != appointment.getAppointmentID()) {
                for (int time = timeStart; time <= timeEnd; time++) {
                    String sat;
                    if (Math.abs(time) < 10) {
                        sat = timeStartHour + ":0" + Math.abs(time) + ":" + iat[2];
                    } else {
                        sat = timeStartHour + ":" + Math.abs(time) + ":" + iat[2];
                    }

                    String[] set = et.split(":");
                    
                    if (Integer.parseInt(set[1]) > Math.abs(time) && Integer.parseInt(set[0]) == timeStartHour) {
                        PatientX x = DBAccess.getData(appointmentList.get(i).getPatientID());
                        JOptionPane.showMessageDialog(null, "Appointment Time is already booked.\n" + x.getFullName() + " at " + appointmentList.get(i).getAppointmentTime() + " to " + appointmentList.get(i).getAppointmentEndTime() + ".");
                        notApp = true;
                        break;
                    }

                    if (at.equals(sat) || et.equals(sat)) {

                        PatientX x = DBAccess.getData(appointmentList.get(i).getPatientID());
                        notApp = true;
                        JOptionPane.showMessageDialog(null, "Appointment Time is already booked.\n" + x.getFullName() + " at " + appointmentList.get(i).getAppointmentTime() + " to " + appointmentList.get(i).getAppointmentEndTime() + ".");
                    }
                }
            }
        }
        
        if("Hour".equals(sptStartHour.getSelectedItem())) {
            sptStartHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
           JOptionPane.showMessageDialog(null, "Time of Appointment input incorrect.");
        } else if ("Minute".equals(sptStartMin.getSelectedItem())){
            sptStartMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "Time of Appointment input incorrect.");
        } else if("Hour".equals(sptDurHour.getSelectedItem())) {
            sptDurHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
           JOptionPane.showMessageDialog(null, "Time of Appointment input incorrect.");
        } else if ("Minute".equals(sptDurMin.getSelectedItem())){
            sptDurMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "Time of Appointment input incorrect.");
        } else if ("".equals(sptPatient.getSelectedItem()) || sptPatient.getSelectedItem().equals("Select Patient")){
            sptPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (sptStartHour.getSelectedItem().equals("")){
            sptStartHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (sptStartMin.getSelectedItem().equals("")){
            sptStartMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (sptDurHour.getSelectedItem().equals("")){
            sptDurHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (sptDurMin.getSelectedItem().equals("")){
            sptDurMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (!hasNumbers((String) sptStartHour.getSelectedItem())){
            sptStartHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (!hasNumbers((String) sptStartMin.getSelectedItem())){
            sptStartMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (!hasNumbers((String) sptDurHour.getSelectedItem())){
            sptDurHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if (!hasNumbers((String) sptDurMin.getSelectedItem())){
            sptDurMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0 ,51)));
            JOptionPane.showMessageDialog(null, "No patient selected");
        } else if(notApp){
            
                    
        } else {
            try {
                DBAccess.updateAppointmentData(appointment);
                JOptionPane.showMessageDialog(null, "Appointment Updated");
            } catch (Exception e) {
                System.out.println("UpdateAppointment - sptSaveActionPerformed Error: " + e);
            }

            Window w = SwingUtilities.getWindowAncestor(this);
            w.dispose();
        }
    }//GEN-LAST:event_sptSaveActionPerformed

    private void tempPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempPatientActionPerformed
        // get patient name -> add
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                JDialog jd = new JDialog();
                jd.add(tempPatient);
                jd.pack();
                jd.setVisible(true);
                jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            }
        });
    }//GEN-LAST:event_tempPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sptCancel;
    private javax.swing.JLabel sptCharLeft;
    private javax.swing.JComboBox sptDurHour;
    private javax.swing.JComboBox sptDurMin;
    private javax.swing.JTable sptMiniCalendar;
    private javax.swing.JLabel sptMonth;
    private javax.swing.JButton sptNext;
    private javax.swing.JComboBox sptPatient;
    private javax.swing.JButton sptPrevious;
    private javax.swing.JTextPane sptReason;
    private javax.swing.JButton sptSave;
    private javax.swing.JComboBox sptStartHour;
    private javax.swing.JComboBox sptStartMin;
    private javax.swing.JLabel sptYear;
    private javax.swing.JButton tempPatient;
    // End of variables declaration//GEN-END:variables
}
