public class Barang {
    AdaptiveArray array = new AdaptiveArray();
     int stok, harga;
     String kode, nama;

    Barang(String nm, String kd, int price, int stock) {
        nama = nm;
        kode = kd;
        harga = price;
        stok = stock;
    }


    String[] kbl(){
        String a [] = new String[4];
        a[0] = kode;
        a[1] = nama;
        a[2] = String.valueOf(harga);
        a[3] = String.valueOf(stok);
        return a;
    }
    String kembali(){
        return kode+"\t"+nama+"\t"+harga+"\t"+stok;
    }

    void tampil() {
        System.out.printf("$s\t%s\t%d\t%d", kode, nama, harga, stok);
    }

    void ubahHarga(int hrg) {
        harga = hrg;
    }

    void ubahNama(String hrg) {
        nama = hrg;
    }

    boolean kurangiStok(int stk) {
        if ((stok - stk) < 1) {
            return false;
        }
        stok -= stk;
        return true;
    }

    void tambahStok(int stk) {
        stok += stk;
    }
}