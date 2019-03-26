package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class EndPointComponent extends Component implements Serializable {

    private static final long serialVersionUID = 9105405338139605646L;

    public EndPointComponent() {
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {

    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        
    }

}
