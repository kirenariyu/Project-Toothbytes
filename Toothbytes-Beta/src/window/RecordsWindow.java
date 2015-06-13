/*
 * Copyright (c) 2014, 2015, Project Toothbytes. All rights reserved.
 *
 *
 */
package window;

import components.ModuleWindow;
import components.PatientListViewer;
import components.TreatmentWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.DentalChart;
import models.OrganizedTreatment;
import models.Patient;
import models.PatientX;
import models.Picture;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hsqldb.jdbc.JDBCConnection;
import org.hsqldb.jdbc.JDBCDriver;
import utilities.DBAccess;
import utilities.DataMan;
import utilities.PersonalInfo;
import window.forms.AdditionalInformation;
import window.forms.InfoEditor;
import window.forms.MedicalCondition;
import window.forms.PersonalInformation;
import window.forms.UpdatePersonalInformation;

/**
 * <h1>RecordsWindow</h1>
 * The {@code RecordsWindow class constructs the Records Window to be able to
 * see the list of patients and their respective attributes.
 */
public class RecordsWindow extends ModuleWindow {

    private Graphics2D g2d;
    private PatientListViewer plv;
    private JTabbedPane tabsPane;
    private JPanel dentalViewer, infoViewer, gallery;
    private MigLayout layout, formLayout, chartLayout;
    private JScrollPane scrollInfo, scrollDental, scrollGallery;
    private PatientX current;
    private JButton patientRepBut, editInfoBut, addInfoBut, editMedCon, checkup, history;
    
    private static JDBCConnection conn = null;
    private static String dir = "data/db";
    private JTable theTable;
    private DefaultTableModel tableModel;
    private JFrame owner;
    private final String ICON_DIR = "res/buttons/";
    
    private JToolBar dentalBar, recordsBar;
    private JLabel chart;
    private boolean trigger = false;
    private DentalChart dc = new DentalChart();

    /**
     * This constructor layouts the Records Window.
     *
     * @param pList Object of array list of Patient.
     */
    public RecordsWindow(ArrayList<Patient> pList) {
        layout = new MigLayout(
                "filly, wrap 12",
                "[fill]push[fill][fill]push[fill]push"
                + "[fill]push[fill]push[fill]push[fill]push"
                + "[fill]push[fill]push[fill]push[fill]" //12 columns
        );
        formLayout = new MigLayout(
                "wrap 12",
                "[fill]push[fill]push[fill]push[fill]push"
                + "[fill]push[fill]push[fill]push[fill]push"
                + "[fill]push[fill]push[fill]push[fill]", //12 columns
                "[fill]push[fill]push[fill]push[fill]push"
                + "[fill]push[fill]push[fill]push[fill]push"
                + "[fill]push[fill]push[fill]push[fill]push"
                + "[fill]push[fill]" //14 rows
        );

        super.setMainPaneLayout(layout);
        plv = new PatientListViewer(pList);

        PatientListListener pll = new PatientListListener();
        plv.setListListener(pll);

        tabsPane = new JTabbedPane();
        tabsPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        infoViewer = new JPanel();
        infoViewer.setLayout(formLayout);
        infoViewer.setBackground(Color.white);

        dentalViewer = new JPanel();
        dentalViewer.setLayout(new BorderLayout());
        dentalViewer.setBackground(Color.white);

        gallery = new JPanel();
        gallery.setLayout(formLayout);
        gallery.setBackground(Color.white);
        
        scrollDental = new JScrollPane(dentalViewer);
        scrollInfo = new JScrollPane(infoViewer);
        scrollGallery = new JScrollPane(gallery);

        tabsPane.addTab("Personal Info", new ImageIcon(ICON_DIR + "PersonalInfo.png"), scrollInfo);
        tabsPane.addTab("Dental Info", new ImageIcon(ICON_DIR + "DentalRecords.png"), scrollDental);
        tabsPane.addTab("Gallery", new ImageIcon(ICON_DIR + "Images.png"), scrollGallery);

        super.addToMainPane(plv, "span 2, grow");
        super.addToMainPane(tabsPane, "span 10, grow");
    }

    public void setOwner(JFrame f) {
        owner = f;
    }

