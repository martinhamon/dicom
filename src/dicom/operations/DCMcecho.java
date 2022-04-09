/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

/**
 *
 * @author MH
 */
import com.pixelmed.dicom.DicomException;
import com.pixelmed.network.DicomNetworkException;
import com.pixelmed.network.VerificationSOPClassSCU;
import dicom.config.DCMconfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DCMcecho {
   
    
    

    DCMconfig dcmConfig;

    public DCMcecho(DCMconfig dcmConfig) {
        this.dcmConfig = dcmConfig;
    }
    
    public void echo(){
        try {
            new VerificationSOPClassSCU(dcmConfig.getREMOTE_AE(),dcmConfig.getREMOTE_PORT(),dcmConfig.getREMOTE_AE(),dcmConfig.getLOCAL_AE(),false);
            
            System.out.println("Conexion correcta....");
        } catch (DicomNetworkException ex) {
            Logger.getLogger(DCMcecho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DicomException ex) {
            Logger.getLogger(DCMcecho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DCMcecho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
