/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.sql.*;
/**
 *
 * @author USER
 */

public class koneksi {
    private Connection connect;
    private String jdbcUrl = "jdbc:mysql://localhost:3306/kalkulator_ravina"; // Sesuaikan dengan URL koneksi Anda
    private String username = "root";
    private String password = ""; // Sesuaikan dengan kata sandi Anda jika ada
    
    public Connection getKoneksi() {
        if (connect == null) {
            try {
                // Memuat driver JDBC (Anda dapat melewati langkah ini jika driver sudah dimuat sebelumnya)
                connect = DriverManager.getConnection(jdbcUrl, username, password);
                System.out.println("Koneksi Berhasil");
            } catch ( SQLException ex) {
                System.out.println("Koneksi gagal: " + ex);
            }
        }
        return connect;
    }
}

