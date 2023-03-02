public class DoWhile {
    public static void main(String[] args) {
        int a = 1;
        do {
            System.out.println(a);
            a++;
            if (a==9) {
                break;
            }
        } while (a<=15);
    }
}
