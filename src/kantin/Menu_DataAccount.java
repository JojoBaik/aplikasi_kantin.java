package kantin;

import modul.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Menu_DataAccount extends javax.swing.JFrame {
    private DefaultTableModel model = null; // untuk model tabelnya supaya dengan sesuai keinginan kita
    private PreparedStatement stat; // supaya dapat mengirimkan query atau menmpung code sql
    private ResultSet rs; // return value yang didapat apabila kita menjalankan SQL statement dan ditampun di rs
    koneksi k = new koneksi (); //panggil class koneksi
    
    
    public Menu_DataAccount() {
        initComponents();
        k.connect(); // mengkonekkan GUI ke localhost
        refreshTable(); // untuk merefresh table
        IDotomatis();
        
    } //mengextensds dari menu registrasi
    class user extends Menu_DataAccount {
        int  id_level; // mendeklarasikan tipedata & variable sesuai di database
        String id_user,username, password, nama_user, email;
        
        public user(){ // membuat konstraktornya, memberi nilai awal
            id_user = jText_User.getText();//mengambil nilai id user dari Jtext_User dan disimpan di variabel id user
            username = jText_Username.getText(); // memakai getTEXt karena textField
            password = jText_Password.getText();
            nama_user = jText_NamaUser.getText();
            // karena id level int sedangkan secara defaulf setiap componen di gui ini string,maka harus kita konvert
            id_level = Integer.parseInt(jComboBox_IDLevel.getSelectedItem().toString()); //menggunakan getselected untuk mengambil data karena combobox            
            email = jTextField_Email.getText();
        }
    }
    
    public void refreshTable(){ // fungsinya untuk membuat komponen baris dan colom di table desaign
        model = new DefaultTableModel(); // setting model
        model.addColumn("ID User");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Nama User");
        model.addColumn("ID Level");
        model.addColumn("Email");
        Table_Registrasi.setModel(model); // memasukan komponen table ke tabel GUI
        
        try { // setiap mengambil data di localhost atau sql dengan menggunakan try
            this.stat = k.getCon().prepareStatement("select * from user"); // untuk mengeksekusi syntax sql
            // nilai yang berada di tabel user dimasukan ke varible rs 
            this.rs = this.stat.executeQuery(); //mengambil data localhost(sql)ke dalam tabel GUI
            
            while (rs.next()) { // karena akan banyak user, menggunakan perulangan
                Object[] data = { // disatu baris didefinisikan dengan array
                    //data yang ditampung di rs kemudian kita masukan di setiap baris
                    rs.getString("id_user"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("nama_user"),
                    rs.getInt("id_level"),
                    rs.getString("email")
                    
                };
                model.addRow(data); //kemudiaan kita masukan di model di setiap baris
                
            }
        } catch (Exception e) { // untuk memberi tau  jika ada eroor
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // untuk mengkosongkan text field supaya dapat diisikan kembali
        IDotomatis(); // supaya field id direfresh dan masuk ke fromat berikutnya
        jText_Username.setText("");
        jText_Password.setText("");
        jText_NamaUser.setText("");
        jTextField_Email.setText("");
    }
    private void IDotomatis(){
         try {
        // Koneksi ke database
        k.connect();
        
        // Mendapatkan ID terakhir dari database
        //mengurutkan secara descending maka nilai terbesar akan muncul pertama
        String query = "SELECT id_user FROM user ORDER BY id_user DESC LIMIT 1";//hanya ingin satu baris data yang memiliki nilai id_masakan tertinggi.
        this.stat = k.getCon().prepareStatement(query);
        ResultSet rs = this.stat.executeQuery();// Mengeksekusi query dan menyimpan hasilnya dalam objek ResultSet
        
        String lastID = "";// Variabel untuk menyimpan ID terakhir yang diambil dari database
        if(rs.next()) {// Memeriksa apakah ResultSet memiliki hasil (baris data)
            lastID = rs.getString("id_user");//jika ad akan dikonvrsi ke lastid
        }
        
        // Mengekstrak angka dari ID terakhir
        int idNum = 0;
        // Memeriksa apakah ID terakhir tidak null dan tidak kosong
        if (lastID != null && !lastID.isEmpty()) {
            idNum = Integer.parseInt(lastID.substring(2)); // Mengabaikan dua karakter pertama ("KR")dan mengonversi sisa string ke integer(idNum)
        }
        
        // Membuat ID baru dengan increment 1
        idNum++;
        // Menggabungkan string "KR" dengan angka baru yang diformat sebagai tiga digit dengan nol di depan jika perlu
        String newID = "KR" + String.format("%03d", idNum);
        
        // Set nilai ID otomatis ke field
        jText_User.setText(newID);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Registrasi = new javax.swing.JTable();
        jText_NamaUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jText_Password = new javax.swing.JTextField();
        jComboBox_IDLevel = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jText_Username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jText_User = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_menutransaksi = new javax.swing.JButton();
        jButton_LogOut = new javax.swing.JButton();
        jButton_MenuMasakan = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_Input = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jButton_Clear = new javax.swing.JButton();
        jLabel_Ucapandatang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel8.setText("EMAIL");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, 30));

        Table_Registrasi.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Registrasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Table_Registrasi.setRowHeight(40);
        Table_Registrasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_RegistrasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Registrasi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 690, 320));
        jPanel2.add(jText_NamaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 398, 29));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("USERNAME");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("PASSWORD");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, 30));
        jPanel2.add(jText_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 398, 29));

        jComboBox_IDLevel.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox_IDLevel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jComboBox_IDLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        jComboBox_IDLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_IDLevelActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_IDLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 206, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU ACCOUNT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 250, -1));
        jPanel2.add(jText_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 398, 29));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("NAMA USER");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 130, 30));

        jText_User.setEnabled(false);
        jText_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_UserActionPerformed(evt);
            }
        });
        jPanel2.add(jText_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 398, 29));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel2.setText("ID USER");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        jButton_menutransaksi.setBackground(new java.awt.Color(204, 51, 255));
        jButton_menutransaksi.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_menutransaksi.setForeground(new java.awt.Color(255, 255, 255));
        jButton_menutransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button transaksi.png"))); // NOI18N
        jButton_menutransaksi.setText(" MENU TRANSAKSI");
        jButton_menutransaksi.setBorder(null);
        jButton_menutransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_menutransaksiActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_menutransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 210, 40));

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
        jPanel2.add(jButton_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jButton_MenuMasakan.setBackground(new java.awt.Color(204, 51, 255));
        jButton_MenuMasakan.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_MenuMasakan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_MenuMasakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button masakan.png"))); // NOI18N
        jButton_MenuMasakan.setText(" MENU MASAKAN");
        jButton_MenuMasakan.setBorder(null);
        jButton_MenuMasakan.setMaximumSize(new java.awt.Dimension(183, 30));
        jButton_MenuMasakan.setPreferredSize(new java.awt.Dimension(183, 28));
        jButton_MenuMasakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenuMasakanActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_MenuMasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 200, 40));

        jButton_Delete.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Delete.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button delete 1.png"))); // NOI18N
        jButton_Delete.setText("  HAPUS");
        jButton_Delete.setBorder(null);
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 130, 40));

        jButton_Update.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Update.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button ubah.png"))); // NOI18N
        jButton_Update.setText("  EDIT");
        jButton_Update.setBorder(null);
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 120, 40));

        jButton_Input.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Input.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Input.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button save.png"))); // NOI18N
        jButton_Input.setText("  SIMPAN");
        jButton_Input.setBorder(null);
        jButton_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InputActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 140, 40));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel9.setText("ID LEVEL");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, 30));

        jTextField_Email.setEditable(false);
        jPanel2.add(jTextField_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 290, 30));

        jButton_Clear.setBackground(new java.awt.Color(0, 255, 0));
        jButton_Clear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button clear.png"))); // NOI18N
        jButton_Clear.setText("  CLEAR");
        jButton_Clear.setBorder(null);
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 140, 40));

        jLabel_Ucapandatang.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel_Ucapandatang.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Ucapandatang.setText("SELAMAT DATANG ADMIN ...!");
        jPanel2.add(jLabel_Ucapandatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_all.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, 0, 1490, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
         try {
        // Koneksi ke database
        k.connect();

        // Query SQL untuk mengupdate data pengguna dengan nilai baru(?)
        String query = "UPDATE user SET nama_user = ?, username = ?, password = ?, id_level = ? WHERE id_user = ?";
        stat = k.getCon().prepareStatement(query); 

        // Isi parameter pada query dengan nilai dari JTextField dan JComboBox
        stat.setString(1, jText_NamaUser.getText()); // Isi parameter 1 dengan nilai dari JTextField jText_NamaUser
        stat.setString(2, jText_Username.getText()); 
        stat.setString(3, jText_Password.getText()); 
        //karena idlevel int akan di konvert menjadi string dan menggunakan getselecteditem karena kombobox 
        stat.setInt(4, Integer.parseInt(jComboBox_IDLevel.getSelectedItem().toString()));
        stat.setString(5, jText_User.getText()); 

        // Eksekusi query update
        int kosongkanbaris = stat.executeUpdate();

        // Jika data berhasil diupdate
        if (kosongkanbaris > 0) {
            JOptionPane.showMessageDialog(this, "Data pengguna berhasil diperbarui.");
            // Kosongkan kembali JTextField dan nonaktifkan kembali JTextField yang sudah diaktifkan sebelumnya
            jText_User.setText(""); 
            jText_NamaUser.setText(""); 
            jText_Username.setText(""); 
            jText_Password.setText(""); 
            jTextField_Email.setText(""); 
            refreshTable(); // Refresh tabel untuk memperbarui tampilan setelah penyuntingan berhasil disimpan
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data pengguna."); // Tampilkan pesan jika update gagal
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); // Tangani error dengan menampilkan pesan kesalahan
    }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        Login log = new Login(); // memanggin menu login kembali ketika logout
        log.setVisible(true);
        this.setVisible(false); // false karena menu masakan hilang pindah ke menu login
    }//GEN-LAST:event_jButton_LogOutActionPerformed

    
    private void jComboBox_IDLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_IDLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_IDLevelActionPerformed

    private void jButton_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InputActionPerformed
        try {
        user u = new user();
        // Validasi apakah ada kolom yang kosong
        if (u.id_user.isEmpty() || u.username.isEmpty() || u.password.isEmpty() || u.nama_user.isEmpty() || u.email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
        } else {//jika kolom sudah terisi semua
            this.stat = k.getCon().prepareStatement("insert into user values(?,?,?,?,?,?)");
            stat.setString(1, u.id_user);// Isi parameter 1 dengan nilai dari JTextField jText_iduser
            stat.setString(2, u.username);
            stat.setString(3, u.password);
            stat.setString(4, u.nama_user);
            stat.setInt(5, u.id_level);
            stat.setString(6, u.email);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        refreshTable();
    }//GEN-LAST:event_jButton_InputActionPerformed
    
    // fungsinya ketika kita klik data isi table, data akan ditampilkan ke textField 
    private void Table_RegistrasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_RegistrasiMouseClicked
        // Mengatur nilai jText_User dengan nilai dari kolom pertama baris yang dipilih di Table_Registrasi
        jText_User.setText(model.getValueAt(Table_Registrasi.getSelectedRow(), 0).toString());
        jText_Username.setText(model.getValueAt(Table_Registrasi.getSelectedRow(), 1).toString());
        jText_Password.setText(model.getValueAt(Table_Registrasi.getSelectedRow(), 2).toString());
        jText_NamaUser.setText(model.getValueAt(Table_Registrasi.getSelectedRow(), 3).toString());
        jComboBox_IDLevel.setSelectedItem(model.getValueAt(Table_Registrasi.getSelectedRow(), 4).toString());
        jTextField_Email.setText(model.getValueAt(Table_Registrasi.getSelectedRow(), 5).toString());
  
    }//GEN-LAST:event_Table_RegistrasiMouseClicked

    private void jText_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_UserActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        try { // unutuk mangambil data dengan menggunkan syntax sql
            user u = new user();
            // konekkan dan tuluskan statmen/syntax sql
            this.stat = k.getCon().prepareStatement("delete from user where id_user=?"); // tuliskan statmen/syntax sql
            stat.setString(1, jText_User.getText()); // isikan tanda tnya ke1 isinya jtexrUser 
            stat.executeUpdate(); // memasukan data dari tabel kedalam sql
            refreshTable(); // kemudian kita refresh
            } catch (Exception e) { // untuk memberi tau  jika ada eroor
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_MenuMasakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MenuMasakanActionPerformed
        Menu_Masakan masak = new Menu_Masakan(); // panggil menu masakan
        masak.setVisible(true); // untuk mengenablekan tombol menu masakan
        this.setVisible(false); // menu registrasi disetvisiblenya false(hilang)
    }//GEN-LAST:event_jButton_MenuMasakanActionPerformed

    private void jButton_menutransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_menutransaksiActionPerformed
        Menu_Transaksi tran = new Menu_Transaksi();
        tran.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_menutransaksiActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        IDotomatis(); // supaya field id direfresh dan masuk ke fromat berikutnya
        jText_Username.setText("");
        jText_Password.setText("");
        jText_NamaUser.setText("");
        jComboBox_IDLevel.setSelectedIndex(0);
        jTextField_Email.setText("");
    }//GEN-LAST:event_jButton_ClearActionPerformed


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
            java.util.logging.Logger.getLogger(Menu_DataAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_DataAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_DataAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_DataAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_DataAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Registrasi;
    private javax.swing.JButton jButton_Clear;
    public javax.swing.JButton jButton_Delete;
    public javax.swing.JButton jButton_Input;
    public javax.swing.JButton jButton_LogOut;
    public javax.swing.JButton jButton_MenuMasakan;
    public javax.swing.JButton jButton_Update;
    private javax.swing.JButton jButton_menutransaksi;
    private javax.swing.JComboBox<String> jComboBox_IDLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Ucapandatang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jText_NamaUser;
    private javax.swing.JTextField jText_Password;
    public javax.swing.JTextField jText_User;
    private javax.swing.JTextField jText_Username;
    // End of variables declaration//GEN-END:variables
}
