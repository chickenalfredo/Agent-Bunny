package core.ecs.components;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.Weapon;
import javafx.scene.canvas.GraphicsContext;

public class WeaponComponent extends Component {

    public WeaponComponent() {}

    public void update(Sprite actor, Weapon weapon, GraphicsContext gc) {
        weapon.setX(actor.getX() + actor.getWidth());
        weapon.setY(actor.getY() + actor.getHeight()/2);
        actor.getComponent("RenderComponent", RenderComponent.class).render(weapon, gc);
    }

}
