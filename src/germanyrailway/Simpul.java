/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package germanyrailway;

/**
 *
 * @author Admin
 */
public class Simpul {
    String infoSimpul;
    Simpul nextSimpul;
    Jalur jalur;

    public Simpul() {
        infoSimpul = null;
        nextSimpul = null;
        jalur = null;
    }

    public Simpul(String info) {
        this.infoSimpul = info;
        nextSimpul = null;
        jalur = null;
    }

    public Simpul(String info, Simpul next) {
        this.infoSimpul = info;
        this.nextSimpul = next;
        jalur = null;
    }

    public Simpul(String info, Simpul next, Jalur jalur) {
        this.infoSimpul = info;
        this.nextSimpul = next;
        this.jalur = jalur;
    }
}
