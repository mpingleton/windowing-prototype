import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Surface {
    // "Surface" is a raw bitmap that will be written to the video memory and displayed on the monitor.
    private int width, height;
    private BufferedImage image;
    private Component component;
    private ComponentRenderer renderer;

    public Surface() {
        this.width = 0;
        this.height = 0;
        this.component = new Component();
    }

    public Surface(int width, int height, Component component) {
        this.width = width;
        this.height = height;
        this.component = component;
        this.component.reposition(0, 0);
        this.component.resize(width, height);

        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.renderer = new ComponentRenderer(this.image, this.component);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Component getComponent() {
        return component;
    }

    public void resize(int w, int h) {
        width = w;
        height = h;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        component.resize(w, h);
    }

    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
    }

    public void render() {
        clear();
        renderer.render();
    }
}
