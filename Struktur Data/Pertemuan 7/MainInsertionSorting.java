public class MainInsertionSorting {

    public static void main(String[] args) {
        int[] a = {67, 90, 23, 1, 5, 3, 2};
        InsertionSorting urut = new InsertionSorting(a, a.length);
        System.out.println("Data sebelum urut");
        urut.tampilData();
        urut.insertionSort();
        System.out.println("Data setelah diurut (ascending)");
        urut.tampilData();

    }

}
