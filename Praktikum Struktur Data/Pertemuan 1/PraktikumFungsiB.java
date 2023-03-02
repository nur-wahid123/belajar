import java.util.Scanner;

public class PraktikumFungsiB {
    static int royal[][] = { { 10, 5, 15, 7 }, { 6, 11, 9, 12 }, { 2, 10, 10, 5 }, { 5, 7, 12, 9 } };
    static String namaBunga[] = { "Aglonema", "Keladi", "Alocasia", "Mawar" };
    static int hargaBunga[] = { 75000, 50000, 60000, 10000 };
    public static void _jumlahBunga(String _namaBunga) {
        int jumlahbga[] = new int[namaBunga.length];
        for (int i = 0; i < hargaBunga.length; i++) {
            for (int j = 0; j < hargaBunga.length; j++) {
                jumlahbga[i] += royal[i][j];
            }
        }
        for (int i = 0; i < namaBunga.length; i++) {
            if (namaBunga[i].equalsIgnoreCase(_namaBunga)) {
                System.out.println("Jumlah bunga " + namaBunga[i] + " = "+jumlahbga[i]);
                return;
            }
        }
        System.out.println("Bunga "+_namaBunga+" tidak tersedia");
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Nama Bunga : ");
        String nama = inp.next();
        _jumlahBunga(nama);
        inp.close();
    }
}
