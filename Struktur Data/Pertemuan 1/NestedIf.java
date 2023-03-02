public class NestedIf {
    public static void main(String[] args) {
        int semester = 3;
        double ipk = 3.5;
        if (semester>=2) {
            if (ipk>3.2) {
                System.out.println("Selamat anda lolos");
            }else{
                System.out.println("IPK anda kurang");
            }
        }else{
            System.out.println("maaf yang diperbolehkan hanya semester 3 keatas");
        }
    }
}
