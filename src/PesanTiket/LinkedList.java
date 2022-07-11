package PesanTiket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Kargo
 */
public class LinkedList {

    private Elemen first;
    private Elemen last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void tambahTiket(String nama, String rute, double harga) {
        Elemen tiketBaru = new Elemen(nama, rute, harga);

        if (first == null) {
            first = tiketBaru;
            last = tiketBaru;
        } else {
            Elemen pointer = first;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = tiketBaru;
            last = tiketBaru;
        }
    }

    public void lihatData() {
        Elemen pointer = first;

        if (pointer == null) {
            System.out.println("Linked List Kosong!");
        } else {
            int i = 1;
            while (pointer != null && i <= 99) {
                System.out.println("-------------" + i + "------------");
                System.out.println("Nama : " + pointer.data.nama);
                System.out.println("Rute : " + (pointer.data.rute));
                System.out.println("Harga Total : " + (pointer.data.harga));
                pointer = pointer.next;
                i++;
            }
        }
    }
}
