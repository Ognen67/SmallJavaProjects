import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Screen extends JPanel implements Runnable{
    JFrame frame;

    boolean isRunning;

    Game game;

    public Screen() {
        frame = new JFrame("Platformer");
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new Game();

        addKeyListener(new InputManager());

        Thread thread = new Thread(this, "Game");
        thread.start();

        frame.setVisible(true);
    }

    @Override
    public void run() {
        isRunning = true;

        while(isRunning) {
            game.update();

            repaint();

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    isRunning = false;
                }
            });

            try {
                Thread.sleep(16);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.CYAN);

        game.render(g);
    }
}
