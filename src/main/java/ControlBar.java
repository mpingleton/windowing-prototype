import java.awt.*;

public class ControlBar extends Component {

    public int border;
    public boolean fullBorder;

    public ControlBar() {
        border = 1;
        fullBorder = false;
    }

    @Override
    public void renderSubstrate() {
        if (fullBorder) {
            for (int y = 0; y < pos.getHeight(); y++) {
                for (int x = 0; x < pos.getWidth(); x++) {
                    if (x < border || y < border || x >= pos.getWidth() - border || y >= pos.getHeight() - border) {
                        Color c = new Color(0, 0, 0);
                        substrate.setRGB(x, y, c.getRGB());
                    } else {
                        Color cn = new Color(25, 25, 25);
                        substrate.setRGB(x, y, cn.getRGB());
                    }
                }
            }
        } else {
            for (int y = 0; y < pos.getHeight(); y++) {
                for (int x = 0; x < pos.getWidth(); x++) {
                    if (y >= pos.getHeight() - 1) {
                        Color c = new Color(0, 0, 0);
                        substrate.setRGB(x, y, c.getRGB());
                    } else {
                        Color cn = new Color(25, 25, 25);
                        substrate.setRGB(x, y, cn.getRGB());
                    }
                }
            }
        }
    }
}
