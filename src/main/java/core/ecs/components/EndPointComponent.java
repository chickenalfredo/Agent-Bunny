package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class EndPointComponent extends Component implements Serializable {

    public EndPointComponent() {}

    public void update(Sprite actor, World world) {
        // System.out.println("updating EndPoint...");
    }
    
}
