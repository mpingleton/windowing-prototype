import javax.swing.*;
import java.awt.*;

public class SurfaceDisplayPanel extends JPanel {
    public Surface surface;

    public Dimension getPreferredSize() {
        return new Dimension(1280, 780);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        surface.resize(this.getWidth(), this.getHeight());
        surface.render();
        g.drawImage(surface.getImage(), 0, 0, this);
    }
}
