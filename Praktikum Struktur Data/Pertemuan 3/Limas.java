import java.util.Scanner;

public class Limas {
    double tinggi, panjangAlas;

    Limas() {
        tinggi = 0;
        panjangAlas = 0;
    }

    Limas(double tinggiLimas, double panjangSisiAlas) {
        tinggi = tinggiLimas;
        panjangAlas = panjangSisiAlas;
    }

    private double volume() {
        return (tinggi * (luasAlas())) / 3;
    }

    //by Indra Fajar Nurwahid Bro
    private double phytagoras(double a, double b) {
        return Math.sqrt((a * a) + (b * b));
    }

    private double luasAlas() {
        return panjangAlas * panjangAlas;
    }

    private double luasSegitigaTegakLurus() {
        double tinggiSegitiga = phytagoras(tinggi, panjangAlas / 2);
        double alasSegitiga = panjangAlas;
        return (tinggiSegitiga * alasSegitiga) / 2;
    }

    private double luasPermukaan() {
        return luasAlas() + (4 * luasSegitigaTegakLurus());
    }

    void tampil() {
        System.out.println("Tinggi = " + tinggi);
        System.out.println("Panjang Sisi Alas Limas = " + panjangAlas);
        System.out.println("Volume = " + volume());
        System.out.println("Luas Alas = " + luasAlas());
        System.out.println("Luas Segitiga Berdiri = " + luasSegitigaTegakLurus());
        System.out.println("Luas Selimut = " + luasSegitigaTegakLurus() * 4);
        System.out.println("Luas Permukaan = " + luasPermukaan());
    }
}
