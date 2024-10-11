import javax.swing.*;

public class WindowingPrototype {

    public static void main(String[] args) {
        Component component = new Component(new Position(60, 10, 640, 480));

        Surface surface = new Surface(1024, 768);
        surface.addComponent(component);

        SurfaceDisplay display = new SurfaceDisplay(surface);
    }
}
