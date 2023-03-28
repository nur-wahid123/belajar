public class mainmain {
    public static void main(String[] args) {
        int data[] = new int[50];
        for (int i = 0; i < data.length-1; i++) {
            int imin = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] > data[imin]) {
                    imin = j;
                }
            }
            int emp = data[i];
            data[i] = data[imin];
            data[imin] = emp;
        }
        int id=0;
        for (int i = 0; i < data.length-1; i++) {
            for (int j = 1; j < data.length-i; j++) {
                id++;
                if (data[j] < data[j-1]) {
                    int emp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = emp;
                }
            }
        }
        for (int i : data) {
            System.out.println(i);
        }
        System.out.println("panjang array - "+data.length);
        System.out.println("KE - "+id);
        System.out.println("coba = "+(coba(50)-50));
    }

    public static int coba(int a){
        if (a>1) {
            return a + coba(a-1);
        }else{
            return 1;
        }
    }
}