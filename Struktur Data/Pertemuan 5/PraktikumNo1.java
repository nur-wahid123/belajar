public class PraktikumNo1 {
    public static void main(String[] args) {
        int arr[] = { 17, 20, 26, 33, 37, 41, 53, 65, 73, 83 };
        int cari = 41;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > cari) {
                System.out.println("Data Tidak ditemukan");
                break;
            } else if (arr[i] == cari) {
                System.out.println("Data " + arr[i] + " ditemukan  pada index ke-" + i);
                break;
            }
        }
    }
}
