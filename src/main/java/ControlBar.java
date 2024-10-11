import java.awt.*;

public class ControlBar extends Component {

    @Override
    public void renderSubstrate() {
        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                if (y >= pos.getHeight() - 1) {
                    Color c = new Color(0, 0, 0);
                    substrate.setRGB(x, y, c.getRGB());
                } else {
                    Color cn = new Color(60, 60, 60);
                    substrate.setRGB(x, y, cn.getRGB());
                }
            }
        }
    }
}
