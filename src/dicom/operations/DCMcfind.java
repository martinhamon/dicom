/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.SpecificCharacterSet;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.network.FindSOPClassSCU;
import com.pixelmed.network.IdentifierHandler;
import dicom.config.DCMconfig;
import dicom.utils.FindIdentifierHandlerCfind;
import dicom.utils.Patient;
import dicom.utils.Study;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 *
 * @author MH
 */
public class DCMcfind  extends IdentifierHandler {
    private DCMconfig dcmConfig;
    private TreeMap  <String,Study> pacsPatients= null;
    public DCMcfind(DCMconfig dcmConfig) {
        this.dcmConfig = dcmConfig;
    }
    
    public TreeMap  cFind(){
         AttributeList identifier = new AttributeList();
          SpecificCharacterSet specificCharacterSet = new SpecificCharacterSet((String[])null);
         
          try {
         //build the attributes that you would like to retrieve as well as passing in any search criteria
                identifier.putNewAttribute(TagFromName.QueryRetrieveLevel).addValue("STUDY"); //specific query root
               // identifier.putNewAttribute(TagFromName.PatientName,specificCharacterSet).addValue("hamon");
               identifier.putNewAttribute(TagFromName.PatientName);
                identifier.putNewAttribute(TagFromName.PatientID,specificCharacterSet);
                identifier.putNewAttribute(TagFromName.PatientBirthDate);
                identifier.putNewAttribute(TagFromName.PatientSex);
                identifier.putNewAttribute(TagFromName.StudyInstanceUID,specificCharacterSet);
                identifier.putNewAttribute(TagFromName.SeriesInstanceUID);
                identifier.putNewAttribute(TagFromName.SOPInstanceUID,specificCharacterSet);
                identifier.putNewAttribute(TagFromName.StudyDescription);
                identifier.putNewAttribute(TagFromName.StudyDate,specificCharacterSet).addValue("20220411");
                identifier.putNewAttribute(TagFromName.AccessionNumber);
                identifier.putNewAttribute(TagFromName.Modality);
                identifier.putNewAttribute(TagFromName.ModalitiesInStudy);
                identifier.putNewAttribute(TagFromName.ReferringPhysicianName);
                 identifier.putNewAttribute(TagFromName.OperatorsName);
                 
             identifier.putNewAttribute(TagFromName.UID);
                 
                //FindIdentifierHandlerCfind ih = new FindIdentifierHandlerCfind();
                IdentifierHandler ih = new IdentifierHandler();
                pacsPatients = new TreeMap <String,Study>();
                //retrieve all studies belonging to patient with name 'Bowen'
                new FindSOPClassSCU(dcmConfig.getREMOTE_HOST(),
                        dcmConfig.getREMOTE_PORT(),
                        dcmConfig.getREMOTE_AE(),
                        dcmConfig.getLOCAL_AE(),
                        SOPClass.PatientRootQueryRetrieveInformationModelFind,identifier,
                       this);
               
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
                return null;
            }
          return pacsPatients;
        }
         
         
       @Override
     public void doSomethingWithIdentifier(AttributeList attributeListForFindResult) throws DicomException {
       //System.out.println("Matched result:" + attributeListForFindResult);
            String AccessionNumber ="";
            String Modality = "";
            String PatienId ="";
            String StudyInstanceUid="";
            String StudyInstanceSeriesUid ="";
            String ObjecInstancetUid = "";
            String StudyDate ="";
            String StudyDescription = "";
            
            String PatientName = attributeListForFindResult.get(TagFromName.PatientName).getSingleStringValueOrDefault(" ");
            
           
             
           
             Modality =(attributeListForFindResult.containsKey(TagFromName.ModalitiesInStudy)) ?
                     attributeListForFindResult.get(TagFromName.ModalitiesInStudy).getSingleStringValueOrEmptyString(): " NA" ;
             PatienId = (attributeListForFindResult.containsKey(TagFromName.PatientID)) ?
                     attributeListForFindResult.get(TagFromName.PatientID).getSingleStringValueOrEmptyString(): " NA" ;
             StudyInstanceUid =(attributeListForFindResult.containsKey(TagFromName.StudyInstanceUID)) ?
                     attributeListForFindResult.get(TagFromName.StudyInstanceUID).getSingleStringValueOrEmptyString(): " NA" ;
             StudyInstanceSeriesUid =(attributeListForFindResult.containsKey(TagFromName.SeriesInstanceUID)) ?
                     attributeListForFindResult.get(TagFromName.SeriesInstanceUID).getSingleStringValueOrEmptyString(): " NA" ;
             ObjecInstancetUid=(attributeListForFindResult.containsKey(TagFromName.SOPInstanceUID)) ?
                     attributeListForFindResult.get(TagFromName.SOPInstanceUID).getSingleStringValueOrEmptyString(): " NA" ;
             StudyDate=(attributeListForFindResult.containsKey(TagFromName.StudyDate)) ?
                     attributeListForFindResult.get(TagFromName.StudyDate).getSingleStringValueOrEmptyString(): " NA" ;
             StudyDescription=(attributeListForFindResult.containsKey(TagFromName.StudyDescription)) ?
                     attributeListForFindResult.get(TagFromName.StudyDescription).getSingleStringValueOrEmptyString(): " NA" ;
             AccessionNumber =(attributeListForFindResult.containsKey(TagFromName.AccessionNumber)) ?
                     attributeListForFindResult.get(TagFromName.AccessionNumber).getSingleStringValueOrEmptyString(): PatienId ;
             
             System.out.println("/**************************************************************************/*");
             System.out.println("PatientName: " + PatientName + " Patient ID: "+ PatienId);
             System.out.println("AccessionNumber: " + AccessionNumber  + " Modality: " + Modality);
             System.out.println("Study instance UID: " + StudyInstanceUid  );
             System.out.println("Study series  UID: " + StudyInstanceSeriesUid  );
             System.out.println("Study IOD  UID: " + StudyInstanceSeriesUid  );
             
             Patient patient = new Patient(PatientName, PatienId);
             Study study = new Study(AccessionNumber, StudyDate,StudyDescription, Modality, patient);
             pacsPatients.put(AccessionNumber, study);
             
            
            //do other things you need to do with the matched results
    }  
         
    }
    

