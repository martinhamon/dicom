/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.TransferSyntax;
import com.pixelmed.network.Association;
import com.pixelmed.network.AssociationFactory;
import com.pixelmed.network.PresentationContext;
import dicom.config.DCMconfig;
import java.util.LinkedList;

/**
 *
 * @author MH
 */
public class DCMassociation {
DCMconfig dcmConfig;
    public DCMassociation(DCMconfig dcmConfig) {
        this.dcmConfig = dcmConfig;
    }
    public void DCMstartAssociation(){
        
     try {
            LinkedList<PresentationContext> prestnContexts = new LinkedList<PresentationContext>();
                LinkedList<String> transferSyntaxList = new LinkedList<String>();
                transferSyntaxList.add(TransferSyntax.Default);
               // transferSyntaxList.add(TransferSyntax.ExplicitVRBigEndian);
               //transferSyntaxList.add(TransferSyntax.ImplicitVRLittleEndian);
                
                
                byte prentnContextIdOfVerfSopClass = 1;//use any number here for tracking
                String verificationSopClass = SOPClass.Verification; //this is the UID for the Verification SOP class
                
                //Print it to console so you can see its UID
                System.out.println("The UID of the SOP class that we are using as Abstract Syntax is " + verificationSopClass);
                
                //Make a list of presentation contexts consisting of the Abstract syntax and the list of transfer syntaxes
                //We will ask the Called AE to see whether it supports these
                prestnContexts.add(new PresentationContext(prentnContextIdOfVerfSopClass, verificationSopClass,transferSyntaxList));
                
                System.out.println("Attempting association establishment with remote peer...");
                
                //Attempt to create the association to Medical Connections public DICOM server
                Association association = AssociationFactory.createNewAssociation(dcmConfig.getREMOTE_HOST(), //their hostname or IP address
                                                                                    dcmConfig.getREMOTE_PORT(), //the port their entity is listening on
                                                                                    dcmConfig.getREMOTE_AE(), //their Application Entity Title
                                                                                    dcmConfig.getLOCAL_AE(), //our Application Entity Title
                                                                                    prestnContexts,
                                                                                    null,
                                                                                    false,
                                                                                    2);
                
                //print the details of the association established to the console
                System.out.println(association);
                try {
                    //Check to see if the presentation context is supported by the Called AE
                   byte supportedContextId = association.getSuitablePresentationContextID(verificationSopClass);
                   System.out.println("The Verification SOP class is supported");
                //Check to see what transfer syntax is preferred by the Called AE
                String transferSyntaxSupported = association.getTransferSyntaxForPresentationContextID(supportedContextId);
                //You should see Explicit VR Big-endian UID - 1.2.840.10008.1.2.2 returned here. 
                //This is because an Explicit VR transfer syntax is always be preferable over Implicit (or the "Default") transfer syntax
                System.out.println("The transfer syntax supported for this presentation context is " + transferSyntaxSupported);
                } catch (Exception e) {
                      System.out.println(e);
                    System.out.println("The transfer syntax  UID of  is not supported");
                }
                
                
            
            } catch (Exception e) {
                //In real-life, do something about these exceptions
                e.printStackTrace();
            }
        }
    }

