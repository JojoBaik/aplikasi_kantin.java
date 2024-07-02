package modul;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import kantin.dasboard;

public class Kasir {

    public static void main(String[] args) {
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
                jenisPengguna = options[choice];
            } else {
                // Default jika pengguna tidak memilih atau menutup dialog
                jenisPengguna = "Guest";
            }
            
            // Memanggil metode cekPengguna() dengan parameter yang sesuai
            dashboard.cekPengguna(jenisPengguna);
            }
        });
}
}

