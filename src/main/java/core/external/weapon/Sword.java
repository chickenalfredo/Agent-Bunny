package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;

/**
 * 
 */
public class Sword extends Melee {

    private static final long serialVersionUID = 9149336230444330916L;
    private final double SWORD_BASE_DAMAGE = 15;

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Sword(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * 
     * @return
     */
    public double getBaseDamage() {
        return SWORD_BASE_DAMAGE;
    }

    /**
     * 
     * @return
     */
    public double getDamage() {
        return SWORD_BASE_DAMAGE + DAMAGE;
    }

    /**
     * 
     * @return
     */
    public double getRange() {
        return RANGE;
    }

    /**
     * 
     * @param enemy
     * @return
     */
    @Override
    public double damageEnemy(Entity enemy) {
        return 0.0;
    }

}
