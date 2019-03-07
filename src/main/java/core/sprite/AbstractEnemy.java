package core.sprite;

import core.sprite.interfaces.EnemyDefense;

public abstract class AbstractEnemy extends Entity implements EnemyDefense {

    public AbstractEnemy(double x, double y, double width, double height, char playerImage, String playerName, int playerHealth, double playerSpeed) {
        super(playerName, playerHealth, playerSpeed, false, x, y, width, height, playerImage);
    }

}
