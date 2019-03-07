package core.external.entity;

import core.sprite.AbstractEnemy;

/**
 * This class implements the AI and behaviours of weak hostile npc in the game.
 * It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class Monster extends AbstractEnemy {

    /**
     * This is the constructor for this class that extends from Entity class.
     * 
     * @param entityName   This is the entity's name.
     * @param entityHealth This is the entity's health.
     * @param entitySpeed  This is the entity's speed.
     * @param enemy        This detemines whether if the entity is an enemy.
     * @param entityX      This is the x coordinate of the location of the entity.
     * @param entityY      This is the y coordinate of the location of the entity.
     * @param entityWidth  This is the width of the entity's size.
     * @param entityHeight This is the height of the entity's size.
     * @param entityImage  This sets the visual graphic for the entity
     * @param power        This sets the overall strength of the enemy's attack.
     */
    /**
     * 
     */
    public Monster(double x, double y, double width, double height, char playerImage, String playerName, int playerHealth, double playerSpeed) {
        super(x, y, width, height, playerImage, playerName, playerHealth, playerSpeed);
    }

    @Override
    public void draw() {}
    @Override
    public void update() {}

    @Override
    public void attack() {}
    @Override
    public void guard() {}
    @Override
    public void dodge() {}
    @Override
    public void collisionResolution() {}

}
