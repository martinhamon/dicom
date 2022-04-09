/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

/**
 *
 * @author MH
 */
import com.pixelmed.dicom.Attribute;
    import com.pixelmed.dicom.AttributeList;
    import com.pixelmed.dicom.AttributeTag;
    import com.pixelmed.dicom.TagFromName;


public class DCMinfo {
     private static AttributeList list = new AttributeList();
     String dicomFile ="";
     public DCMinfo(){
         String directoryName = System.getProperty("user.dir");
		System.out.println("Current Working Directory is = " +directoryName);
                 dicomFile = "E:\\OneDrive\\Documentos\\NetBeansProjects\\dicom\\I100000B";
     }
     
     
     public void readDicomAttributes ()
     {
         try {
                list.read(dicomFile);

              /*  System.out.println("Study Instance UID:" + getTagInformation(TagFromName.StudyInstanceUID));
                System.out.println("Series Instance UID:" + getTagInformation(TagFromName.SeriesInstanceUID));
                System.out.println("SOP Class UID:" + getTagInformation(TagFromName.SOPClassUID));
                System.out.println("SOP Instance UID:" + getTagInformation(TagFromName.SOPInstanceUID));
                System.out.println("Transfer Syntax UID:" + getTagInformation(TagFromName.TransferSyntaxUID));*/
               System.out.println(list.toString());

            } catch (Exception e) {
                e.printStackTrace(); //in real life, do something about this exception
            }
        }
     private static String getTagInformation(AttributeTag attrTag) {
            return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
        }
     
}
