import java.awt.*;

public class Game {
    Player player;

    Platform platform;

    public Game() {
        player = new Player(700,200, 50,100);

        platform = new Platform(700,600, 600,50, player);
    }

    public void render(Graphics g) {
        player.render(g);

        platform.render(g);
    }

    public void update() {
        player.update();

        platform.update();
    }
}
