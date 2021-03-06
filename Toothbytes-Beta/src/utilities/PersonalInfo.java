/*
 * Copyright (c) 2014, 2015, Project Toothbytes. All rights reserved.
 *
 *
*/
package utilities;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * <h1>PersonalInfo</h1>
 * The {@code PersonalInfo} class retrieves and updates the data the user 
 * manipulates for the Patient table of Toothbytes database. It represents the 
 * variables of additional information about the user that are used to the 
 * forms and database.
 */
public class PersonalInfo {
    String patientID;
    String surname;
    String givenName;
    String mi;
    String gender;
    Calendar birthDate;
    String occupation;
    String nickname;  
    String civilStatus;
    String homeAddress;   
    String telephoneNo;
    String officeNo;
    String emailAdd;
    String cellphoneNo;
    String faxNo;    
    byte[] patientPhoto;

    public PersonalInfo() {}
    
    /**
     * This method constructs the variables to be used in the Patient table of 
     * Toothbytes database schema.
     * @param   surname
     *          Last name of the patient.
     * @param   givenName
     *          First name of the patient.
     * @param   middleInitial
     *          Middle initial of the patient.
     * @param   gender
     *          Gender of the patient.
     * @param   birthDate
     *          Date of birth of the patient.
     * @param   civilStatus
     *          Civil Status of the patient.
     * @param   nickname
     *          Nickname of the patient.
     * @param   occupation
     *          Occupation of the patient.
     * @param   homeAddress
     *          Home address of the patient.
     * @param   telephoneNo
     *          Telephone number of the patient.
     * @param   officeNo
     *          Office number of the patient.
     * @param   emailAdd
     *          Email address of the patient.
     * @param   cellphoneNo
     *          Mobile number of the patient.
     * @param   faxNo 
     *          Fax number of the patient.
     */
    public PersonalInfo(String surname, String givenName, String middleInitial, 
        String gender, Calendar birthDate, String civilStatus, String nickname, 
        String occupation, String homeAddress, String telephoneNo, 
        String officeNo, String emailAdd, String cellphoneNo, String faxNo, byte[] patientPhoto) {
        
        this.surname = surname;
        this.givenName = givenName;
        mi = middleInitial;
        this.gender = gender;
        this.birthDate = birthDate;
        this.civilStatus = civilStatus;
        this.nickname = nickname;
        this.occupation = occupation;
        this.homeAddress = homeAddress;
        this.telephoneNo = telephoneNo;
        this.officeNo = officeNo;
        this.emailAdd = emailAdd;
        this.cellphoneNo = cellphoneNo;
        this.faxNo = faxNo;        
        this.patientPhoto = patientPhoto;
    }
    
    /**
     * This method injects data the user input that will update the 
     * Patient table from the Toothbytes database schema.
     * @param   medicalHistoryID
     *          A foreign key from the Medical_History table.
     * @return  Identity value while inserting records into database.
     */
    public int UpdatePersonalInfo(String patientID) {
        String personalInfoUpdate = "UPDATE PATIENT SET "
                + "PATIENT_LASTNAME = '"+surname+"', "
                + "PATIENT_FIRSTNAME = '"+givenName+"', "
                + "PATIENT_MIDDLEINITIAL = '"+mi.charAt(0)+"', "
                + "BIRTHDATE = '"+new SimpleDateFormat("yyyy-MM-dd").format(birthDate.getTime())+"', "
                + "OCCUPATION = '"+occupation+"', "
                + "NICKNAME = '"+nickname+"', "
                + "GENDER = '"+gender.charAt(0)+"', "
                + "CIVILSTATUS = '"+civilStatus+"', "
                + "HOMEADDRESS = '"+homeAddress+"', "
                + "HOMENO = '"+telephoneNo+"', "
                + "OFFICENO = '"+officeNo+"', "
                + "FAXNO = '"+faxNo+"', "
                + "CELLNO = '"+cellphoneNo+"', "
                + "EMAILADDRESS = '"+emailAdd+"'"
                + "WHERE patientID = " + patientID + ";";
    
//        String PersonalInfoUpdate = "INSERT INTO PATIENT VALUES("+patientID+", '"+surname+"', '"+givenName+"', '"+mi.charAt(0)+"', "
//                + "'"+patientPhoto+"', '"+birthDate.get(Calendar.YEAR)+"-"+birthDate.get(Calendar.MONTH)+"-"+birthDate.get(Calendar.DAY_OF_MONTH) +"', 
                    //'"+occupation+"', '"+nickname+"', '"+gender.charAt(0)+"', '"+civilStatus+"', "
//                + "'"+homeAddress+"', '"+telephoneNo+"', '"+officeNo+"', '"+faxNo+"', '"+cellphoneNo+"', '"+emailAdd+"')";
        
        
        System.out.println(personalInfoUpdate);
        DBAccess.dbQuery(personalInfoUpdate);
        return DBAccess.CallIdentity();
    }
    
