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
public class RenderComponent extends Component implements Serializable {

    private transient Image image;
    private String fileName;

    public RenderComponent(Sprite actor, String filename) {
        setImage(actor, filename);
        this.fileName = filename;
    }

    public void update(Sprite actor, GraphicsContext gc) {
        System.out.println("updated");
    }

    public void render(Sprite actor, GraphicsContext gc) {
        if (image == null) {
        setImage(actor, fileName);
        }
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
