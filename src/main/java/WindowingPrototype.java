import javax.swing.*;

public class WindowingPrototype {

    public static void main(String[] args) {
        Component mainComponent = new Component();

        Surface surface = new Surface(1024, 768, mainComponent);
        SurfaceDisplay display = new SurfaceDisplay(surface);
    }
}
