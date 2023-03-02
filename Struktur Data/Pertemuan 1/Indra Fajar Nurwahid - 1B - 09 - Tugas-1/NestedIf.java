import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {
        int semester = 3;
        Scanner inp = new Scanner(System.in);
        double ipk = 3.5;
        System.out.print("Masukkan Semester Berapa anda saat ini => ");
        semester = inp.nextInt();
        if (semester>=3) {
            System.out.print("Masukkan Berapa IPK Terakhir anda => ");
            ipk = inp.nextDouble();
            if (ipk>3.2) {
                System.out.println("Selamat anda lolos");
            }else{
                System.out.println("Maaf IPK anda kurang");
            }
        }else{
            System.out.println("maaf yang diperbolehkan hanya semester 3 atau lebih");
        }
        inp.close();
    }
}
