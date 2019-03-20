package core.sprite;

public abstract class Weapon extends Sprite {

    public Weapon(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public abstract double damageEnemy(Entity enemy);

}
