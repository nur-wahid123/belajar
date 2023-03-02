public class Film {
    String judul, genre, rate;
    int hargaTiket, jumlahTiket;

    Film(){

    }

    Film(String jd, String gr,String rt, int jt,int ht){
        judul = jd;
        genre = gr;
        rate = rt;
        hargaTiket = ht;
        jumlahTiket = jt;
    }

    void tampilFilm() {
        System.out.println("Judul : " + judul);
        System.out.println("Genre : " + genre);
        System.out.println("Rate : " + rate);
        System.out.println("Jumlah Tiket : " + jumlahTiket);
        System.out.println("Harga Tiket : " + hargaTiket);
    }

    void tambahTiket(int n) {
        jumlahTiket += n;
    }

    void kurangiTiket(int n) {
        if((jumlahTiket-n)<0){
            System.out.println("Maaf tiket kurang / habis");
        }else{
            jumlahTiket -= n;
        }
    }

    int totalRevenue() {
        return jumlahTiket * hargaTiket;
    }

}