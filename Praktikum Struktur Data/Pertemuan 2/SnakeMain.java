import java.util.Scanner;

public class SnakeMain {
    public static void main(String[] args) {
        Snake snk = new Snake();
        Snake snk2 = new Snake(59, 49);
        snk.height = 6;
        snk.width = 8;
        snk.x = snk.width / 2;
        snk.y = snk.height / 2;
        String jwb = "";
        Scanner inp = new Scanner(System.in);
        // boolean rgs = true;
        int rgs = 1;
        while (rgs == 1) {
            System.out.print("masukkan input (up,down,right,left)=> ");
            jwb = inp.next();
            switch (jwb) {
                case "up":
                    rgs = snk.moveUp();
                    break;
                case "down":
                    rgs = snk.moveDown();
                    break;
                case "right":
                    rgs = snk.moveRight();
                    break;
                case "left":
                    rgs = snk.moveLeft();
                    break;

                default:
                    System.out.println("maaf Salah");
                    break;
            }
            snk.printPosition();
            if (rgs == 0) {
                System.out.println("Game Over");
            }
        }
    }
}
