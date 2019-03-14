package core.sprite;

import java.util.ArrayList;
import java.util.List;

import core.components.AttackComponent;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
public abstract class Entity extends Sprite {

    private int health = 100;
    private int attackPower = 1;
    private boolean isEnemy = false;
    private AttackComponent attackComponent = new AttackComponent();
    private ArrayList<Weapon> weaponsOwned = new ArrayList<Weapon>();

    /**
     * Constructor that calls the constructor of the Sprite class and sets name,
     * health, and speed for the Character
     * 
     * @see Sprite class
     * @param entityX
     *                         The x coordinate of the entity to set
     * @param entityY
     *                         The y coordinate of the entity to set
     * @param entityWidth
     *                         The width of the entity to set
     * @param entityHeight
     *                         The height of the entity to set
     */
    public Entity(double entityX, double entityY, double entityWidth, double entityHeight) {
        super(entityX, entityY, entityWidth, entityHeight);
    }

    /**
     * @return the weaponsOwned
     */
    public ArrayList<Weapon> getWeaponsOwned() {
        return weaponsOwned;
    }

    /**
     * @param weaponsOwned
     *                         the weaponsOwned to set
     */
    public void setWeaponsOwned(ArrayList<Weapon> weaponsOwned) {
        this.weaponsOwned = weaponsOwned;
    }

    /**
     * @return the attackComponent
     */
	public AttackComponent getAttackComponent() {
		return attackComponent;
	}

	/**
	 * @param attackComponent the attackComponent to set
	 */
	public void setAttackComponent(AttackComponent attackComponent) {
		this.attackComponent = attackComponent;
	}

	public Entity(double entityX, double entityY, double entityWidth, double entityHeight, String image) {
        super(entityX, entityY, entityWidth, entityHeight, image);
    }


    public Entity(double x, double y) {
        super(x, y);
    }

    public Entity(double x, double y, String image) {
        super(x, y, image);
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

    protected void setIsEnemy(boolean isEnemy) {
        this.isEnemy = isEnemy;
    }

    public boolean getIsEnemy() {
        return isEnemy;
    }

    public void move(String key, boolean isKeyPressedEvent) {
        this.getPhysicsComponent().moveEntity(key, isKeyPressedEvent);
    }

    public void attackCollider(List<Sprite> world) {
        attackComponent.update(this, world);
    }

    public void addWeapon(Weapon weapon) {
        if (weapon != null)
            weaponsOwned.add(weapon);
    }

}
