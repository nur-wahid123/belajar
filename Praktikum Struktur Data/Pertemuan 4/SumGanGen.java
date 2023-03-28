import java.util.Scanner;

public class SumGanGen {
    public static void main(String[] args) {
        int a = 100;
        int gen = 0;
        int gan = 0;
        while (a != 0) {
            a = getIntInput();
            if (a!=0) {
                if(a%2==0){
                    gen++;
                }else{
                    gan++;
                }
            }
        }
        System.out.println("Jumlah Bilangan Ganjil : "+gan);
        System.out.println("Jumlah Bilangan Genap : "+gen);
    }
    public static int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Suatu Bilangan => ");
                input = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Tolong jangan masukkan selain angka bro");
                scanner.nextLine();
            }
        } while (!validInput);
        return input;
    }
}
