import java.util.Scanner;

public class PraktikumNo2 {
    public static void main(String[] args) {
        String arr[][] = {
                { "Alfi", "Safira", "Tiara", "Arif", "Erdi" },
                { "Yudha", "Nisa", "Yulia", "Fauzan", "Dwi" },
                { "Dewa", "Ana", "Abdul", "Dani", "Ammar" }
        };
        Mhs mhs[] = new Mhs[arr.length * arr[0].length];
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                mhs[b] = new Mhs(i + 1, j + 1, arr[i][j]);
                b++;
            }
        }

        int a = 0;
        for (int i = 0; i < mhs.length; i++) {
            if (mhs[i].kelompok != a) {
                System.out.println();
                System.out.print("Kelompok " + mhs[i].kelompok + ": " + mhs[i].nama);
                a++;
                continue;
            }
            System.out.print(", " + mhs[i].nama);
        }
        System.out.println();
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan nama siswa yang ingin dicari => ");
        String cari = inp.nextLine();
        boolean ditemukan = false;
        for (int i = 0; i < mhs.length; i++) {
            if (cari.equalsIgnoreCase(mhs[i].nama)) {
                System.out.println("Siswa bernama" + mhs[i].nama + " ditemukan pada kelompok-" + mhs[i].kelompok
                        + ", dan pada urutan ke-" + mhs[i].urut);
                ditemukan = true;
            }
        }
        if (ditemukan == false) {
            System.out.println("Siswa bernama " + cari + " tidak ditemukan di kelompok manapun..");
        }

    }
}

class Mhs {
    int kelompok, urut;
    String nama;

    Mhs(int klmpk, int urt, String nm) {
        kelompok = klmpk;
        urut = urt;
        nama = nm;
    }
}