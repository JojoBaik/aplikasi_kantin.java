package kantin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modul.koneksi;
import java.sql.*; //supaya dapat menggunakan semua kelas


public class daftar extends javax.swing.JFrame {
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; // return value yang didapat apabila kita menjalankan SQL statement dan ditampung hasilnya
    koneksi k = new koneksi (); //panggil class koneksi
    
    public daftar() {
        initComponents();
        k.connect();
        IDotomatis();
    }
    class user extends daftar {
        int  id_level; // mendeklarasikan tipedata & variable sesuai di database
        String id_user,username, password, nama_user, email;
        
        public user(){ // membuat konstraktornya, memberi nilai awal
            //Mengambil dan Mengonversi Nilai dari Komponen GUI
            id_user = jFieldidotomatis.getText();
            username = jText_Username.getText(); // memakai getTEXt karena textField
            password = jPassword_PW.getText();
            nama_user = jText_NamaUser.getText();
            // karena id level int sedangkan secara defaulf setiap componen di gui ini string,maka harus kita konvert
            id_level = Integer.parseInt(jComboBox_IDLevel.getSelectedItem().toString()); //menggunakan getselected untuk mengambil data karena combobox            
            email = jTextField_Email.getText();
        }
    }
    private void IDotomatis(){
        try {
        // Koneksi ke database
        k.connect();
        
        // Mendapatkan ID terakhir dari database
        String query = "SELECT id_user FROM user ORDER BY id_user DESC LIMIT 1";
        this.stat = k.getCon().prepareStatement(query);
        ResultSet rs = this.stat.executeQuery();
        
        String lastID = "";
        if(rs.next()) { //data yg ditampung di rs tadi kemudian dlkukan percabangan (next=lnjt ke baris berikutny)
            lastID = rs.getString("id_user");
        }
        
        // Mengekstrak angka dari ID terakhir
        int idNum = Integer.parseInt(lastID.substring(2)); // Mengabaikan dua karakter pertama ("KR")
        
        // Membuat ID baru dengan increment 1
        idNum++;
        String newID = "KR" + String.format("%03d", idNum); // Format ID dengan tiga digit angka dengan 0 didepany(%=urutan)
        
        // Set nilai ID otomatis ke field
        jFieldidotomatis.setText(newID);
        
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jText_NamaUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_IDLevel = new javax.swing.JComboBox<>();
        jText_Username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Input = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Daftar = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel_Lupapassword = new javax.swing.JLabel();
        jLabel_LihatPassword = new javax.swing.JLabel();
        jLabel_TutupPassword = new javax.swing.JLabel();
        jPassword_PW = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel_EXIT = new javax.swing.JLabel();
        jFieldidotomatis = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel8.setText("ID LEVEL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 70, 30));
        jPanel1.add(jText_NamaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 280, 29));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 110, 24));

