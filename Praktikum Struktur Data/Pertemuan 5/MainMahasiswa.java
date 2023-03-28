import java.util.Scanner;

public class MainMahasiswa {
    public static void main(String[] args) {
        Mahasiswa mhs[] = new Mahasiswa[7];
        mhs[0] = new Mahasiswa("2238748846", "indra", 2.3);
        mhs[1] = new Mahasiswa("0989244846", "fajar", 2.9);
        mhs[2] = new Mahasiswa("8748373746", "nurwaid", 3.7);
        mhs[3] = new Mahasiswa("0356948457", "sapto", 3.9);
        mhs[4] = new Mahasiswa("9289983493", "mukti", 2.6);
        mhs[5] = new Mahasiswa("1993828349", "yoki", 10.9);
        mhs[6] = new Mahasiswa("0234927393", "oke", 1.8);
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Nama yang ingin Dicari => ");
        String cari = inp.nextLine();
        for (int i = 0; i < mhs.length; i++) {
            if (cari.equalsIgnoreCase(mhs[i].Nama)) {
                System.out.println("Nama : "+mhs[i].Nama);
                System.out.println("NIM : "+mhs[i].nim);
                System.out.println("IPK : "+mhs[i].ipk);
            }
        }
    }
}
