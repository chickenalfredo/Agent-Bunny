package core.external.entity;

import core.sprite.Entity;
import core.sprite.interfaces.IPhysics;
import core.sprite.interfaces.IHeroOffensive;

/**
 * 
 */
public class Player extends Entity implements IPhysics, IHeroOffensive {

    private int lives = 3;

    /**
     * 
     */
    public Player(double x, double y, double width, double height, char playerImage, String playerName, int playerHealth, double playerSpeed) {
        super(playerName, playerHealth, playerSpeed, false, x, y, width, height, playerImage);

    }

    /**
     * 
     */
    public Player(Player player) {
        super(player.getName(), player.getHealth(), player.getSpeed(), player.getIsEnemy(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), player.getTerminalChar());
    }

    /**
     * 
     */
    public int getLives() {
        return lives;
    }

    /**
     * 
     */
    public void setLives(int oneUp) {
        lives += oneUp;
    }

    @Override
    public void draw() {}
    @Override
    public void update() {}

    @Override
    public void attack() {}

    @Override
    public void collisionResolution() {}

    @Override
    public void jump() {}
    @Override
    public void doubleJump() {}
    @Override
    public void dash() {}
    @Override
    public void duck() {}

}
