public class Buku {
    double tinggi;
    String namaBuku;
    int jumlahHalaman;
    String jeniskertas;

    Buku(String namabuku, String tgg, int hlmnBuku) {
        namaBuku = namabuku;
        jumlahHalaman = hlmnBuku;
        jeniskertas = tgg;
        if (tgg.equalsIgnoreCase("b5")) {
            tinggi = 25;
        } else if (tgg.equalsIgnoreCase("a4")) {
            tinggi = 29.7;
        } else if (tgg.equalsIgnoreCase("b3")) {
            tinggi = 70.7;
        } else if (tgg.equalsIgnoreCase("b2")) {
            tinggi = 50;
        }
    }

    void tampil() {
        System.out.println();
        System.out.println("Nama Buku\t: " + namaBuku);
        System.out.println("Jenis Kertas\t: " + jeniskertas.toUpperCase());
        System.out.println("Tinggi Buku\t: " + tinggi);
        System.out.println("Jumlah Halaman\t: " + jumlahHalaman);
    }
}
