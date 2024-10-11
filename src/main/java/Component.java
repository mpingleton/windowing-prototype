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

    public void renderSubstrate() {}

    public void render() {}

    public void reposition(int x, int y) {
        Position newPos = new Position(x, y, this.pos.getWidth(), this.pos.getHeight());
        this.pos = newPos;
    }

    public void resize(int width, int height) {
        Position newPos = new Position(this.pos.getX(), this.pos.getY(), width, height);
        this.pos = newPos;

        this.substrate = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.mask = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
}
