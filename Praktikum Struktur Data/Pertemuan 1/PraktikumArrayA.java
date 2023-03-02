public class PraktikumArrayA {
    public static void main(String[] args) {
        int royal[][] = { { 10, 5, 15, 7 }, { 6, 11, 9, 12 }, { 2, 10, 10, 5 }, { 5, 7, 12, 9 } };
        int jumlah[] = new int[4];
        for (int i = 0; i < jumlah.length; i++) {
            for (int j = 0; j < royal.length; j++) {
                    jumlah[i] += royal[i][j];
            }
        }
        String namaBunga[] = { "Aglonema", "Keladi", "Alocasia", "Mawar" };
        for (int i = 0; i < namaBunga.length; i++) {
            System.out.println("Jumlah " + namaBunga[i] + " = " + jumlah[i]);
        }
    }
}
