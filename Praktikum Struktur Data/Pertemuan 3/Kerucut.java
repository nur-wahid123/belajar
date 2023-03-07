public class Kerucut {
    double diameter,sisiMiring, tinggi;

    Kerucut() {
        sisiMiring = 0;
        diameter = 0;
        tinggi = 0;
    }

    Kerucut(double Diameter, double SisiMiring) {
        diameter = Diameter;
        sisiMiring = SisiMiring;
        tinggi = phytagorasC(SisiMiring, diameter/2);
    }

    private double phi() {
        return 3.14;
    }

    private double luasPermukaan() {
        return (phi()) * (diameter / 2) * (S() + (diameter / 2));
    }

    private double luasAlas() {
        return (phi()) * (diameter / 2) * (diameter / 2);
    }

    // by Indra Fajar Nurwahid Bro

    private double phytagorasC(double a, double b) {
        return Math.sqrt((a * a) - (b * b));
    }

    private double S() {
        return Math.sqrt(Math.pow(diameter / 2, 2) + Math.pow(tinggi, 2));
    }

    private double luasSelimut() {
        return (phi()) * (diameter / 2) * S();
    }

    private double volume() {
        return (luasAlas() * tinggi) / 3;
    }

    void tampil() {
        System.out.println("Diameter Kerucut = " + diameter);
        System.out.println("Jari - jari Kerucut = " + diameter / 2);
        System.out.println("Tinggi Kerucut = " + tinggi);
        System.out.println("Garis Pelukis = " + S());
        System.out.println("Luas Alas Kerucut = " + luasAlas());
        System.out.println("Luas Selimut Kerucut = " + luasSelimut());
        System.out.println("Luas Permukaan Kerucut = " + luasPermukaan());
        System.out.println("Volume Kerucut = " + volume());
    }
}