/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package germanyrailway;

/**
 *
 * @author Admin
 */
public class GermanyRailway {

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
        Graph G = new Graph();
        addNode(G, "Berlin");
        addNode(G, "Hamburg");
        addNode(G, "Lubeck");
        addNode(G, "Hannover");
        addNode(G, "Rostock");
        addNode(G, "Kiel");
        addNode(G, "Leipzig");
        addNode(G, "Dresden");
        addNode(G, "Magdeburg");
        addNode(G, "Bremen");
        
        addEdgeL(G, "Berlin", "Dresden", 165);
        addEdgeL(G, "Dresden", "Leipzig", 100);
        addEdgeL(G, "Leipzig", "Magdeburg", 101);
        addEdgeL(G, "Magdeburg", "Hannover", 132);
        addEdgeL(G, "Hannover", "Bremen", 101);
        addEdgeL(G, "Bremen", "Hamburg", 97);
        addEdgeL(G, "Hamburg", "Kiel", 87);
        addEdgeL(G, "Kiel", "Lubeck", 64);
        addEdgeL(G, "Lubeck", "Rostock", 60);
        addEdgeL(G, "Rostock", "Berlin", 196);
        G.cetakGraph();
        
        System.out.println("");
        int option = 0;
        switch (option) {
            case 1:
                break;
        }
    }
}
