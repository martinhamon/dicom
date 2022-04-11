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
        
        DCMconfig dcmConfig= new DCMconfig();
        /*dcmConfig.setLOCAL_AE("MHPC");
        dcmConfig.setREMOTE_AE("SERVERPACS");*/
        dcmConfig.setREMOTE_HOST("10.16.107.13");
        dcmConfig.setLOCAL_AE("EMULATOR_TEST");
        dcmConfig.setREMOTE_AE("phia-pacsFIR");
       
        dcmConfig.setREMOTE_PORT(2104);
                
        // TODO code application logic here
        //DCMinfo dcmInfo = new DCMinfo();
       
       
       // dcmInfo.readDicomAttributes ();
      // DCMcecho dcmcEcho= new DCMcecho(dcmConfig);
      //  dcmcEcho.echo();
       
       
        //DCMassociation dcmAssociation = new DCMassociation(dcmConfig);
        //dcmAssociation.DCMstartAssociation();
        
        
        //DCMimage dcmImage = new DCMimage();
        //dcmImage.image();
        
       // DCMcfind cFind= new DCMcfind(dcmConfig);
       // cFind.cFind();
        
        //DCMwado dcmWado = new DCMwado(dcmConfig);
       // dcmWado.wadoRequest();
        DCMcfind cFind= new DCMcfind(dcmConfig);
      TreeMap   pacsPatients =  cFind.cFind();
      TreeMap   pacsPatients2 = (TreeMap) pacsPatients.clone();
       DBconecction dbConnection = new DBconecction();
      TreeMap   wlPatients = dbConnection.connectionTest();
       
      
      Set <String> anKeys = pacsPatients2.keySet();
      
      // Empieza con HGDL y no esta en la WL
     
      
      anKeys.forEach(
              key -> {
                  if ( (key.startsWith("HGDL") && !wlPatients.containsKey(key) ))
                  {
                     pacsPatients.remove(key);
                  }
              }
      
      );
      
        System.out.println("Estudios con inconsistencias: " + pacsPatients.size());
       int i=0;
    }
    
    
    
}
