public class NestedWhile {
    public static void main(String[] args) {
        int n = 4;
        int i = 0;
        int j = 0;
        while (i < n) {
            j = 0;
            while (j < n) {
                System.out.println(i + " ," + j + " ," + n);
                j++;
            }
            i++;
        }
    }
}
