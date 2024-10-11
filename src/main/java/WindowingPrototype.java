import javax.swing.*;

public class WindowingPrototype {

    public static void main(String[] args) {
        Surface surface = new Surface(1024, 768);
        SurfaceDisplay display = new SurfaceDisplay(surface);
    }
}
