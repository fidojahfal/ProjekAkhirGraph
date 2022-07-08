/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway;

/**
 *
 * @author Admin
 */
public class Jalur {
    int bebanJalur;
    Jalur nextJalur;
    Simpul simpul;

    public Jalur() {
        bebanJalur = 0;
        nextJalur = null;
        simpul = null;
    }

    public Jalur(int beban) {
        this.bebanJalur = beban;
        nextJalur = null;
        simpul = null;
    }

    public Jalur(int beban, Jalur next) {
        this.bebanJalur = beban;
        this.nextJalur = next;
        simpul = null;
    }

    public Jalur(int beban, Jalur next, Simpul simpul) {
        this.bebanJalur = beban;
        this.nextJalur = next;
        this.simpul = simpul;
    }
}

