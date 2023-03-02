public class NestedFor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                for (int j2 = 0; j2 < 2; j2++) {
                    System.out.printf("Tingkat 1 : %d, Tingkat 2 : %d,Tingkat 3 :  %d",i,j,j2);
                    System.out.println();
                }
            }
        }
    }
}
