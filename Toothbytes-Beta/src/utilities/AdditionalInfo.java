/*
 * Copyright (c) 2014, 2015, Project Toothbytes. All rights reserved.
 *
 *
*/
package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <h1>AdditionalInfo</h1>
 * The {@code AdditionalInfo} class retrieves and updates the data the user 
 * manipulates for the Additional_info table of Toothbytes database. It 
 * represents the variables of additional information about the user that are 
 * used to the forms and database.
 */
public class AdditionalInfo {
    private int additionalInfoID;
    private int patientID;
    private String dentalInsurance;          
    private Calendar effectiveDate;      
    private String guardiansName;            
    private String occupation;                   
    private String referrer;                        
    private String reason;                             
    private String previousDentist;           
    private Calendar lastDentalVisit;   
    private String nameOfPhysician;          
    private String officeAddress;            
    private String specialization;             
    private String officeNumber;      
    
    private AdditionalInfo ai;

    /**
     * This method constructs the variables to be used in the Additional_Info 
     * table of Toothbytes database schema.
     * @param   dentalInsurance
     *          Dental insurance of the patient, if available.
     * @param   effectiveDate
     *          Last date of the dental insurance is effective.
     * @param   guardianName
     *          Guardian name of the patient if he/she is below 18 years old.
     * @param   occupation
     *          Occupation of the guardian of the patient.
     * @param   referrer
     *          Doctor or acquaintance of the patient who refer Dr. Pascual 
     *          to the patient.
     * @param   reason
     *          The reason of checkup on that day.
     * @param   previousDentist
     *          Name of the previous dentist of the patient, if available.
     * @param   lastDentalVisit
     *          date when the patient last went to the dental clinic.
     * @param   physicianName
     *          Name of the physician of the patient.
     * @param   officeAddress
     *          Office address of the physician of the patient.
     * @param   specialization
     *          Specialization/s of the physician of the patient.
     * @param   officeNumber
     *          Phone or mobile number the physician of the patient on the 
     *          office or used for his/her work.
     */
    
    public AdditionalInfo(int additionalInfoID, int patientID, String dentalInsurance, Calendar effectiveDate, String guardianName, String occupation, String referrer, String reason,
                        String previousDentist, Calendar lastDentalVisit, String physicianName, String officeAddress, String specialization, String officeNumber){
        this.additionalInfoID = additionalInfoID;
        this.patientID = patientID;
        this.dentalInsurance = dentalInsurance;
        this.effectiveDate = effectiveDate;
        this.guardiansName = guardianName;
        this.occupation = occupation;
        this.referrer = referrer;
        this.reason = reason;
        this.previousDentist = previousDentist;
        this.lastDentalVisit = lastDentalVisit;
        this.nameOfPhysician = physicianName;
        this.officeAddress = officeAddress;
        this.specialization = specialization;
        this.officeNumber = officeNumber;
    }
    
    public AdditionalInfo(String dentalInsurance, Calendar effectiveDate, String guardianName, String occupation, String referrer, String reason,
                        String previousDentist, Calendar lastDentalVisit, String physicianName, String officeAddress, String specialization, String officeNumber) {
        
        this.dentalInsurance = dentalInsurance;
        this.effectiveDate = effectiveDate;
        this.guardiansName = guardianName;
        this.occupation = occupation;
        this.referrer = referrer;
        this.reason = reason;
        this.previousDentist = previousDentist;
        this.lastDentalVisit = lastDentalVisit;
        this.nameOfPhysician = physicianName;
        this.officeAddress = officeAddress;
        this.specialization = specialization;
        this.officeNumber = officeNumber;
    }
    
    /**
     * This method allows the program to insert the data the user input to the 
     * Additional_Info table of the the database.
     * @param   patientID
     *          A unique number given to the patient in the database.
     * @return  false
     *          If the program failed to update or insert the data the user 
     *          input for the database.
     */
    public void UpdateAdditionalInfo(int patientID, AdditionalInfo ai) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String effectiveDate = "";
            String lastDentalVisit = "";
            
            try{
                if(sdf.format(ai.getEffectiveDate().getTime()).isEmpty()){
                    effectiveDate = "0000-00-00";
                } else {
                    effectiveDate = "'"+sdf.format(ai.getEffectiveDate().getTime())+"'";
                }
            }catch(Exception e){
                effectiveDate = "DEFAULT";
            }
            
            try{
                if(sdf.format(ai.getLastDentalVisit().getTime()).isEmpty()){
                    lastDentalVisit = "0000-00-00";
                } else {
                    lastDentalVisit = "'"+sdf.format(ai.getLastDentalVisit().getTime())+"'";
                }
            }catch(Exception e){
                lastDentalVisit = "DEFAULT";
            }
            
