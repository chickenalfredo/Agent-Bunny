package core.components;

import core.sprite.Sprite;
import core.sprite.Weapon;
import javafx.scene.canvas.GraphicsContext;

public class WeaponComponent {

    public WeaponComponent() {}

    public void update(Sprite actor, Weapon weapon, GraphicsComponent graphics, GraphicsContext gc) {
        weapon.setX(actor.getX() + actor.getWidth());
        weapon.setY(actor.getY() + actor.getHeight()/2);
        actor.getGraphicsComponent().update(weapon, gc);
    }

}
