package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;
import core.sprite.Sprite;

public class Sword extends Melee {

    private final double SWORD_BASE_DAMAGE = 15;

    public Sword(double x, double y, double width, double height) {
        super(x, y, width, height);
        // setWeaponDamage(SWORD_BASE_DAMAGE);
    }

    public double getSwordBaseDamage() {
        return SWORD_BASE_DAMAGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        // return this.getWeaponDamage();
        return 0.0;
    }

}
