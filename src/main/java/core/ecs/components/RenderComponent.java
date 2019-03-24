package core.ecs.components;

import java.io.FileInputStream;
import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class RenderComponent extends Component {

    private Image image;

    public RenderComponent(Sprite actor, String filename) {
        setImage(actor, filename);
    }

    public void update(Sprite actor, GraphicsContext gc) {}

    public void render(Sprite actor, GraphicsContext gc) {
        gc.drawImage(image, actor.getX(), actor.getY());
    }

    private void setImage(Sprite actor, String filename) {
        try {
            image = new Image(new FileInputStream(filename), actor.getWidth(), actor.getHeight(), false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
