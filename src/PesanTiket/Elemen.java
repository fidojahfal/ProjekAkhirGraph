/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PesanTiket;

import germanyrailway.Antrian.*;

/**
 *
 * @author Kargo
 */
public class Elemen {
    Tiket data;
    Elemen next;
    
    Elemen(String nama, String rute, double harga){
        data = new Tiket(nama, rute, harga);
        next = null;
    }
}
