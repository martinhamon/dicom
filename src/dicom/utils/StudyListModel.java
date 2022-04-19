/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.utils;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author MH
 */
public class StudyListModel extends AbstractListModel{
private ArrayList<Study> list = new ArrayList<Study>();
    @Override
    public int getSize() {
       return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index).getStudyPatient().getPatientName();
    }
    
    public void addStudy (Study study)
    {
        list.add(study);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void reoveStudy(int index)
    {
         list.remove(index);
   this.fireIntervalRemoved(index, getSize(), getSize()+1);
    }
    
    
    public Study getStudy(int index){
  return list.get(index);
}
}
