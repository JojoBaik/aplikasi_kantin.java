
package kantin;

import modul.koneksi;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class dasboard extends javax.swing.JFrame {
    public static Dimension ukuran;
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; //return value yang didapat apabila kita menjalankan SQL statement
    koneksi k = new koneksi(); //panggil class koneksi

    public dasboard() {
        initComponents();
        k.connect();
        ukuran = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Untuk membuat frame full screen
        jPanel1.setPreferredSize(ukuran); // Mengatur ukuran panel sesuai layar
        
    } 
    
public String jenisPengguna;
public void cekPengguna(String jenisPengguna) { //dengan parameter
    this.jenisPengguna = jenisPengguna;
    switch (jenisPengguna) { //percabangan
        case "Customer":
            jButton_Customer.setEnabled(true);
            jButton_Karyawan.setEnabled(false);
            jButton_Administrator.setEnabled(false);
            break;
        case "Karyawan":
            jButton_Customer.setEnabled(false);
            jButton_Karyawan.setEnabled(true);
            jButton_Administrator.setEnabled(false);
            break;
        case "Administrator":
            jButton_Customer.setEnabled(false);
            jButton_Karyawan.setEnabled(false);
            jButton_Administrator.setEnabled(true);
            break;
        default:
            jButton_Customer.setEnabled(false);
            jButton_Karyawan.setEnabled(false);
            jButton_Administrator.setEnabled(false);
            break;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_Customer = new javax.swing.JButton();
        jButton_Karyawan = new javax.swing.JButton();
        jButton_Administrator = new javax.swing.JButton();
        jLabel_Kembali = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuBar_home = new javax.swing.JMenu();
        jMenuBar_profil = new javax.swing.JMenu();
        jMenuBar_trend = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("SELAMAT DATANG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jButton_Customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button pesan 1.png"))); // NOI18N
        jButton_Customer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CustomerActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 430, 390));

        jButton_Karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/karyawan-cut.png"))); // NOI18N
        jButton_Karyawan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 630, 70, 70));

        jButton_Administrator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button setting.png"))); // NOI18N
        jButton_Administrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AdministratorActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Administrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 630, 70, 70));

        jLabel_Kembali.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel_Kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button back.png"))); // NOI18N
        jLabel_Kembali.setText("  BACK");
        jLabel_Kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_KembaliMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 140, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 770));

        jMenuBar1.setBackground(new java.awt.Color(204, 4, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(163, 50));
        jMenuBar1.setRequestFocusEnabled(false);

        jmenuBar_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button home.png"))); // NOI18N
        jmenuBar_home.setText("HOME");
        jmenuBar_home.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jMenuBar1.add(jmenuBar_home);

        jMenuBar_profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/dashboard profil.png"))); // NOI18N
        jMenuBar_profil.setText("TENTANG");
        jMenuBar_profil.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jMenuBar_profil.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jMenuBar_profilMouseMoved(evt);
            }
        });
        jMenuBar_profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar_profilMouseClicked(evt);
            }
        });
        jMenuBar_profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBar_profilActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuBar_profil);

        jMenuBar_trend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/dashboard trend.png"))); // NOI18N
        jMenuBar_trend.setText("MASAKAN");
        jMenuBar_trend.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jMenuBar_trend.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jMenuBar_trendMouseMoved(evt);
            }
        });
        jMenuBar_trend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar_trendMouseClicked(evt);
            }
        });
        jMenuBar_trend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBar_trendActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuBar_trend);

        setJMenuBar(jMenuBar1);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_KaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KaryawanActionPerformed
        daftar daf = new daftar();
        daf.setVisible(true);       
    }//GEN-LAST:event_jButton_KaryawanActionPerformed

    private void jButton_CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CustomerActionPerformed
        Menu_Pesan san = new Menu_Pesan();
        san.setVisible(true); 
    }//GEN-LAST:event_jButton_CustomerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void jButton_AdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AdministratorActionPerformed
        Login log = new Login();
        log.setVisible(true);
        
    }//GEN-LAST:event_jButton_AdministratorActionPerformed

    private void jMenuBar_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBar_profilActionPerformed
        
    }//GEN-LAST:event_jMenuBar_profilActionPerformed

    private void jMenuBar_trendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBar_trendActionPerformed

    }//GEN-LAST:event_jMenuBar_trendActionPerformed

    private void jMenuBar_trendMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_trendMouseMoved
        
    }//GEN-LAST:event_jMenuBar_trendMouseMoved

    private void jMenuBar_profilMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_profilMouseMoved
        
    }//GEN-LAST:event_jMenuBar_profilMouseMoved

    private void jMenuBar_trendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_trendMouseClicked
        dasboard_trend trend = new dasboard_trend();
        trend.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuBar_trendMouseClicked

    private void jMenuBar_profilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_profilMouseClicked
        dasboard_profil prof = new dasboard_profil();
        prof.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuBar_profilMouseClicked

    private void jLabel_KembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_KembaliMouseClicked
        // Menutup frame dasboard saat ini
        this.dispose();
    
        // Membuat instance baru dari dasboard dan menampilkannya
        dasboard dashboard = new dasboard();
        dashboard.setVisible(true);

        // Menampilkan dialog pop-up untuk memilih jenis pengguna
        String[] options = {"Customer", "Karyawan", "Administrator"};
        int choice = JOptionPane.showOptionDialog(dashboard, "Pilih jenis pengguna:", "Jenis Pengguna", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Menentukan jenis pengguna berdasarkan pilihan pengguna
        if (choice >= 0 && choice < options.length) {
            jenisPengguna = options[choice]; //akan mengeksekisi jenis pengguna berdasarkan opsi pilihan pada metod cekpengguna()
        } else {
            // Default jika pengguna tidak memilih atau menutup dialog
            jenisPengguna = "Guest";
        }
        // Memanggil metode cekPengguna() dengan parameter yg dibuat
        dashboard.cekPengguna(jenisPengguna);
        
    }//GEN-LAST:event_jLabel_KembaliMouseClicked

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
            java.util.logging.Logger.getLogger(dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dasboard().setVisible(true);
                dasboard dashboard = new dasboard();
            dashboard.setVisible(true);
            
            // Menampilkan dialog pop-up untuk memilih jenis pengguna
            String[] options = {"Customer", "Karyawan", "Administrator"};
            int choice = JOptionPane.showOptionDialog(dashboard, "Pilih jenis pengguna:", "Jenis Pengguna", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            // Menentukan jenis pengguna berdasarkan pilihan pengguna
            String jenisPengguna;
            if (choice >= 0 && choice < options.length) {
                jenisPengguna = options[choice];  //akan mengeksekisi jenis pengguna berdasarkan opsi pilihan pada metod cekpengguna()
            } else {
                // Default jika pengguna tidak memilih atau menutup dialog
                jenisPengguna = "Guest";
            }
            
            // Memanggil metode cekPengguna() dengan parameter yg sudh dibuat
            dashboard.cekPengguna(jenisPengguna);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Administrator;
    private javax.swing.JButton jButton_Customer;
    private javax.swing.JButton jButton_Karyawan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Kembali;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBar_profil;
    private javax.swing.JMenu jMenuBar_trend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmenuBar_home;
    // End of variables declaration//GEN-END:variables
}
