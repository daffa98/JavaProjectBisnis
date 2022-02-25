
package aplikasi_toko;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aplikasi_Master_Supplier extends javax.swing.JFrame {
Connection c;
ResultSet r;
Statement s;
private Object[][]datasupplier=null;
private String[]label={"Kode Supplier","Nama Perusahaan","Nama Penanggungjawab",
    "No Telepon","Email",
    "Alamat"};
 
    public Aplikasi_Master_Supplier() {
        initComponents();
        BukaKoneksi();
        BacaTabelSupplier();
        tkd_sup.setVisible(true);
    }

private void BukaKoneksi(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost/db_toko","root","");
        System.out.println("Koneksi Sukses");
    }
    catch (Exception e){
    System.out.println(e);
    }
}
private void BacaTabelSupplier(){
    try {
        s=c.createStatement();
        String sql="Select* From barang Order By kd_sup";
        r=s.executeQuery(sql);
        ResultSetMetaData m=r.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(r.next()){
            baris=r.getRow();
        }
        datasupplier=new Object[baris][kolom];
        int x=0;
        r.beforeFirst();
        while(r.next()){
            datasupplier[x][0]=r.getString("kd_sup");
            datasupplier[x][1]=r.getString("nm_per");
            datasupplier[x][2]=r.getString("nm_pen");
            datasupplier[x][3]=r.getString("No_telp");
            datasupplier[x][4]=r.getString("enail");
            datasupplier[x][5]=r.getString("alamat");
            x++;
        }
        tbl_sup.setModel(new DefaultTableModel(datasupplier,label));
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
private void SetTabel(){
    int row=tbl_sup.getSelectedRow();
    tkd_sup.setText((String)tbl_sup.getValueAt(row, 0));
    tnm_per.setText((String)tbl_sup.getValueAt(row, 1));
    tnm_pen.setText((String)tbl_sup.getValueAt(row, 2));
    tno_telp.setText((String)tbl_sup.getValueAt(row, 3));
    temail.setText((String)tbl_sup.getValueAt(row, 4));
    talm.setText((String)tbl_sup.getValueAt(row, 5));
    
    
}
    private void BersihField(){
        tkd_sup.setText("");
        tnm_per.setText("");
        tnm_pen.setText("");
        tno_telp.setText("");
        temail.setText("");
        talm.setText("");
    }
    private void SimpanData(){
       try {
           String sql="Insert Into supplier Values ('"+tkd_sup.getText()+"',"
                   + "'"+tnm_per.getText()+"','"+tnm_pen.getText()+"',"
                   + "'"+tno_telp.getText()+"',"
                   + "'"+temail.getText()+"',"
                   + "'"+talm.getText()+"')";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
           BersihField();
           BacaTabelSupplier();
           
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
       }
   }
     private void EditData(){
       try {
           String sql="Update barang Set kd_sup='"+tkd_sup.getText()+"',"
                   + "nm_per='"+tnm_per.getText()+"',"
                   + "nm_pen='"+tnm_pen.getText()+"',"
                   + "No_Telp='"+tno_telp.getText()+"',"
                   + "email='"+temail.getText()+"',alamat='"+talm.getText()+"',"
                    + "Where kd_sup='"+tkd_sup.getText()+"'";                 
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
           BersihField();
           BacaTabelSupplier();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
       }
     }
       private void HapusData(){
       try {
           String sql="Delete from suppler Where kd_sup='"+tkd_sup.getText()+"'";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
           BersihField();
           BacaTabelSupplier();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
   }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sup = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tkd_sup = new javax.swing.JTextField();
        tnm_per = new javax.swing.JTextField();
        tnm_pen = new javax.swing.JTextField();
        tno_telp = new javax.swing.JTextField();
        temail = new javax.swing.JTextField();
        talm = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        bt_tambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI MASTER SUPPLIER");
        setPreferredSize(new java.awt.Dimension(751, 472));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TABEL DATA SUPPLIER");

        tbl_sup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Supplier", "Nama Perusahaan", "Nama Penanggung Jawab", "No Telepon", "Email", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_sup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_supMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sup);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("INPUT DATA SUPPLIER");

        jLabel3.setText("Kode Supplier");

        jLabel4.setText("Nama Perusahaan");

        jLabel5.setText("Nama Penanggungjawab");

        jLabel6.setText("No. Telepon");

        jLabel7.setText("Email");

        jLabel8.setText("Alamat");

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_edit.setText("EDIT");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        bt_hapus.setText("HAPUS");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_keluar.setText("KELUAR");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tkd_sup)
                                            .addComponent(tnm_per)
                                            .addComponent(tnm_pen)
                                            .addComponent(tno_telp)
                                            .addComponent(temail)
                                            .addComponent(talm))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bt_tambah)
                                .addGap(78, 78, 78)
                                .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(bt_keluar)
                                .addGap(13, 13, 13)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tkd_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tnm_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tnm_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tno_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(talm, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_edit)
                    .addComponent(bt_hapus)
                    .addComponent(bt_keluar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>                        

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
       SimpanData();
    }                                         

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {                                        
        EditData();
    }                                       

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        HapusData();        
    }                                        

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    private void tbl_supMouseClicked(java.awt.event.MouseEvent evt) {                                     
      SetTabel();
    }                                    

  
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
            java.util.logging.Logger.getLogger(Aplikasi_Master_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Master_Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField talm;
    private javax.swing.JTable tbl_sup;
    private javax.swing.JTextField temail;
    private javax.swing.JTextField tkd_sup;
    private javax.swing.JTextField tnm_pen;
    private javax.swing.JTextField tnm_per;
    private javax.swing.JTextField tno_telp;
    // End of variables declaration                   
}
