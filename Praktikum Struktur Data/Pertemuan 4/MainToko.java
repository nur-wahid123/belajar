import java.util.Scanner;

public class MainToko {
    public static void main(String[] args) {
        Keranjang krj = new Keranjang();
        Stok stok = new Stok();
        Scanner inp = new Scanner(System.in);
        // stok.tampil();
        boolean f = true;
        while (f) {
            awal();
            int a = getIntInput();
            switch (a) {
                case 1 -> {
                    stok.tampil();
                }
                case 2 -> {
                    boolean c = true;
                    while (c) {
                        System.out.print("Masukkan Kode Barang => ");
                        String b = inp.next();
                        krj.tambahBarang(b);
                        boolean e = true;
                        while (e) {
                            System.out.print("Apakah Akan Belanja Lagi?(Y/N) =>");
                            String d = inp.next();
                            if (d.equalsIgnoreCase("y") || d.equalsIgnoreCase("n")) {
                                if (d.equalsIgnoreCase("y")) {
                                    // c = false;
                                    e = false;
                                } else {
                                    c = false;
                                    e = false;
                                }
                            } else {
                                System.out.println("Maaf silahkan ulangi lagi");
                            }
                        }
                    }
                }
                case 3 -> {
                    krj.tampil();
                }
                case 4 -> {
                    f = false;
                }
                default -> {
                    System.out.println("Maaf pilihan tidak tersedia");
                }
            }
            // System.out.println(a);
        }
    }

    static void awal() {
        System.out.println("\n===============================");
        System.out.println("\tToko Indra Jaya");
        System.out.println("===============================");
        System.out.println("1. Tampilkan Barang");
        System.out.println("2. Beli");
        System.out.println("3. Tampilkan Keranjang");
        System.out.println("4. Keluar");
        System.out.print("Pilih 1 - 4 => ");

    }

    public static int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        do {
            try {
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
