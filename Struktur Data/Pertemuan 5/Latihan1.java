import java.util.Arrays;

public class Latihan1 {
    public static void main(String[] args) {
        int[] arr = { 46, 7, 3, 17, 30, 25, 20 };
        Arrays.sort(arr);
        int cari = 21;
        boolean ditemukan = false;
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > cari) {
                a++;
                System.out.println(a);
                System.out.println("Data Tidak ditemukan1");
                break;
            } else if (cari == arr[i]) {
                System.out.println("Data " + cari + " ditemukan pada index ke-" + i);
                ditemukan = true;
            }
            a += 2;
        }
    }
}