/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dicom;

import dicom.basedatos.DBconecction;
import dicom.config.DCMconfig;
import dicom.operations.DCMassociation;
import dicom.operations.DCMcecho;
import dicom.operations.DCMcfind;
import dicom.operations.DCMimage;
import dicom.operations.DCMinfo;
import dicom.operations.DCMwado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author MH
 */
public class Dicom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         new DCMmainWindow().setVisible(true);
       
    }
    
    
    
}
