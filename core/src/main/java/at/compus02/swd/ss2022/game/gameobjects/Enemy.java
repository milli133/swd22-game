package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.observer.PositionObserver;
import at.compus02.swd.ss2022.game.strategy.CowardStrategy;
import at.compus02.swd.ss2022.game.strategy.Strategy;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements GameObject {
    private Texture image;
    private Sprite sprite;
    private float posX;
    private float posY;
    private List<PositionObserver> observers = new ArrayList<>();

    public Enemy() {
        image = AssetRepository.getInstance().getTexture(TextureType.ENEMY);
        sprite = new Sprite(image);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    @Override
    public void act(float delta) {
        Strategy strategy = new CowardStrategy(this);
        strategy.execute();
    }

    @Override
    public void setPosition(float x, float y) {
        posX = x;
        posY = y;
        sprite.setPosition(x, y);
        for (PositionObserver obs : this.observers) {
            obs.update(x,y);
        }
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void addObserver(PositionObserver obs) {
        this.observers.add(obs);
    }
    public void removeObserver(PositionObserver obs) {
        this.observers.remove(obs);
    }

}
