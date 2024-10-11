import javax.swing.*;
import java.awt.*;

public class SurfaceDisplayPanel extends JPanel {
    public Surface surface;

    public Dimension getPreferredSize() {
        return new Dimension(surface.getWidth(), surface.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        surface.render();
        g.drawImage(surface.getImage(), 0, 0, this);
    }
}
