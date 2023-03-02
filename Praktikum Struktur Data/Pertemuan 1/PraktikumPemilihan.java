import java.util.Scanner;
public class PraktikumPemilihan{
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double tugas,UTS,UAS;
        System.out.println("Program Menghitung nilai akhir");
        System.out.println("=============================");
        System.out.print("Masukkan Nilai Tugas => ");
        tugas = inp.nextDouble();
        System.out.print("Masukkan Nilai UTS => ");
        UTS = inp.nextDouble();
        System.out.print("Masukkan Nilai UAS => ");
        UAS=inp.nextDouble();
        System.out.println("=============================");
        double total = (0.2*tugas)+(0.35*UTS)+(0.45*UAS);
        String hasil ;
        boolean lulus;
        if (total>80) {
            hasil = "A";
            lulus = true;
        }
        else if(total>73){
            hasil = "B+";
            lulus = true;
        }
        else if(total>65){
            hasil = "B";
            lulus = true;
        }
        else if(total>60){
            hasil = "C+";
            lulus = true;
        }
        else if(total>50){
            hasil = "C";
            lulus = true;
        }
        else if(total>39){
            hasil = "D";
            lulus = false;
        }
        else{
            hasil = "E";
            lulus = false;
        }
        System.out.println("Nilai Akhir : " +total);
        System.out.println("Nilai Huruf : " +hasil);
        System.out.println("=============================");
        System.out.println((lulus ? "Selamat Anda dinyatakan Lulus" : "Maaf anda Belum Lulus"));
        inp.close();
    }
}