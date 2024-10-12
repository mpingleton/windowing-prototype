import java.awt.*;

public class ApplicationWindow extends Window {

    public ControlBar controlBar;

    public ApplicationWindow(String title, Position position) {
        super(title, position);
        controlBar = new ControlBar();
        controlBar.fullBorder = true;
        controlBar.resize(position.getWidth(), 22);
    }

    @Override
    public void render() {
        for (int y = 0; y < controlBar.pos.getHeight(); y++) {
            for (int x = 0; x < controlBar.pos.getWidth(); x++) {
                mask.setRGB(x, y, Color.WHITE.getRGB());
            }
        }

        ComponentRenderer controlBarRenderer = new ComponentRenderer(img, controlBar);
        controlBarRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        controlBar.resize(width, 22);
    }
}
