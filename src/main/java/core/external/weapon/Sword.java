package core.external.weapon;

import core.sprite.Entity;
import core.sprite.Melee;

public class Sword extends Melee {

    private final double SWORD_BASE_DAMAGE = 15;

    public Sword(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public Sword(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
    }

    public double getSwordBaseDamage() {
        return SWORD_BASE_DAMAGE;
    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0.0;
    }

}
