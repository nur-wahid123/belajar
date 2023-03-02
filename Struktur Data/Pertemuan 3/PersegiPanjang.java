public class PersegiPanjang {
    // String aku;
    int panjang;
    int lebar;

    PersegiPanjang() {

    }

    PersegiPanjang(int p, int l) {
        panjang = p;
        lebar = l;

    }

    // PersegiPanjang(String a) {
    //     aku = Integer.toString(panjang);
    // }

    void tambahLebar(int ak) {
        lebar += ak;
    }

    void kurangiLebar(int ak) {
        lebar -= ak;
    }

    void kurangiPanjang(int ak) {
        panjang -= ak;
    }

    void tambahPanjang(int ak) {
        panjang += ak;
    }

    void setPanjang(int a) {
        panjang = a;
    }

    void setLebar(int a) {
        lebar = a;
    }

    int hitungLuas() {
        return panjang * lebar;
    }

    int hitungKeliling() {
        return 2 * (panjang + lebar);
    }

    void tampilPP() {
        System.out.println("Panjang = " + panjang);
        System.out.println("Lebar = " + lebar);
        System.out.println("Keliling = " + hitungKeliling());
        System.out.println("Luas = " + hitungLuas());
    }
}