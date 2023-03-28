public class Keranjang {
    String alo[] = new String[0];

    Keranjang() {

    }

    void tambahBarang(String a) {
        AdaptiveArray arr = new AdaptiveArray(alo);
        Stok stok = new Stok();
        String b[][] = stok.asli;
        boolean c = false;
        for (int j = 0; j < b.length; j++) {
            if (a.equalsIgnoreCase(b[j][0])) {
                Barang brg = new Barang(b[j][1], b[j][0], Integer.parseInt(b[j][2]), Integer.parseInt(b[j][3]));
                arr.add(brg.kembali());
                c = true;
                alo = arr.getArray();
            }
        }
        if (c) {
            System.out.println("Barang Berhasil ditambahkan");
        } else {
            System.out.println("Kode Barang tidak ditemukan");
        }
    }

    void tampil() {
        System.out.println("\n==============================");
        System.out.println("\tList Barang");
        System.out.println("==============================");
        for (String string : alo) {
            System.out.println(string);
        }

    }
}
