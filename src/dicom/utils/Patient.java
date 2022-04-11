/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.utils;

/**
 *
 * @author MH
 */
public class Patient {
    
    private String patientName;
    private String patientId;
    

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Patient(String patientName, String patientId) {
        this.patientName = patientName;
        this.patientId = patientId;
    }

   
    
    
}
