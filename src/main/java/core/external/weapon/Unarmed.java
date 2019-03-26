package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;

/**
 * 
 */
public class Unarmed extends Melee {

    private final double UNARMED_BASE_DAMAGE = 5;

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Unarmed(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * 
     * @return
     */
    public double getBaseDamage() {
        return UNARMED_BASE_DAMAGE;
    }

    /**
     * 
     * @return
     */
    public double getDamage() {
        return UNARMED_BASE_DAMAGE + DAMAGE;
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
