/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.basedatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MH
 */
public class DBconecction {
    
    Connection conn = null;

    public DBconecction() {
    }
    
    public void connectionTest(){
        try {
            
            String SqlQuery="select pt.szPatientId as 'IDTASY',pt.szName ,szAccessionNumber,ImagingServiceRequest.dtCreate, rp.szCodeMeaning,sp.szModality\n" +
                            "from ImagingServiceRequest\n" +
                            "INNER JOIN Patient as pt on ImagingServiceRequest.idPatient = pt.idPatient\n" +
                            "INNER JOIN RequestedProcedure as rp on rp.szRequestedID = ImagingServiceRequest.szAccessionNumber\n" +
                            "INNER JOIN ScheduledProcedureStep as sp on sp.szProcedureStepId=ImagingServiceRequest.szAccessionNumber\n" +
                            "WHERE ImagingServiceRequest.dtCreate >=  '2022-04-11 00:00:00' and ImagingServiceRequest.dtCreate <='2022-04-11 23:59:59'";
                //jdbc:sqlserver://serverip\XIS:1433;DatabaseName=XIS;User=sa;Password=R0chesterRules!
            String dbURL = "jdbc:sqlserver://10.16.107.15:1433;databaseName=XIS;useSSL=false;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String pass = "R0chesterRules!";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SqlQuery);
                while (rs.next()) {
                 String idTasy = rs.getString("IDTASY");
                 System.out.println(idTasy + "\n");
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
    }
    }
    

