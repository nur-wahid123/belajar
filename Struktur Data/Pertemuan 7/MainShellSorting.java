public class MainShellSorting {

    public static void main(String[] args) {
        int[] a = { 37, 57, 56, 45, 44,45,22,21, 23, 89, 100, 24 };
        ShellSorting urut = new ShellSorting(a);
        System.out.println("Data sebelum urut");
        urut.tampilData();
        urut.shellSort();
        System.out.println("Data setelah diurut (ascending)");
        urut.tampilData();
    }

}
