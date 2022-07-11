package germanyrailway.Antrian;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kargo
 */
public class Queue {
    Elemen first;
    Elemen last;
    int nomor;
    
    public Queue(){
        first = null;
        last = null;
        nomor = 1;
    }
    
    public void tambahAntrian(String nama){
        
        Elemen antrianBaru = new Elemen(nomor, nama);
        
        if(first == null){
            first = antrianBaru;
            last = antrianBaru;
        }else{
            Elemen pointer = first;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            
            pointer.next = antrianBaru;
        }
        nomor += 1;
    }
    
    public void prosesAntrian(){
        if(first == null){
            System.out.println("Tidak ada antrian!");
        }else{
            first = first.next;
        }
    }
    
    public void tampilAntrian() {
        Elemen pointer = first;

        if (pointer == null) {
            System.out.println("Linked List Kosong!");
        } else {
            int i = 1;
            while (pointer != null && i <= 99) {
                System.out.println("-------------------------");
                System.out.println("Antrian nomor : " + pointer.data.nomor);
                System.out.println("Nama : " + (pointer.data.nama));
                pointer = pointer.next;
                i++;
            }
        }
    }
}
