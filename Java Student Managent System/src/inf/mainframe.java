/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inf;
import code.DBconect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class mainframe extends javax.swing.JFrame {

    Connection con = null;
    
    PreparedStatement pst= null;
    
    ResultSet rs = null;
    
    public mainframe() {
        initComponents();
        con = DBconect.connect();
        tableload();
        
    }

    
    
    
    
    
    
   
    public void tableload(){
    
        try {
            
            String sql ="SELECT id AS ID,sname As NAME,sage AS AGE,sgrade AS GRADE FROM STUDENT";
            pst =con.prepareStatement(sql);
            rs =pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    
    }
    
   public void tabledata(){
   
       int r=table1.getSelectedRow();
       String id=table1.getValueAt(r, 0).toString();
       String name = table1.getValueAt(r, 1).toString();
       String age= table1.getValueAt(r,2).toString();
       String grade=table1.getValueAt(r, 3).toString();
       
       idbox.setText(id);
       namebox.setText(name);
       agebox.setText(age);
       gradebox.setSelectedItem(grade);
       
       
       
   
   }
   
   public void search(){
   
       String srch = searchbox.getText();
       try {
           String sql="SELECT * FROM student WHERE sname LIKE'%"+srch+"%' or id like'%"+srch+"%'";
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           table1.setModel(DbUtils.resultSetToTableModel(rs));
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
   
   
   }
   
   
   
   public void update(){
   
       String id=idbox.getText();
       String name=namebox.getText();
       String age= agebox.getText();
       String grade=gradebox.getSelectedItem().toString();
       
       try {
           String sql="UPDATE student SET sname='"+name+"',sage='"+age+"',sgrade='"+grade+"' WHERE id='"+id+"'";
           pst=con.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Updated");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       tableload();
       clear();
       
   
   }
    
   
   public void clear(){
   
       searchbox.setText("");
       idbox.setText("ID");
       namebox.setText("");
       agebox.setText("");
       gradebox.setSelectedIndex(0);
   
   
   }
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        insertbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        gradebox = new javax.swing.JComboBox<>();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Name :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Age :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("Grade :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        insertbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(0, 153, 153));
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 80, -1));

        deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(0, 153, 153));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel2.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 80, -1));

        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(0, 153, 153));
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 80, -1));

        clearbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(0, 153, 153));
        clearbtn.setText("clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 80, -1));

        exitbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(0, 153, 153));
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel2.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 80, -1));

        gradebox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", " " }));
        gradebox.setToolTipText("");
        gradebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeboxActionPerformed(evt);
            }
        });
        jPanel2.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 200, 30));

        namebox.setToolTipText("Enter Your Name");
        jPanel2.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 270, 30));

        agebox.setToolTipText("Age");
        jPanel2.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 270, 30));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 330, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("ID :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 60, 30));

        idbox.setText("id");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 40, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 540));

        table1.setBackground(new java.awt.Color(102, 102, 102));
        table1.setForeground(new java.awt.Color(255, 255, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 8", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 700, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        String name;
        int age;
        int grade;
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        grade= Integer.parseInt(gradebox.getSelectedItem().toString());
        
        
        
        try {
            
            String sql = "INSERT INTO student(sname,sage,sgrade) VALUES ('"+name+"','"+age+"','"+grade+"')";
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserted");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        tableload();
        clear();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       
        tabledata();
        tableload();
        
        // Display the table data
        
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased

        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        update();
        clear();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do You Want To Delete : ");
        if(check==0){
        
            String id =idbox.getText();
            try {
                String sql="DELETE FROM student WHERE id='"+id+"'";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "something went wrong "+e);
            }
        
        
        }
        tableload();
        clear();
        
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void gradeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeboxActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
