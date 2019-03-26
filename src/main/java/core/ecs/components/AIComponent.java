package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class AIComponent extends Component implements Serializable {

    private static final long serialVersionUID = 7300058353639188186L;

    public AIComponent() {
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
