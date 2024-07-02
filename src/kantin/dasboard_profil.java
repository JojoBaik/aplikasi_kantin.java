
package kantin;

import modul.koneksi;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class dasboard_profil extends javax.swing.JFrame {
    public static Dimension ukuran;
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; //return value yang didapat apabila kita menjalankan SQL statement
    koneksi k = new koneksi(); //panggil class koneksi

    public dasboard_profil() {
        initComponents();
        k.connect();
        ukuran = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Untuk membuat frame full screen
        jPanel1.setPreferredSize(ukuran); // Mengatur ukuran panel sesuai layar
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_Pesan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuBar_home = new javax.swing.JMenu();
        jMenuBar_profil = new javax.swing.JMenu();
        jMenuBar_Trend = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 777));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Pesan.setBackground(new java.awt.Color(204, 51, 255));
        jButton_Pesan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton_Pesan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Pesan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button checklist.png"))); // NOI18N
        jButton_Pesan.setText("  PESAN");
        jButton_Pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PesanActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 180, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_tentang.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(204, 4, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(163, 50));
        jMenuBar1.setRequestFocusEnabled(false);
        jMenuBar1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jMenuBar1ComponentResized(evt);
            }
        });

        jMenuBar_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button home.png"))); // NOI18N
        jMenuBar_home.setText("HOME");
        jMenuBar_home.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jMenuBar_home.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jMenuBar_homeMouseMoved(evt);
            }
        });
        jMenuBar_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar_homeMouseClicked(evt);
            }
        });
        jMenuBar_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBar_homeActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuBar_home);

        jMenuBar_profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/dashboard profil.png"))); // NOI18N
        jMenuBar_profil.setText("TENTANG");
        jMenuBar_profil.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jMenuBar1.add(jMenuBar_profil);

        jMenuBar_Trend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/dashboard trend.png"))); // NOI18N
        jMenuBar_Trend.setText("MASAKAN");
        jMenuBar_Trend.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jMenuBar_Trend.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jMenuBar_TrendMouseMoved(evt);
            }
        });
        jMenuBar_Trend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar_TrendMouseClicked(evt);
            }
        });
        jMenuBar_Trend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBar_TrendActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuBar_Trend);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jMenuBar1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuBar1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1ComponentResized

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened

    private void jMenuBar_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBar_homeActionPerformed

    }//GEN-LAST:event_jMenuBar_homeActionPerformed

    private void jMenuBar_TrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBar_TrendActionPerformed
       
    }//GEN-LAST:event_jMenuBar_TrendActionPerformed

    private void jMenuBar_homeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_homeMouseMoved
        
    }//GEN-LAST:event_jMenuBar_homeMouseMoved

    private void jMenuBar_TrendMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_TrendMouseMoved
        
    }//GEN-LAST:event_jMenuBar_TrendMouseMoved

    private void jMenuBar_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_homeMouseClicked
        dasboard home = new dasboard();
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();
    
        // Membuat instance baru dari dasboard dan menampilkannya
        dasboard dashboard = new dasboard();
        dashboard.setVisible(true);

        // Menampilkan dialog pop-up untuk memilih jenis pengguna
        String[] options = {"Customer", "Karyawan", "Administrator"};
        int choice = JOptionPane.showOptionDialog(dashboard, "Pilih jenis pengguna:", "Jenis Pengguna", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Menentukan jenis pengguna berdasarkan pilihan pengguna
        String jenisPengguna;
        if (choice >= 0 && choice < options.length) {
            jenisPengguna = options[choice]; //akan mengeksekisi jenis pengguna berdasarkan opsi pilihan pada metod cekpengguna()
        } else {
            // Default jika pengguna tidak memilih atau menutup dialog
            jenisPengguna = "Guest";
        }

        // Memanggil metode cekPengguna() dengan parameter yang sesuai
        dashboard.cekPengguna(jenisPengguna);
    }//GEN-LAST:event_jMenuBar_homeMouseClicked

    private void jMenuBar_TrendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_TrendMouseClicked
       dasboard_trend trend = new dasboard_trend();
       trend.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jMenuBar_TrendMouseClicked

    private void jButton_PesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PesanActionPerformed
      Menu_Pesan pesan = new Menu_Pesan();
      pesan.setVisible(true);
    }//GEN-LAST:event_jButton_PesanActionPerformed

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
            java.util.logging.Logger.getLogger(dasboard_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dasboard_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dasboard_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dasboard_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dasboard_profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Pesan;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBar_Trend;
    private javax.swing.JMenu jMenuBar_home;
    private javax.swing.JMenu jMenuBar_profil;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
