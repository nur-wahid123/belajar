public class PengurutanBuku {
    Buku lisBuku[] = new Buku[10];
    int id = 0;

    PengurutanBuku() {

    }

    PengurutanBuku(int a) {
        lisBuku = new Buku[a];
    }

    void ukBuku() {
        for (int j = 0; j < lisBuku.length - 1; j++) {
            for (int i = 1; i < lisBuku.length - j; i++) {
                Buku last = lisBuku[i];
                Buku first = lisBuku[i - 1];
                if (last.tinggi < first.tinggi) {
                    lisBuku[i] = first;
                    lisBuku[i - 1] = last;
                }
            }
        }
    }

    void halBuku() {
        for (int j = 0; j < lisBuku.length; j++) {
            int imin = j;
            for (int i = j + 1; i < lisBuku.length; i++) {
                if (lisBuku[i].jumlahHalaman < lisBuku[imin].jumlahHalaman) {
                    imin = i;
                }
            }
            Buku temp = lisBuku[j];
            lisBuku[j] = lisBuku[imin];
            lisBuku[imin] = temp;
        }

    }

    void tambah(Buku m) {
        if (id < lisBuku.length) {
            lisBuku[id] = m;
            id++;
        } else {
            System.out.println("Data Penuh!!");
        }
    }

    void tampil() {
        for (Buku buku : lisBuku) {
            buku.tampil();
        }
    }
}
