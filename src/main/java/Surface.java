import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Surface {
    // "Surface" is a raw bitmap that will be written to the video memory and displayed on the monitor.
    private int width, height;
    private BufferedImage image;
    private ArrayList<Component> components;
    private ArrayList<ComponentRenderer> renderers;

    public Surface() {
        this.width = 0;
        this.height = 0;
        this.components = new ArrayList();
        this.renderers = new ArrayList();
    }

    public Surface(int width, int height) {
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.components = new ArrayList();
        this.renderers = new ArrayList();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addComponent(Component component) {
        ComponentRenderer newRenderer = new ComponentRenderer(image, component);

        this.renderers.add(newRenderer);
        this.components.add(component);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void resize(int w, int h) {
        width = w;
        height = h;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void clear(int color) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, color);
            }
        }
    }

    public void render() {
        clear(Color.DARK_GRAY.getRGB());

        for (int i = 0; i < this.renderers.size(); i++) {
            this.renderers.get(i).render();
        }
    }
}
