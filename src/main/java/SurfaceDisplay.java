import javax.swing.*;

public class SurfaceDisplay extends JFrame {
    SurfaceDisplayPanel panel;

    public SurfaceDisplay(Surface surface) {
        super("Windowing Prototype Display Surface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new SurfaceDisplayPanel();
        this.panel.surface = surface;
        add(this.panel);

        pack();
        setVisible(true);
    }
}