        jComboBox_IDLevel.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox_IDLevel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jComboBox_IDLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        jComboBox_IDLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_IDLevelActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_IDLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 180, -1));
        jPanel1.add(jText_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 280, 29));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel7.setText("NAMA USER");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 130, 24));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel2.setText("ID USER");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 30));

        jButton_Input.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Input.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Input.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button save.png"))); // NOI18N
        jButton_Input.setText("   SAVE");
        jButton_Input.setBorder(null);
        jButton_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InputActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 133, 41));

        jButton_Cancel.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Cancel.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button cancel.png"))); // NOI18N
        jButton_Cancel.setText(" CANCEL");
        jButton_Cancel.setBorder(null);
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 136, 41));

        jLabel5.setText("Sudah punya akun?");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, -1, -1));

        jLabel_Daftar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Daftar.setText("Masuk?");
        jLabel_Daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_DaftarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_Daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 630, -1, -1));
        jPanel1.add(jTextField_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 280, 30));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel9.setText("EMAIL");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 30));

        jLabel_Lupapassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Lupapassword.setText("Lupa Password");
        jLabel_Lupapassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LupapasswordMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_Lupapassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, -1, -1));

        jLabel_LihatPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button_eyes_buka-removebg-preview.png"))); // NOI18N
        jLabel_LihatPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LihatPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_LihatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 30, 30));

        jLabel_TutupPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button_eyes_tutup-removebg-preview.png"))); // NOI18N
        jLabel_TutupPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_TutupPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_TutupPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 30, 30));
        jPanel1.add(jPassword_PW, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 280, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_EXIT.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel_EXIT.setText("X");
        jLabel_EXIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_EXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EXITMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_EXIT, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 30, 40));

        jFieldidotomatis.setEnabled(false);
        jPanel1.add(jFieldidotomatis, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 280, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setText("SIGN UP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_IDLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_IDLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_IDLevelActionPerformed

    private void jLabel_EXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EXITMouseClicked
        dispose();
    }//GEN-LAST:event_jLabel_EXITMouseClicked

    private void jButton_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InputActionPerformed
        try {
        user u = new user();
        
        // Query untuk mencari username yang sama di database
        String cekusername = "SELECT COUNT(*) FROM user WHERE username = ?"; //menghitung jumlah baris dalam tabel user yang memiliki kolom username yang cocok
        PreparedStatement statcekusername = k.getCon().prepareStatement(cekusername);
        statcekusername.setString(1, u.username);
        ResultSet rscekusername = statcekusername.executeQuery();

        // Cek apakah username sudah terdaftar di database
        if (rscekusername.next() && rscekusername.getInt(1) > 0) {//menggambil username sebagai index 1 kemudian dibandingkan dengan 0
        JOptionPane.showMessageDialog(null, "Username sudah terdaftar!");//jika hasilny lebih dari 0
        //clear 
        IDotomatis(); // supaya field id direfresh dan masuk ke fromat berikutnya
        jText_Username.setText("");
        jPassword_PW.setText("");
        jText_NamaUser.setText("");
        jComboBox_IDLevel.setSelectedIndex(0);
        jTextField_Email.setText("");
        }else
        // Validasi apakah ada kolom yang kosong
        if (u.id_user.isEmpty() || u.username.isEmpty() || u.password.isEmpty() || u.nama_user.isEmpty() || u.email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
        } else {
            this.stat = k.getCon().prepareStatement("insert into user values(?,?,?,?,?,?)");
            stat.setString(1, u.id_user);
            stat.setString(2, u.username);
            stat.setString(3, u.password);
            stat.setString(4, u.nama_user);
            stat.setInt(5, u.id_level);
            stat.setString(6, u.email);
            stat.executeUpdate();//mengexecute dari GUI masuk ke localhost
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_jButton_InputActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        IDotomatis(); // supaya field id direfresh dan masuk ke fromat berikutnya
        jText_Username.setText("");
        jPassword_PW.setText("");
        jText_NamaUser.setText("");
        jComboBox_IDLevel.setSelectedIndex(0);
        jTextField_Email.setText("");
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jLabel_DaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_DaftarMouseClicked
        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel_DaftarMouseClicked

    private void jLabel_LihatPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_LihatPasswordMouseClicked
         // Ketika pengguna mengklik ikon mata untuk menampilkan kata sandi (setEchoChar: mengatur karakter yang akan ditampilkan)
        jPassword_PW.setEchoChar((char) 0); // Menampilkan karakter teks
        jLabel_LihatPassword.setVisible(false); // Menyembunyikan ikon mata terbuka
        jLabel_TutupPassword.setVisible(true); // Menampilkan ikon mata tertutup
    }//GEN-LAST:event_jLabel_LihatPasswordMouseClicked

    private void jLabel_TutupPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TutupPasswordMouseClicked
        // Ketika pengguna mengklik ikon mata untuk menyembunyikan kata sandi (setEchoChar: mengatur karakter yang akan ditampilkan)
        jPassword_PW.setEchoChar('*'); // Menyembunyikan karakter teks dengan bulatan hitam
        jLabel_LihatPassword.setVisible(true); // Menampilkan ikon mata terbuka
        jLabel_TutupPassword.setVisible(false); // Menyembunyikan ikon mata tertutup
    }//GEN-LAST:event_jLabel_TutupPasswordMouseClicked

    private void jLabel_LupapasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_LupapasswordMouseClicked
        forgotpassword ganti = new forgotpassword();
        ganti.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel_LupapasswordMouseClicked

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
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Cancel;
    public javax.swing.JButton jButton_Input;
    private javax.swing.JComboBox<String> jComboBox_IDLevel;
    private javax.swing.JPasswordField jFieldidotomatis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Daftar;
    private javax.swing.JLabel jLabel_EXIT;
    private javax.swing.JLabel jLabel_LihatPassword;
    private javax.swing.JLabel jLabel_Lupapassword;
    private javax.swing.JLabel jLabel_TutupPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword_PW;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jText_NamaUser;
    private javax.swing.JTextField jText_Username;
    // End of variables declaration//GEN-END:variables
}
