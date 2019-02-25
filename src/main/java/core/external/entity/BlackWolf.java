package core.external.entity;

import core.sprite.Entity;
import java.util.Random;
import java.util.List;
import java.lang.Thread;
import java.lang.Math;

/**
 * This class implements the AI and behaviours of strong hostile npc in the game.
 * It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class BlackWolf extends Entity {
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
    public BlackWolf(String entityName, int entityHealth, double entitySpeed, boolean enemy, float entityX, float entityY,
            float entityWidth, float entityHeight, char entityImage) {
        super(entityName, entityHealth, entitySpeed, enemy, entityX, entityY, entityWidth, entityHeight, entityImage);
        setDirection(Math.random() < 0.5);
    }

    /**
     * This is the get method for the variable power.
     * 
     * @return the value for overall strength of the wolf
     */
    public int getPower() {
        return power;
    }

    /**
     * This generates a random integer between a range of numbers for some
     * randomness in the behavior of the wolf.
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
     * This is what the wolf will passively do when player is not nearby.
     */
    public void guard() {
    }

    /**
     * When player attacks the black wolf, it will dodge dodge the attack by significant chance.
     */
    public void dodge(){
    }
    
    /**
     * If player collides with the wolf, the player will lose 2 health.
     */
    public void collisionReaction(Entity spriteCollidingWith) {
        spriteCollidingWith.setHealth(spriteCollidingWith.getHealth()-2);
    }
}