import java.awt.*;
import java.awt.image.BufferedImage;

public class Surface {
    // "Surface" is a raw bitmap that will be written to the video memory and displayed on the monitor.
    private int width, height;
    private BufferedImage image;

    public Surface() {
        this.width = 0;
        this.height = 0;
    }

    public Surface(int width, int height) {
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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

    public void resize(int w, int h) {
        width = w;
        height = h;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void render() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(x / 10, y / 10, 0);
                image.setRGB(x, y, c.getRGB());
            }
        }
    }
}
