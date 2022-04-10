/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.utils;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.network.IdentifierHandler;
import java.util.Objects;

/**
 *
 * @author MH
 */
public class FindIdentifierHandlerCfind extends IdentifierHandler{
    
    @Override
     public void doSomethingWithIdentifier(AttributeList attributeListForFindResult) throws DicomException {
       //System.out.println("Matched result:" + attributeListForFindResult);
            String AccessionNumber ="";
            String Modality = "";
            String PatienId ="";
            String StudyInstanceUid="";
            String StudyInstanceSeriesUid ="";
            String ObjecInstancetUid = "";
            
            
            String PatientName = attributeListForFindResult.get(TagFromName.PatientName).getSingleStringValueOrDefault(" ");
            
           
             AccessionNumber =(attributeListForFindResult.containsKey(TagFromName.AccessionNumber)) ?
                     attributeListForFindResult.get(TagFromName.AccessionNumber).getSingleStringValueOrEmptyString(): " NA" ;
           
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
             
             System.out.println("/**************************************************************************/*");
             System.out.println("PatientName: " + PatientName + " Patient ID: "+ PatienId);
             System.out.println("AccessionNumber: " + AccessionNumber  + " Modality: " + Modality);
             System.out.println("Study instance UID: " + StudyInstanceUid  );
             System.out.println("Study series  UID: " + StudyInstanceSeriesUid  );
             System.out.println("Study IOD  UID: " + StudyInstanceSeriesUid  );
             
             
            
            //do other things you need to do with the matched results
    }
     
    private  String isEmpty( final String s ) {
                // Null-safe, short-circuit evaluation.
                return (s == null || s.trim().isEmpty()) ?  " " : s;
        }
}
