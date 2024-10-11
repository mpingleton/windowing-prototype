import javax.swing.*;

public class WindowingPrototype {

    public static void main(String[] args) {
        Desktop desktop = new Desktop();

        Window w1 = new ApplicationWindow("Program 1", new Position(100, 100, 640, 480));
        Window w2 = new ApplicationWindow("Program 2", new Position(200, 200, 640, 480));
        desktop.addWindow(w1);
        desktop.addWindow(w2);

        Surface surface = new Surface(1280, 768, desktop);
        SurfaceDisplay display = new SurfaceDisplay(surface);
    }
}
