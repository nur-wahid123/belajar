import java.util.Scanner;

public class MainMhs {
    public static void main(String[] args) {
        DaftarMahasiswaTerbaik data = new DaftarMahasiswaTerbaik();
        Scanner inp = new Scanner(System.in); 
        for (int i = 0; i < data.listMhs.length; i++) {
            System.out.println();
            System.out.println("Masukkan Nama Mahasiswa Ke-"+(i+1));
            System.out.print("Masukkan Nama Mahasiswa : ");
            String nama = inp.nextLine();
            // inp.nextLine();
            System.out.print("Masukkan Tahun Masuk Mahasiswa : ");
            int thnMasuk = inp.nextInt();
            System.out.print("Masukkan Umur Mahasiswa : ");
            int umur = inp.nextInt();
            System.out.print("Masukkan IPK Mahasiswa : ");
            double ipk = inp.nextDouble();
            inp.nextLine();
            Mhs m =new Mhs(umur, thnMasuk, nama, ipk);
            data.tambah(m);
        }
        System.out.println("Data Sebelum Diurutkan");
        data.tampil();
        data.bubbleSort();
        System.out.println("Data Setelah Diurutkan bubble sort");
        data.tampil();
        System.out.println();
        System.out.println("Data Setelah Diurutkan Selection sort");
        data.selectionSort();
        data.tampil();
        
    }
}
