public class tokoAtk {
    Atk a[] = new Atk[4];

    tokoAtk() {
        a[0] = new Atk("Pensil", 1000, 35);
        a[1] = new Atk("Pensil", 1000, 20);
        a[2] = new Atk("Pensil", 1000, 50);
        a[3] = new Atk("Pensil", 1000, 25);
    }

    void tampil() {
        for (Atk atk : a) {
            System.out.println("Nama :" + atk.nama);
            System.out.println("Stok :" + atk.stok);
            System.out.println("Harga :" + atk.harga);
        }
    }

    void insertionSort() {
        for (int i = 1; i <= a.length - 1; i++) {
            Atk temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].stok > temp.stok) {
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
                Atk temp = a[i];
                int j;
                for (j = i; j >= interval && a[j - interval].stok > temp.stok; j -= interval) {
                    a[j] = a[j - interval];
                }
                a[j] = temp;
            }
        }
    }
}
