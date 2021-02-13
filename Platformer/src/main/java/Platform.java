import java.awt.*;

public class Platform {
    private int xPos, yPos, width, height;

    private Player player;

    public Platform(int xPos, int yPos, int width, int height, Player player) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        this.player = player;
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);

        g.fillRect(xPos, yPos, width, height);
    }

    public void update() {
        Rectangle playerRect = new Rectangle(player.getPosition()[0],player.getPosition()[1], player.getSize()[0],player.getSize()[1]);
        Rectangle platformRect = new Rectangle(getPosition()[0],getPosition()[1], getSize()[0],getSize()[1]);

        if(playerRect.intersects(platformRect)) {
            player.setPosition(player.getPosition()[0], (int)(player.getPosition()[1]-player.GRAVITY));

            Player.isGrounded = true;
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
}
