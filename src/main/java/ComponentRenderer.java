import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentRenderer {

    private BufferedImage image;
    private Component component;

    public ComponentRenderer(BufferedImage image, Component component) {
        this.image = image;
        this.component = component;
    }

    public void render() {
        for (int y = 0; y < component.pos.getHeight(); y++) {
            for (int x = 0; x < component.pos.getWidth(); x++) {
                int p = image.getRGB(x + component.pos.getX(), y + component.pos.getY());
                component.substrate.setRGB(x, y, p);
            }
        }

        component.renderSubstrate();
        component.render();

        for (int y = 0; y < component.pos.getHeight(); y++) {
            for (int x = 0; x < component.pos.getWidth(); x++) {
                int c = component.mask.getRGB(x, y);

                int p;
                if (Color.WHITE.getRGB() == c) {
                    p = component.img.getRGB(x, y);
                } else {
                    p = component.substrate.getRGB(x, y);
                }
                image.setRGB(x + component.pos.getX(), y + component.pos.getY(), p);
            }
        }
    }
}
