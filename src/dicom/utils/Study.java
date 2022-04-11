/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.utils;

/**
 *
 * @author MH
 */
public class Study {
    
    private String studyAccessionNumber;
    private String studyDate;
    private String studyDescription;
    private String studyModality;
    private Patient studyPatient;

    public Study(String studyAccessionNumber, String studyDate, String studyDescription, String studyModality, Patient studyPatient) {
        this.studyAccessionNumber = studyAccessionNumber;
        this.studyDate = studyDate;
        this.studyDescription = studyDescription;
        this.studyModality = studyModality;
        this.studyPatient = studyPatient;
    }

    public Patient getStudyPatient() {
        return studyPatient;
    }

    public void setStudyPatient(Patient studyPatient) {
        this.studyPatient = studyPatient;
    }

    public String getStudyAccessionNumber() {
        return studyAccessionNumber;
    }

    public void setStudyAccessionNumber(String studyAccessionNumber) {
        this.studyAccessionNumber = studyAccessionNumber;
    }

    public String getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(String studyDate) {
        this.studyDate = studyDate;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public void setStudyDescription(String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public String getStudyModality() {
        return studyModality;
    }

    public void setStudyModality(String studyModality) {
        this.studyModality = studyModality;
    }
    
    
}
