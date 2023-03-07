public class Mahasiswa {
    String nama,nim,jk,ipk;
    Mahasiswa(){
        nama = "";
        nim = "";
        jk = "";
        ipk = "";
    }

    Mahasiswa(String Nama,String NIM,String JenisKelamin,String IPK){
        nama = Nama;
        nim = NIM;
        jk = JenisKelamin;
        ipk = IPK;
    }

    void tampil(){
        System.out.println("Nama\t\t: "+nama);
        System.out.println("NIM\t\t: "+nim);
        System.out.println("Jenis Kelamin\t: "+jk);
        System.out.println("IPK\t\t: "+ipk);
    }
}
