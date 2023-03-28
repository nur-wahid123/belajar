public class Stok {
    String sttk[], asli[][];

    Stok() {
        AdaptiveArray stok = new AdaptiveArray();
        AdaptiveArray2dimension ass = new AdaptiveArray2dimension();
        Barang brg = new Barang("Shampo", "K01", 10000, 30);
        stok.add(brg.kembali());
        ass.add(brg.kbl());
        brg = new Barang("Pulpen", "K02", 3000, 35);
        stok.add(brg.kembali());
        ass.add(brg.kbl());
        brg = new Barang("Parfum", "K03", 15000, 20);
        stok.add(brg.kembali());
        ass.add(brg.kbl());
        brg = new Barang("Gelas", "K04", 12000, 40);
        stok.add(brg.kembali());
        ass.add(brg.kbl());
        brg = new Barang("Sabun", "K05", 7000, 20);
        stok.add(brg.kembali());
        ass.add(brg.kbl());
        asli = ass.getArray();
        sttk = stok.getArray();
    }

    void tambahProduk(String nm, String kd, int price, int stock) {
        Barang brg = new Barang(nm, kd, price, stock);
        AdaptiveArray stk = new AdaptiveArray(sttk);
        stk.add(brg.kembali());
        sttk = stk.getArray();
    }

    void tampil() {
        System.out.println("\n===============================");
        System.out.println("\tToko Indra Jaya");
        System.out.println("===============================");
        System.out.println();
        for (String ok : sttk) {
            System.out.println(ok);
        }
        System.out.println("=================================");
    }

}

class Barang {
    AdaptiveArray array = new AdaptiveArray();
    int stok, harga;
    String kode, nama;

    Barang(String nm, String kd, int price, int stock) {
        nama = nm;
        kode = kd;
        harga = price;
        stok = stock;
    }

    String[] kbl() {
        String a[] = new String[4];
        a[0] = kode;
        a[1] = nama;
        a[2] = String.valueOf(harga);
        a[3] = String.valueOf(stok);
        return a;
    }

    String kembali() {
        return kode + "\t" + nama + "\t" + harga + "\t" + stok;
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

class AdaptiveArray2dimension {
    private String[][] adaptiveArray;

    public AdaptiveArray2dimension() {
        adaptiveArray = new String[0][4];
    }

    public AdaptiveArray2dimension(String strings[][]) {
        adaptiveArray = strings;
    }

    public void add(String newValue[]) {
        String[][] tempArray = new String[adaptiveArray.length + 1][4];
        System.arraycopy(adaptiveArray, 0, tempArray, 0, adaptiveArray.length);
        adaptiveArray = tempArray;

        adaptiveArray[adaptiveArray.length - 1] = newValue;
    }

    public String[][] getArray() {
        return adaptiveArray;
    }
}

class AdaptiveArray {
    private String[] adaptiveArray;

    public AdaptiveArray() {
        adaptiveArray = new String[0];
    }

    public AdaptiveArray(String... strings) {
        adaptiveArray = strings;
    }

    public void add(String newValue) {
        String[] tempArray = new String[adaptiveArray.length + 1];
        System.arraycopy(adaptiveArray, 0, tempArray, 0, adaptiveArray.length);
        adaptiveArray = tempArray;

        adaptiveArray[adaptiveArray.length - 1] = newValue;
    }

    public String[] getArray() {
        return adaptiveArray;
    }
}
