import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WindowingPrototype {

    public static void main(String[] args) {
        SurfaceDisplayPanel surfaceDisplayPanel = new SurfaceDisplayPanel();
        surfaceDisplayPanel.surface = new Surface();

        JFrame frame = new JFrame("Windowing Prototype Display Surface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());
        frame.add(surfaceDisplayPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
