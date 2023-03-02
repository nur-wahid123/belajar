public class Buku {
    String nama, pengarang, penerbit;
    double hargaSatuan, jumlah;

    Buku() {

    }

    Buku(String nm, String pn, String pb, int hg, int jm) {
        nama = nm;
        penerbit = pb;
        pengarang = pn;
        hargaSatuan = hg;
        jumlah = jm;
    }

    double hitungHargaTotal() {
        return hargaSatuan * jumlah;
    }

    void tampil() {
        System.out.println("Nama Buku : " + nama);
        System.out.println("Pengarang Buku : " + pengarang);
        System.out.println("Penerbit : " + penerbit);
        System.out.println("Harga Satuan : " + hargaSatuan);
        System.out.println("Jumlah : " + jumlah);
    }

    double hitungDiskon() {
        double a = hitungHargaTotal();
        if (a > 100000) {
            return 0.1 * a;
        } else if (a <= 100000 && a >= 50000) {
            return 0.05 * a;
        } else {
            return 0 * a;
        }
    }

    double hitungHargaBayar() {
        double a = hitungHargaTotal();
        double b = hitungDiskon();
        return a - b;
    }
}
