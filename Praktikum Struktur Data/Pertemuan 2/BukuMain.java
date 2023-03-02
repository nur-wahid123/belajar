public class BukuMain {
    public static void main(String[] args) {
        Buku buk = new Buku();
        Buku buk2 = new Buku("Indra & Juli","Fajar","Erlangga",7000,100);
        buk.nama = "Indra In Heart";
        buk.penerbit = "Intan Mulia";
        buk.pengarang = "Fajar";
        buk.hargaSatuan = 6000;
        buk.jumlah = 10;
        buk.tampil();
        buk.hitungHargaTotal();
        buk.hitungDiskon();
        double a = buk.hitungHargaBayar();
        System.out.println("Jumlah Bayar = Rp." + a);
        System.out.println("======================");
        buk2.tampil();
        a = buk2.hitungHargaBayar();
        System.out.println("Jumlah Bayar = Rp." + a);
    }
}
