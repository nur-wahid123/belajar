public class MainSort {
    public static void main(String[] args) {
        int[] o = {3,2,6,84,3,3,56,6,5,7,667,7,1};
        Sort oi = new Sort(o);
        System.out.println("Data Sebelum Diurutkan");
        oi.tampil();
        System.out.println("Data Sesudah Diurutkan");
        // oi.insertionSort();
        oi.shellSort();
        oi.tampil();
    }
}
