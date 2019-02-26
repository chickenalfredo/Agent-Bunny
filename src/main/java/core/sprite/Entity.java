package core.sprite;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 * 
 * @author Daniel Contreras
 */
abstract public class Entity extends Sprite {

    private String name;
    private double gravity = 1.0;
    private int health;
    private boolean isEnemy;
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
     * Gets the name of the entity
     * 
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the entity
     * 
     * @param nameToSet
     */
    public void setName(String nameToSet) {
        name = nameToSet;
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

    public boolean getIsEnemy() {
        return isEnemy;
    }

    public void move(String key) {
        switch (key) {
        case "w":
            this.setCoordinate(this.getX(), this.getY() - this.getHeight() * this.getSpeed());
            break;
        case "a":
            this.setCoordinate(this.getX() - this.getWidth(), this.getY());
            break;
        case "s":
            this.setCoordinate(this.getX(), this.getY() + this.getHeight() * this.getSpeed());
            break;
        case "d":
            this.setCoordinate(this.getX() + this.getWidth(), this.getY());
            break;
        case "z":
            System.out.println("no attack yet");
            break;
        default:
            System.out.println("Not a valid movement");
            break;
        }
    }

    /**
     * TODO
     * 
     * @param attackDamage
     */
    public void attack(int attackDamage) {}

}
