/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import static main.KalkulatorForm.pembagian;
import static main.KalkulatorForm.pengurangan;
import static main.KalkulatorForm.penjumlahan;
import static main.KalkulatorForm.perkalian;

/**
 *
 * @author USER
 */
public class App {
    public static void main(String[] args) {
        KalkulatorForm kf = new KalkulatorForm();
        kf.setLocationRelativeTo(null);
        kf.setVisible(true);
    }
    
    public static Double hitung(Double angka1, Double angka2, String operator){
        Double hasil = null;
        
         if (operator.equals("+")){
           hasil = penjumlahan(angka1, angka2);
        } else if (operator.equals("-")){
            hasil = pengurangan(angka1, angka2);
        } else if (operator.equals(":")){
            hasil = pembagian(angka1, angka2);
        }else if (operator.equals("x")){
            hasil = perkalian(angka1, angka2);
        }
         
         return hasil;
    }
    
    public static Double penjumlahan(double angka1, double angka2){
        Double hasil = angka1 + angka2;
        return hasil;
    }
    
    public static Double pengurangan(double angka1, double angka2){
        Double hasil = angka1 - angka2;
        return hasil;
    }
    
    public static Double pembagian(double angka1, double angka2){
        Double hasil = angka1 / angka2;
        return hasil;
    }
    
    public static Double perkalian(double angka1, double angka2){
        Double hasil = angka1 * angka2;
        return hasil;
    }
    
    public static void kalkulator(Double angka1, Double angka2, String operator, Double hasil){
    Connection connect;
    PreparedStatement pst;
    
    String url = "jdbc:mysql://localhost:3306/kalkulator_ravina";
    String username = "root";
    String password = "";
    String query = "INSERT INTO kalkulator (angka1, angka2, operator, hasil) values (?, ?, ?, ?)";
    
    try{
    connect = DriverManager.getConnection(url, username, password);
    pst = connect.prepareStatement (query);
    pst.setDouble(1, angka1);
    pst.setDouble(2, angka2);
    pst.setString(3, operator);
    pst.setDouble(4, hasil);
    pst.executeUpdate();
    pst.close();
} catch (SQLException ex){
            System.out.println("Insert gagal: " + ex);
}
}
}
