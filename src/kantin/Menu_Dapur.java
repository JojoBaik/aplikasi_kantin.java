package kantin;

import modul.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu_Dapur extends javax.swing.JFrame {

    private DefaultTableModel model = null; // untuk model tabelnya supaya dengan sesuai keinginan kita
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; //return value yang didapat apabila kita menjalankan SQL statement
    koneksi k = new koneksi(); //panggil class koneksi
    
    public Menu_Dapur() {
        initComponents();
        k.connect(); // mengkonekkan GUI ke localhost
        refreshTable();
    }
    
    class Dapur extends Menu_Dapur {
        int jumlah_beli, total_bayar; // mendeklarasikan tipedata & variable sesuai di database
        String id_transaksi, nama_pelanggan,statuspesanan;

        public Dapur() {// membuat konstraktornya, memberi nilai awal
            //nama pelangkan diambil dari jtextNamaPelnggan dan disimpan di variabel nama_pelanggan
            nama_pelanggan = jText_NamaPelanggan.getText();
            id_transaksi = jText_IDTransaksi.getText();
            total_bayar = Integer.parseInt(jText_TotalBayar.getText());
            jumlah_beli = Integer.parseInt(jText_JumlahBeli.getText());// convert dan ambil jumlah beli dari jtextJumlhbeli
            statuspesanan = jComboBox_StatusPesan.getSelectedItem().toString();
        }     
   }
    
    public void refreshTable(){ // fungsinya untuk membuat komponen baris dan colom di table desaign, menampilkan isi tabel
        model = new DefaultTableModel(); // setting modelnya
        model.addColumn("ID");
        model.addColumn("Nama Pemesan");
        model.addColumn("Paket Masakan");
        model.addColumn("Nama Masakan");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        model.addColumn("Status Pesanan");
        Table_Transaksi.setModel(model); // di set/memasukan komponen table ke tabel GUI
        
        try { // setiap mengambil data di localhost atau sql dengan menggunakan try
            this.stat = k.getCon().prepareStatement("select * from transaksi"); // untuk mengeksekusi syntax sql
            this.rs = this.stat.executeQuery(); //mengambil data localhost(sql)ke dalam tabel GUI
            while (rs.next()) { // karena akan banyak user, menggunakan perulangan
                Object [] data = { // disatu baris didefinisikan dengan array
                    //data yang ditampung di rs kemudian akan masukan di setiap kolom
                  rs.getString(1),
                  rs.getString(2),
                  rs.getString(3),
                  rs.getString(4),
                  rs.getString(5),
                  rs.getString(6),
                  rs.getString(7),
                  rs.getString(9)
                        
                };
                model.addRow(data); //kemudiaan kita masukan di model di setiap baris
            }
        } catch (Exception e) { // untuk memberi tau  jika ada eroor
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // untuk mengkosongkan text field supaya dapat diisikan kembali
        jText_NamaPelanggan.setText(""); // mengkosongkan field
        jText_JumlahBeli.setText("");
        jText_TotalBayar.setText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Transaksi = new javax.swing.JTable();
        jButton_Selesai = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jText_IDTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jText_NamaPelanggan = new javax.swing.JTextField();
        jText_JumlahBeli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jText_TotalBayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton_LogOut = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jLabel_Ucapandatang = new javax.swing.JLabel();
        jComboBox_StatusPesan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_Transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_Transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Table_Transaksi.setRowHeight(60);
        Table_Transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_TransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Transaksi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 20, 799, 417));

        jButton_Selesai.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Selesai.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Selesai.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Selesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button checklist.png"))); // NOI18N
        jButton_Selesai.setText("   PESANAN SELESAI");
        jButton_Selesai.setBorder(null);
        jButton_Selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelesaiActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 410, 51));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR PESANAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 171, -1, 40));

        jText_IDTransaksi.setEditable(false);
        jPanel1.add(jText_IDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 179, 350, 29));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("Nama Pelanggan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 232, -1, 30));

        jText_NamaPelanggan.setEditable(false);
        jPanel1.add(jText_NamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 235, 350, 29));

        jText_JumlahBeli.setEditable(false);
        jPanel1.add(jText_JumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 290, 350, 29));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("Jumlah Beli");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 282, -1, 40));

        jText_TotalBayar.setEditable(false);
        jPanel1.add(jText_TotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 340, 350, 29));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("Total Bayar");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 340, -1, 40));

        jButton_LogOut.setBackground(new java.awt.Color(255, 0, 0));
        jButton_LogOut.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton_LogOut.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button logout.png"))); // NOI18N
        jButton_LogOut.setText("LOGOUT");
        jButton_LogOut.setBorder(null);
        jButton_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogOutActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 40));

        jButton_Clear.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Clear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button clear.png"))); // NOI18N
        jButton_Clear.setText("CLEAR");
        jButton_Clear.setBorder(null);
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 460, 100, 51));

        jLabel_Ucapandatang.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel_Ucapandatang.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Ucapandatang.setText("SELAMAT DATANG KOKI ...!");
        jPanel1.add(jLabel_Ucapandatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 117, -1, -1));

        jComboBox_StatusPesan.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jComboBox_StatusPesan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELESAI", "TERTUNDA" }));
        jPanel1.add(jComboBox_StatusPesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 160, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel6.setText("Status Pesanan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 130, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 1450, 540));

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

    private void Table_TransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_TransaksiMouseClicked
        // Mengatur nilai jText_IDTransaksi dengan nilai dari kolom pertama baris yang dipilih di Table_Transaksi
        jText_IDTransaksi.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 0).toString());
        jText_NamaPelanggan.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 1).toString());
        jText_JumlahBeli.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 5).toString());
        jText_TotalBayar.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_Table_TransaksiMouseClicked

    private void jButton_SelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelesaiActionPerformed
        try { // unutuk mangambil data dengan menggunkan syntax sql
            Dapur dap = new Dapur(); //panggil dapur misal dengan dap (? = karena data diambil dari table)
            dap.id_transaksi = jText_IDTransaksi.getText();
            this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?," // syntax update yang ada di menu transaksi
                    + "jumlah_beli=?,total_bayar=?, statuspesanan=? "
                    + "where id_transaksi=?");
            this.stat.setString(1, dap.nama_pelanggan);
            this.stat.setInt(2, dap.jumlah_beli);
            this.stat.setInt(3, dap.total_bayar);
            this.stat.setString(4,dap.statuspesanan);
            this.stat.setString(5, dap.id_transaksi);
            this.stat.executeUpdate(); // memasukan data dari tabel kedalam sql
            refreshTable(); // kemudian kita refresh
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton_SelesaiActionPerformed

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        Login log = new Login(); // memanggin menu login kembali ketika klik logout
        log.setVisible(true);
        this.setVisible(false); // false kare
    }//GEN-LAST:event_jButton_LogOutActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        jText_IDTransaksi.setText("");
        jText_NamaPelanggan.setText(""); // mengkosongkan field
        jText_JumlahBeli.setText("");
        jText_TotalBayar.setText("");
    }//GEN-LAST:event_jButton_ClearActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Dapur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Transaksi;
    private javax.swing.JButton jButton_Clear;
    public javax.swing.JButton jButton_LogOut;
    public javax.swing.JButton jButton_Selesai;
    private javax.swing.JComboBox<String> jComboBox_StatusPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Ucapandatang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText_IDTransaksi;
    private javax.swing.JTextField jText_JumlahBeli;
    private javax.swing.JTextField jText_NamaPelanggan;
    private javax.swing.JTextField jText_TotalBayar;
    // End of variables declaration//GEN-END:variables
}
