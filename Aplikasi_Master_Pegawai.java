/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi_toko;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Aplikasi_Master_Pegawai extends javax.swing.JFrame {
Connection c;
ResultSet r;
Statement s;
private Object[][]datapegawai=null;
private String [] label={"Kode Pegawai","Nama Pegawai","Tempat Lahir","Tanggal Lahir","Pendidikan","Jabatan","No Telepon","Alamat"};
    /**
     * Creates new form Aplikasi_Master_Pegawai
     */
    public Aplikasi_Master_Pegawai(){
        initComponents();
        BukaKoneksi();
        BacaTabelPegawai();
        tkd_peg.setVisible(true);
    }
private void BukaKoneksi(){
            try {
          Class.forName("com.mysql.cj.jdbc.Driver");
   c=DriverManager.getConnection("jdbc:mysql://localhost/db_toko","root","");
            System.out.println("Koneksi Sukses");
            } catch (Exception e) {
            System.out.println(e);
            }
    
        }
private void BacaTabelPegawai(){
            try {
                s=c.createStatement();
                String sql="Select *from pegawai Order By kd_peg";
                r=s.executeQuery(sql);
                ResultSetMetaData m=r.getMetaData();
                int kolom=m.getColumnCount();
                int baris=0;
                while(r.next()){
                    baris=r.getRow();
                }
               datapegawai=new Object[baris][kolom];
               int x=0;
               r.beforeFirst();
               while(r.next()){
                   datapegawai[x][0]=r.getString("kd_peg");
                   datapegawai[x][1]=r.getString("nm_peg");
                   datapegawai[x][2]=r.getString("temp_lahir");
                   datapegawai[x][3]=r.getString("tgl_lhr");
                   datapegawai[x][4]=r.getString("pend");
                   datapegawai[x][5]=r.getString("jab");
                   datapegawai[x][6]=r.getString("no_telp");
                   datapegawai[x][7]=r.getString("alamat");
                   x++;
               }
               tbl_peg.setModel(new DefaultTableModel(datapegawai,label));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
private void SetTabel(){
        int row=tbl_peg.getSelectedRow();
        tkd_peg.setText((String)tbl_peg.getValueAt(row, 0));
        tnm_peg.setText((String)tbl_peg.getValueAt(row, 1));
        ttemp.setText((String)tbl_peg.getValueAt(row, 2));
        ttgl.setText((String)tbl_peg.getValueAt(row, 3));
        cb_pend.setSelectedItem((String)tbl_peg.getValueAt(row, 4));
        cb_jab.setSelectedItem((String)tbl_peg.getValueAt(row, 5)); 
        ttelp.setText((String)tbl_peg.getValueAt(row, 6));
        talm.setText((String)tbl_peg.getValueAt(row, 7)); 
    }
private void BersihField(){
        tkd_peg.setText("");
        tnm_peg.setText("");
        ttemp.setText("");
        ttgl.setText("");
        cb_pend.setSelectedIndex(0);
        cb_jab.setSelectedIndex(0);
        ttelp.setText("");
        talm.setText("");
          }
private void SimpanData(){
        try {
            String sql="Insert into pegawai Values('"+tkd_peg.getText()+"','"+tnm_peg.getText()+"','"+ttemp.getText()+"','"+ttgl.getText()+"','"+cb_pend.getSelectedItem()+"','"+cb_jab.getSelectedItem()+"','"+ttelp.getText()+"','"+talm.getText()+"')";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
            BersihField();
            BacaTabelPegawai();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
private void EditData(){
        try {
           String sql = "Update pegawai Set kd_peg='"+tkd_peg.getText()+"',"
                   + "nm_peg='"+tnm_peg.getText()+"',"
                   + "temp_lahir='"+ttemp.getText()+"',"
                   + "tgl_lhr='"+ttgl.getText()+"',"
                   + "pend='"+cb_pend.getSelectedItem()+"',"
                   + "jab='"+cb_jab.getSelectedItem()+"',"
                   + "no_telp='"+ttelp.getText()+"',"
                   + "alamat='"+talm.getText()+"'"
                   + "Where kd_peg='"+tkd_peg.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
            BersihField();
            BacaTabelPegawai();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
private void HapusData(){
        try {
           String sql="Delete From pegawai Where kd_peg='"+tkd_peg.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
            BersihField();
            BacaTabelPegawai();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_peg = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tkd_peg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_pend = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tnm_peg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_jab = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ttemp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ttelp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ttgl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        talm = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        bt_tambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI MASTER PEGAWAI");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("TABEL DATA PEGAWAI");

        tbl_peg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pegawai", "Nama Pegawai", "Tempat Lahir", "Tanggal Lahir", "Pendidikan", "Jabatan", "No Telepon", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_peg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pegMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_peg);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("INPUT DATA PEGAWAI");

        jLabel3.setText("Pendidikan");

        cb_pend.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SD", "SMP", "SMA/SMK", "D3", "S1", "S2" }));

        jLabel4.setText("Nama Pegawai");

        jLabel5.setText("Jabatan");

        cb_jab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kasir", "Kepala Toko", "Programmer", "Administrator", "Manager" }));

        jLabel6.setText("Tempat Lahir");

        jLabel7.setText("No. Telepon");

        jLabel8.setText("Tanggal Lahir");

        ttgl.setText("tahun-bulan-tanggal");

        jLabel9.setText("Alamat");

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_keluar.setText("Keluar");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        jLabel10.setText("Kode Pegawai");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ttemp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tnm_peg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tkd_peg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_pend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_jab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(talm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(bt_tambah)
                .addGap(73, 73, 73)
                .addComponent(bt_edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_hapus)
                .addGap(74, 74, 74)
                .addComponent(bt_keluar)
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tkd_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(cb_pend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tnm_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cb_jab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ttemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ttelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(talm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_hapus)
                    .addComponent(bt_keluar)
                    .addComponent(bt_edit)
                    .addComponent(bt_tambah))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>                        

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        SimpanData ();
    }                                         

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {                                        
        EditData ();
    }                                       

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        HapusData ();
    }                                        

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose ();
    }                                         

    private void tbl_pegMouseClicked(java.awt.event.MouseEvent evt) {                                     
       SetTabel ();
    }                                    

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
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Master_Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JComboBox<String> cb_jab;
    private javax.swing.JComboBox<String> cb_pend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField talm;
    private javax.swing.JTable tbl_peg;
    private javax.swing.JTextField tkd_peg;
    private javax.swing.JTextField tnm_peg;
    private javax.swing.JTextField ttelp;
    private javax.swing.JTextField ttemp;
    private javax.swing.JTextField ttgl;
    // End of variables declaration                   
}
