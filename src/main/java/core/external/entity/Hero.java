package core.external.entity;

import core.ecs.components.PhysicsComponent;
import core.sprite.Entity;

/**
 * 
 */
public class Hero extends Entity {

    private int lives = 3;

    public Hero(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('H');
        setAttackPower(25);
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

    public void jump() {
        getComponent("PhysicsComponent", PhysicsComponent.class).jump();
    }

}
