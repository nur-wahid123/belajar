import java.util.Scanner;

public class MainBuku {
    public static void main(String[] args) {
        PengurutanBuku data = new PengurutanBuku(4);
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < data.lisBuku.length; i++) {
            System.out.println("Masukkan Data Buku ke-" + (1 + i));
            System.out.print("Masukkan Nama Buku : ");
            String nm = inp.nextLine();
            System.out.print("Masukkan Jenis Kertas (B5, B3, B2, A4) : ");
            String kls = inp.nextLine();
            System.out.print("Masukkan jumlah halaman : ");
            int tg = inp.nextInt();
            inp.nextLine();
            Buku oi = new Buku(nm, kls, tg);
            data.tambah(oi);
        }
        System.out.println("Data sebelum Diurutkan");
        data.tampil();
        System.out.println();
        System.out.println("Data setelah Diurutkan menurut Ukuran Buku");
        data.ukBuku();
        data.tampil();
        System.out.println();
        System.out.println("Data setelah Diurutkan menurut jumlah Halaman Buku");
        data.halBuku();
        data.tampil();
    }
}
