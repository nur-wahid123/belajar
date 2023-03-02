
import java.util.Scanner;

public class PersegiMain {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Berapa banyak array of object dari persegi yang ingin dibuat \nMasukkan Jawaban=> ");
        Persegi p [] = new Persegi[inp.nextInt()];
        for (int i = 0; i < p.length; i++) {
            System.out.println("Masukkan sisi Persegi ke - "+(i+1));
            p[i] = new Persegi(inp.nextInt());
        }
        for (int i = 0; i < p.length; i++) {
            System.out.println("Persegi ke - "+(i+1));
            p[i].tampil();
        }

    }
}