    private JFrame getOwner() {
        return owner;
    }

//    public void setupTable() {
//        tableModel.addColumn("Date");
//        tableModel.addColumn("Tooth No.");
//        tableModel.addColumn("Condition");
//        tableModel.addColumn("Remarks");
//
//        theTable = new JTable(tableModel);
//
//        theTable.getColumnModel().getColumn(0).setMinWidth(100);
//        theTable.getColumnModel().getColumn(1).setMinWidth(60);
//        theTable.getColumnModel().getColumn(2).setMinWidth(100);
//
//        theTable.getColumnModel().getColumn(0).setMaxWidth(200);
//        theTable.getColumnModel().getColumn(1).setMaxWidth(100);
//        theTable.getColumnModel().getColumn(2).setMaxWidth(300);
//
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
//
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//
//        theTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
//        theTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
//        theTable.getTableHeader().setReorderingAllowed(false);
//    }
    
    private boolean isTriggered() {
        return trigger;
    }
    public void showDental(Patient p) {
//        chartLayout = new MigLayout("wrap 4, filly", "[]push[]push[]push[]", "[]");
        //if there is a selected patient clear the viewer
        if (this.current != null) {
            dentalViewer.removeAll();
        }

//        JPanel dentalPanel = new JPanel(chartLayout);
        ArrayList<OrganizedTreatment> otList = DataMan.organizeTreatment(DBAccess.getTreatmentList(p.getId()));
        for (int i = 0; i < otList.size(); i++) {
            OrganizedTreatment temp = otList.get(i);
            for (int j = i + 1; j < otList.size(); j++) {
                if (temp.getDate().compareTo(otList.get(j).getDate()) == -1) {
                    otList.set(i, otList.get(j));
                    otList.set(j, temp);
                }
            }
        }
        
        if (otList.size() >= 1) {
            trigger = true;
            //chart
            dc = new DentalChart();
            
            for (int i = 1; i < 53; i++) {
                if (otList.get(0).getHm().containsKey(i)) {
                    dc.updateTooth(i + 1, otList.get(0).getHm().get(i).toLowerCase());
                    dc.updateUI();
                }
            }
            
            dentalViewer.add(dc, BorderLayout.CENTER);
        } else {
            JLabel info = new JLabel("This patient has still no dental record. Create now by clicking Start checkup!");
            info.setFont(new Font("Calibri", Font.PLAIN, 18));
            dentalViewer.add(info, BorderLayout.CENTER);
        }
        
        dentalBar = new JToolBar("dentalBar");
        dentalBar.setFloatable(false);
        
        history =  new JButton("View History");
        
        checkup = new JButton("Start Checkup!");
        
        checkup.setIcon(new ImageIcon(ICON_DIR + "\\BeginTreatment.png"));
        checkup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (trigger) {
                    TreatmentWindow tw = new TreatmentWindow(getOwner(), p, dc);
                    tw.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    tw.setVisible(true);
                    
                } else {
                    TreatmentWindow tw = new TreatmentWindow(getOwner(), p);
                    tw.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    tw.setVisible(true);
                }
            }
        });
        
        dentalBar.add(checkup);
        dentalBar.add(history);
        
        dentalViewer.add(dentalBar, BorderLayout.NORTH);
        SwingUtilities.updateComponentTreeUI(dentalViewer);
    }
    
    final String BUTTON_DIR = "res/buttons/";
    final String PATIENTS_DIR = "res/patients/";
    /**
     * This method shows the information about the Patient from the database.
     *
     * @param p Object representation of PatientX.
     */
    public void showInfo(PatientX p) {      
        recordsBar = new JToolBar("dentalBar");
        recordsBar.setFloatable(false);

        //if there is a selected patient clear the viewer
        if (this.current != null) {
            infoViewer.removeAll();
        }

        this.current = p;     

        JLabel[] name = new JLabel[]{new JLabel(p.getLastName()), new JLabel(p.getFirstName()), new JLabel(p.getMidName())};
        for (JLabel n : name) {
            n.setFont(new Font("Calibri", Font.BOLD, 14));
        }
        JLabel lblName = new JLabel("Name:");
        
        JLabel age = new JLabel(DataMan.getAge(p.getBdate()) + "");
        JLabel lblAge = new JLabel("Age:");

        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        String bday = format1.format(p.getBdate().getTime());
        
        JLabel bdate = new JLabel(bday);
        JLabel lblBdate = new JLabel("Birthdate:");

        JLabel occupation = new JLabel(p.getOccupation());
        JLabel lblOccupation = new JLabel("Occupation:");

        JLabel civstat = new JLabel(p.getCivilStatus());
        JLabel lblCivstat = new JLabel("Civil Status:");

        JLabel gender = new JLabel(p.getGender() + "");
        JLabel lblGender = new JLabel("Gender:");

        JLabel nName = new JLabel(p.getNickname());
        JLabel lblNname = new JLabel("Nickname:");

        JLabel homeadd = new JLabel(p.getHomeAddress());
        JLabel lblHomeadd = new JLabel("Home Address:");

        JLabel homeno = new JLabel(p.getHomeNo());
        JLabel lblHomeno = new JLabel("Home Number:");

        JLabel officeno = new JLabel(p.getOfficeNo());
        JLabel lblOfficeno = new JLabel("Office Number:");

        JLabel faxno = new JLabel(p.getFaxNo());
        JLabel lblFaxno = new JLabel("Fax Number:");

        JLabel cellno = new JLabel(p.getCellNo());
        JLabel lblCellno = new JLabel("Cellphone Number:");

        JLabel eAdd = new JLabel(p.getEmailAdd());
        JLabel lblEadd = new JLabel("Email Address:");
        
        JLabel photo = new JLabel();
        
        File f = new File("res/patients/" + p.getId() + ".jpg");
        String path = PATIENTS_DIR + p.getId() + ".jpg";
        ImageIcon croppedImg = ResizeImage(path);
        
        if (f.exists()) {
            photo.setIcon(croppedImg);
        } else {
            photo.setIcon(new ImageIcon("res/images/patient.png"));
        }

        infoViewer.add(photo, "wrap");
        
        infoViewer.add(lblName);
        infoViewer.add(name[0], "split 3");
        infoViewer.add(name[1]);
        infoViewer.add(name[2], "wrap");

        infoViewer.add(lblAge);
        infoViewer.add(age, "wrap");

        infoViewer.add(lblBdate);
        infoViewer.add(bdate, "wrap");

        infoViewer.add(lblOccupation);
        infoViewer.add(occupation, "wrap");

        infoViewer.add(lblCivstat);
        infoViewer.add(civstat, "wrap");

        infoViewer.add(lblGender);
        infoViewer.add(gender, "wrap");

        infoViewer.add(lblNname);
        infoViewer.add(nName, "wrap");

        infoViewer.add(lblHomeadd);
        infoViewer.add(homeadd, "wrap");

        infoViewer.add(lblHomeno);
        infoViewer.add(homeno, "wrap");

        infoViewer.add(lblOfficeno);
        infoViewer.add(officeno, "wrap");

        infoViewer.add(lblFaxno);
        infoViewer.add(faxno, "wrap");

        infoViewer.add(lblFaxno);
        infoViewer.add(faxno, "wrap");

        infoViewer.add(lblCellno);
        infoViewer.add(cellno, "wrap");

        infoViewer.add(lblEadd);
        infoViewer.add(eAdd, "wrap");
        
        //Print Report
        patientRepBut = new JButton(new ImageIcon(BUTTON_DIR + "ReportGenPatient-30x30.png"));
        patientRepBut.setBackground(WHITE);
        patientRepBut.setToolTipText("Print Patient Records");
        
        PatientRecordsReport prr = new PatientRecordsReport();
        recordsBar.add(patientRepBut, "skip 20, split 4");
        patientRepBut.addActionListener(prr);

        //EditInfoBut
        editInfoBut = new JButton(new ImageIcon(BUTTON_DIR + "EditPersonalRecord.png"));
        editInfoBut.setBackground(WHITE);
        editInfoBut.setToolTipText("Edit Personal Information");
        recordsBar.add(editInfoBut);
        editInfoBut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalInfo pix = new PersonalInfo(current.getLastName(), current.getFirstName(), current.getMidName(), String.valueOf(current.getGender()), 
                current.getBdate(), current.getCivilStatus(), current.getNickname(), current.getOccupation(), current.getHomeAddress(), current.getHomeNo(), 
                current.getOfficeNo(), current.getEmailAdd(), current.getCellNo(), current.getOfficeNo(), null);
                
                pix.setPatientID(String.valueOf(current.getId()));

                java.awt.EventQueue.invokeLater(new Runnable(){
                    public void run(){
                        JDialog pI = new JDialog();
                        pI.add(new UpdatePersonalInformation(pix));
                        pI.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        pI.pack();
                        pI.setVisible(true);
                        pI.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
                
           }
        });
        
        //Edit Additional info
        addInfoBut = new JButton(new ImageIcon(BUTTON_DIR + "EditPersonalRecord.png"));
        addInfoBut.setBackground(WHITE);
        addInfoBut.setToolTipText("Edit Addtional Information");
        recordsBar.add(addInfoBut);
        addInfoBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                java.awt.EventQueue.invokeLater(new Runnable(){
                    public void run(){
                        JDialog ai = new JDialog();
                        ai.add(new AdditionalInformation(current.getId()));
                        ai.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        ai.pack();
                        ai.setVisible(true);
                        ai.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
            }
        });
        
        //Edit Additional/Med Records
        editMedCon = new JButton(new ImageIcon(BUTTON_DIR + "EditPersonalRecord.png"));
        editMedCon.setBackground(WHITE);
        editMedCon.setToolTipText("Edit Medical Information");
        recordsBar.add(editMedCon);
        editMedCon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
                java.awt.EventQueue.invokeLater(new Runnable(){
                    public void run(){
                        JDialog mc = new JDialog();
                        mc.add(new MedicalCondition(current.getId()));
                        mc.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        mc.pack();
                        mc.setVisible(true);
                        mc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
            }
        });
        
        infoViewer.add(recordsBar, "skip 15");
        SwingUtilities.updateComponentTreeUI(infoViewer);
    }
    
    public ImageIcon ResizeImage(String imagePath){
        ImageIcon MyImage = new ImageIcon(imagePath);
        Image img = MyImage.getImage();        
        Image newImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    public void printPatientRecords(){        
        try{
            Class.forName("org.hsqldb.jdbcDriver");
            String dbConn = "jdbc:hsqldb:file:"+dir+";user=root";
            conn = (JDBCConnection) JDBCDriver.getConnection(dbConn, null);
            File path = new File("Reports/patientRecords.jrxml");
            String reportPath = path.getCanonicalPath();
            JasperDesign jd = JRXmlLoader.load(reportPath);
            String sql = "SELECT patientPhoto, CONCAT(pa.patient_LastName, ',', ' ', pa.patient_FirstName, ' ', pa.patient_MiddleInitial, '.') AS \"PATIENT NAME\", nickname, gender, birthdate, occupation, civilStatus, cellNo, emailAddress, homeNo, homeAddress, officeNo, faxNo, treatmentDate, procedure, amountCharged, balance, \n" +
                        "q1_goodhealth, q2_condition, q3_seriousillness, q4_hospitalized, q5_prescription, q6_tobacco, q7_drugs, q8_pregnant, q8_nursing, q8_birthcontrol, q9_allergy, q9_otherallergy, q10_bloodtype, q11_bloodpressure, q12_illness, q12_otherillness FROM patient pa\n" +
                        "JOIN dental_records dr ON pa.patientID = dr.patientID\n" +
                        "JOIN payments py ON dr.dentalRecordID = py.dentalRecordID\n" +
                        "JOIN medical_history md ON pa.patientID = md.patientID\n" +
                        "WHERE patientID =" + current.getId();                                         
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jrCompile = JasperCompileManager.compileReport(jd);
            JasperPrint jpPrint = JasperFillManager.fillReport(jrCompile, null, conn);
            JasperViewer.viewReport(jpPrint, false);
            conn.close();
        }catch(IOException | ClassNotFoundException | SQLException | JRException error){
            JOptionPane.showMessageDialog(null,error);
        }
    }
    
    private void gallerySetUp(Patient p){
        JButton uploadImage = new JButton("Save Image");
        uploadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        JDialog im = new JDialog();
                        im.add(new ImageManager(p));
                        im.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        im.pack();
                        im.setVisible(true);
                        im.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
            }
        });
        gallery.add(uploadImage);
        
        ArrayList<Picture> pictureList = new ArrayList<>();
        pictureList = DBAccess.getPictureData(p.getId());
        
        for(int i = 0; i < pictureList.size(); i++){
            gallery.add(new JLabel(pictureList.get(i).getImageLocation()));
        }
    }

    /**
     * <h1>PatientListListener</h1>
     * The {@code PatientListListener} class implements ListSelectionListener
     * for retrieving the Patient data in database.
     */
    public class PatientListListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                Patient p = plv.getSelectedPatient();
                PatientX px = DBAccess.getData(p.getId());
                showInfo(px);
                showDental(p);
                gallerySetUp(p);
            }
        }
    }
    
    public class PatientRecordsReport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == patientRepBut) {
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        printPatientRecords();
                    }
                }
                );
            }         
        }
    }
}
