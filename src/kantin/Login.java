package kantin;
//Import digunakan untuk mengimpor kelas, antarmuka, atau paket dari luar ke dalam file
import modul.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
// membuat variabel
public class Login extends javax.swing.JFrame {
    private PreparedStatement stat; // menampung codingan sql
    private ResultSet rs; // memperbarui data dan menampung data yang sudah dieksekusi
    koneksi k = new koneksi();
    
    public Login() {        
        initComponents(); //berfungsi untuk menginisialisasi dan mengatur komponen-komponen GUI
        k.connect(); //mengkoneksikan dengan database
    }
    class user { // mereferensi dari tabel database
        int id_level;
        String username, password, nama_user,id_user;
        // bikin Constructor, merupakan suatu method yang akan memberikan nilai awal pada saat suatu objek dibuat
        public user() {//mengonversi Nilai dari Komponen GUI ()
            this.id_user = jTextField_IDuser.getText();
            this.username = JText_Username.getText();
            this.password = jText_Password.getText();
            this.nama_user = "";
            this.id_level = 0;
        }
    }
    
    /*public void simpandatausersementara(){
        user u = new user();
            try {
            this.stat = k.getCon().prepareStatement("insert into login values(?,?,?)");
            stat.setString(1, u.id_user);
            stat.setString(2, u.username);
            stat.setString(3, u.password);
            stat.executeUpdate(); 
            
            }catch (SQLException e){
            }
        }
    
    public  void Ceklogin(String username){
        user u = new user();
        try {
            // Query untuk mencari username yang sama di database
        String cekusername = "SELECT COUNT(*) FROM login WHERE username = ?"; //menghitung jumlah baris dalam tabel user yang memiliki kolom username yang cocok dengan parameter yang diberikan.
        PreparedStatement statcekusername = k.getCon().prepareStatement(cekusername);
        statcekusername.setString(1, u.username);
        ResultSet rscekusername = statcekusername.executeQuery();

        // Cek apakah username sudah terdaftar di database
        if (rscekusername.next() && rscekusername.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Username sudah terdaftar!");
        } else {
        JOptionPane.showMessageDialog(null, "Selamat datang");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }*/


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JText_Username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton_Login = new javax.swing.JButton();
        jText_Password = new javax.swing.JPasswordField();
        jButton_Cancel = new javax.swing.JButton();
        jLabel_LihatPassword = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Daftar = new javax.swing.JLabel();
        jLabel_Lupapassword = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_IDuser = new javax.swing.JTextField();
        jLabel_TutupPassword = new javax.swing.JLabel();
        jLabel_EXIT = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel1.setText("ID USER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, 30));
        jPanel1.add(JText_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 229, 26));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        jButton_Login.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Login.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button login.png"))); // NOI18N
        jButton_Login.setText("   LOGIN");
        jButton_Login.setBorder(null);
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 130, 40));
        jPanel1.add(jText_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 229, 26));

        jButton_Cancel.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Cancel.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button cancel.png"))); // NOI18N
        jButton_Cancel.setText("CANCEL");
        jButton_Cancel.setBorder(null);
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 130, 40));

        jLabel_LihatPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button_eyes_buka-removebg-preview.png"))); // NOI18N
        jLabel_LihatPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LihatPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_LihatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 30, 40));

        jLabel5.setText("Belum punya akun?");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel_Daftar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Daftar.setText("Daftar?");
        jLabel_Daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_DaftarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_Daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        jLabel_Lupapassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Lupapassword.setText("Lupa Password");
        jLabel_Lupapassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LupapasswordMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_Lupapassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel6.setText("USERNAME");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, 30));
        jPanel1.add(jTextField_IDuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, 30));

        jLabel_TutupPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button_eyes_tutup-removebg-preview.png"))); // NOI18N
        jLabel_TutupPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_TutupPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_TutupPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 30, 20));

        jLabel_EXIT.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel_EXIT.setText("X");
        jLabel_EXIT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel_EXIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_EXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EXITMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_EXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 30, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel2.setText("LOGIN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 160, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed
        user u = new user(); // memanggil class yang sudah kita buat tadi user = u
        // jika ingin mengmbil sesuatu di database gunakan try and catch
        try { // memasukan perintah sql(prepareStatement), ++ untuk menggabungkan syntax sql dengan java
            //Tanda kutip tunggal (') digunakan untuk mengapit nilai-nilai yang akan disamakan dalam kondisi WHERE.
            this.stat = k.getCon().prepareStatement("select * from user where " 
                    + "id_user='"+u.id_user+"' and username='"+u.username+"' and password='"+u.password+"';");
            this.rs = this.stat.executeQuery(); // mengeksekusi data dari database(localhost)ke GUI
            while (rs.next()){ //data yg ditampung di rs tadi kemudian dlkukan perulangan (next=lnjt ke baris berikutny)
                u.id_level = rs.getInt("id_level"); // apakah ada id_levelnya kalau ada akan ditampung di id_level
            }
            if (u.id_level==0){ // apakah id_levelnya =0 , brati tidak ada
                JOptionPane.showMessageDialog(null,"AKUN TIDAK DITEMUKAN, PERHATIKAN KEMBALI"); // untuk memberi tau  jika akun salah
            }else{ 
                switch(u.id_level){ // percabangan untuk memilih id level
                    case 1:
                        Menu_DataAccount reg = new Menu_DataAccount();
                        reg.setVisible(true); // untuk administrator, menampilkan/mengenablekan hak akses 1 ke menu registrsi
                        this.setVisible(false); // false karena login hilang pindah ke regristrasi
                        break;
                    case 2:
                        Menu_Transaksi tran = new Menu_Transaksi();
                        tran.setVisible(true); // untuk kasir hak akses 2 ke menu transaksi
                        this.setVisible(false); // false karena login hilang pindah ke transaksi
                        tran.jButton_Delete.setVisible(false);
                        tran.jButton_MenuMasakan.setVisible(false);
                        
                        break;
                    case 3:
                        Menu_Dapur dap = new Menu_Dapur();
                        dap.setVisible(true); //  untul koki hak akses ke 3 ke menu dapur untuk koki
                        this.setVisible(false); // false karena login hilang pindah ke transaksi
                        break;
                    /*case 4:
                        Menu_Masakan masak = new Menu_Masakan(); 
                        masak.setVisible(true); // untuk administrator hak akses ke 4 ke menu menu masakan misal untuk pelanggan
                        this.setVisible(false); // false karena login hilang pindah ke masakan
                        masak.jButton_LogOut.setEnabled(true); // mengeneblekan button logout
                        break;*/
                }   
            }
        } catch (Exception e) { // untuk memberi tau  jika ada eroor
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        JText_Username.setText(""); //mengkosongkan field
        jText_Password.setText("");
        jTextField_IDuser.setText("");
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jLabel_LihatPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_LihatPasswordMouseClicked
    // Ketika pengguna mengklik ikon mata untuk menyembunyikan kata sandi (setEchoChar: mengatur karakter yang akan ditampilkan)
    jText_Password.setEchoChar((char) 0); // Menampilkan karakter teks
    jLabel_LihatPassword.setVisible(false); // Menampilkan ikon mata terbuka
    jLabel_TutupPassword.setVisible(true); // Menyembunyikan ikon mata tertutup
    
    }//GEN-LAST:event_jLabel_LihatPasswordMouseClicked

    private void jLabel_DaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_DaftarMouseClicked
        daftar daf = new daftar(); //memanggil form daftar
        daf.setVisible(true);
        this.setVisible(false); //this:form login
    }//GEN-LAST:event_jLabel_DaftarMouseClicked

    private void jLabel_EXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EXITMouseClicked
        dispose();
    }//GEN-LAST:event_jLabel_EXITMouseClicked

    private void jLabel_TutupPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TutupPasswordMouseClicked
    // Ketika pengguna mengklik ikon mata untuk menampilkan kata sandi (setEchoChar: mengatur karakter yang akan ditampilkan)
    jText_Password.setEchoChar((char) '*'); // Menyembunyikan karakter teks dengan bulatan hitam
    jLabel_LihatPassword.setVisible(true); // Menyembunyikan ikon mata terbuka
    jLabel_TutupPassword.setVisible(false); // Menampilkan ikon mata tertutup
    }//GEN-LAST:event_jLabel_TutupPasswordMouseClicked

    private void jLabel_LupapasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_LupapasswordMouseClicked
        forgotpassword ganti = new forgotpassword();
        ganti.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel_LupapasswordMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JText_Username;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Daftar;
    private javax.swing.JLabel jLabel_EXIT;
    private javax.swing.JLabel jLabel_LihatPassword;
    private javax.swing.JLabel jLabel_Lupapassword;
    private javax.swing.JLabel jLabel_TutupPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField_IDuser;
    private javax.swing.JPasswordField jText_Password;
    // End of variables declaration//GEN-END:variables
}