    public void NewPersonalInfo(){
        String PersonalInfoUpdate = "INSERT INTO PATIENT VALUES("+patientID+", '"+surname+"', '"+givenName+"', '"+mi.charAt(0)+"', "
        + "'"+Arrays.toString(patientPhoto)+"', '"+birthDate.get(Calendar.YEAR)+"-"+birthDate.get(Calendar.MONTH)+"-"+birthDate.get(Calendar.DAY_OF_MONTH) +"', '"+occupation+"', '"+nickname+"', '"+gender.charAt(0)+"', '"+civilStatus+"', "
        + "'"+homeAddress+"', '"+telephoneNo+"', '"+officeNo+"', '"+faxNo+"', '"+cellphoneNo+"', '"+emailAdd+"')";
        
        
        System.out.println(PersonalInfoUpdate);
        DBAccess.dbQuery(PersonalInfoUpdate);
    }
    
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }
    
    public String getPatientID(){
        return patientID;
    }
    
    /**
     * Returns the last name of the patient
     * @return  Surname.
     */
    public String getSurname() {
        return surname;
    }
    
    /**
     * Returns the first name of the patient.
     * @return  Given name.
     */
    public String getGivenName() {
        return givenName;
    }
    
    /**
     * Returns the middle initial of the patient.
     * @return  Middle initial.
     */
    public String getMI() {
        return mi;
    }
    
    /**
     * Returns the gender of the patient.
     * @return  Gender.
     */
    public String getGender() {
        return gender;
    }
    
    /**
     * Returns the date of birth of the patient.
     * @return  Birthday.
     */
    public Calendar getBirthDate() {
        return birthDate;
    }
    
    /**
     * Returns the civil status of the patient.
     * @return  Civil Status.
     */
    public String getCivilStatus() {
        return civilStatus;
    }
    
    /**
     * Returns the nickname of the patient.
     * @return  Nickname.
     */
    public String getNickname() {
        return nickname;
    }
    
    /**
     * Returns the occupation of the patient.
     * @return  Occupation.
     */
    public String getOccupation() {
        return occupation;
    }
    
    /**
     * Returns the home address of the patient.
     * @return  Home address.
     */
    public String getHomeAddress() {
        return homeAddress;
    }
    
    /**
     * Returns the telephone number of the patient.
     * @return  Telephone number.
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }
    
    /**
     * Returns the office number of ten patient.
     * @return  Office number.
     */
    public String getOfficeNo() {
        return officeNo;
    }
    
    /**
     * Returns the email address of the patient.
     * @return  Email address.
     */
    public String getEmailAdd() {
        return emailAdd;
    }
    
    /**
     * Returns the mobile number of the patient
     * @return  Mobile number.
     */
    public String getCellphoneNo() {
        return cellphoneNo;
    }
    
    /**
     * Returns the fax number of the patient.
     * @return  Fax number.
     */
    public String getFaxNo() {
        return faxNo;
    }
}
