import java.util.Scanner;

public class ppmain {
    public static void main(String[] args) {
        PersegiPanjang[] pp = new PersegiPanjang[3];
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < pp.length; i++) {
            System.out.println("\nPersegi Panjang ke - "+ (i+1));
            System.out.print("Masukkan Panjang => ");
            int pjg = inp.nextInt();
            System.out.print("Masukkan Lebar => ");
            int lbr = inp.nextInt();
            pp[i] = new PersegiPanjang(pjg,lbr);
            // pp[i] = new PersegiPanjang(((i+7)+i*5),((i+2)+i*3));
        }
        for (int i = 0; i < pp.length; i++) {
            System.out.println("\nPersegi Panjang ke - "+(i+1));
            pp[i].tampilPP();
        }
    }
}
