package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.observer.PlayerPositionLogObserver;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveLeftCommand implements Command {

    private Sprite sprite;
    private Player player;
    @Override
    public void execute() {
        PlayerPositionLogObserver positionObserver = new PlayerPositionLogObserver();
        player.addObserver(positionObserver);
        // negative x-position = left
        player.setPosition(sprite.getX() - 10, sprite.getY());
    }

    public MoveLeftCommand(Player player) {
        this.sprite = player.getSprite();
        this.player = player;
    }
}
