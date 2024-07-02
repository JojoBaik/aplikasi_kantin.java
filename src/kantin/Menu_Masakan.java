package kantin;

import modul.koneksi;
import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Menu_Masakan extends javax.swing.JFrame {
    private File file;
    private File selectedFile;
    private DefaultTableModel model = null; // untuk model tabelnya supaya dengan sesuai keinginan kita
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; //return value yang didapat apabila kita menjalankan SQL statement
    koneksi k = new koneksi(); //panggil class koneksi

    public Menu_Masakan() {
        initComponents();
        k.connect(); // mengkonekkan GUI ke localhost
        IDotomatis();
        refreshTable(); // untuk merefresh table
        settablerender();
        
    }
    
    //mengextensds dari menu masakan
    class masakan extends Menu_Masakan {
        int  harga; // mendeklarasikan tipedata & variable sesuai di database
        String id_masakan,nama_masakan, status;
        byte []gambar;
        
        public masakan() { //Mengambil dan Mengonversi Nilai dari Komponen GUI ()/menginisialisasi objek, mengatur nilai awal
        this.id_masakan = jText_IDMasakan.getText(); // Mengambil teks dari komponen GUI jText_IDMasakan dan menyimpannya di variabel id_masakan
        this.nama_masakan = jText_NamaMasakan.getText();
        this.harga = Integer.parseInt(jText_Harga.getText());
        this.status = jComboBox_StatusMasakan.getSelectedItem().toString();
        
        if (file != null) { // Memeriksa apakah variabel file tidak null (artinya file telah dipilih)
            try {
                FileInputStream fis = new FileInputStream(file);//untuk membaca file byte per byte
                ByteArrayOutputStream bos = new ByteArrayOutputStream();// Membuat output stream untuk menyimpan data byte yang dibaca
                byte[] buf = new byte[1024];// membaca data dalam blok-blok besar dari file,buffer dapat menampung hingga 1024 byte data pada satu waktu
                for (int readNum; (readNum = fis.read(buf)) != -1;) { //Jika file yang dibaca lebih besar dari 1024 byte, proses pembacaan akan dilakukan dalam beberapa iterasi
                    bos.write(buf, 0, readNum);// Menulis data dari buffer ke ByteArrayOutputStream
                }
                this.gambar = bos.toByteArray();//Mengonversi data yang disimpan di ByteArrayOutputStream menjadi array byte dan menyimpannya di variabel gambar
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {// Jika file belum dipilih
            this.gambar = null;
        }
    }
    }
    
    public void refreshTable (){ // fungsinya untuk membuat komponen baris dan colom di table desaign
        model = new DefaultTableModel(); // setting modelnya
        model.addColumn("ID Masakan");
        model.addColumn("Nama Masakan");
        model.addColumn("Harga");
        model.addColumn("Status Masakan");
        model.addColumn("Gambar");
        Table_Masakan.setModel(model); // memasukan komponen table ke tabel GUI
        
        try { // setiap mengambil data di localhost atau sql dengan menggunakan try
            this.stat = k.getCon().prepareStatement("select * from masakan"); // untuk mengeksekusi syntax sql
            this.rs = this.stat.executeQuery(); //mengambil data localhost(sql)ke dalam tabel GUI
            while (rs.next()) {// karena akan banyak user, menggunakan perulangan
                Object[] data = { // disatu baris didefinisikan dengan array
                    //data yang ditampung di rs kemudian kita masukan di setiap baris
                  rs.getString("id_masakan"),
                  rs.getString("nama_masakan"),
                  rs.getInt("harga"),
                  rs.getString("status"),
                  rs.getBytes("gambar") // Ambil gambar dari database
                };
                model.addRow(data); //kemudiaan kita masukan di model di setiap baris
            }
        } catch (Exception e) { // untuk memberi tau  jika ada eroor
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        settablerender();
        // untuk mengkosongkan text field supaya dapat diisikan kembali
        IDotomatis();// supaya field id direfresh dan masuk ke fromat berikutnya
        jText_NamaMasakan.setText("");
        jText_Harga.setText("");
    }
    private void IDotomatis(){
         try {
        // Koneksi ke database
        k.connect();
        
        // Mendapatkan ID terakhir dari database
        //mengurutkan secara descending maka nilai terbesar akan muncul pertama
        String query = "SELECT id_masakan FROM masakan ORDER BY id_masakan DESC LIMIT 1";//hanya ingin satu baris data yang memiliki nilai id_masakan tertinggi.
        this.stat = k.getCon().prepareStatement(query);
        ResultSet rs = this.stat.executeQuery();// Mengeksekusi query dan menyimpan hasilnya dalam objek ResultSet
        
        String lastID = ""; // Variabel untuk menyimpan ID terakhir yang diambil dari database
        if(rs.next()) {// Memeriksa apakah ResultSet memiliki hasil (baris data)
            lastID = rs.getString("id_masakan"); //jika ad akan dikonvrsi ke lastid
        }
        
        // Mengekstrak angka dari ID terakhir
        int idNum = 0;// Variabel untuk menyimpan angka yang diekstrak dari ID terakhir
        if (lastID != null && !lastID.isEmpty()) { // Memeriksa apakah ID terakhir tidak null dan tidak kosong
            idNum = Integer.parseInt(lastID.substring(2)); // Mengabaikan dua karakter pertama ("MN")dan mengonversi sisa string ke integer(idNum)
        }
        
        // Membuat ID baru dengan increment 1
        idNum++;
        // Menggabungkan string "MN" dengan angka baru yang diformat sebagai tiga digit dengan nol di depan jika perlu
        String newID = "MN" + String.format("%03d", idNum);
        
        // Set nilai ID otomatis ke field
        jText_IDMasakan.setText(newID);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
    private void settablerender() {
     //Inner class untuk menangani rendering sel tabel
    class customrender extends DefaultTableCellRenderer {

        //Override metode untuk menyesuaikan tampilan sel tabel
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Memeriksa apakah nilai sel adalah array byte (gambar)
           if (value instanceof byte[]) {
                // Mengubah data byte array menjadi ImageIcon
                byte[] imageData = (byte[]) value;//value menjadi tipe byte[] dan menyimpannya dalam variabel imageData.
               ImageIcon icon = new ImageIcon(imageData);
               
               // Membuat label untuk menampilkan gambar
                JLabel label = new JLabel(icon);
               
                // Mengatur tata letak gambar menjadi tengah
               label.setHorizontalAlignment(JLabel.CENTER);
                
               // Mengembalikan label untuk ditampilkan di sel tabel
                return label;//sama seperti soutprln tapi return itu non void
            } else {
               //memanggil metode getTableCellRendererComponent() dari kelas induk (superclass) yang diperluas oleh kelas saat ini (customrender).
                // Jika nilai sel bukan array byte (gambar), kembalikan default renderer
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           }
        }

   }
//    // Mengatur renderer khusus untuk kolom gambar di tabel
    Table_Masakan.getColumnModel().getColumn(4).setCellRenderer(new customrender());
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton_CARI = new javax.swing.JButton();
        jButton_LogOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jText_IDMasakan = new javax.swing.JTextField();
        jText_Harga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jText_NamaMasakan = new javax.swing.JTextField();
        jButton_Menutransaksi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Masakan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_StatusMasakan = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton_Carigambar = new javax.swing.JButton();
        jButton_Input = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_MenuRegistrasi = new javax.swing.JButton();
        jLabel_Carigambar = new javax.swing.JLabel();
        jButton_Clear = new javax.swing.JButton();
        jLabel_Ucapandatang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_CARI.setBackground(new java.awt.Color(0, 102, 255));
        jButton_CARI.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton_CARI.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CARI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button search 2.png"))); // NOI18N
        jButton_CARI.setText(" CARI");
        jButton_CARI.setBorder(null);
        jButton_CARI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CARIActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_CARI, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 90, 30));

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
        jPanel2.add(jButton_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel2.setText("ID Masakan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        jText_IDMasakan.setEnabled(false);
        jPanel2.add(jText_IDMasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 370, 29));
        jPanel2.add(jText_Harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 370, 29));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("Nama Masakan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("Harga");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 140, 30));
        jPanel2.add(jText_NamaMasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 370, 29));

        jButton_Menutransaksi.setBackground(new java.awt.Color(204, 102, 255));
        jButton_Menutransaksi.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Menutransaksi.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Menutransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button transaksi.png"))); // NOI18N
        jButton_Menutransaksi.setText(" MENU TRANSAKSI");
        jButton_Menutransaksi.setBorder(null);
        jButton_Menutransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenutransaksiActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Menutransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 210, 40));

        Table_Masakan.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Masakan.setRowHeight(100);
        Table_Masakan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_MasakanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Masakan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 670, 450));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel8.setText("Gambar");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 190, 30));

        jComboBox_StatusMasakan.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox_StatusMasakan.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jComboBox_StatusMasakan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERSEDIA", "TIDAK TERSEDIA" }));
        jPanel2.add(jComboBox_StatusMasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 150, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU MASAKAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 270, 50));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel9.setText("Status Makanan");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 190, 30));

        jButton_Carigambar.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Carigambar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton_Carigambar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Carigambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button search gambar.png"))); // NOI18N
        jButton_Carigambar.setText(" Browse");
        jButton_Carigambar.setBorder(null);
        jButton_Carigambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CarigambarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Carigambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 90, 40));

        jButton_Input.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Input.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Input.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button save.png"))); // NOI18N
        jButton_Input.setText("   TAMBAH");
        jButton_Input.setBorder(null);
        jButton_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InputActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 370, 41));

        jButton_Update.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Update.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button ubah.png"))); // NOI18N
        jButton_Update.setText("   UBAH");
        jButton_Update.setBorder(null);
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 160, 41));

        jButton_Delete.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Delete.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button delete 1.png"))); // NOI18N
        jButton_Delete.setText("   DELETE");
        jButton_Delete.setBorder(null);
        jButton_Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_DeleteMouseClicked(evt);
            }
        });
        jPanel2.add(jButton_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 160, 40));

        jButton_MenuRegistrasi.setBackground(new java.awt.Color(204, 102, 255));
        jButton_MenuRegistrasi.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_MenuRegistrasi.setForeground(new java.awt.Color(255, 255, 255));
        jButton_MenuRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button user 1.png"))); // NOI18N
        jButton_MenuRegistrasi.setText("MENU REGISTRASI");
        jButton_MenuRegistrasi.setBorder(null);
        jButton_MenuRegistrasi.setMaximumSize(new java.awt.Dimension(183, 30));
        jButton_MenuRegistrasi.setPreferredSize(new java.awt.Dimension(183, 28));
        jButton_MenuRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenuRegistrasiActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_MenuRegistrasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 210, 41));
        jPanel2.add(jLabel_Carigambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 170, 30));

        jButton_Clear.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Clear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button clear.png"))); // NOI18N
        jButton_Clear.setText(" CLEAR");
        jButton_Clear.setBorder(null);
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 90, 30));

        jLabel_Ucapandatang.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel_Ucapandatang.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Ucapandatang.setText("SELAMAT DATANG ADMIN ...!");
        jLabel_Ucapandatang.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel_UcapandatangComponentShown(evt);
            }
        });
        jPanel2.add(jLabel_Ucapandatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, -20, 1580, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
    String idMasakan = jText_IDMasakan.getText();
    String namaMasakan = jText_NamaMasakan.getText();
    String harga = jText_Harga.getText();
    String statusMasakan = jComboBox_StatusMasakan.getSelectedItem().toString();

    String updateQuery = "UPDATE masakan SET nama_masakan = ?, harga = ?, status = ? WHERE id_masakan = ?";

    try {
        this.stat = k.getCon().prepareStatement(updateQuery);
        stat.setString(1, namaMasakan);
        stat.setString(2, harga);
        stat.setString(3, statusMasakan);
        stat.setString(4, idMasakan);

        int affectedRows = stat.executeUpdate();// Melakukan update dan mendapatkan jumlah baris yang terpengaruh
        if (affectedRows > 0) { //jika jumlhnya lebih dari 0
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();//memberikan detail tentang bagaimana dan di mana pengecualian/kesalahan terjadi
        JOptionPane.showMessageDialog(this, "Kesalahan database: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }
    refreshTable();
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        Login log = new Login(); // memanggin menu login kembali ketika logout
        log.setVisible(true);
        this.setVisible(false); // false karena menu masakan hilang pindah ke menu login
    }//GEN-LAST:event_jButton_LogOutActionPerformed

    private void jButton_MenutransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MenutransaksiActionPerformed
        Menu_Transaksi tran = new Menu_Transaksi();//memanggil menu transaksi ketika kita mengklik botton
        tran.setVisible(true);
        this.setVisible(false); // false karena pindah kemenu transaksi
    }//GEN-LAST:event_jButton_MenutransaksiActionPerformed

    private void jButton_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InputActionPerformed
        try {
        masakan m = new masakan();
        this.stat = k.getCon().prepareStatement("INSERT INTO masakan VALUES (?, ?, ?, ?, ?)");
        stat.setString(1, m.id_masakan);//mengatur parameter
        stat.setString(2, m.nama_masakan);
        stat.setInt(3, m.harga);
        stat.setString(4, m.status);
        // Memeriksa apakah ada file gambar yang dipilih
        if (selectedFile != null) {// Jika ada, mengatur parameter ke-5 dengan data gambar dari file yang dipilih
            //membaca semua byte dari file yang dipilih (selectedFile) dan mengembalikan array byte yang berisifile tersebut
            stat.setBytes(5, Files.readAllBytes(selectedFile.toPath()));
        } else {
            // Jika tidak ada, mengatur parameter ke-5 dengan nilai null
            stat.setNull(5, Types.BLOB);
        }
        stat.executeUpdate();
        settablerender();
        refreshTable();
        IDotomatis();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
    }
    }//GEN-LAST:event_jButton_InputActionPerformed

    private void Table_MasakanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_MasakanMouseClicked
        // Mengatur nilai jText_IDMasakan dengan nilai dari kolom pertama baris yang dipilih di Table_Masakan
        jText_IDMasakan.setText(model.getValueAt(Table_Masakan.getSelectedRow(),0).toString());
        jText_NamaMasakan.setText(model.getValueAt(Table_Masakan.getSelectedRow(),1).toString());
        jText_Harga.setText(model.getValueAt(Table_Masakan.getSelectedRow(),2).toString());
        jComboBox_StatusMasakan.setSelectedItem(model.getValueAt(Table_Masakan.getSelectedRow(),3).toString());
        // Menampilkan nama gambar di jLabel_Carigambar
        /*String namaGambar = model.getValueAt(Table_Masakan.getSelectedRow(), 4).toString(); // Mengambil nama gambar dari model tabel
        jLabel_Carigambar.setText(namaGambar); // Menampilkan nama gambar di jLabel_Carigambar*/
    }//GEN-LAST:event_Table_MasakanMouseClicked

    private void jButton_DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_DeleteMouseClicked
                                            
    try {
        String idMasakan = jText_IDMasakan.getText();

        // Hapus data terkait di tabel lain terlebih dahulu
        // tabel terkait bernama "transaksi"
        String deleteTransaksiQuery = "DELETE FROM transaksi WHERE id_masakan = ?";
        this.stat = k.getCon().prepareStatement(deleteTransaksiQuery);
        stat.setString(1, idMasakan);//mengatur parameter
        stat.executeUpdate();

        // Baru kemudian hapus dari tabel masakan
        String deleteMasakanQuery = "DELETE FROM masakan WHERE id_masakan = ?";
        this.stat = k.getCon().prepareStatement(deleteMasakanQuery);
        stat.setString(1, idMasakan);
        stat.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
        refreshTable();
        IDotomatis();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }



    }//GEN-LAST:event_jButton_DeleteMouseClicked

    private void jButton_MenuRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MenuRegistrasiActionPerformed
        Menu_DataAccount reg = new Menu_DataAccount(); // panggil menu registrasi
        reg.setVisible(true); // kemudian eneblekan
        this.setVisible(false); // false karena menu masakan hilang pindah ke menu registrasi
    }//GEN-LAST:event_jButton_MenuRegistrasiActionPerformed

    private void jButton_CARIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CARIActionPerformed
        // Mendapatkan input nama masakan yang akan dicari
        String namaMasakanDicari = jText_NamaMasakan.getText().trim();

        // Menghapus semua baris dalam tabel untuk mengosongkan tabel sebelum pencarian
        model.setRowCount(0);
        boolean hasilDitemukan = false;// Variabel untuk menandai apakah hasil pencarian ditemukan atau tidak

        try {
            // Membuat statement untuk mencari menu masakan berdasarkan nama masakan
            //LIKE : nilai dalam kolom "nama_masakan" harus cocok dengan ?
            this.stat = k.getCon().prepareStatement("SELECT * FROM masakan WHERE nama_masakan LIKE ?");
            //mengatur parameter
            stat.setString(1, "%" + namaMasakanDicari + "%"); // Menyertakan tanda % untuk mencocokkan nama masakan apa pun yang mengandung input yang diberikan
            this.rs = this.stat.executeQuery(); // Mengeksekusi query

            // Melakukan iterasi melalui hasil pencarian
            while (rs.next()) {
                // Menambahkan data ke model tabel untuk ditampilkan,memakai get
                Object[] data = {
                    rs.getString("id_masakan"),
                    rs.getString("nama_masakan"),
                    rs.getInt("harga"),
                    rs.getString("status"),
                    rs.getBytes("gambar")

                };
                model.addRow(data);
                hasilDitemukan = true;// Menandai bahwa hasil pencarian telah ditemukan
            }

            if (!hasilDitemukan) { // Menampilkan pop up jika hasil pencarian tidak ditemukan
                JOptionPane.showMessageDialog(null, "Makanan atau Minuman tidak ditemukan");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton_CARIActionPerformed

    private void jButton_CarigambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CarigambarActionPerformed
    JFileChooser chooser = new JFileChooser(); //JFileChooser untuk memilih file gambar
    chooser.showOpenDialog(null); // Menampilkan dialog pemilihan file
    selectedFile = chooser.getSelectedFile(); // Mendapatkan file yang dipilih oleh pengguna
    if (selectedFile != null) {// Memeriksa apakah file dipilih tidak null
    jLabel_Carigambar.setText(selectedFile.getName()); // Jika file tidak null, menetapkan nama file ke label jLabel_Carigambar
    }
    
    }//GEN-LAST:event_jButton_CarigambarActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        refreshTable();
        IDotomatis();
        settablerender();
    jText_NamaMasakan.setText("");
    jText_Harga.setText(""); // Mengosongkan field
    jComboBox_StatusMasakan.setSelectedIndex(0);
    jLabel_Carigambar.setText(""); // Mengosongkan nama gambar yang ditampilkan
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jLabel_UcapandatangComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel_UcapandatangComponentShown

    }//GEN-LAST:event_jLabel_UcapandatangComponentShown
        
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
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Masakan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Masakan;
    private javax.swing.JButton jButton_CARI;
    private javax.swing.JButton jButton_Carigambar;
    private javax.swing.JButton jButton_Clear;
    public javax.swing.JButton jButton_Delete;
    public javax.swing.JButton jButton_Input;
    public javax.swing.JButton jButton_LogOut;
    public javax.swing.JButton jButton_MenuRegistrasi;
    public javax.swing.JButton jButton_Menutransaksi;
    public javax.swing.JButton jButton_Update;
    private javax.swing.JComboBox<String> jComboBox_StatusMasakan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Carigambar;
    private javax.swing.JLabel jLabel_Ucapandatang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText_Harga;
    public javax.swing.JTextField jText_IDMasakan;
    private javax.swing.JTextField jText_NamaMasakan;
    // End of variables declaration//GEN-END:variables
}
