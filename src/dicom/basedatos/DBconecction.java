/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.basedatos;

import dicom.config.DCMconfig;
import dicom.utils.Patient;
import dicom.utils.Study;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 *
 * @author MH
 */
public class DBconecction {
    
    Connection conn = null;
    DCMconfig dcmConfig;
    private TreeMap <String,Study> wlPatients= null;
    public DBconecction(DCMconfig dcmConfig) {
        this.dcmConfig=dcmConfig;
        
    }
    
    public TreeMap <String,Study> connectionTest(){
        try {
             dcmConfig.setFormat("yyyy-MM-dd");
             String date=dcmConfig.getDateStart();
            String SqlQuery="select pt.szPatientId as 'IDTASY',pt.szName ,szAccessionNumber,ImagingServiceRequest.dtCreate, rp.szCodeMeaning,sp.szModality\n" +
                            "from ImagingServiceRequest\n" +
                            "INNER JOIN Patient as pt on ImagingServiceRequest.idPatient = pt.idPatient\n" +
                            "INNER JOIN RequestedProcedure as rp on rp.szRequestedID = ImagingServiceRequest.szAccessionNumber\n" +
                            "INNER JOIN ScheduledProcedureStep as sp on sp.szProcedureStepId=ImagingServiceRequest.szAccessionNumber\n" +
                            "WHERE ImagingServiceRequest.dtCreate >=  '"+date+" 00:00:00' and ImagingServiceRequest.dtCreate <= '"+date+" 23:59:59'";
               
                            System.err.println(SqlQuery);
//jdbc:sqlserver://serverip\XIS:1433;DatabaseName=XIS;User=sa;Password=R0chesterRules!
            String dbURL = "jdbc:sqlserver://10.16.107.15:1433;databaseName=XIS;useSSL=false;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String pass = "R0chesterRules!";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
               Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SqlQuery);
            wlPatients = new TreeMap <String,Study>();
                while (rs.next()) {
                 String idTasy = rs.getString("IDTASY");
                 String name = rs.getString("szName");
                 String AccessionNumber = rs.getString("szAccessionNumber");
                 String StudyDate = rs.getString("dtCreate");
                 String StudyDescription = rs.getString("szCodeMeaning");
                 String Modality = rs.getString("szModality");
                 System.out.println(idTasy+ " " + name+ " " +AccessionNumber+ " " +StudyDate+ " " +StudyDescription+ " " +Modality+  "\n");
                
                 Patient patient = new Patient(name, idTasy);
                 Study study = new Study(AccessionNumber, StudyDate,StudyDescription, Modality, patient);
                 wlPatients.put(AccessionNumber, study);
                
                
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return wlPatients;
    }
    }
    

