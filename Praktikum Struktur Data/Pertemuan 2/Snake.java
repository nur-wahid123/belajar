public class Snake {
    int x, y, width, height;
    Snake(){

    }
    Snake(int w, int h){
        width = w;
        height = h;
        y = h/2;
        x = w/2;
    }

    int moveLeft() {
        x -= 1;
        return detectCollision(x);
    }

    int moveRight() {
        x += 1;
        return detectCollision(x);
    }

    int moveUp() {
        y += 1;
        return detectCollision(y);
    }

    int moveDown() {
        y -= 1;
        return detectCollision(y);
    }

    void printPosition() {
        System.out.println("koordinat ular = ( " + x + ", " + y + " ) ");
    }

    int detectCollision(int b) {
        if (b > width || b < 0) {
            return 0;
        } else if (b > height || b < 0) {
            return 0;
        } else {
            return 1;
        }
    }
}