public class Persegi {
    int sisi;

    Persegi() {
        sisi = 0;
    }

    Persegi(int a) {
        sisi = a;
    }

    int luas() {
        return sisi * sisi;
    }

    int Keliling() {
        return 4 * sisi;
    }
    void tampil(){
        System.out.println("Panjang Sisi = "+sisi);
        System.out.println("Keliling = "+Keliling());
        System.out.println("Luas = "+luas());
    }
}
