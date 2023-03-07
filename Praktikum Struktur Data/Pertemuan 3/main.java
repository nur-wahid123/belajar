import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Jari Jari Bola => ");
        double jrjr = inp.nextDouble();
        Bola bl = new Bola(jrjr*2);
        bl.tampil();
        System.out.println();
        System.out.print("Masukkan Jari Jari Kerucut => ");
        jrjr = inp.nextDouble();
        System.out.print("Masukkan Sisi Miring Kerucut => ");
        double tg = inp.nextDouble();
        Kerucut kr = new Kerucut(jrjr*2,tg);
        kr.tampil();
        System.out.println();
        System.out.print("Masukkan Panjang Sisi Alas Limas => ");
        jrjr = inp.nextDouble();
        System.out.print("Masukkan Tinggi Limas => ");
        tg = inp.nextDouble();
        Limas lm = new Limas(tg,jrjr);
        lm.tampil();
    }
}
