public class FilmMain {
    public static void main(String[] args) {
        Film flm = new Film();
        flm.judul = "Quantumania Mancing";
        flm.genre = "Action Comedy";
        flm.rate = "Remaja";
        flm.hargaTiket = 40000;
        flm.jumlahTiket = 3000;
        flm.tambahTiket(5);
        flm.kurangiTiket(9);
        flm.tampilFilm();
        int income = flm.totalRevenue();
        System.out.println("Income = Rp. " + income);
        System.out.println("====================");
        Film flm2 = new Film("Maniaquantum","Horor","Dewasa",2000,40000);
        flm2.tampilFilm();
        income = flm2.totalRevenue();
        System.out.println("Income = Rp. " + income);
        System.out.println("====================");
        Film flm3 = new Film("Indra Fajar Nurwahid","Senang","Bayi",2500,20000);
        flm3.tampilFilm();
        income = flm3.totalRevenue();
        System.out.println("Income = Rp. " + income);
    }
}


