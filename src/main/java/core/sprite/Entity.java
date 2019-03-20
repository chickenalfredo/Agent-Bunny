package core.sprite;

import java.util.ArrayList;

import core.ecs.components.AttackComponent;
import core.ecs.components.PhysicsComponent;
import core.ecs.components.RenderComponent;
import core.ecs.components.WeaponComponent;
import javafx.scene.canvas.GraphicsContext;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
public abstract class Entity extends Sprite {

    private int health = 100;
    private int attackPower = 1;
    private boolean isEnemy = false;
    private WeaponComponent weaponComponent = new WeaponComponent();
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
        getComponent("PhysicsComponent", PhysicsComponent.class).moveEntity(key, isKeyPressedEvent);
    }

    public void attackCollider(World world) {
        getComponent("AttackComponent", AttackComponent.class).update(this, world);
    }

    public void update(World world, GraphicsContext gc) {
        super.update(world, gc);
        getComponent("PhysicsComponent", PhysicsComponent.class).update(this, world);
        if (!weaponsOwned.isEmpty())
            weaponComponent.update(this, weaponsOwned.get(0), gc);
    }

    public void addWeapon(Weapon weapon) {
        if (weapon != null)
            weaponsOwned.add(weapon);
    }

    public void attack(Entity enemyToAttack) {
        enemyToAttack.setHealth(enemyToAttack.getHealth() - this.getAttackPower());
    }

}
