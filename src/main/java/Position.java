public class Position {

    private int x, y, w, h;

    public Position() {
        this.x = 0;
        this.y = 0;
        this.w = 0;
        this.h = 0;
    }

    public Position(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public String toString() {
        String tmp = "Position: ";
        tmp += "(X: " + x + "; Y: " + y + "; Width: " + w + "; Height: " + h + ")";
        return tmp;
    }
}
