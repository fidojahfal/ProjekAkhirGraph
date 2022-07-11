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
    
    Queue(){
        first = null;
        last = null;
    }
    
    void tambahAntrian(String nama){
        int nomor = 1;
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
    }
    
    void prosesAntrian(){
        if(first == null){
            System.out.println("Tidak ada antrian!");
        }else{
            first = first.next;
        }
    }
    
    
}
