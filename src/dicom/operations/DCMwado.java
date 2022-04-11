/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

import com.pixelmed.web.WadoRequest;

import dicom.config.DCMconfig;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MH
 */
public class DCMwado {
private DCMconfig dcmConfig;
    public DCMwado(DCMconfig dcmConfig) {
        this.dcmConfig=dcmConfig;
    }
    
    
    public void wadoRequest() {
        
        
        
    try {
        //http://10.16.107.13/um/webapp_services/wado?requestType=WADO&studyUID=1.2.840.113564.99.1.345050825937.5217.2022410163440493.11233.2&seriesUID=1.3.46.670589.61.9527.2.20220410165344202.35137&objectUID=1.3.46.670589.61.9527.2.20220410165344202.35137.69&contentType=application/dicom
        WadoRequest wdr = new WadoRequest
        ("http://10.16.107.13/um/webapp_services/wado?requestType=WADO&studyUID=1.2.840.113564.99.1.345050825937.5217.2022410163440493.11233.2&" +
        "seriesUID=1.3.46.670589.61.9527.2.20220410165344202.35137&objectUID=1.3.46.670589.61.9527.2.20220410165344202.35137.69&" +
        "contentType=application%2dicom");
       int i= wdr.getImageQuality();
        System.out.println(i);

    } catch (Exception ex) {
        Logger.getLogger(DCMwado.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
