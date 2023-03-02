public class Balok{
    int sisi;
    Balok(){
        sisi=0;
    }
    Balok(int a){
        sisi = a;
    }
    int hitungVolume(){
        return (int) Math.pow(sisi, 3);
    }
    int luasPermukaan(){
        return 6*sisi*sisi;
    }
}