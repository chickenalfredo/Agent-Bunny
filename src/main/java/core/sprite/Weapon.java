package core.sprite;

/**
 * 
 */
public abstract class Weapon extends Sprite {

    private static final long serialVersionUID = 2777260606508988144L;

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Weapon(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public abstract double damageEnemy(Entity enemy);

    public abstract double getDamage();

    public abstract double getRange();

}
