import java.util.Scanner;
public class MainSort {
    public static void main(String[] args) {
        // int ad[] = new int[10];
        // Scanner inp = new Scanner(System.in);
        // for (int i = 0; i < ad.length; i++) {
        //     System.out.print("Masukkan Angka => ");
        //     ad[i]= inp.nextInt();
        // }
        Sort aadd = new Sort();
        // Sort aadd = new Sort(ad);
        System.out.println("Sebelum");
        aadd.tampil();
        System.out.println("Sesudah");
        aadd.insertionSort();
        aadd.tampil();
    }
}
