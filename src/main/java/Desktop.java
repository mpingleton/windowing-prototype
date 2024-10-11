import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Desktop extends Component {

    private BufferedImage backgroundImage;
    private ArrayList<Window> windows;
    private ArrayList<Integer> zOrder;
    private ControlBar desktopControlBar;

    public Desktop() {
        super();
        windows = new ArrayList<>();
        zOrder = new ArrayList<>();
        desktopControlBar = new ControlBar();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        desktopControlBar.resize(width, 25);

        // Redo the background image.  It will be a checkerboard pattern.
        backgroundImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mask.setRGB(x, y, Color.WHITE.getRGB());

                if ((y / 10) % 2 == 0) {
                    if ((x / 10) % 2 == 0) {
                        backgroundImage.setRGB(x, y, Color.DARK_GRAY.getRGB());
                    } else {
                        backgroundImage.setRGB(x, y, Color.LIGHT_GRAY.getRGB());
                    }
                } else {
                    if ((x / 10) % 2 == 0) {
                        backgroundImage.setRGB(x, y, Color.LIGHT_GRAY.getRGB());
                    } else {
                        backgroundImage.setRGB(x, y, Color.DARK_GRAY.getRGB());
                    }
                }
            }
        }
    }

    public void addWindow(Window window) {
        windows.add(window);
        zOrder.add(windows.size() - 1);
    }

    @Override
    public void render() {
        // Draw the background image.
        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                if (x < backgroundImage.getWidth() && y < backgroundImage.getHeight()) {
                    int p = backgroundImage.getRGB(x, y);
                    img.setRGB(x, y, p);
                }
            }
        }

        for (int r = 0; r < zOrder.size(); r++) {
            Window window = windows.get(zOrder.get(r));
            ComponentRenderer renderer = new ComponentRenderer(img, window);
            renderer.render();
        }

        ComponentRenderer controlBarRender = new ComponentRenderer(img, desktopControlBar);
        controlBarRender.render();
    }
}
