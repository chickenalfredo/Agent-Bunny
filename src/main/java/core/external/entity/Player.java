package core.external.entity;

import core.sprite.Entity;

/**
 * 
 */
public class Player extends Entity {

    private int lives = 3;
    private int attackPower = 1;

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

    /**
     * 
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * 
     */
    private void setAttackPower(int attack) {
        attackPower = attack;
    }
}
