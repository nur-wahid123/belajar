public class PraktikumNo3 {
    public static void main(String[] args) {
        int arr[] = { 12, 15, 6, 3, 70, 51, 15, 3, 83,45,83 };
        int arr2[][] = new int[arr.length][2];
        int terbesar = 0;
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            // if (arr[i] > terbesar || arr[i] == terbesar) {
            if (arr[i] >= terbesar) {
                terbesar = arr[i];
                arr2[a][0] = terbesar;
                arr2[a][1] = i;
                a++;
            }
        }

        a = 0;
        int b = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            if (arr2[i][0] != 0 && b == 0) {
                System.out.print("Nilai Terbesar adalah " + arr2[i][0] + " dan berada pada ");
                a = arr2[i][0];
                b++;
            }
            if (arr2[i][0] != a) {
                break;
            }
            if (b != 0) {
                System.out.print("index ke-" + arr2[i][1] + ", ");
            }

        }
    }
}
