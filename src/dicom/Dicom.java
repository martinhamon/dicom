/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dicom;

import dicom.config.DCMconfig;
import dicom.operations.DCMassociation;
import dicom.operations.DCMcecho;
import dicom.operations.DCMinfo;

/**
 *
 * @author MH
 */
public class Dicom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DCMconfig dcmConfig= new DCMconfig();
        dcmConfig.setLOCAL_AE("MHPC");
        dcmConfig.setREMOTE_AE("SERVERPACS");
        dcmConfig.setREMOTE_PORT(2104);
                
        // TODO code application logic here
        //DCMinfo dcmInfo = new DCMinfo();
       //DCMcecho dcmcEcho= new DCMcecho(dcmConfig);
       // dcmInfo.readDicomAttributes ();
       
       //dcmcEcho.echo();
       
        DCMassociation dcmAssociation = new DCMassociation(dcmConfig);
        dcmAssociation.DCMstartAssociation();
    }
    
}
