package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;

public class Physical extends Weapon {

    private final double PHYSICAL_BASE_DAMAGE = 1;

    public Physical(double x, double y, double width, double height) {
        super(x, y, width, height);
        setWeaponDamage(PHYSICAL_BASE_DAMAGE);
    }

    public double getPhysicalBaseDamage() {
        return PHYSICAL_BASE_DAMAGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        return this.getWeaponDamage();
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
