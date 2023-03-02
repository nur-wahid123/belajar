public class SepedaMain {
    public static void main(String[] args) {
        Sepeda spd1 = new Sepeda();
        Sepeda spd2 = new Sepeda(21);
        spd1.kecepatan = 10;
        spd1.tambahKecepatan(3);
        spd1.tampil();
        spd1.kurangiKecepatan(7);
        spd1.tampil();
        System.out.println("================");
        spd2.tambahKecepatan(3);
        spd2.tampil();
        spd2.kurangiKecepatan(7);
        spd2.tampil();

    }
}
