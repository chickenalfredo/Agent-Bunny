package core.sprite;

import core.sprite.interfaces.IEnemyDefensive;

public abstract class AbstractEnemy extends Entity implements IEnemyDefensive {

    public AbstractEnemy(double x, double y, double width, double height, char playerImage, String playerName, int playerHealth, double playerSpeed) {
        super(playerName, playerHealth, playerSpeed, false, x, y, width, height, playerImage);
    }

}
