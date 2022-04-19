/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.statics;

import java.awt.Component;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
 *
 * @author MH
 */
public class PieChart extends  Component{
    public PieChart( ) {
     
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "RX" , new Double( 20 ) );  
      dataset.setValue( "MR" , new Double( 20 ) );   
      dataset.setValue( "CT" , new Double( 40 ) );    
      dataset.setValue( "US" , new Double( 10 ) );  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Estadisticas por modalidad",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

}
