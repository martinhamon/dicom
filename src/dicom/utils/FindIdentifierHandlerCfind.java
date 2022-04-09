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
            
            String PatientName = attributeListForFindResult.get(TagFromName.PatientName).getSingleStringValueOrDefault(" ");
            System.out.println("PatientName:" + PatientName);
            String AccessionNumber = isEmpty(attributeListForFindResult.get(TagFromName.AccessionNumber).getSingleStringValueOrEmptyString()) ;
            System.out.println("AccessionNumber:" + AccessionNumber);
            
            //do other things you need to do with the matched results
    }
     
    private  String isEmpty( final String s ) {
                // Null-safe, short-circuit evaluation.
                return (s == null || s.trim().isEmpty()) ?  " " : s;
        }
}
