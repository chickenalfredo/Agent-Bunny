package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Ranged;

public class Gun extends Ranged {

    private final double GUN_BASE_DAMAGE = 10;

    public Gun(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public double getGunBaseDamage() {
        return GUN_BASE_DAMAGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0.0;
    }

}
