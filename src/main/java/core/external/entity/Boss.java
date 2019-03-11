package core.external.entity;

import core.sprite.AbstractEnemy;
import core.sprite.Entity;
import core.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Boss extends AbstractEnemy {

    public Boss(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('B');
    }

    @Override
    public void dodge() {
    }

    @Override
    public void guard() {
    }

    @Override
    public void attack(Entity entityToAttack) {
    }

    @Override
    public void collisionResolution(Sprite sprite) {
    }

}
