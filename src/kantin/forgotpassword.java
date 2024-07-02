package kantin;

import modul.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class forgotpassword extends javax.swing.JFrame {
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; // return value yang didapat apabila kita menjalankan SQL statement dan ditampung
    koneksi k = new koneksi (); //panggil class koneksi
    
    public forgotpassword() {
        initComponents(); //berfungsi untuk menginisialisasi dan mengatur komponen-komponen GUI
        k.connect();
    }
    class user extends forgotpassword {
        // mendeklarasikan tipedata & variable sesuai di database
        String id_user,username, password, nama_user, email;
        
        public user(){ // membuat konstraktornya, memberi nilai awal
            //Mengambil dan Mengonversi Nilai dari Komponen GUI
            id_user = jText_IdUser.getText();
            username = jText_Username.getText(); // memakai getTEXt karena textField
            password = jText_Password.getText();
            nama_user = jText_NamaUser.getText();
            email = jText_Email.getText();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_Update = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Daftar = new javax.swing.JLabel();
        jText_IdUser = new javax.swing.JTextField();
        jText_NamaUser = new javax.swing.JTextField();
        jText_Username = new javax.swing.JTextField();
        jText_Password = new javax.swing.JTextField();
        jText_Email = new javax.swing.JTextField();
        jLabel_CariEmail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_EXIT = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel2.setText("ID User");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 37, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel5.setText("Nama User");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jButton_Update.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Update.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Update.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button save.png"))); // NOI18N
        jButton_Update.setText("   SAVE");
        jButton_Update.setBorder(null);
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 133, 41));

        jButton_Cancel.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Cancel.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button cancel.png"))); // NOI18N
        jButton_Cancel.setText("  CANCEL");
        jButton_Cancel.setBorder(null);
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 136, 41));

        jLabel7.setText("Sudah punya akun?");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, -1, -1));

        jLabel_Daftar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Daftar.setText("Masuk?");
        jLabel_Daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_DaftarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_Daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, -1, -1));

        jText_IdUser.setEditable(false);
        jPanel1.add(jText_IdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 29));

        jText_NamaUser.setEnabled(false);
        jPanel1.add(jText_NamaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 260, 29));

        jText_Username.setEnabled(false);
        jPanel1.add(jText_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 260, 29));

        jText_Password.setEnabled(false);
        jPanel1.add(jText_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 260, 29));

        jText_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jText_EmailKeyTyped(evt);
            }
        });
        jPanel1.add(jText_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 260, 29));

        jLabel_CariEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button_cari-removebg-preview.png"))); // NOI18N
        jLabel_CariEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CariEmailMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_CariEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, 29));

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
            .addGap(0, 26, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel_EXIT)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel_EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 30, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setText("FORGOT PASSWORD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 280, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
         try {
        // Koneksi ke database
        k.connect();

        // Query SQL untuk mengupdate data pengguna dengan nilai baru
        String query = "UPDATE user SET nama_user = ?, username = ?, password = ? WHERE id_user = ?";
        stat = k.getCon().prepareStatement(query);
        stat.setString(1, jText_NamaUser.getText());
        stat.setString(2, jText_Username.getText());
        stat.setString(3, jText_Password.getText());
        stat.setString(4, jText_IdUser.getText());
        int berhasil = stat.executeUpdate();

        // Jika data berhasil diupdate
        if (berhasil > 0) {
            JOptionPane.showMessageDialog(this, "Data pengguna berhasil diperbarui.");
            // Kosongkan kembali JTextField dan nonaktifkan kembali JTextField yang sudah diaktifkan sebelumnya
            jText_IdUser.setText("");
            jText_NamaUser.setText("");
            jText_Username.setText("");
            jText_Password.setText("");
            jText_Email.setText("");
            jText_NamaUser.setEnabled(false);
            jText_Username.setEnabled(false);
            jText_Password.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data pengguna.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        //mengkosongkan field kembali
        jText_IdUser.setText("");
        jText_Username.setText("");
        jText_Password.setText("");
        jText_NamaUser.setText("");
        jText_Email.setText("");
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jLabel_DaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_DaftarMouseClicked
        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel_DaftarMouseClicked

    private void jText_EmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText_EmailKeyTyped

    }//GEN-LAST:event_jText_EmailKeyTyped

    private void jLabel_CariEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CariEmailMouseClicked
        try {
        // Koneksi ke database
        k.connect();

        // Query SQL untuk memeriksa apakah email ada di database
        String query = "SELECT * FROM user WHERE email = ?";
        stat = k.getCon().prepareStatement(query);
        stat.setString(1, jText_Email.getText());
        rs = stat.executeQuery(); // mengeksekusi data dari database(localhost)ke GUI

        // Jika email ditemukan
        if (rs.next()) {
            // Mengaktifkan JTextField untuk mengizinkan pengguna mengedit nama pengguna, kata sandi, dan nama pengguna
            jText_NamaUser.setEnabled(true);
            jText_Username.setEnabled(true);
            jText_Password.setEnabled(true);

            // Menampilkan nilai dari database di JTextField terkait
            jText_IdUser.setText(rs.getString("id_user"));
            jText_NamaUser.setText(rs.getString("nama_user"));
            jText_Username.setText(rs.getString("username"));
            jText_Password.setText(rs.getString("password"));
        } else {
            // Jika email tidak ditemukan, tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(this, "Email tidak ditemukan di database.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jLabel_CariEmailMouseClicked

    private void jLabel_EXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EXITMouseClicked
        dispose();
    }//GEN-LAST:event_jLabel_EXITMouseClicked

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
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotpassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Cancel;
    public javax.swing.JButton jButton_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_CariEmail;
    private javax.swing.JLabel jLabel_Daftar;
    private javax.swing.JLabel jLabel_EXIT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jText_Email;
    private javax.swing.JTextField jText_IdUser;
    private javax.swing.JTextField jText_NamaUser;
    private javax.swing.JTextField jText_Password;
    private javax.swing.JTextField jText_Username;
    // End of variables declaration//GEN-END:variables
}
