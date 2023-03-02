import java.util.Scanner;

public class FungsiRekursif {
    public static void main(String[] args) {
        int a;
        Scanner inp = new Scanner(System.in);
        System.out.println("Masukkan Angka yang ingin di faktorial => ");
        a = inp.nextInt();
        int hasilFaktorial = fungsiRekursif(a);
        System.out.print("Hasil Faktorial dari " + a +"! adalah : "+hasilFaktorial);
        inp.close();
    }

    public static int fungsiRekursif(int a){
        if (a==0) {
            return 1;
        } else {
            return a*fungsiRekursif(a-1);
        }
    }
}
