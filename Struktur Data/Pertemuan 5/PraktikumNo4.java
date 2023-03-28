import java.util.Scanner;

public class PraktikumNo4 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Banyak Penduduk => ");
        int a = inp.nextInt();
        inp.nextLine();
        Pddk pdd[] = new Pddk[a];
        for (int i = 0; i < pdd.length; i++) {
            System.out.println();
            System.out.println("Penduduk Ke-" + (i + 1));
            System.out.print("Masukkan Nama Penduduk => ");
            String nm = inp.nextLine();
            System.out.print("Masukkan NIK Penduduk => ");
            String nk = inp.nextLine();
            System.out.print("Masukkan Alamat Penduduk => ");
            String lmt = inp.nextLine();
            System.out.print("Masukkan Jenis Kelaamin Penduduk (P/L) => ");
            String jk = inp.nextLine();
            pdd[i] = new Pddk(nk, lmt, nm, jk);
        }
        System.out.println();
        System.out.println();
        tampil(pdd);
        System.out.println();
        System.out.println();
        System.out.print("Masukkan NIK Penduduk yang ingin dicari => ");
        String cari = inp.nextLine();
        boolean ditemukan = false;
        for (int i = 0; i < pdd.length; i++) {
            if (cari.equalsIgnoreCase(pdd[i].nik)) {
                System.out.println("Nama : " + pdd[i].nama);
                System.out.println("NIK : " + pdd[i].nik);
                System.out.println("Alamat : " + pdd[i].alamat);
                System.out.println("Jenis Kelamin : " + pdd[i].jenisKlamin);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data NIK Penduduk tidak ditemukan..");
        }
    }

    public static void tampil(Pddk oi[]){
        System.out.println ("------ Data Penduduk ------");
        System.out.println("No\tNIK\tNama\tAlamat\tJenis Kelamin");
        for (int i = 0; i < oi.length; i++) {
            System.out.printf("%d\t%s\t%s\t%s\t%s\n",i+1,oi[i].nik,oi[i].nama,oi[i].alamat,oi[i].jenisKlamin);
        }
    }
}

class Pddk {
    String nik, nama, alamat, jenisKlamin;

    Pddk(String nk, String lmt, String nm, String jk) {
        nama = nm;
        alamat = lmt;
        nik = nk;
        jenisKlamin = jk;
    }
}
