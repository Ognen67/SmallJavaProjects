import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(Player.isGrounded) Player.jump = true;
            System.out.println("space pressed");
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            Player.left = true;
            System.out.println("left pressed");
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Player.right = true;
            System.out.println("right pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            Player.left = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Player.right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
