package core.external.entity;

import core.sprite.Entity;
import java.lang.Math;

/**
 * This class implements the AI and behaviours of weak hostile npc in the game.
 * It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class Monster extends Entity {
    private int power = 20;

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
    public Monster(String entityName, int entityHealth, double entitySpeed, boolean enemy, float entityX, float entityY,
            float entityWidth, float entityHeight, char entityImage) {
        super(entityName, entityHealth, entitySpeed, enemy, entityX, entityY, entityWidth, entityHeight, entityImage);
        setDirection(Math.random() < 0.5);
    }

    /**
     * This is the get method for the variable power.
     * 
     * @return the value for overall strength of the monster
     */
    public int getPower() {
        return power;
    }

    /**
     * This generates a random integer between a range of numbers for some
     * randomness in the behavior of the monster.
     * 
     * @param min the floor of the range of numbers
     * @param max the ceiling of the range of numbers
     * @return the integer that is randomly generated
     */
    public int getRandomInt(int min, int max) {
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

    /**
     * This is what the monster will passively do when player is not nearby.
     */
    public void idle() {
    }
}