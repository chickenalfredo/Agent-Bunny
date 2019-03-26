package core.ecs;

import java.io.Serializable;

import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * 
 */
public abstract class Component {

    public abstract void update(Sprite actor, World world);
    public abstract void render(Sprite actor, GraphicsContext gc, long delta);

}
