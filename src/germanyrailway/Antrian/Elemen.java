/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway.Antrian;

/**
 *
 * @author Kargo
 */
public class Elemen {
    Antrian data;
    Elemen next;
    
    Elemen(int nomor, String nama){
        data = new Antrian(nomor, nama);
        next = null;
    }
}
