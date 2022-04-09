/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.operations;

import com.pixelmed.display.SingleImagePanel;
 import java.awt.Color;
    import javax.swing.JFrame;
    import com.pixelmed.display.SourceImage;

/**
 *
 * @author MH
 */
public class DCMimage {

    public DCMimage() {
    }
    
    
    public void image(){
         String dicomInputFile = "E:\\OneDrive\\Documentos\\NetBeansProjects\\dicom\\I100000B";
            try {
                JFrame frame = new JFrame();
                SourceImage sImg = new SourceImage(dicomInputFile);
                System.out.println("Number of frames: " + sImg.getNumberOfFrames());
                SingleImagePanel  singleImagePanel = new SingleImagePanel(sImg);
                frame.add(singleImagePanel);
                frame.setBackground(Color.BLACK);
                frame.setSize(sImg.getWidth(),sImg.getHeight());
                frame.setTitle("Demo for view, scroll and window width/level operations");
                frame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace(); //in real life, do something about this exception
            }
        }
    }

