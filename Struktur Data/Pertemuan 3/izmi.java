import java.util.Scanner;

class ArrayObjects {
    public static void main(String[] args) {
        PersegiPanjang[] ppArray = new PersegiPanjang[3];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            ppArray[i] = new PersegiPanjang();
            System.out.println("Persegi Panjang ke-" + (i+1));
            System.out.print("Masukkan Panjang : ");
            ppArray[i].panjang = input.nextInt();
            System.out.print("Masukkan Lebar : ");
            ppArray[i].lebar = input.nextInt();
        }
        for (int j = 0; j < ppArray.length; j++) {
            System.out.println("Persegi Panjang ke-" + (j+1));
            System.out.println("Panjang : " + ppArray[j].panjang + ", lebar : " + ppArray[j].lebar);
            System.out.println("====================================");
        }
    }
}