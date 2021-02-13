public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.frame.add(screen);
        screen.requestFocusInWindow();
    }
}
