package core.sprite;

public abstract class Weapon extends Sprite {

    private final double BASE_DAMAGE = 10;
    private double weaponDamage;
    private double weaponRange;

    public Weapon(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * @return the weaponDamage
     */
    public double getWeaponDamage() {
        return weaponDamage;
    }

    /**
     * @param weaponDamage the weaponDamage to set
     */
    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage + BASE_DAMAGE;
    }

    /**
     * @return the weaponRange
     */
    public double getWeaponRange() {
        return weaponRange;
    }

    /**
     * @param weaponRange the weaponRange to set
     */
    public void setWeaponRange(double weaponRange) {
        this.weaponRange = weaponRange;
    }

    /**
     * @return the BASE_DAMAGE
     */
    public double getBaseDamage() {
        return BASE_DAMAGE;
    }

    public abstract double damageEnemy(Entity enemy);

}
