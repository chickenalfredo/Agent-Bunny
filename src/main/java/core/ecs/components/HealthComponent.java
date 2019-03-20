package core.ecs.components;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class HealthComponent extends Component {

    private double health;

    public HealthComponent() {}

    public void update(Sprite actor, World world) {
        // System.out.println("updating Health...");
    }

}
