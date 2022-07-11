/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway;

import java.util.Scanner;
import germanyrailway.Antrian.*;

/**
 *
 * @author Kargo
 */
public class Main {
    public static void addNode(Graph G, String name) {
        Simpul node = G.cariSimpul(name);
        if (node == null) {
            G.tambahSimpul(name);
            System.out.println("Tambah kota " + name + " pada graph");
        } else {
            System.out.println("Kota " + name + " sudah ada");
        }
    }

    public static void addEdge(Graph G, String ori, String dest, int weight) {
        Simpul end = G.cariSimpul(dest);
        Simpul begin = G.cariSimpul(ori);
        if (begin != null && end != null) {
            if (!G.cekJalur(begin, end)) {
                G.tambahJalur(end, weight, begin);
                System.out.println("Tambah jalur dari " + begin.infoSimpul + " ke " + end.infoSimpul + " dengan bobot " + weight);
            } else {
                System.out.println("Sudah ada jalur dari " + begin.infoSimpul + " ke " + end.infoSimpul);
            }
        }
    }
    
    public static void addEdgeL(Graph G, String ori, String dest, int weight) {
        Simpul end = G.cariSimpul(dest);
        Simpul begin = G.cariSimpul(ori);
        if (begin != null && end != null) {
            if (!G.cekJalur(begin, end)) {
                G.tambahJalur(end, weight, begin);
                G.tambahJalur(begin, weight, end);
                System.out.println("Tambah jalur dari " + begin.infoSimpul + " ke " + end.infoSimpul + " dengan bobot " + weight);
            } else {
                System.out.println("Sudah ada jalur dari " + begin.infoSimpul + " ke " + end.infoSimpul);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Graph g = new Graph();
        Queue q = new Queue();
        Scanner s = new Scanner(System.in);
        
        addNode(g, "Berlin");
        addNode(g, "Hamburg");
        addNode(g, "Lubeck");
        addNode(g, "Hannover");
        addNode(g, "Rostock");
        addNode(g, "Kiel");
        addNode(g, "Leipzig");
        addNode(g, "Dresden");
        addNode(g, "Magdeburg");
        addNode(g, "Bremen");
        
        addEdgeL(g, "Berlin", "Dresden", 165);
        addEdgeL(g, "Dresden", "Leipzig", 100);
        addEdgeL(g, "Leipzig", "Magdeburg", 101);
        addEdgeL(g, "Magdeburg", "Hannover", 132);
        addEdgeL(g, "Hannover", "Bremen", 101);
        addEdgeL(g, "Bremen", "Hamburg", 97);
        addEdgeL(g, "Hamburg", "Kiel", 87);
        addEdgeL(g, "Kiel", "Lubeck", 64);
        addEdgeL(g, "Lubeck", "Rostock", 60);
        addEdgeL(g, "Rostock", "Berlin", 196);
        g.cetakGraph();
        
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
                    s.nextLine();
                    System.out.println("\nMenu Tambah Antrian");
                    System.out.print("Masukkan Nama : ");
                    String nama = s.nextLine();
                    q.tambahAntrian(nama);
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("LIST KOTA");
                    g.cetakSimpul();
                    break;
                case 4:
                    
                    break;
                case 5:
                    Scanner input = new Scanner(System.in);
                    System.out.println("TAMBAH KOTA");
                    System.out.print("Masukkan nama kota : ");
                    String newKota = input.nextLine();
                    addNode(g, newKota);
                    break;
                case 6:
                    
                    break;
                case 7:
                    Scanner Input = new Scanner(System.in);
                    System.out.println("CARI KOTA");
                    System.out.print("Masukkan nama kota : ");
                    String cariKota = Input.nextLine();
                    System.out.println("Kota " + cariKota + " " + (g.cekSimpul(cariKota) ? "tersedia" : "tidak tersedia"));
                    break;
                case 8:
                    
                    break;
                case 9:
                    System.out.println("\n---- Daftar Antrian ----");
                    q.tampilAntrian();
                    break;
                case 10:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } while (pilihan != 0);
    }
}
