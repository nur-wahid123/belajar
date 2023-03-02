import java.util.Scanner;

public class Tugas2 {
    
    public static int masukInt() {
        Scanner inp = new Scanner(System.in);
        int a = 0;
        boolean validInput = false;
        
      while (!validInput) {
         System.out.print("Masukkan Angka: ");
         String input = inp.nextLine();
         
         try {
            a = Integer.parseInt(input);
            validInput = true;
         } catch (NumberFormatException e) {
            System.out.println("Input anda salah, Masukkan angka saja...");
         }
      }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Apa yang ingin anda lakukan?\n1. Menghitung kecepatan\n2. menghitung jarak\n3. menghitung Waktu");
        int a = masukInt();
        while (a>3||a<1) {
            System.out.println("jangan memasukkan angka selain 3 angka diatas");
            a= masukInt();
        }
        switch(a){
            case 1 ->{
                System.out.println("Masukkan Jarak (dalam km)");
                double jarak = masukInt();
                System.out.println("Masukkan waktu (dalam jam)");
                double waktu = masukInt();
                System.out.println("Kecepatan = "+(jarak/waktu)+"km/h");
            }
            case 2 ->{
                System.out.println("Masukkan Kecepatan (dalam km/h)");
                double jarak = masukInt();
                System.out.println("Masukkan waktu (dalam jam)");
                double waktu = masukInt();
                System.out.println("Jarak = "+(jarak*waktu)+"km");
            }
            case 3 ->{
                System.out.println("Masukkan Jarak (dalam km)");
                double jarak = masukInt();
                System.out.println("Masukkan kecepatan (dalam km/h)");
                double waktu = masukInt();
                double aaa = ((jarak/waktu)*60)%60;
                aaa = (((jarak/waktu)*60)-aaa)/60;
                System.out.println("Waktu = "+((jarak/waktu)*60<60?(int)(((jarak/waktu)*60)%60)+" Menit":(int)aaa +" jam "+(int)(((jarak/waktu)*60)%60)+ " menit"));
            }
        }
    }
}
