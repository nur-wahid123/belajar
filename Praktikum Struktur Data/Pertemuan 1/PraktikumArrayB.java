public class PraktikumArrayB {
    public static void main(String[] args) {
        int royal[][] = { { 10, 5, 15, 7 }, { 6, 11, 9, 12 }, { 2, 10, 10, 5 }, { 5, 7, 12, 9 } };
        int jumlah[] = new int[4];
        for (int i = 0; i < jumlah.length; i++) {
            for (int j = 0; j < royal.length; j++) {
                    jumlah[i] += royal[i][j];
            }
        }
        royal[0][0] -= 1;
        royal[0][1] -= 2;
        royal[0][2] -= 0;
        royal[0][3] -= 5;
        String namaBunga[] = { "Aglonema", "Keladi", "Alocasia", "Mawar" };
        int hargaBunga[] = {75000,50000,60000,10000}; 
        int totalHarga = 0;
        for (int i = 0; i < hargaBunga.length; i++) {
            totalHarga += hargaBunga[i]*royal[0][i];
        }
        for (int i = 0; i < hargaBunga.length; i++) {
            System.out.println(namaBunga[i] + " : Rp. "+ hargaBunga[i]*royal[0][i]);
        }
        System.out.println("==========================================");
        System.out.println("Total pendapatan RoyalGarden1 setelah pengurangan stock adalah : Rp. "+totalHarga);
    }
}
