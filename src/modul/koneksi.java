package modul;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;


// untuk menghubungkan dengan localhost
public class koneksi {
    private PreparedStatement stat;
    private String url="jdbc:mysql://localhost/db_kantin";
    private String username = "root";
    private String password = "root";
    private Connection con;
    
    // fungsi untuk menghubungkan netbeans dengan dbms exampp
    public void connect(){
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Berhasil"); // jika koneksi berhasil akan diprint
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());// untuk mengirimkan popUp pemberitauan kesalahan
        }
    }
    
    public Connection getCon() {
        return con;
    }        
}
