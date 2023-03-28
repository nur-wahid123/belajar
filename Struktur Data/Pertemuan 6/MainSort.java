public class MainSort {
    public static void main(String[] args) {
        int arr[] = { 45, 34, 24, 75, 79, 34, 34, 5, 345, 33, 453, 34, 55, 235, 57 };
        Sort are = new Sort(arr);
        System.out.println("Data sebelum diurutkan : ");
        are.tampil();
        System.out.println();
        are.bubSort();
        System.out.println("Data sesudah diurutkan bubble sort : ");
        are.tampil();
        System.out.println();
        are.selSort();
        System.out.println("Data sesudah diurutkan selection sort : ");
        are.tampil();
    }
}
