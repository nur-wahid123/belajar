public class Mhs {
    String nama = "";
    int umur = 0;
    int tahunMasuk = 0;
    double ipk = 0;

    Mhs() {

    }

    Mhs(int umr, int msk, String nams, double gpa) {
        nama = nams;
        umur = umr;
        ipk = gpa;
        tahunMasuk = msk;
    }

    void tampil() {
        System.out.println("Nama :\t\t" + nama);
        System.out.println("Tahun Masuk :\t" + tahunMasuk);
        System.out.println("Umur :\t\t" + umur);
        System.out.println("IPK :\t\t" + ipk);
    }

}