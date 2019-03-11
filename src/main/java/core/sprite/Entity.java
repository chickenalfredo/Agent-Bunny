package core.sprite;

import core.sprite.interfaces.Attacks;
import core.sprite.interfaces.Movement;
import core.sprite.interfaces.Physics;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
public abstract class Entity extends Sprite implements Movement, Attacks, Physics {

    private int health = 100;
    private int attackPower = 1;
    private boolean isEnemy = false;
    private double speed = 1.0;

    /**
     * Constructor that calls the constructor of the Sprite class and sets name,
     * health, and speed for the Character
     * 
     * @see Sprite class
     * @param entityX      The x coordinate of the entity to set
     * @param entityY      The y coordinate of the entity to set
     * @param entityWidth  The width of the entity to set
     * @param entityHeight The height of the entity to set
     */
    public Entity(double entityX, double entityY, double entityWidth, double entityHeight) {
        super(entityX, entityY, entityWidth, entityHeight);
    }

    public Entity(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a boolean to tell if the character's health has reached 0
     * 
     * @return boolean
     */
    public boolean isDead() {
        return (health <= 0);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * Returns the value of the entity's health
     * 
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the value of the entity's health
     * 
     * @param entityHealth The value of health to set.
     */
    public void setHealth(int entityHealth) {
        health = entityHealth;
    }

    /**
     * Returns the value of the entity's speed
     * 
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the entity's speed
     * 
     * @param entitySpeed The value of speed to set
     */
    public void setSpeed(double entitySpeed) {
        speed = entitySpeed;
    }

    protected void setIsEnemy(boolean isEnemy) {
        this.isEnemy = isEnemy;
    }

    public boolean getIsEnemy() {
        return isEnemy;
    }

    @Override
    public void move(String key) {
        switch (key) {
        case "w":
            this.setCoordinate(this.getX(), this.getY() - 10);
            break;
        case "a":
            this.setCoordinate(this.getX() - 10, this.getY());
            break;
        case "s":
            this.setCoordinate(this.getX(), this.getY() + 10);
            break;
        case "d":
            this.setCoordinate(this.getX() + 10, this.getY());
            break;
        }
    }
}
