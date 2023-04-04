public class Sort {
    public int[] data;
    public int jumlData;

    Sort() {

    }

    Sort(int[] a) {
        data = a;
        jumlData = a.length;
    }

    void insertionSort() {
        int j;
        int temp;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            j = i - 1;
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }

    void shellSort() {
        int temp = 0;
        int jarak = data.length;
        boolean sudah;
        while (jarak > 1) {
            jarak = jarak / 2;
            sudah = false;
            while (!sudah) {
                sudah = true;
                for (int j = 0; j < data.length - jarak; j++) {
                    if (data[j] > data[j + jarak]) {
                        temp = data[j];
                        data[j] = data[j + jarak];
                        data[j+jarak]=temp;
                        sudah = false;
                    }
                }
            }
        }
    }

    void tampil() {
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}