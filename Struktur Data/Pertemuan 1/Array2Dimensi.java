import java.util.Scanner;

public class Array2Dimensi {
    public static void main(String[] args) {
        double a[][] = new double[3][3];
        double total = 0;
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("Masukkan Rating Anda ["+i+"]["+j+"] => ");
                a[i][j] = inp.nextDouble();
                total +=a[i][j];
                // System.out.println();
            }
        }
        double rataRata = total/(a.length*a[0].length);
        // double rataRata = total/(a.length*a[0].length);
        System.out.println("Total Rating yang didapat adalah => " + total);
        System.out.println("Rata - Rata Ratingnya adalah => " + rataRata);
    }
}
