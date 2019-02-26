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
    public Player(float x, float y, float width, float height, char playerImage, boolean enemy, String playerName,
            int playerHealth, double playerSpeed) {
        super(playerName, playerHealth, playerSpeed, enemy, x, y, width, height, playerImage);

    }

    /**
     * 
     */
    public Player (Player player) {
        super(player.getName(), player.getHealth(), player.getSpeed(), player.getIsEnemy(), (float)player.getX(), 
        (float)player.getY(), (float)player.getWidth(), (float)player.getHeight(), player.getTerminalChar());
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
