package core.ecs.components;

import core.ecs.Component;
import core.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class RenderComponent extends Component {

    public RenderComponent() {}

    public void update(Sprite actor, GraphicsContext gc) {}

    public void render(Sprite actor, GraphicsContext gc) {
        gc.drawImage(actor.getImage(), actor.getX(), actor.getY());
    }
    
}
