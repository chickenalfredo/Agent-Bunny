package core.sprite;

import core.sprite.interfaces.EnemyDefense;

public abstract class AbstractEnemy extends Entity implements EnemyDefense {

    public AbstractEnemy(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsEnemy(true);
    }

    public AbstractEnemy(double x, double y) {
        super(x, y);
    }

}
