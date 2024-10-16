import java.awt.*;

public class Button extends Component {

    // TODO: Figure out how to change the state of the button and get it to display a different color or something.
    // TODO: Figure out how to register a button click, and get that information to the application.

    public int border;
    public boolean topBorder, bottomBorder, leftBorder, rightBorder;
    Color backgroundColor;

    public Button() {
        border = 1;
        topBorder = false;
        bottomBorder = false;
        leftBorder = false;
        rightBorder = false;
        backgroundColor = new Color(100, 100, 100);
    }

    @Override
    public void render() {
        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                img.setRGB(x, y, Color.LIGHT_GRAY.getRGB());
            }
        }
    }

    @Override
    public void renderSubstrate() {
        for (int y = 0; y < pos.getHeight(); y++) {
            for (int x = 0; x < pos.getWidth(); x++) {
                substrate.setRGB(x, y, backgroundColor.getRGB());
            }
        }

        if (topBorder) {
            for (int x = 0; x < pos.getWidth(); x++) {
                Color c = new Color(0, 0, 0);
                substrate.setRGB(x, 0, c.getRGB());
            }
        }

        if (bottomBorder) {
            for (int x = 0; x < pos.getWidth(); x++) {
                Color c = new Color(0, 0, 0);
                substrate.setRGB(x, pos.getHeight() - 1, c.getRGB());
            }
        }

        if (leftBorder) {
            for (int y = 0; y < pos.getHeight(); y++) {
                Color c = new Color(0, 0, 0);
                substrate.setRGB(0, y, c.getRGB());
            }
        }

        if (rightBorder) {
            for (int y = 0; y < pos.getHeight(); y++) {
                Color c = new Color(0, 0, 0);
                substrate.setRGB(pos.getWidth() - 1, y, c.getRGB());
            }
        }
    }
}
