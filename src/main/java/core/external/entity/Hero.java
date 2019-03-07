package core.external.entity;

import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.interfaces.Physics;
import core.sprite.interfaces.HeroDefense;;

/**
 * 
 */
public class Hero extends Entity implements Physics, HeroDefense {

    private int lives = 3;

    public Hero(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('H');
    }

    public Hero(Hero player) {
        super(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int oneUp) {
        lives += oneUp;
    }

    @Override
    public void attack() {}

    @Override
    public void draw() {}

    @Override
    public void update() {}

    @Override
    public void jump() {}

    @Override
    public void doubleJump() {}

    @Override
    public void dash() {}

    @Override
    public void duck() {}

    @Override
    public void collisionResolution(Sprite sprite) {}

}
