package core.sprite;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
abstract public class Entity extends Sprite {

    private String name;
    private double gravity = 1.0;
    private int health;
    private boolean isEnemy;
    private boolean isColliding = false;

    // Is the entity performing an action right now?
    private boolean isInAction = false;

    // The direction the entity's facing. false = Left, true = Right
    private boolean isFacingRight;
    private double speed;

    /**
     * Constructor that calls the constructor of the Sprite class and sets name,
     * health, and speed for the Character
     * 
     * @param entityName   The name of the entity to set
     * @param entityHealth The health of the entity to set
     * @param entitySpeed  The speed of the entity to set
     * @param enemy        is the entity an enemy?
     * 
     * @see Sprite class
     * @param entityX      The x coordinate of the entity to set
     * @param entityY      The y coordinate of the entity to set
     * @param entityWidth  The width of the entity to set
     * @param entityHeight The height of the entity to set
     * @param entityImage  The terminal character representation of the entity
     */
    public Entity(String entityName, int entityHealth, double entitySpeed, boolean enemy, float entityX, float entityY,
            float entityWidth, float entityHeight, char entityImage) {
        super(entityImage, entityX, entityY, entityWidth, entityHeight);
        name = entityName;
        health = entityHealth;
        speed = entitySpeed;
        this.isEnemy = enemy;
    }

    /**
     * Returns a boolean to tell if the character's health has reached 0
     * 
     * @return boolean
     */
    public boolean isDead() {
        return (health <= 0);
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
     * Returns the value of the entity's gravity
     * 
     * @return gravity
     */
    public double getGravity() {
        return gravity;
    }

    /**
     * Sets the value of the entity's gravity
     * 
     * @param entityGravity The value of gravity to set
     */
    public void setGravity(double entityGravity) {
        gravity = entityGravity;
    }

    /**
     * Returns the value of the entity's direction
     * 
     * @return isFacingRight
     */

    public boolean getDirection() {
        return isFacingRight;
    }

    /**
     * Sets the value of the entity's direction
     * 
     * @param entityDirection The direction to set
     */
    public void setDirection(boolean entityDirection) {
        isFacingRight = entityDirection;
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

    /**
     * Returns true if the entity is current in an action
     * 
     * @return isInAction
     */
    public boolean getAction() {
        return isInAction;
    }

    /**
     * Sets the entity's action state
     * 
     * @param action The action state to set
     */
    public void setAction(boolean action) {
        isInAction = action;
    }

    /**
     * Checks if the entity is already in an action then moves the character one
     * body length in the X direction specified prior to the call (modified my speed)
     * 
     * @see Sprite Class
     * @see Coordinate Class
     */
    public void moveX() {
        if (isInAction == false) {
            isInAction = true;
            if (isFacingRight) {
                this.getCoordinate().setLocation(this.getX() + this.getWidth() * this.getSpeed(), this.getY());
            } else {
                this.getCoordinate().setLocation(this.getX() - this.getWidth() * this.getSpeed(), this.getY());
            }
            isInAction = false;
        }
    }

    /**
     * Checks if the entity is already in an action, then moves the character one
     * body length up (modified by speed)
     */

    public void moveUp() {
        if (isInAction == false) {
            isInAction = true;

            this.getCoordinate().setLocation(this.getX(), this.getY() - this.getHeight() * this.getSpeed());

            isInAction = false;
        }
    }

    /**
     * Checks if the entity is already in an action, then moves the character one
     * body length down (modified by speed)
     */
    public void moveDown() {
        if (isInAction == false) {
            isInAction = true;

            this.getCoordinate().setLocation(this.getX(), this.getY() + this.getHeight() * this.getSpeed());

            isInAction = false;
        }
    }

    /**
     * TO DO
     */
    public void collisionReaction(Sprite colliding) {}

    public void attack() {}
}
