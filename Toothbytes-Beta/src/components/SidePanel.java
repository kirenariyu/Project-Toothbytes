/*
 * Copyright (c) 2014, 2015, Project Toothbytes. All rights reserved.
 *
 *
*/
package components;

import java.awt.BorderLayout;
import static java.awt.Color.WHITE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import models.Appointment;
import models.Patient;
import utilities.Configuration;
import utilities.DBAccess;

/**
 * <h1>SidePanel</h1>
 * The {@code Sidepanel} class constructs a side panel within the main window. 
 * The side panel includes an appointments feature ("Patients for today") and 
 * payments feature ("Payments Tracker").
 */
public class SidePanel extends JPanel{
    
    private JTabbedPane sideTabsPane;
    private JPanel sideAppointment, sidePayment;
    private JList sideAppList, sidePayList;
    private JScrollPane sideAppScroll, sidePayScroll;
    
    private ArrayList<Appointment> appointmentToday, appointmentX;
    
    /**
     * This is the default constructor of the SidePanel class.
     */
    public SidePanel() {
        this.setLayout(new BorderLayout());
        
        sideTabsPane = new JTabbedPane();
        this.add(sideTabsPane);
        
        // APPOINTMENTS
        sideAppointment = new JPanel();
        sideAppointment.setLayout(new BorderLayout());
        sideTabsPane.setFont(Configuration.TB_FONT_HEADER);
        sideTabsPane.addTab("Appointments for today", new ImageIcon("res/buttons/AppointmentsForToday.png"),sideAppointment);
        
        sideAppList = new JList();
        sideAppScroll = new JScrollPane(sideAppList);
        sideAppointment.setLayout(new BoxLayout(sideAppointment,BoxLayout.Y_AXIS));
        
        appointmentToday = new ArrayList<>();
        appointmentToday = DBAccess.getAppointmentData("");
        
        int a = 0;
        
        for(int i = 0; i < appointmentToday.size(); i++){
            try{
                if(checkAppointmentToday(appointmentToday.get(i))){
                    sideAppointment.add(new AppointmentForToday(appointmentToday.get(i)));
                    if(a < 10){
                        a++;
                    } else {
                        break;
                    }
                }
            }catch(Exception e){
                
            }
        }
        
        // PAYMENTS
        sidePayment = new JPanel();
        sideTabsPane.addTab("Payments Tracker", sidePayment);
        sidePayment.setLayout(new BoxLayout(sidePayment,BoxLayout.Y_AXIS));
        sidePayment.setBackground(WHITE);
        
        appointmentX = new ArrayList<>();
        appointmentX = DBAccess.getAppointmentData("");
        
        int x = 0;
        
        for(int i = 0; i < appointmentX.size(); i++){
            try{
                if(checker(appointmentX.get(i))){
                    sidePayment.add(new PaymentSchedule(appointmentX.get(i)));
                    if(x < 10){
                        x++;
                    } else {
                        break;
                    }
                }
            }catch(Exception e){
                
            }
        }
    }
    
    private boolean checker(Appointment appointment){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            Calendar now = Calendar.getInstance();
            Calendar then = Calendar.getInstance();
            
            then.setTime(sdf.parse(appointment.getAppointmentDate()));
            int time = then.compareTo(now);
            
            if(appointment.getAppointmentRemarks().equals("Payment") && time == 1){
                return true;
            } else {
                return false;
            }
            
        }catch(ParseException e){
            return false;
        }
    }
    
    private boolean checkAppointmentToday(Appointment appointmentToday){
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            Calendar inCal = Calendar.getInstance();
            Calendar inApp = Calendar.getInstance();
            
            inCal.setTime(sdf.parse(appointmentToday.getAppointmentDate()));
            
            String inCalendar = sdf.format(inCal.getTime());
            String inAppointment = sdf.format(inApp.getTime());
            
            boolean same = inCalendar.equalsIgnoreCase(inAppointment);
            
            if(same == true){
                System.out.println(inCalendar + " = " + inAppointment);
                return true;
            }else{
                return false;
            }
        }catch(ParseException e){
            return false;
        }
    }
    
    private void updateList() throws SQLException{
       appointmentX = new ArrayList<>();
       appointmentX = DBAccess.getAppointmentData("");
       int x = 0;
        
        for(int i = 0; i < appointmentX.size(); i++){
            try{
                if(checker(appointmentX.get(i))){
                    sidePayment.add(new PaymentSchedule(appointmentX.get(i)));
                    sidePayment.repaint();
                    System.out.println(appointmentX.get(i));
                    if(x < 10){
                        x++;
                    } else {
                        break;
                    }
                }
            }catch(Exception e){
                
            }
        }
    }
}
