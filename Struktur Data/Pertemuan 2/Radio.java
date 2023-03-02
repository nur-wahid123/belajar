public class Radio {
    double frekuensi, volume;
    String warna;

    void gantiWarna(String a) {
        warna = a;
    }

    void gantiFrekuensi(double frek) {
        frekuensi = frek;
    }

    void tambahVolume() {
        volume++;
        // by Indra Fajar Nurwahid Bro
        if (volume > 14) {
            volume = 14;
            System.out.println("Maaf suara sudah paling besar");
        }
    }

    void kurangiVolume() {
        volume--;
        if (volume < 0) {
            volume = 0;
            System.out.println("Maaf suara sudah paling kecil");
        }
    }
}
