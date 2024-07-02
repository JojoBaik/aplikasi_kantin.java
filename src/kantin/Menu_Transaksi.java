package kantin;


//import= memasukkan paket dan kelas ke dalam form ini supaya dapat mengguankan kelas/metod/fungsionnya tanpa menulis lengkap
import modul.koneksi;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Menu_Transaksi extends javax.swing.JFrame {
    private DefaultTableModel model = null; // untuk model tabelnya supaya dengan sesuai keinginan kita
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; //return value yang didapat apabila kita menjalankan SQL statement kemudian ditampung di rs
    koneksi k = new koneksi(); //panggil class koneksi
    
    public Menu_Transaksi() {
        initComponents(); //berfungsi untuk menginisialisasi dan mengatur komponen-komponen GUI
        k.connect(); // mengkonekkan GUI ke localhost
        refreshTable(); // untuk merefresh table
        IDotomatis(); // untuk format otomatis
    }

    class transaksi extends Menu_Transaksi {
        int jumlah_beli, total_bayar; // mendeklarasikan tipedata & variable sesuai di database
        String id_transaksi, nama_pelanggan,statusbayar;

        public transaksi() {
            //Mengambil dan Mengonversi Nilai dari Komponen GUI ()/menginisialisasi objek, mengatur nilai awal
            nama_pelanggan = jText_NamaPelanggan.getText();//mengambil nilai nama pelanggan dari Jtext_NamaPelanggan dan disimpan di variabel nama pelanggan
            id_transaksi = jText_IDTransaksi.getText();
            total_bayar = Integer.parseInt(jText_TotalBayar.getText());// karena int sedangkan secara defaulf setiap componen di gui ini string,maka harus kita konvert
            jumlah_beli = Integer.parseInt(jText_JumlahBeli.getText());// convert dan ambil jumlah beli dari jtextJumlhbeli
            statusbayar = jComboStatusBayar.getSelectedItem().toString();
        }
   }
    
    public void refreshTable(){ // fungsinya untuk membuat komponen baris dan colom di table desaign
        model = new DefaultTableModel(); // setting modelnya
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Masakan");
        model.addColumn("Nama Masakan");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        model.addColumn("Status Bayar");
        Table_Transaksi.setModel(model); // di set/memasukan komponen table ke tabel GUI
        
        try { // setiap mengambil data di localhost atau sql dengan menggunakan try
            this.stat = k.getCon().prepareStatement("select * from transaksi"); // untuk mengeksekusi syntax sql
            this.rs = this.stat.executeQuery(); //mengambil data localhost(sql)ke dalam tabel GUI
            while (rs.next()) { // karena akan banyak user, menggunakan perulangan
                Object [] data = { // disatu baris didefinisikan dengan array
                    //data yang ditampung di rs kemudian kita masukan di setiap kolom
                  rs.getString(1),
                  rs.getString(2),
                  rs.getString(3),
                  rs.getString(4),
                  rs.getString(5),
                  rs.getString(6),
                  rs.getString(7),
                  rs.getString(8),
                };
                model.addRow(data); //kemudiaan kita masukan di model di setiap baris
            }
        } catch (Exception e) { // untuk memberi tau  jika ada eroor
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // untuk mengkosongkan text field supaya dapat diisikan kembali
        IDotomatis(); // supaya field id direfresh dan masuk ke fromat berikutnya
        jText_NamaPelanggan.setText(""); // mengkosongkan field
        jText_JumlahBeli.setText("");
        jText_TotalBayar.setText("");
        jComboStatusBayar.setSelectedIndex(0);
        
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
            String nomor_urut = id_terakhir.substring(8); //dari format tgl index0
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jText_IDTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jText_NamaPelanggan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jText_JumlahBeli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Transaksi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jText_TotalBayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_Delete = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_MenuMasakan = new javax.swing.JButton();
        jComboStatusBayar = new javax.swing.JComboBox<>();
        jButton_LogOut = new javax.swing.JButton();
        jLabel_Ucapandatang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel2.setText("ID Transaksi");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jText_IDTransaksi.setEnabled(false);
        jPanel2.add(jText_IDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, 29));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("Nama Pelanggan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

        jText_NamaPelanggan.setEditable(false);
        jPanel2.add(jText_NamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 260, 29));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel6.setText("Status Bayar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        jText_JumlahBeli.setEditable(false);
        jPanel2.add(jText_JumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 260, 29));

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
        Table_Transaksi.setRowHeight(40);
        Table_Transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_TransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Transaksi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 720, 540));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("Jumlah Beli");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 30));

        jText_TotalBayar.setEnabled(false);
        jPanel2.add(jText_TotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 260, 29));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("Total Bayar");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU TRANSAKSI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 240, 50));

        jButton_Delete.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Delete.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button delete 1.png"))); // NOI18N
        jButton_Delete.setText("   DELETE");
        jButton_Delete.setBorder(null);
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 260, 41));

        jButton_Update.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Update.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Update.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button save.png"))); // NOI18N
        jButton_Update.setText("   SIMPAN");
        jButton_Update.setBorder(null);
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 260, 41));

        jButton_MenuMasakan.setBackground(new java.awt.Color(204, 102, 255));
        jButton_MenuMasakan.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_MenuMasakan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_MenuMasakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button masakan.png"))); // NOI18N
        jButton_MenuMasakan.setText("MENU MASAKAN");
        jButton_MenuMasakan.setBorder(null);
        jButton_MenuMasakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenuMasakanActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_MenuMasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 180, 41));

        jComboStatusBayar.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jComboStatusBayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<~~Pilih Status~~>", "LUNAS", "BELUM LUNAS" }));
        jPanel2.add(jComboStatusBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 30));

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
        jPanel2.add(jButton_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 570, 110, 40));

        jLabel_Ucapandatang.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel_Ucapandatang.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Ucapandatang.setText("SELAMAT DATANG KASIR ...!");
        jPanel2.add(jLabel_Ucapandatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-360, 0, 1460, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1093, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        try { // unutuk mangambil data dengan menggunkan syntax sql
            transaksi tran = new transaksi(); //panggin transaksi misal dengan tran (? = karena data diambil dari table)
            tran.id_transaksi = jText_IDTransaksi.getText();
            this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?," // syntax update yang ada di menu transaksi
                    + "jumlah_beli=?,total_bayar=?, statusbayar=? "
                    + "where id_transaksi=?");
            this.stat.setString(1, tran.nama_pelanggan);//memakai set karena ingin memasukan data
            this.stat.setInt(2, tran.jumlah_beli);
            this.stat.setInt(3, tran.total_bayar);
            this.stat.setString(4,tran.statusbayar);
            this.stat.setString(5, tran.id_transaksi);
            this.stat.executeUpdate(); // memasukan data dari tabel kedalam sql
            refreshTable(); // kemudian kita refresh
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_MenuMasakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MenuMasakanActionPerformed
/*        try { // unutuk mangambil data dengan menggunkan syntax sql
            transaksi tran = new transaksi(); //panggin transaksi misal dengan tran (? = karena data diambil dari table)
            jText_TotalBayar.setText(""+tran.total_bayar); //kita set popup pemberitahuan yes/no dan kita masukan hasil totalbayar
            this.stat = k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?)"); // konekkan dan tuluskan statmen/syntax sql
            this.stat.setString(1, tran.id_transaksi);
            this.stat.setString(2, tran.nama_pelanggan);
            this.stat.setString(3, tran.id_masakan);
            this.stat.setString(4, tran.tanggal);
            this.stat.setString(5, tran.nama_masakan);
            this.stat.setInt(6, tran.harga);
            this.stat.setInt(7, tran.jumlah_beli);
            this.stat.setInt(8, tran.total_bayar);
            // sebelum di exsekusi (input) akan mucul popup konfirmasi transaksi YES/NO
            int pilihan = JOptionPane.showConfirmDialog(null, "Tanggal: " +tran.tanggal +
                    "\nNama Pelanggan: " +tran.nama_pelanggan + //kita masukan semua data yang ingin di konfirmasi
                    "\nPembelian: "+tran.jumlah_beli + " "+ tran.nama_masakan + 
                    "\nTotal Bayar: "+tran.total_bayar+
                    "\n",
                    "Tambahkan Transaksi?",
                    JOptionPane.YES_NO_OPTION); //untuk pilihan YES/NO option
            if (pilihan == JOptionPane.YES_OPTION){ // jika pilihan YES
                this.stat.executeUpdate(); // maka di executeUpdate
                refreshTable(); // kemudian di refresh
            }else if (pilihan == JOptionPane.NO_OPTION){ // jika pilihan NO
                refreshTable(); //maka hanya refresh tabel saja tidak di exekusi
            }
            
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
            Menu_Masakan msk = new Menu_Masakan();
            msk.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton_MenuMasakanActionPerformed

    private void Table_TransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_TransaksiMouseClicked
        // Mengatur nilai jText_IDTransaksi dengan nilai dari kolom pertama baris yang dipilih di Table_Transaksi
        jText_IDTransaksi.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 0).toString());
        jText_NamaPelanggan.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 1).toString());
        jText_JumlahBeli.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 5).toString());
        jText_TotalBayar.setText(model.getValueAt(Table_Transaksi.getSelectedRow(), 4).toString());
        jComboStatusBayar.setSelectedItem(model.getValueAt(Table_Transaksi.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_Table_TransaksiMouseClicked

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        transaksi tran = new transaksi(); // panggil transaksi
        tran.id_transaksi = jText_IDTransaksi.getText(); 
        try {
            this.stat = k.getCon().prepareStatement("delete from transaksi "
                    + "where id_transaksi=?");
            this.stat.setString(1, tran.id_transaksi);// kemudian kita isikan untuk tanda tanyake1 isiny adalah tran.idtransaksi
            this.stat.executeUpdate(); // kemudian kita exekusi
            refreshTable(); // kemudian refresh
             
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        Login log = new Login(); // memanggin menu login kembali ketika logout
        log.setVisible(true);
        this.setVisible(false); // false karena menu masakan hilang pindah ke menu login
    }//GEN-LAST:event_jButton_LogOutActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Transaksi;
    public javax.swing.JButton jButton_Delete;
    public javax.swing.JButton jButton_LogOut;
    public javax.swing.JButton jButton_MenuMasakan;
    public javax.swing.JButton jButton_Update;
    private javax.swing.JComboBox<String> jComboStatusBayar;
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
