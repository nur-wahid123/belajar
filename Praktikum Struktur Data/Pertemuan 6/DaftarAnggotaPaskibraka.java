public class DaftarAnggotaPaskibraka {

    Paskibraka listPkb[] = new Paskibraka[10];
    int id = 0;

    DaftarAnggotaPaskibraka(){

    }

    DaftarAnggotaPaskibraka(int a){
        listPkb = new Paskibraka[a];
    }

    void tambah(Paskibraka m) {
        if (id < listPkb.length) {
            listPkb[id] = m;
            id++;
        } else {
            System.out.println("Maaf Data penuh!!");
        }
    }

    void tampil() {
        for (Paskibraka paskibraka : listPkb) {
            System.out.println();
            paskibraka.tampil();
        }
    }

    void selectionSort() {
        for (int j = 0; j < listPkb.length - 1; j++) {
            for (int i = 1; i < listPkb.length - j; i++) {
                Paskibraka last = listPkb[i];
                Paskibraka first = listPkb[i - 1];
                if (last.tinggi > first.tinggi) {
                    listPkb[i] = first;
                    listPkb[i - 1] = last;
                }
            }
        }
    }

    void tampilDiterima(){
        selectionSort();
        for (Paskibraka paskibraka : listPkb) {
            if (paskibraka.tinggi >= 170) {
                paskibraka.tampil();
            }
        }
    }
}
