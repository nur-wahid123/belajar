import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        int arr[] = {13,5,2,9,10,6,14,4,3,12,5};
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Angka yang ingin dicari => ");
        int cari = inp.nextInt();
        boolean ditemukan = false;
        for (int i = 0; i < arr.length; i++) {
            if(cari==arr[i]){
                System.out.println("ADA PADA INDEX KE-"+i);
                ditemukan = true;
                break;
            }
        }
        if (ditemukan == false) {
            System.out.println("TIDAK ADA");
        }
    }
}
