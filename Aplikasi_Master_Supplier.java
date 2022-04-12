package aplikasi_toko;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zahreen
 */
public class Aplikasi_Master_Supplier extends javax.swing.JFrame {
Connection c;
ResultSet r;
Statement s;
private Object[][]datasupplier=null;
private String [] label={"Kode Supplier",
    "Nama Perusahaan",
    "Nama Penanggungjawab",
    "No Telepon","Email","Alamat"};
    /**
     * Creates new form Aplikasi_Master_Supplier
     */
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
            } catch (Exception e) {
            System.out.println(e);
            }
    
        }

private void BacaTabelSupplier(){
            try {
                s=c.createStatement();
                String sql="Select *from barang Order By kd_sup";
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
                   datasupplier[x][4]=r.getString("email");
                   datasupplier[x][5]=r.getString("alamat");
                   x++;
               }
               tbl_sup.setModel(new DefaultTableModel(datasupplier,label));
            } catch (SQLException e) {
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
            String sql="Insert into supplier Values('"+tkd_sup.getText()+"','"+tnm_per.getText()+"','"+tnm_pen.getText()+"','"+tno_telp.getText()+"','"+temail.getText()+"','"+talm.getText()+"')";
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
            String sql ="Update supplier set kd_brg='"+tkd_sup.getText()+"',"
                    + "nm_per='"+tnm_per.getText()+"',"
                    + "nm_pen='"+tnm_pen.getText()+"',"
                    + "No_telp='"+tno_telp.getText()+"',"
                    + "email='"+temail.getText()+"',"
                    + "alamat='"+talm.getText()+"'," 
                    + "Where kd_sup='"+tkd_sup.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
            BersihField();
            BacaTabelSupplier();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
private void HapusData(){
        try {
           String sql="Delete from supplier Where kd_sup='"+tkd_sup.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
            BersihField();
            BacaTabelSupplier();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
