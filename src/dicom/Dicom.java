/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dicom;

import dicom.config.DCMconfig;
import dicom.operations.DCMassociation;
import dicom.operations.DCMcecho;
import dicom.operations.DCMcfind;
import dicom.operations.DCMimage;
import dicom.operations.DCMinfo;
import dicom.operations.DCMwado;

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
        /*dcmConfig.setLOCAL_AE("MHPC");
        dcmConfig.setREMOTE_AE("SERVERPACS");*/
        dcmConfig.setREMOTE_HOST("10.16.107.13");
        dcmConfig.setLOCAL_AE("EMULATOR_TEST");
        dcmConfig.setREMOTE_AE("phia-pacsFIR");
       
        dcmConfig.setREMOTE_PORT(2104);
                
        // TODO code application logic here
        //DCMinfo dcmInfo = new DCMinfo();
       //DCMcecho dcmcEcho= new DCMcecho(dcmConfig);
       // dcmInfo.readDicomAttributes ();
       
       //dcmcEcho.echo();
       
        //DCMassociation dcmAssociation = new DCMassociation(dcmConfig);
        //dcmAssociation.DCMstartAssociation();
        
        
        //DCMimage dcmImage = new DCMimage();
        //dcmImage.image();
        
       // DCMcfind cFind= new DCMcfind(dcmConfig);
        //cFind.cFind();
        
        DCMwado dcmWado = new DCMwado(dcmConfig);
        dcmWado.wadoRequest();
    }
    
}
