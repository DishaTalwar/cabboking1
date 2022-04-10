/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabboking1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acs
 */
public class viewcars extends javax.swing.JFrame {

    /**
     * Creates new form viewcars
     */
    ArrayList<cars_details> al = new ArrayList<>();
    TableModel tm=new TableModel();
    public viewcars() {
        initComponents();
        setSize(1000,1000);
        setVisible(true);
        cbtype1.removeAllItems();
        for(int i=0;i<globalclass.car_type.length;i++)  {
            cbtype1.addItem(globalclass.car_type[i]);
    }
        jTable2.setModel(tm);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cbtype1 = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        cbtype1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbtype1);
        cbtype1.setBounds(67, 48, 215, 44);

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsearch.setText("search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(371, 48, 136, 44);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 210, 452, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
      
       try{
        String type=cbtype1.getSelectedItem().toString();
        
        HttpResponse<String> httpResponse = Unirest.get("http://localhost:8888/fetchcars")
                .queryString("type",type)
                .asString();
        
        if(httpResponse.getStatus()==200)   {
                        
               String anss =httpResponse.getBody(); 
               System.out.println(""+anss);
               
               StringTokenizer st = new StringTokenizer(anss , "~~");
               al.clear();
               while(st.hasMoreTokens()){
                   String res = st.nextToken();
                   
                   
                   StringTokenizer st2 = new StringTokenizer(res,";;");
          int carid=Integer.parseInt(st2.nextToken());
            String carname = st2.nextToken();
            String type2 = st2.nextToken();            
            String description =st2.nextToken();
            String brand = st2.nextToken();
            String petroltype = st2.nextToken();
            int pricewithdriver = Integer.parseInt(st2.nextToken());
            int pricewithoutdriver = Integer.parseInt(st2.nextToken());
            int security = Integer.parseInt(st2.nextToken());
            String photo = st2.nextToken();
                   
            cars_details obj = new cars_details( carid,carname, type2, description, brand, petroltype, pricewithdriver, pricewithoutdriver, security, photo);
            
            al.add(obj);
            
                   
               }
               
               
              tm.fireTableDataChanged();
               
               
        }
        
       }    catch(UnirestException ex){
       ex.printStackTrace();
    }
    }//GEN-LAST:event_btnsearchActionPerformed

   
    
      
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewcars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewcars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewcars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewcars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewcars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox<String> cbtype1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables


class TableModel extends AbstractTableModel
        
{
    String name[]={"carname","brand","description","fueltype"};
    public int getColumnCount()
    {
        return name.length;
}
    public int getRowCount()
            
    {
        return al.size();
    }
    public String getColumnName(int column)
    {
        return name[column];
    }
    public Object getValueAt(int rowIndex,int columnIndex)  {
        if(columnIndex==0){
            return al.get(rowIndex).carname;
        }
        else if(columnIndex==1)  {
            return al.get(rowIndex).brand;
        }
        else if(columnIndex==2)  {
            return al.get(rowIndex).description;
        }
         else if(columnIndex==3)  {
            return al.get(rowIndex).petroltype;
        }
        else  {
            return al.get(rowIndex).type2;
    }

}
}
}


   
   
 
            

