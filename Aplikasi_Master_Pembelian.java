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
public class Aplikasi_Transaksi_Pembelian extends javax.swing.JFrame {
Connection c;
ResultSet r;
Statement s;
private Object [][]datapembelian=null;
private String [] label4 ={"Kode Pembelian","Tanggal Pembelian","Kode Supplier","Kode Barang","Jumlah Pembelian","Harga Beli"};
    /**
     * Creates new form Aplikasi_Transaksi_Pembelian
     */
    public Aplikasi_Transaksi_Pembelian() {
        initComponents();
        BukaKoneksi();
       BacaTabelPembelian();
       tkd_beli.setVisible(true);
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
    private void BacaTabelPembelian(){
            try {
                s=c.createStatement();
                String sql="Select pembelian.kd_beli, pembelian.tgl_beli, pembelian.kd_sup, pembelian.kd_brg, pembelian.jml_beli, pembelian.hrg_beli from pembelian, supplier, barang Where pembelian.kd_sup=supplier.kd_sup AND pembelian.kd_brg=barang.kd_brg Order By pembelian.kd_beli";
                r=s.executeQuery(sql);
                ResultSetMetaData m=r.getMetaData();
                int kolom=m.getColumnCount();
                int baris=0;
                while(r.next()){
                    baris=r.getRow();
                }
               datapembelian=new Object[baris][kolom];
               int x=0;
               r.beforeFirst();
               while(r.next()){
                   datapembelian[x][0]=r.getString("kd_beli");
                   datapembelian[x][1]=r.getString("tgl_beli");
                   datapembelian[x][2]=r.getString("kd_sup");
                   datapembelian[x][3]=r.getString("kd_brg");
                   datapembelian[x][4]=r.getString("jml_beli");
                   datapembelian[x][5]=r.getString("hrg_beli");
                   x++;
               }
               tbl_beli.setModel(new DefaultTableModel(datapembelian,label4));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    private void SetTabel(){
        int row=tbl_beli.getSelectedRow();
        tkd_beli.setText((String)tbl_beli.getValueAt(row, 0));
        ttgl.setText((String)tbl_beli.getValueAt(row, 1));
        tkd_sup.setText((String)tbl_beli.getValueAt(row, 2));
        tkd_brg.setText((String)tbl_beli.getValueAt(row, 3));
        tjum.setText((String)tbl_beli.getValueAt(row, 4));
        thrg_beli.setText((String)tbl_beli.getValueAt(row, 5));
    }
 private void BersihField(){
        tkd_beli.setText("");
        ttgl.setText("");
        tkd_sup.setText("");
        tkd_brg.setText("");
        tjum.setText("");
        thrg_beli.setText("");
    }
 private void SimpanData(){
        try {
            String sql="Insert into pembelian Values('"+tkd_beli.getText()+"','"+ttgl.getText()+"','"+tkd_sup.getText()+"','"+tkd_brg.getText()+"','"+tjum.getText()+"','"+thrg_beli.getText()+"')";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
            BersihField();
            BacaTabelPembelian();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 private void EditData(){
        try {
           String sql = "Update pembelian Set "
                   + "pembelian.kd_beli='"+tkd_beli.getText()+"',"
                   + "pembelian.tgl_beli='"+ttgl.getText()+"',"
                   + "pembelian.kd_sup='"+tkd_sup.getText()+"',"
                   + "pembelian.kd_brg='"+tkd_brg.getText()+"',"
                   + "pembelian.jml_beli='"+tjum.getText()+"',"
                   + "pembelian.hrg_beli='"+thrg_beli.getText()+"'"
                   + "Where pembelian.kd_beli='"+tkd_beli.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
            BersihField();
            BacaTabelPembelian();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 private void HapusData(){
        try {
           String sql="Delete From pembelian Where kd_beli='"+tkd_beli.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
            BersihField();
            BacaTabelPembelian();
            
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_beli = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tkd_beli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ttgl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tkd_sup = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tkd_brg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tjum = new javax.swing.JTextField();
        thrg_beli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TABEL DATA TRANSASKSI PEMBELIAN ");

        tbl_beli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pembelian", "Tanggal Pembelian", "Kode Supplier", "Kode Barang", "Jumlah Pembelian", "Harga Beli"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_beli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_beliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_beli);

        jLabel2.setText("INPUT DATA TRANSAKSI");

        jLabel3.setText("Kode Transaksi");

        jLabel4.setText("Tanggal Transaksi");

        jLabel5.setText("Kode Supplier");

        jLabel6.setText("Kode Barang");

        jLabel7.setText("Jumlah Pembelian");

        jLabel8.setText("Harga Beli");

        jLabel9.setText("Rp.");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(233, 233, 233))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(119, 119, 119))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(thrg_beli, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(tkd_beli)
                                    .addComponent(ttgl)
                                    .addComponent(tkd_sup)
                                    .addComponent(tkd_brg)
                                    .addComponent(tjum)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_tambah)
                                .addGap(94, 94, 94)
                                .addComponent(bt_edit)
                                .addGap(111, 111, 111)
                                .addComponent(bt_hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_keluar)))))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tkd_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tkd_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tjum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thrg_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_edit)
                    .addComponent(bt_hapus)
                    .addComponent(bt_keluar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>                        

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        SimpanData ();
    }                                         

    private void tbl_beliMouseClicked(java.awt.event.MouseEvent evt) {                                      
        SetTabel ();
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
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Transaksi_Pembelian().setVisible(true);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_beli;
    private javax.swing.JTextField thrg_beli;
    private javax.swing.JTextField tjum;
    private javax.swing.JTextField tkd_beli;
    private javax.swing.JTextField tkd_brg;
    private javax.swing.JTextField tkd_sup;
    private javax.swing.JTextField ttgl;
    // End of variables declaration                   
}
