package core.sprite;

import core.sprite.interfaces.RangedType;

public abstract class Ranged extends Weapon implements RangedType {

    public Ranged(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0;
    }

}
