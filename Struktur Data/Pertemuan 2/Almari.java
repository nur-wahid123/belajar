public class Almari {
    String warna;
    int harga;
    boolean statusPintu;
    //by Indra Fajar Nurwahid Bro

    void gantiWarna(String w) {
        warna = w;
    }

    void kurangiHarga(int ar) {
        harga -= ar;
    }

    void tambahHarga(int ar) {
        harga += ar;
    }

    void bukaPintu() {
        statusPintu = true;
    }

    void tutupPintu() {
        statusPintu = false;
    }
}
