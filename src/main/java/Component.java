import java.awt.*;
import java.awt.image.BufferedImage;

public class Component {
    // Random thought:  is it better to have each component have its own bitmap?
    // Or each component to draw directly to the surface image buffer?
    // A component will not necessarily have child components, so that
    // will be left up to any class which inherits this one.

    public Position pos;
    public BufferedImage substrate, mask, img;

    public Component() {
        this.pos = new Position();
    }

    public Component(Position position) {
        this.pos = position;
        this.substrate = new BufferedImage(pos.getWidth(), pos.getWidth(), BufferedImage.TYPE_INT_RGB);
        this.mask = new BufferedImage(pos.getWidth(), pos.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        this.img = new BufferedImage(pos.getWidth(), pos.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    // TODO
    public void resize(int width, int height) {
    }

    public void renderSubstrate() {
        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                int p = substrate.getRGB(x, y);

                Color c = new Color(p);
                int r = c.getRed() + 100;
                int g = c.getGreen() + 100;
                int b = c.getBlue() + 100;

                Color c1 = new Color(r, g, b);
                substrate.setRGB(x, y, c1.getRGB());
            }
        }
    }

    public void render() {
        for (int x = 0; x < pos.getWidth(); x++) {
            mask.setRGB(x, 0, Color.WHITE.getRGB());
            mask.setRGB(x, pos.getHeight() - 1, Color.WHITE.getRGB());
        }

        for (int y = 0; y < pos.getHeight(); y++) {
            mask.setRGB(0, y, Color.WHITE.getRGB());
            mask.setRGB(pos.getWidth() - 1, y, Color.WHITE.getRGB());
        }

        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                img.setRGB(x, y, Color.GREEN.getRGB());
            }
        }
    }
}
