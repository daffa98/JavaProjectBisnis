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
