public class PraktikumFungsiA {
    static int royal[][] = { { 10, 5, 15, 7 }, { 6, 11, 9, 12 }, { 2, 10, 10, 5 }, { 5, 7, 12, 9 } };
    static String namaBunga[] = { "Aglonema", "Keladi", "Alocasia", "Mawar" };
    static int hargaBunga[] = { 75000, 50000, 60000, 10000 };

    public static void tampilTabel() {
        System.out.println("Tabel Barang Royal Garden");
        System.out.print("\t\t");
        for (int i = 0; i < namaBunga.length; i++) {
            System.out.print(namaBunga[i] + (namaBunga[i].length() < 7 ? "\t" : "") + "\t");
        }
        System.out.println();
        for (int i = 0; i < hargaBunga.length; i++) {
            System.out.print("RoyalGarden" + (i + 1) + "\t");
            for (int j = 0; j < hargaBunga.length; j++) {
                System.out.print(royal[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        tampilTabel();
    }
}
