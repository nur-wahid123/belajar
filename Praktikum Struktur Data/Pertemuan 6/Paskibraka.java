public class Paskibraka {
    int tinggi;
    String kelas, nama;
    Paskibraka(String nm,String kls,int tg){
        tinggi=tg;
        nama = nm;
        kelas = kls;
    }
    void tampil(){
        System.out.println("Nama\t: "+ nama);
        System.out.println("Kelas\t: "+ kelas);
        System.out.println("Tinggi\t: "+ tinggi);
    }
    
}
