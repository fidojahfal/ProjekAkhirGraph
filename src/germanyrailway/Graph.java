/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway;

/**
 *
 * @author Admin
 */
public class Graph {
    int jumlahSimpul;
    Simpul firstSimpul;
    Jalur firstJalur;

    public Graph() {
        jumlahSimpul = 0;
        firstSimpul = null;
        firstJalur = null;
    }

    public void tambahSimpul(String infoSimpul) {
        Simpul node = new Simpul(infoSimpul, null, null);
        if (firstSimpul == null) {
            firstSimpul = node;
        } else {
            Simpul last = firstSimpul;
            while (last.nextSimpul != null) {
                last = last.nextSimpul;
            }
            last.nextSimpul = node;
        }
    }

    public void tambahJalur(Simpul tujuan, int bebanJalur, Simpul asal) {
        Jalur edge = new Jalur(bebanJalur, null, tujuan);
        if (asal.jalur == null) {
            asal.jalur = edge;
        } else {
            Jalur last = asal.jalur;
            while (last.nextJalur != null) {
                last = last.nextJalur;
            }
            last.nextJalur = edge;
        }
    }

    public void hapusSimpul(String namaSimpul) {
        Simpul node = firstSimpul;
        if (node != null) {
            Simpul temp = null;
            boolean ketemu = false;
            while (node != null && ketemu == false) {
                if (node.infoSimpul.equals(namaSimpul)) {
                    ketemu = true;
                } else {
                    temp = node;
                    node = node.nextSimpul;
                }
            }
            if (ketemu) {
                if (temp == null) {
                    firstSimpul = node.nextSimpul;
                } else {
                    if (node.nextSimpul == null) {
                        temp.nextSimpul = null;
                    } else {
                        temp.nextSimpul = node.nextSimpul;
                        node.nextSimpul = null;
                    }
                }
            } else {
                System.out.println("Kota " + namaSimpul + " tidak itemukan!");
            }
        } else {
            System.out.println("Kota " + namaSimpul + " tidak itemukan!");
        }
    }

    public Simpul cariSimpul (String namaSimpul) {
        Simpul hasil = null;
        Simpul node = firstSimpul;
        boolean ketemu = false;
        
        while (node != null && ketemu == false) {
            if (node.infoSimpul == namaSimpul) {
                hasil = node;
                ketemu = true;
            } else {
                node = node.nextSimpul;
            }
        }
        return hasil;
    }

    public void hapusJalur (String namaJalur) {
        Simpul node = firstSimpul;
        if (node != null) {
            Simpul temp = null;
            boolean ketemu = false;
            while (node != null && ketemu == false) {
                if (node.infoSimpul.equals(namaJalur)) {
                    ketemu = true;
                } else {
                    temp = node;
                    node = node.nextSimpul;
                }
            }
            if (ketemu) {
                if (temp == null) {
                    firstSimpul = node.nextSimpul;
                } else {
                    if (node.nextSimpul == null) {
                        temp.nextSimpul= null;
                    } else {
                        temp.nextSimpul = node.nextSimpul;
                        node.nextSimpul = null;
                    }
                }
            } else {
                System.out.println("Kota " + namaJalur + " tidak itemukan!");
            }
        } else {
            System.out.println("Kota " + namaJalur + " tidak itemukan!");
        }
    }

    public int hitungSimpul () {
        Simpul node = firstSimpul;
        jumlahSimpul = 0;
        if (node != null) {
            while (node != null) {
                jumlahSimpul += 1;
                node = node.nextSimpul;
            }
        }
        return jumlahSimpul;
    }

    public void cetakGraph() {
        Simpul node = firstSimpul;
        if (node != null) {
            while (node != null) {
                jumlahSimpul++;
                System.out.println("\nKota : " + node.infoSimpul);
                Jalur jlr = node.jalur;
                while (jlr != null) {
                    System.out.println("Ada jalur ke kota : " + jlr.simpul.infoSimpul + " dengan jarak : " + jlr.bebanJalur + " km");
                    jlr = jlr.nextJalur;
                }
                node = node.nextSimpul;
            }
        } else {
            System.out.println("Graph Kosong!");
        }
    }

    public boolean cekJalur (Simpul asal, Simpul tujuan) {
        Jalur jlr = asal.jalur;
        boolean ada = false;
        while (jlr != null) {
            if (jlr.simpul.infoSimpul.equals(tujuan.infoSimpul)) {
                ada = true;
            }
            jlr = jlr.nextJalur;
        }
        return ada;
    }

    public int getNilaiJalur(String ori, String dest) {
        int nilai = 0;
        Simpul end = cariSimpul(dest);
        Simpul begin = cariSimpul(ori);
        Jalur jlr = begin.jalur;
        while (jlr != null) {
            if (jlr.simpul.infoSimpul.equals(end.infoSimpul)) {
                nilai = jlr.bebanJalur;
            }
            jlr = jlr.nextJalur;
        }
        return nilai;
    }
}