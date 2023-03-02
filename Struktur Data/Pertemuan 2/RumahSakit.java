public class RumahSakit {
    String namaPasien;
    boolean sembuh = false;
    // levelPelayanan diukur dari 1, 2, 3, 4 dimana 4 adalah vip
    int idPasien, levelPelayanan;

    void gantiNama(String a) {
        namaPasien = a;
    }

    // code by Indra Fajar Nurwahid
    void sembuhKan() {
        sembuh = true;
    }

    void gantiId(int id) {
        idPasien = id;
    }

    void tetapkanPelayanan(int a) {
        if (a < 1 || a > 4) {
            System.out.println("Maaf Pelayanan hanya ada 1 - 4");
            return;
        }
        levelPelayanan = a;
    }
}
