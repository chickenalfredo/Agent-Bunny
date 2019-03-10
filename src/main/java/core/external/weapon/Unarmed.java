package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;
import core.sprite.Sprite;

public class Unarmed extends Melee {

    private final double PHYSICAL_BASE_DAMAGE = 1;

    public Unarmed(double x, double y, double width, double height) {
        super(x, y, width, height);
        // setWeaponDamage(PHYSICAL_BASE_DAMAGE);
    }

    public double getPhysicalBaseDamage() {
        return PHYSICAL_BASE_DAMAGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        // return this.getWeaponDamage();
        return 0.0;
    }

    @Override
    public void draw() {

    }

    @Override
    public void update() {

    }

    @Override
    public void collisionResolution(Sprite sprite) {

    }

}
