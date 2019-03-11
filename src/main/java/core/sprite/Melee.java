package core.sprite;

import core.sprite.interfaces.MeleeType;

public abstract class Melee extends Weapon implements MeleeType {

    public Melee(double x, double y, double width, double height) {
        super(x, y, width, height);
    }


    @Override
    public void collisionResolution(Sprite sprite) {

    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0;
    }

}