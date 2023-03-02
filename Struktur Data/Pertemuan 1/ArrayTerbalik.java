import java.util.Scanner;

public class ArrayTerbalik {
    public static void main(String[] args) {
        char b[] = {'S','e','l','a','m','a','t'}; 
        for (int i = b.length; i > 0 ; i--) {
            System.out.print(b[i-1]);
        }
    }
}
