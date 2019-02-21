/**
 * The abstract Character class extends Sprite with characteristics for creating
 * new generic characters that will be further defined by concrete subclasses. 
 */
abstract public class Character extends Sprite {

    private String name;
    private double gravity;
    private int health;
    private int action = 0;
    private boolean direction;
    private double speed;

    /**
     * Constructor that calls the constructor of the Sprite class and sets name,
     * health, and speed for the Character
     * 
     * @param charName    The name of the character to set
     * @param charHealth The health of the character to set
     * @param charSprite The Sprite of the character @see Sprite class
     * @param charSpeed  The speed of the character to set
     */
    public Character(String charName, int charHealth, Sprite charSprite, double charSpeed) {
        super(charSprite);
        name = charName;
        health = charHealth;
        speed = charSpeed;
    }

    /**
     * Method that will be called upo
     */
    public void dead() {
        GameMap.sprite.remove();
    }

    /**
     * Returns a boolean 
     */
    public boolean isDead() {
        return (health <= 0);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int charHealth) {
        health = charHealth;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double charGravity) {
        gravity = charGravity;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean charDirection) {
        direction = charDirection;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double charSpeed) {
        speed = charSpeed;
    }

    public void run() {
        if (!isColliding(this)) {

            // True = Right, False = Left
            if (direction) {
                Coordinate moveTo = new Coordinate(this.x + 1 * speed, this.y);
                super.setCoordinate(moveTo);
            } else {
                Coordinate moveTo = new Coordinate(this.x - 1 * speed, this.y);
                super.setCoordinate(moveTo);
            }
        }
    }

    public void attack() {

    }

}