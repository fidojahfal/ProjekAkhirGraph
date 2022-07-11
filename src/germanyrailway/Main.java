/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway;

import java.util.Scanner;

/**
 *
 * @author Kargo
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();

        Scanner s = new Scanner(System.in);

        int pilihan;
        //AAAAA
        do {
            System.out.println("PEMESANAN TIKET KERETA BAWAH LAUT");
            System.out.println("Pilih Menu :");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Pembelian Tiket");
            System.out.println("3. Lihat Daftar Kota");
            System.out.println("4. Lihat Rute Perjalanan");
            System.out.println("5. Tambah Kota");
            System.out.println("6. Tambah Jalur");
            System.out.println("7. Cari Kota");
            System.out.println("8. Cari Jalur");
            System.out.println("9. Lihat Antrian");
            System.out.println("10. Lihat Data Penumpang");
            System.out.print("Silahkan Pilih Menu Di atas : ");
            pilihan = s.nextInt();
            
            switch (pilihan) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } while (pilihan != 0);
    }
}
