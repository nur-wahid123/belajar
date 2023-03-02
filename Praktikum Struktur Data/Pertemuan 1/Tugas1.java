public class Tugas1 {
    public static void main(String[] args) {
        double harga = 4500;
        String nama[] ={"Ani","Budi","Bina","Cita"}; 
        double barang[]={4,15,6,11};
        double total = 0;
        double totala[] = new double[barang.length];
        for (int i = 0; i < barang.length; i++) {
            totala[i] = barang[i]>10?(barang[i]*harga-(0.05*barang[i]*harga)):(barang[i]*harga);
            total += barang[i]>10?(barang[i]*harga-(0.05*barang[i]*harga)):(barang[i]*harga);
        }
        for (int i = 0; i < nama.length; i++) {
            System.out.println(nama[i]+" : Rp. "+totala[i]);
        }
        System.out.println("============================================");
        System.out.println("Total Uang yang didapat : Rp. "+total);
    }
}