            String additionalInfoUpdate = "INSERT INTO ADDITIONAL_INFO VALUES(DEFAULT, "+patientID+", '"+ai.getDentalInsurance()+"', "
                    + ""+effectiveDate+" , '"+ai.getGuardianName()+"', '"+ai.getOccupation()+"', '"+ai.getReferrer()+"', "
                    + "'"+ai.getReason()+"', '"+ai.getPreviousDentist()+"', "+lastDentalVisit+", '"+ai.getPhysicianName()+"', "
                    + "'"+ai.getOfficeAddress()+"', '"+ai.getSpecialization()+"', '"+ai.getOfficeNumber()+"')";

            DBAccess.dbQuery(additionalInfoUpdate);
        }catch(Exception e) {
            System.out.println("AdditionalInfo - UpdateAdditionalInfo Error: "+e);
        }
    }
    
    public void EditAdditionalInfo(int additionalInfoID){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String seffectiveDate = "";
            String slastDentalVisit = "";
            
            try{
                if(sdf.format(effectiveDate.getTime()).isEmpty()){
                    seffectiveDate = "0000-00-00";
                } else {
                    seffectiveDate = "'"+sdf.format(effectiveDate.getTime())+"'";
                }
            }catch(Exception e){
                seffectiveDate = "DEFAULT";
            }
            
            try{
                if(sdf.format(lastDentalVisit.getTime()).isEmpty()){
                    slastDentalVisit = "0000-00-00";
                } else {
                    slastDentalVisit = "'"+sdf.format(lastDentalVisit.getTime())+"'";
                }
            }catch(Exception e){
                slastDentalVisit = "DEFAULT";
            }
            
            String additionalInfoUpdate = "UPDATE ADDITIONAL_INFO SET "
                    + "DENTALINSURANCE = '"+dentalInsurance+"', "
                    + "EFFECTIVEDATE = "+seffectiveDate+", "
                    + "GUARDIANNAME = '"+guardiansName+"', "
                    + "GUARDIANOCCUPATION = '"+occupation+"', "
                    + "REFERRAL = '"+referrer+"', "
                    + "REMARKS = '"+reason+"', "
                    + "PREVIOUSDENTIST = '"+previousDentist+"', "
                    + "LASTDENTALVISIT = "+slastDentalVisit+", "
                    + "PHYSICIANNAME = '"+nameOfPhysician+"', "
                    + "PHYSICIANOFFICE = '"+officeAddress+"', "
                    + "PHYSICIANSPECIALTY = '"+specialization+"', "
                    + "PHYSICIANCONTACTNO = '"+officeNumber+"' "
                    + "WHERE ADDITIONALINFOID = "+additionalInfoID+";";
            System.out.println(additionalInfoUpdate);
            DBAccess.dbQuery(additionalInfoUpdate);
        }catch(Exception e){
            System.out.println("AdditionalInfo - EditAdditionalInfo Error: " + e);
        }
    }
    
    
    
    public int getAdditionalInfoID(){
        return additionalInfoID;
    }
    /**
     * Returns dental insurance of the patient.
     * @return  Dental insurance.
     */
    public String getDentalInsurance() {
        return dentalInsurance;
    }
    
    /**
     * Returns last year of the dental insurance is effective.
     * @return  Effective date year.
     */
    public Calendar getEffectiveDate() {
        return effectiveDate;
    }
    
    /**
     * Returns guardian name of the patient if he/she is below 18 years old.
     * @return  Guardian name.
     */
    public String getGuardianName() {
        return guardiansName;
    }
    
    /**
     * Returns the occupation of the guardian of the patient.
     * @return  Occupation of the guardian.
     */
    public String getOccupation() {
        return occupation;
    }
    
    /**
     * Returns the name of the doctor or acquaintance of the patient who refer 
     * Dr. Pascual to the patient.
     * @return  Referrer.
     */
    public String getReferrer() {
        return referrer;
    }
    
    /**
     * Returns the reason of the patient or what is the checkup is all about on 
     * the day of your first meeting.
     * @return  Reason.
     */
    public String getReason() {
        return reason;
    }
    
    /**
     * Returns the name of the previous dentist of the patient, if available.
     * @return  Previous dentist.
     */
    public String getPreviousDentist() {
        return previousDentist;
    }
    
    /**
     * Returns the year when the patient last went to the dental clinic.
     * @return  Last dental visit year.
     */
    public Calendar getLastDentalVisit() {
        return lastDentalVisit;
    }
    
    /**
     * Returns the name of the physician of the patient.
     * @return  Physician name.
     */
    public String getPhysicianName() {
        return nameOfPhysician;
    }    
    
    /**
     * Returns the specialization/s of the physician of the patient.
     * @return  Specialization.
     */
    public String getSpecialization() {
        return specialization;
    }
    
    /**
     * Returns the office number or contact number of the physician of the 
     * patient.
     * @return  Office number.
     */
    public String getOfficeNumber() {
        return officeNumber;
    }
    
    public String getOfficeAddress(){
        return officeAddress;
    }
}
