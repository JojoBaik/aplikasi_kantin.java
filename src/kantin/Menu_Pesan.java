
package kantin;

import modul.koneksi;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Menu_Pesan extends javax.swing.JFrame {
    private DefaultTableModel model = null; // untuk model tabelnya supaya dengan sesuai keinginan kita
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; //return value yang didapat apabila kita menjalankan SQL statement
    koneksi k = new koneksi(); //panggil class koneksi
    
    public Menu_Pesan() {
        initComponents();
        k.connect(); // mengkonekkan GUI ke localhost
        refreshCombo(); // untuk merefrsh combo, supaya mengambil data dari database
        IDotomatis(); // untuk format otomatis
    }
    class pesan extends Menu_Pesan{// mendeklarasikan tipedata & variable sesuai di database
        int harga, jumlah_beli, total_bayar; 
        String id_transaksi, id_masakan, nama_pelanggan, nama_masakan;

        public pesan() {// membuat konstraktornya, memberi nilai awal
            this.nama_pelanggan = jText_NamaPelanggan.getText();
            // Mengambil item yang dipilih dari JComboBox jComboBox_IDMasakan dan mengonversinya ke string karena mengambil dari tabel masakan
            String combo = jComboBox_IDMasakan.getSelectedItem().toString();
            String[] arr = combo.split(":");// Memisahkan string combo berdasarkan tanda titik dua (:) dan menyimpannya dalam array arr
            this.id_masakan = arr[0];// Mengambil elemen pertama dari array arr (ID masakan) dan menyimpannya ke variabel id_masakan
            this.nama_masakan = arr[1];  // Mengambil elemen kedua dari array arr (nama masakan) dan menyimpannya ke variabel nama_masakan
            this.harga = Integer.parseInt(arr[2]); // Mengambil elemen ketiga dari array arr (harga) dan mengonversinya ke tipe integer, lalu menyimpannya ke variabel harga
            this.jumlah_beli = Integer.parseInt(jText_JumlahBeli.getText());  // Mengambil nilai jumlah beli dari JTextField jText_JumlahBeli, mengonversinya ke tipe integer, dan menyimpannya ke variabel jumlah_beli
            this.total_bayar = this.harga * this.jumlah_beli; // Menghitung total bayar dengan mengalikan harga dan jumlah beli, lalu menyimpannya ke variabel total_bayar
            this.id_transaksi = jText_IDTransaksi.getText(); // Mengambil nilai ID transaksi dari JTextField jText_IDTransaksi dan menyimpannya ke variabel id_transaksi
        }
    }
    
    //id masakan dalam kombobox kita ambil dari data masakan di localHost(database)
    public  void refreshCombo(){
        try {
            this.stat = k.getCon().prepareStatement("select * from masakan " + "where status='tersedia'");//kita mengambil semua data dari tabel masakan
            this.rs = this.stat.executeQuery(); // karena ambil tabel localhost ke GUI
            while (rs.next()){ // karena lebih dari 1 menggunakan perulangan untuk rs untuk memasukan setiap item ke dalam combobox
                jComboBox_IDMasakan.addItem(rs.getString("id_masakan")+":"+ rs.getString("nama_masakan")+":"+ rs.getString("harga"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void IDotomatis() {
    try {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); // Format tanggal "yyyyMMdd"
        Date date = new Date(); // Tanggal saat ini
        String tanggal = dateFormat.format(date); // Konversi tanggal ke string dengan format "yyyyMMdd"
        
        // Query untuk mendapatkan ID terakhir dari tabel transaksi
        String query = "SELECT MAX(id_transaksi) FROM transaksi";
        this.stat = k.getCon().prepareStatement(query);
        this.rs = this.stat.executeQuery();
        
        String id_terakhir = null;
        if (rs.next()) {
            id_terakhir = rs.getString(1); // Mendapatkan ID terakhir dari hasil query
        }
        
        // Jika belum ada transaksi sebelumnya
        if (id_terakhir == null) {
            jText_IDTransaksi.setText(tanggal + "001"); // Format ID transaksi: "yyyyMMdd001"
        } else {
            // Jika sudah ada transaksi sebelumnya
            // Mengambil tiga digit terakhir dari ID terakhir
            String nomor_urut = id_terakhir.substring(8);//dari format tgl index0
            int nomor = Integer.parseInt(nomor_urut); // Konversi nomor urut ke integer
            nomor++; // Increment nomor urut
            String id_baru = String.format("%03d", nomor); // Format nomor urut dengan tiga digit terakhir
            jText_IDTransaksi.setText(tanggal + id_baru); // Format ID transaksi: "yyyyMMdd" + nomor urut
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jText_IDTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jText_NamaPelanggan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_IDMasakan = new javax.swing.JComboBox<>();
        jText_JumlahBeli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jText_TotalBayar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_Input = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_EXIT = new javax.swing.JLabel();
        jLabel_Ucapandatang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 17, -1, 40));

        jText_IDTransaksi.setEnabled(false);
        jPanel1.add(jText_IDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 25, 206, 29));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("Nama Pemesan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 142, -1, 30));
        jPanel1.add(jText_NamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 183, 350, 29));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel6.setText("Paket Masakan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 218, -1, 40));

        jComboBox_IDMasakan.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox_IDMasakan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(jComboBox_IDMasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 264, 350, 39));
        jPanel1.add(jText_JumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 183, 188, 29));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("Jumlah Beli");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 137, -1, 40));

        jText_TotalBayar.setEnabled(false);
        jPanel1.add(jText_TotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 264, 188, 29));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PESAN MASAKAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 17, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("Total Bayar");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 218, -1, 40));

        jButton_Input.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Input.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jButton_Input.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button checklist.png"))); // NOI18N
        jButton_Input.setText("   PESAN");
        jButton_Input.setBorder(null);
        jButton_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InputActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 420, 616, 66));

        jButton_Clear.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Clear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button clear.png"))); // NOI18N
        jButton_Clear.setText(" CLEAR");
        jButton_Clear.setBorder(null);
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 420, 100, 66));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_EXIT.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel_EXIT.setText("X");
        jLabel_EXIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_EXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EXITMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_EXIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_EXIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 6, -1, -1));

        jLabel_Ucapandatang.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel_Ucapandatang.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Ucapandatang.setText("SELAMAT DATANG, Silahkan pilih pesananmu ...!!!");
        jPanel1.add(jLabel_Ucapandatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, -150, 1230, 670));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InputActionPerformed
    // Validasi input tidak boleh kosong
    if (jText_NamaPelanggan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama Pelanggan tidak boleh kosong!");
        return;
    }
    if (jComboBox_IDMasakan.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(null, "Paket Masakan tidak boleh kosong!");
        return;
    }
    
    if (jText_JumlahBeli.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Jumlah Beli tidak boleh kosong!");
        return;
    }
    try {
        // Proses transaksi jika semua input sudah diisi
        pesan san = new pesan();
        jText_TotalBayar.setText("" + san.total_bayar); // Menampilkan total bayar di JTextField jText_TotalBayar
        this.stat = k.getCon().prepareStatement("insert into transaksi (id_transaksi, nama_pelanggan, id_masakan, nama_masakan, harga, jumlah_beli, total_bayar) values(?,?,?,?,?,?,?)");
        this.stat.setString(1, san.id_transaksi);// Mengatur nilai parameter 1 dengan id_transaksi dari objek san
        this.stat.setString(2, san.nama_pelanggan);
        this.stat.setString(3, san.id_masakan);       
        this.stat.setString(4, san.nama_masakan);
        this.stat.setInt(5, san.harga);
        this.stat.setInt(6, san.jumlah_beli);
        this.stat.setInt(7, san.total_bayar);

        // Menampilkan dialog konfirmasi dengan detail pesanan
        int pilihan = JOptionPane.showConfirmDialog(null, 
            "DETAIL PESANAN"+
            "\nNama Pelanggan: " + san.nama_pelanggan + // Menampilkan nama pelanggan
            "\nPembelian: " + san.jumlah_beli + "  " + san.nama_masakan +
            "\nTotal Bayar: " + san.total_bayar + "\n",
            "PESANAN ANDA SEDANG DI PROSES",// Judul dialog
            JOptionPane.YES_NO_OPTION);// Opsi yang ditampilkan pada dialog (Yes dan No)

        if (pilihan == JOptionPane.YES_OPTION) {// Jika pengguna memilih Yes
            this.stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi berhasil ditambahkan!");
        } else {// Jika pengguna memilih No
            JOptionPane.showMessageDialog(null, "PESANAN BERHASIL DICANCEL");
        }
        refreshCombo();// Memperbarui data pada komponen ComboBox
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_jButton_InputActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        jText_NamaPelanggan.setText("");
        jComboBox_IDMasakan.setSelectedIndex(0);
        jText_JumlahBeli.setText("");
        jText_TotalBayar.setText("");
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jLabel_EXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EXITMouseClicked
        this.dispose();
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
            java.util.logging.Logger.getLogger(Menu_Pesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Pesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Pesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Pesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Pesan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Clear;
    public javax.swing.JButton jButton_Input;
    private javax.swing.JComboBox<String> jComboBox_IDMasakan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_EXIT;
    private javax.swing.JLabel jLabel_Ucapandatang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jText_IDTransaksi;
    private javax.swing.JTextField jText_JumlahBeli;
    private javax.swing.JTextField jText_NamaPelanggan;
    private javax.swing.JTextField jText_TotalBayar;
    // End of variables declaration//GEN-END:variables
}
