/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author root
 */

public class Kasir extends javax.swing.JFrame {

    /**
     * Creates new form Kasir
     */
    int level;
   koneksi koneksi;
    private  DefaultTableModel model;
    Date today = new Date();
    public Kasir() {
        initComponents();
        autokode();
        setTitle("Riez Hadiningrat");
        ldate.setText(today.toString());
         
         model = new DefaultTableModel();
        tblkasir.setModel(model);
        model.addColumn("id");
        model.addColumn("username");
        model.addColumn("password");
        model.addColumn("level");

        loadData();
        
        
    
    }


   

 
    private void clear() {
        iduser.setText("");
        txtuser.setText("");
        txtpassword.setText("");
        txtlvl.setSelectedIndex(0);
        


    }
public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = koneksi.getkoneksi();
            try (Statement s = c.createStatement()) {
                String sql = "Select * from loginbok";
            try (ResultSet r = s.executeQuery(sql)) {
                    while (r.next()) {
                        Object[] o = new Object[4];
                        o[0] = r.getString("id");
                        o[1] = r.getString("user");
                        o[2] = r.getString("password");
                        o[3] = r.getString("level");
                        model.addRow(o);
                    }
            }
            }
        } catch (SQLException e) {
            System.out.println("tdk Bisa Load");
        }
}
        private void search(String sql){
            
        model = new DefaultTableModel();
        tblkasir.setModel(model);
        model.addColumn("id");
        model.addColumn("username");
        model.addColumn("password");
        model.addColumn("level");
        
        
        String cari = txtcari.getText();
            try {
            Connection c=koneksi.getkoneksi();
            Statement s=c.createStatement();
          
            ResultSet rs = s.executeQuery(sql);
       if (rs.next()){
            model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
        }
       else {
           JOptionPane.showMessageDialog(this,"RA ONO BOK !");
       }
         tblkasir.setModel(model);
        }catch(SQLException e){
        
        }
        }

 private void simpen () {
               int ok = JOptionPane.showConfirmDialog(null, "Disimpen BOK ??? ","",JOptionPane.YES_NO_OPTION);
        if (ok==0){
                   
                   
                
               
                        try {
                            Connection con=koneksi.getkoneksi();
                            Statement stt=con.createStatement();
                            String sql ="insert into loginbok values ('"+iduser.getText()+"','"+txtuser.getText()+"',sha1('"+txtpassword.getText()+"'),'"+txtlvl.getSelectedItem()+"')";
                            stt.executeUpdate(sql);
                            
                        }
                        catch (Exception e){
                            
                        
                                    
                        }finally{
                            loadData();
                        }
                
                
 }
 }

   private void autokode(){
    try{ Connection c=koneksi.getkoneksi();
     Statement s=c.createStatement();
     String sql= "SELECT MAX(right(id,4)) AS id FROM loginbok";
     ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
                if(rs.first() == false){
                iduser.setText("0001");
        }
                else {
                   rs.last();
                   int auto_id = rs.getInt(1) + 1;
                   String no = String.valueOf(auto_id);
                   int noLong = no.length();
                   //MENGATUR jumlah 0
                    for(int a=0;a<4-noLong;a++){
                        no = "0" + no;
         }
                   iduser.setText(1+no);
               }       
            }
       rs.close();
       s.close(); }   
catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: \n" + e.toString(),
                            "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        iduser = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        tgl11 = new javax.swing.JLabel();
        jam11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkasir = new javax.swing.JTable();
        txtuser = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtlvl = new javax.swing.JComboBox();
        txtpassword = new javax.swing.JPasswordField();
        txtcari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ldate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setText("Daftar User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("ID User");

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        jLabel6.setText("Level");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, -1));

        iduser.setEnabled(false);
        iduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iduserActionPerformed(evt);
            }
        });
        getContentPane().add(iduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 152, 25));

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        tgl11.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        getContentPane().add(tgl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 163, 22));

        jam11.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        getContentPane().add(jam11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 86, 22));

        tblkasir.setModel(new javax.swing.table.DefaultTableModel(
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
        tblkasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkasirMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblkasir);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 560, 280));

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 150, 25));

        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));

        txtlvl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Admin", "User" }));
        getContentPane().add(txtlvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, -1));
        getContentPane().add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 170, 30));

        jButton2.setText("CARI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 80, 30));

        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 100, -1));

        ldate.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        getContentPane().add(ldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 10, 300, 27));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iduserActionPerformed
        // TODO add your handling code here:
           txtuser.requestFocus();
           
    }//GEN-LAST:event_iduserActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
int ok = JOptionPane.showConfirmDialog(null, "Yakin BOK ??? ","",JOptionPane.YES_NO_OPTION);
        if (ok==0){
        int i=tblkasir.getSelectedRow();
        
        if(1==-1)
        {
            return;
        }

        String id=(String) model.getValueAt(i, 0);

        try {
            Connection c=koneksi.getkoneksi();
            String sql = "DELETE From loginbok WHERE id=?";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            p.setString(1, id);

            p.executeUpdate();
            p.close();

        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());;
        }finally{
            loadData();
            clear();
            autokode();
        }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
 simpen();
 clear();
 autokode();
         
            
    }//GEN-LAST:event_simpanActionPerformed

    private void tblkasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkasirMouseClicked
        // TODO add your handling code her
    int i = tblkasir.getSelectedRow();
        if (i == -1) {
            
        }
        
        String id = (String) model.getValueAt(i, 0);
        iduser.setText(id);
        String user = (String) model.getValueAt(i, 1);
        txtuser.setText(user);
        String password = (String) model.getValueAt(i, 2);
        txtpassword.setText(password);
        String level = (String) model.getValueAt(i, 3);
        txtlvl.setSelectedItem(level);
        
    }//GEN-LAST:event_tblkasirMouseClicked

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Home(Login1.kondisiLogin).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String cari = txtcari.getText();
        String sql= "select * from loginbok where user like'"+cari+"%'";
        
        search(sql);
        txtcari.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            
        try{
            if (iduser.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "ID Tidak Boleh KOSONG BOK", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
               Connection c = koneksi.getkoneksi();
                Statement s=c.createStatement();
              
                String sql ="update loginbok set user='"+txtuser.getText()+"',password =sha1 ('"+txtpassword.getText()+"') where id='" + iduser.getText() + "'";
                 boolean r=s.execute(sql);
                JOptionPane.showMessageDialog(rootPane, "Update Tersimpan !", "Update", JOptionPane.INFORMATION_MESSAGE);
            }
            loadData();
            clear();
        }catch(SQLException error_update){
            JOptionPane.showMessageDialog(rootPane, "Error : "+error_update.getMessage(), "Update Gagal", JOptionPane.ERROR_MESSAGE);
        clear();
                                            

        
                }
        
                
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JTextField iduser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jam11;
    private javax.swing.JLabel ldate;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tblkasir;
    private javax.swing.JLabel tgl11;
    private javax.swing.JTextField txtcari;
    private javax.swing.JComboBox txtlvl;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
