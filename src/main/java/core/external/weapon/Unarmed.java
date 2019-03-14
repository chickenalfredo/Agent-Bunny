package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;

public class Unarmed extends Melee {

    private final double PHYSICAL_BASE_DAMAGE = 1;

    public Unarmed(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public double getPhysicalBaseDamage() {
        return PHYSICAL_BASE_DAMAGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0.0;
    }

}
