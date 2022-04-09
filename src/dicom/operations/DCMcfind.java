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
                identifier.putNewAttribute(TagFromName.QueryRetrieveLevel).addValue("STUDY"); //specific query root
                identifier.putNewAttribute(TagFromName.PatientName,specificCharacterSet).addValue("hamon");
                identifier.putNewAttribute(TagFromName.PatientID,specificCharacterSet);
                identifier.putNewAttribute(TagFromName.PatientBirthDate);
                identifier.putNewAttribute(TagFromName.PatientSex);
                identifier.putNewAttribute(TagFromName.StudyInstanceUID);
                identifier.putNewAttribute(TagFromName.SOPInstanceUID);
                identifier.putNewAttribute(TagFromName.StudyDescription);
                identifier.putNewAttribute(TagFromName.StudyDate);
                identifier.putNewAttribute(TagFromName.AccessionNumber);
                FindIdentifierHandlerCfind ih = new FindIdentifierHandlerCfind();
                //IdentifierHandler ih = new IdentifierHandler();

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
    

