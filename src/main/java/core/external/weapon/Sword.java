package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;

public class Sword extends Melee {

    private final double SWORD_BASE_DAMAGE = 15;

    public Sword(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public double getSwordBaseDamage() {
        return SWORD_BASE_DAMAGE;
    }

    public double getDamage() {
        return SWORD_BASE_DAMAGE + DAMAGE;
    }

    public double getRange() {
        return RANGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0.0;
    }

}
