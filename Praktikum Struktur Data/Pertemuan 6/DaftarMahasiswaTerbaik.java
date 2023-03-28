public class DaftarMahasiswaTerbaik {
    Mhs listMhs[] = new Mhs[5];
    int idx = 0;

    void tambah(Mhs m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data Sudah Penuh!!");
        }
    }

    void tampil() {
        for (Mhs mhs : listMhs) {
            mhs.tampil();
            System.out.println("-----------------------");
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                if (listMhs[j].ipk > listMhs[j - 1].ipk) {
                    Mhs temp = listMhs[j];
                    listMhs[j] = listMhs[j - 1];
                    listMhs[j - 1] = temp;
                }
            }
        }
    }
    void selectionSort(){
        for (int i = 0; i < listMhs.length-1; i++) {
            int idxmin = i;
            for (int j = i+1; j < listMhs.length; j++) {
                if (listMhs[j].ipk < listMhs[j - 1].ipk) {
                    idxmin = j;
                }
            }
            Mhs temp = listMhs[idxmin];
            listMhs[idxmin] = listMhs[i];
            listMhs[i]=temp;
        }
    }
}
