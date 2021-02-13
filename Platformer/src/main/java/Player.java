import java.awt.*;

public class Player {
    private int xPos, yPos, width, height;

    public final double GRAVITY = 10;

    public static boolean jump, left, right, isGrounded;

    int jumpLimit = 100, jumpHeight = 0;

    public Player(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);

        g.fillRect(xPos, yPos, width, height);
    }

    public void update() {
        yPos += GRAVITY;

        if (jump) {
            yPos -= GRAVITY + 10;
            jumpHeight -= GRAVITY;
            isGrounded = false;

            if (jumpHeight == 0) jump = false;
        }
        else {
            jumpHeight = jumpLimit;
        }

        if (left) {
            xPos -= 5;
        }

        if (right) {
            xPos += 5;
        }
    }

    public int[] getPosition() {
        int[] position = new int[2];

        position[0] = xPos;
        position[1] = yPos;

        return position;
    }

    public int[] getSize() {
        int[] size = new int[2];

        size[0] = width;
        size[1] = height;

        return size;
    }

    public void setPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}