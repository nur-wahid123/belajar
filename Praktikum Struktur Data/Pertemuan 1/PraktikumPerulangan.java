import java.util.Scanner;

public class PraktikumPerulangan {
    public static int lastTwoDigitNumber(String NIM) {
        long ANIM = Long.parseLong(NIM);
        ANIM = ANIM%100;
        int OANIM = (int)ANIM;
        if (OANIM<10) {
            OANIM += 10;
        }
        return OANIM;
    }
    public static void main(String[] args) {
        String[]hari = {"senin","selasa","rabu","kamis","jumat","sabtu","minggu"};
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan NIM anda => ");
        String NIM = inp.next();
        int ONIM = lastTwoDigitNumber(NIM);
        int a = 0;
        for (int i = 0; i < ONIM; i++) {
            a++;
            if(i%7==0){
                a=0;
            }
            System.out.println(hari[a]);
        }
        inp.close();
    }
}
