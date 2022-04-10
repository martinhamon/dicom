/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.SpecificCharacterSet;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.network.FindSOPClassSCU;
import com.pixelmed.network.IdentifierHandler;
import dicom.config.DCMconfig;
import dicom.utils.FindIdentifierHandlerCfind;

/**
 *
 * @author MH
 */
public class DCMcfind {
DCMconfig dcmConfig;
    public DCMcfind(DCMconfig dcmConfig) {
        this.dcmConfig = dcmConfig;
    }
    
    public void cFind(){
         AttributeList identifier = new AttributeList();
          SpecificCharacterSet specificCharacterSet = new SpecificCharacterSet((String[])null);
         
          try {
         //build the attributes that you would like to retrieve as well as passing in any search criteria
                identifier.putNewAttribute(TagFromName.QueryRetrieveLevel).addValue("IMAGE"); //specific query root
               // identifier.putNewAttribute(TagFromName.PatientName,specificCharacterSet).addValue("hamon");
               identifier.putNewAttribute(TagFromName.PatientName);
                identifier.putNewAttribute(TagFromName.PatientID,specificCharacterSet);
                identifier.putNewAttribute(TagFromName.PatientBirthDate);
                identifier.putNewAttribute(TagFromName.PatientSex);
                identifier.putNewAttribute(TagFromName.StudyInstanceUID,specificCharacterSet).addValue("1.2.840.113564.99.1.345050825937.5217.2022410163440493.11233.2");
                identifier.putNewAttribute(TagFromName.SeriesInstanceUID);
                identifier.putNewAttribute(TagFromName.SOPInstanceUID,specificCharacterSet).addValue("1.3.46.670589.61.9527.2.20220410165344202.35137.69");
                identifier.putNewAttribute(TagFromName.StudyDescription);
                identifier.putNewAttribute(TagFromName.StudyDate,specificCharacterSet).addValue("20220410");
                identifier.putNewAttribute(TagFromName.AccessionNumber);
                identifier.putNewAttribute(TagFromName.Modality);
                identifier.putNewAttribute(TagFromName.ModalitiesInStudy);
                identifier.putNewAttribute(TagFromName.ReferringPhysicianName);
                 identifier.putNewAttribute(TagFromName.OperatorsName);
                 
             identifier.putNewAttribute(TagFromName.UID);
                 
                //FindIdentifierHandlerCfind ih = new FindIdentifierHandlerCfind();
                IdentifierHandler ih = new IdentifierHandler();

                //retrieve all studies belonging to patient with name 'Bowen'
                new FindSOPClassSCU(dcmConfig.getREMOTE_HOST(),
                        dcmConfig.getREMOTE_PORT(),
                        dcmConfig.getREMOTE_AE(),
                        dcmConfig.getLOCAL_AE(),
                        SOPClass.PatientRootQueryRetrieveInformationModelFind,identifier,
                       ih);
               
             /* IdentifierHandler ih = new IdentifierHandler();
               new FindSOPClassSCU("www.dicomserver.co.uk",
                        104,
                        "MEDCONNEC",
                        dcmConfig.getLOCAL_AE(),
                        SOPClass.StudyRootQueryRetrieveInformationModelFind,identifier,
                       ih);*/
             
              /* new FindSOPClassSCU("www.dicomserver.co.uk",
                        104,
                        "MEDCONNEC",
                        dcmConfig.getLOCAL_AE(),
                        SOPClass.StudyRootQueryRetrieveInformationModelFind,identifier,
                       ih);*/
                //ih.doSomethingWithIdentifier(identifier);
            }
            catch (Exception e) {
                e.printStackTrace(System.err); // in real life, do something about this exception
                System.exit(0);
            }
        }
         
         
         
         
    }
    

