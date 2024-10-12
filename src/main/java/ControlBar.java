import java.awt.*;

public class ControlBar extends Component {

    public int border;
    public boolean fullBorder;
    public Button exitButton, menuButton, windowButton, minimizeButton;

    public ControlBar() {
        border = 1;
        fullBorder = false;
        exitButton = new Button();
        exitButton.backgroundColor = new Color(100, 0, 0);
        exitButton.leftBorder = false;
        exitButton.rightBorder = true;
        exitButton.topBorder = false;
        exitButton.bottomBorder = false;

        menuButton = new Button();
        menuButton.backgroundColor = new Color(0, 100, 0);
        menuButton.leftBorder = true;
        menuButton.rightBorder = false;
        menuButton.topBorder = false;
        menuButton.bottomBorder = false;

        windowButton = new Button();
        windowButton.backgroundColor = new Color(0, 0, 100);
        windowButton.leftBorder = true;
        windowButton.rightBorder = false;
        windowButton.topBorder = false;
        windowButton.bottomBorder = false;

        minimizeButton = new Button();
        minimizeButton.backgroundColor = new Color(0, 0, 100);
        minimizeButton.leftBorder = true;
        minimizeButton.rightBorder = false;
        minimizeButton.topBorder = false;
        minimizeButton.bottomBorder = false;
    }

    public void setButtonMask() {
        for (int x = 0; x < pos.getWidth(); x++) {
            if ((x > exitButton.pos.getX() && x < exitButton.pos.getX() + exitButton.pos.getWidth())
                    || (x > menuButton.pos.getX() && x < menuButton.pos.getX() + menuButton.pos.getWidth())
                    || (x > windowButton.pos.getX() && x < windowButton.pos.getX() + windowButton.pos.getWidth())
                    || (x > minimizeButton.pos.getX() && x < windowButton.pos.getX() + minimizeButton.pos.getWidth())) {

                for (int y = 0; y < pos.getHeight(); y++) {
                    mask.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            exitButton.mask.setRGB(i + 5, i + 6, Color.WHITE.getRGB());
            exitButton.mask.setRGB(5 + (9 - i), i + 6, Color.WHITE.getRGB());
        }

        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                menuButton.mask.setRGB(x + 7, y + 9, Color.WHITE.getRGB());
            }
        }
    }

    @Override
    public void renderSubstrate() {
        if (fullBorder) {
            for (int y = 0; y < pos.getHeight(); y++) {
                for (int x = 0; x < pos.getWidth(); x++) {
                    if (x < border || y < border || x >= pos.getWidth() - border || y >= pos.getHeight() - border) {
                        Color c = new Color(0, 0, 0);
                        substrate.setRGB(x, y, c.getRGB());
                        mask.setRGB(x, y, Color.BLACK.getRGB());
                    } else {
                        Color cn = new Color(25, 25, 25);
                        substrate.setRGB(x, y, cn.getRGB());
                    }
                }
            }
        } else {
            for (int y = 0; y < pos.getHeight(); y++) {
                for (int x = 0; x < pos.getWidth(); x++) {
                    if (y >= pos.getHeight() - 1) {
                        Color c = new Color(0, 0, 0);
                        substrate.setRGB(x, y, c.getRGB());
                        mask.setRGB(x, y, Color.BLACK.getRGB());
                    } else {
                        Color cn = new Color(25, 25, 25);
                        substrate.setRGB(x, y, cn.getRGB());
                    }
                }
            }
        }

        ComponentRenderer exitButtonRenderer = new ComponentRenderer(img, exitButton);
        ComponentRenderer menuButtonRenderer = new ComponentRenderer(img, menuButton);
        ComponentRenderer windowButtonRenderer = new ComponentRenderer(img, windowButton);
        ComponentRenderer minimizeButtonRenderer = new ComponentRenderer(img, minimizeButton);

        exitButtonRenderer.render();
        menuButtonRenderer.render();
        windowButtonRenderer.render();
        minimizeButtonRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        exitButton.reposition(0, 0);
        exitButton.resize(20, height);
        menuButton.reposition(width - 20, 0);
        menuButton.resize(20, height);
        windowButton.reposition(width - 40, 0);
        windowButton.resize(20, height);
        minimizeButton.reposition(width - 60, 0);
        minimizeButton.resize(20, height);

        setButtonMask();
    }
}
