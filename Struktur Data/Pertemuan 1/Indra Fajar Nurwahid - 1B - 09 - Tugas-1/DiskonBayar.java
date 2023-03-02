import java.util.Scanner;

public class DiskonBayar {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Total Bayar Anda =>");
        double bayar = inp.nextDouble();
        System.out.print("Masukkan Berapa Persen diskon yang diinginkan => ");
        double diskon = inp.nextDouble();
        double total = bayar-(bayar*(diskon/100));
        System.out.println("Total uang yang harus dibayar adalah : Rp. " + total);
        inp.close();

        
    }
}
