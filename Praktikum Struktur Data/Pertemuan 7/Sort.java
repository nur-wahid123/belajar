import java.util.Scanner;

public class Sort {
    int[] a;

    Sort() {
        Scanner inp = new Scanner(System.in);
        a = new int[10];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Masukkan Angka => ");
            a[i] = inp.nextInt();
        }
    }

    Sort(int an[]) {
        a = an;
    }

    void tampil() {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void insertionSort() {
        for (int i = 1; i <= a.length - 1; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    void shellSort() {
        int interval;
        for (interval = a.length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < a.length; i++) {
                int temp = a[i];
                int j;
                for (j = i; j >= interval && a[j - interval] > temp; j -= interval) {
                    a[j] = a[j - interval];
                }
                a[j] = temp;
            }
        }
    }
}