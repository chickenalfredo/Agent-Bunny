package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;

public class Gun extends Weapon {

    private final double GUN_BASE_DAMAGE = 10;

    public Gun(double x, double y, double width, double height) {
        super(x, y, width, height);
        setWeaponDamage(GUN_BASE_DAMAGE);
    }

    public double getGunBaseDamage() {
        return GUN_BASE_DAMAGE;
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
