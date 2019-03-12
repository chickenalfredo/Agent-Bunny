package core.components;

import core.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class GraphicsComponent {

    public GraphicsComponent() {
    }

    public void update(Sprite actor, GraphicsContext gc) {
        gc.drawImage(actor.getImage(), actor.getX(), actor.getY());
    }
}
