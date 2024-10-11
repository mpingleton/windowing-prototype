import java.awt.*;

public class Window extends Component {

    public String title;

    public Window(String title, Position position) {
        super(position);
        this.title = title;
    }

    @Override
    public void renderSubstrate() {
        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                if (x == 0 || x == pos.getWidth() - 1 || y == 0 || y == pos.getHeight() - 1) {
                    Color c = new Color(0, 0, 0);
                    substrate.setRGB(x, y, c.getRGB());
                } else {
                    Color cn = new Color(50, 50, 50);
                    substrate.setRGB(x, y, cn.getRGB());
                }
            }
        }
    }

    @Override
    public void reposition(int x, int y) {
        super.reposition(x, y);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
