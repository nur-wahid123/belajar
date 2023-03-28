import java.util.Scanner;

public class MainPaskib {
    public static void main(String[] args) {
        DaftarAnggotaPaskibraka data = new DaftarAnggotaPaskibraka(10);
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < data.listPkb.length; i++) {
            System.out.println("Masukkan Data Anggota Paskibraka ke-" + (1 + i));
            System.out.print("Masukkan Nama : ");
            String nm = inp.nextLine();
            System.out.print("Masukkan Kelas : ");
            String kls = inp.nextLine();
            System.out.print("Masukkan Tinggi : ");
            int tg = inp.nextInt();
            inp.nextLine();
            Paskibraka b = new Paskibraka(nm, kls, tg);
            data.tambah(b);
        }
        data.tampil();
        System.out.println();
        System.out.println("Data Siswa Terurut");
        System.out.println();
        data.selectionSort();
        data.tampil();
        System.out.println();
        System.out.println("Data Siswa Diterima");
        System.out.println();
        data.tampilDiterima();
    }

}
