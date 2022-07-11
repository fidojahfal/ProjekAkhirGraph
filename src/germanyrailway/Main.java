/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway;

import java.util.Scanner;
import germanyrailway.Antrian.*;
import PesanTiket.*;

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
        LinkedList t = new LinkedList();
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
                case 1 -> {
                    s.nextLine();
                    System.out.println("\nMenu Tambah Antrian");
                    System.out.print("Masukkan Nama : ");
                    String nama = s.nextLine();
                    q.tambahAntrian(nama);
                    System.out.println("");
                }
                case 2 -> {
                    if (q.first == null) {
                        break;
                    }
                    System.out.println("\nMenu Pembelian Tiket");
                    System.out.println("Nomor Antrian : " + q.first.data.nomor);
                    System.out.println("Nama : " + q.first.data.nama);
                    boolean valid = false;
                    String tambah = "Y";
                    String namaPembeli = q.first.data.nama;
                    String done = "N";
                    String asal;
                    String tujuan;
                    Simpul begin;
                    Simpul end;
                    String rute = "";
                    double harga = 0;
                    while (tambah.equals("Y")) {
                        while (done.equals("N") && valid == false) {
                            while (valid == false) {
                                do {
                                    System.out.print("Kota asal : ");
                                    asal = s.next();
                                } while (!g.cekSimpul(asal));

                                do {
                                    System.out.print("Kota tujuan : ");
                                    tujuan = s.next();
                                } while (!g.cekSimpul(tujuan));
                                begin = g.cariSimpul(asal);
                                end = g.cariSimpul(tujuan);

                                if (g.cekJalur(begin, end)) {
                                    rute += asal + " - " + tujuan + ", ";
                                    harga += g.getNilaiJalur(asal, tujuan);
                                    valid = true;
                                }else{
                                    System.out.println("Jalur tersebut tidak ada!");
                                }
                            }
                            System.out.print("Apakah data anda sudah benar (Y / N)? ");
                            done = s.next();
                        }
                        System.out.println("Harga sementara : " + harga * 500);
                        System.out.print("\nApakah ingin menambah rute (Y / N)? ");
                        tambah = s.next();
                        if(tambah.equals("Y")){
                            done = "N";
                            valid = false;
                        }
                    }
                    double hargaTotal = harga * 500;
                    System.out.println("\nHasil akhir pesanan anda :");
                    System.out.println("Nama : " + namaPembeli);
                    System.out.println("Rute : " + rute);
                    System.out.println("Harga Total : " + hargaTotal);
                    t.tambahTiket(namaPembeli, rute, hargaTotal);
                    q.prosesAntrian();
                    System.out.println("");
                }
                case 3 -> {
                    System.out.println("LIST KOTA");
                    g.cetakSimpul();
                    System.out.println("");
                }
                case 4 -> {
                    System.out.println("LIST RUTE YANG TERSEDIA");
                    g.cetakJalur();
                    System.out.println("");
                }
                case 5 -> {
                    s.nextLine();
                    System.out.println("TAMBAH KOTA");
                    System.out.print("Masukkan nama kota : ");
                    String newKota = s.nextLine();
                    addNode(g, newKota);
                    System.out.println("");
                }
                case 6 -> {
                    s.nextLine();
                    String ori, dest;
                    System.out.println("TAMBAH JALUR");
                    do {
                        System.out.print("Masukkan kota awal : ");
                        ori = s.nextLine();
                        g.cekSimpul(ori);
                    } while (!g.cekSimpul(ori));
                    do {
                        System.out.print("Masukkan kota tujuan : ");
                        dest = s.nextLine();
                        g.cekSimpul(dest);
                    } while (!g.cekSimpul(dest));
                    System.out.print("Jarak : ");
                    int jarak = s.nextInt();
                    System.out.print("Jalur bolak balik? (Y/N): ");
                    String yes = s.next();
                    if (yes.equals("Y") || yes.equals("y")) {
                        addEdgeL(g, ori, dest, jarak);
                    } else {
                        addEdge(g, ori, dest, jarak);
                    }
                    System.out.println("");
                }
                case 7 -> {
                    s.nextLine();
                    System.out.println("CARI KOTA");
                    System.out.print("Masukkan nama kota : ");
                    String cariKota = s.nextLine();
                    System.out.println("Kota " + cariKota + " " + (g.cekSimpul(cariKota) ? "tersedia" : "tidak tersedia"));
                    System.out.println("");
                }
                case 8 -> {
                    s.nextLine();
                    System.out.println("CEK JALUR");
                    String ori;
                    do {
                        System.out.print("Masukkan kota awal : ");
                        ori = s.nextLine();
                        g.cekSimpul(ori);
                    } while (!g.cekSimpul(ori));
                    String dest;
                    do {
                        System.out.print("Masukkan kota tujuan : ");
                        dest = s.nextLine();
                        g.cekSimpul(dest);
                    } while (!g.cekSimpul(dest));
                    System.out.println(g.cekJalur(g.cariSimpul(ori), g.cariSimpul(dest)) ? "Jalur tersedia" : "Jalur tidak ditemukan");
                    System.out.println("");
                }
                case 9 -> {
                    System.out.println("\n---- Daftar Antrian ----");
                    q.tampilAntrian();
                    System.out.println("");
                }
                case 10 -> {
                    System.out.println("\n---- Daftar Penumpang ----");
                    t.lihatData();
                    System.out.println("");
                }
                default -> {
                    throw new AssertionError();
                }
            }
        } while (pilihan != 0);
    }
}
