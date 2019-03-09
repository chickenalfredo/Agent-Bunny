package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;

public class Sword extends Weapon {

    private final double SWORD_BASE_DAMAGE = 15;

    public Sword(double x, double y, double width, double height) {
        super(x, y, width, height);
        setWeaponDamage(SWORD_BASE_DAMAGE);
    }

    public double getSwordBaseDamage() {
        return SWORD_BASE_DAMAGE;
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
