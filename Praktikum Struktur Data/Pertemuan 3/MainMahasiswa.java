import java.util.Scanner;

public class MainMahasiswa {
    public static void main(String[] args) {
        Mahasiswa[] mhs = new Mahasiswa[3];
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < mhs.length; i++) {
            System.out.println("Masukkan Data mahasiswa ke - "+(i+1));
            System.out.print("Nama => ");
            String nama = inp.nextLine();
            System.out.print("NIM => ");
            String nim = inp.nextLine();
            System.out.print("Jenis Kelamin => ");
            String jk = inp.nextLine();
            System.out.print("IPK => ");
            String ipk = inp.nextLine();
            mhs[i] = new Mahasiswa(nama,nim,jk,ipk);
        }
        for (int j = 0; j < mhs.length; j++) {
            System.out.print("\nData Mahasiswa ke - "+(1+j)+"\n");
            mhs[j].tampil();
        }

    }
}
